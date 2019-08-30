#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define NULLVALUE 0
#define maxsize 100

typedef int Elemtype;

typedef struct Tree{
	Elemtype data;
	struct Tree *LTree;//������ 
	struct Tree *RTree;//������ 
	bool LExist;//�������Ƿ���ڣ��ڷǵݹ鴴����ʹ�� 
	bool RExist;//�������Ƿ���ڣ��ڷǵݹ鴴����ʹ�� 
};

//***ջ ***
typedef struct Stack{
	Tree *data[maxsize];
	int top;
};

void Init(Stack *S){
	S->top=0;
}

void Push(Stack *S,Tree *tree){
	if(S->top==maxsize-1){
		cout<<"Stack is full!"<<endl;cout<<111;
		return ;
	}
	S->data[S->top]=tree;
	S->top++;
}

Tree *Pop(Stack *S){
	Tree *tree;
	if(S->top==0){
		cout<<"Stack is empty!"<<endl;
		return error;
	}
	tree=S->data[--S->top];
	return tree;
}

Tree *GetTop(Stack *S){
	//ע�⣺���ջ��Ԫ�أ�������Ҫ��ջ��Ԫ�ص���Ҳ���ǲ��ܸı�top��ֵ 
	int top=S->top-1;
	return S->data[top];
}

bool IsEmpty(Stack *S){
	if(S->top==0)	return true;
	else	return false;
}
//***endջ***

//***��α����õ��Ķ��� ***
typedef struct Queue{
	Tree* data[maxsize];
	int front;
	int rear;
}; 

void Init(Queue *Q){
	Q->front=Q->rear=0;
}

void EnQueue(Queue *Q,Tree *tree){
	Q->data[Q->rear]=tree;
	Q->rear++;
}

Tree* DeQueue(Queue *Q){
	if(Q->rear==Q->front)
		return NULL;
	Tree *tree=Q->data[Q->front];
	Q->front++;
	return tree;
}
//***end���� ***

//***�ݹ齨��*** 
//����˼�룺�ݹ���ڣ��������鳤�Ȼ���������ֵ��Ϊ����
//���������ݹ鴴�����������ݹ鴴�������� 
void Create(Tree **tree,Elemtype *data,int &start,int len){
	//ע�⣺1.Ҫ��˫ָ������main�ж����Tree *tree������ϵ����Ϊmain�е�tree��ȫ�ֱ�����ָ���
	//ָ��createʱȷʵtreeָ�������ɵ�������һ���������ָ���ֻص�ָ��յ�״̬�������
	//��Ϊ�����в������Ǿֲ�����������˫ָ��󣬴��Ĳ���ʱtreeָ��ĵ�ַ����һ������������tree
	//����ָ��գ�����ָ���½���������˫ָ���൱�ڵ�ַ��
	//2.start�Ǳ�ʶ������ʱ�õ������鿪ʼλ
	//ע��startҲҪ�õ�ַ��ʾ����Ϊ�ݹ�ʱִ�е�Ҳ�Ǻ�������ֲ��������ܻ�䣬Ҫ�ô�ַ�� 
	if(start>=len||data[start]==NULLVALUE){
		//������ȴ��ڸ�������ĳ��Ȼ��������п�ֵ������Ϊ�� 
		*tree=NULL;//�ں����У�tree��ָ������ָ�룬*tree������**tree��ָ��treeָ���ַ��ָ�� 
		return ;
	}
	else{
		*tree=(Tree *)malloc(sizeof(Tree));
		(*tree)->data=data[start];//��ֵ 
		Create(&(*tree)->LTree,data,++start,len);//���������� 
		Create(&(*tree)->RTree,data,++start,len);//���������� 
	}
}

//***�ǵݹ齨��***
//����˼�룺���������һֱѹջ��ѹջ��ͬʱ������������
//ѹ����ߵ����һ�����ٵ�ջ����һ���ʹ���һ����������
//�����һ���ı�־�����һ���ڵ��������������ڲ��Ҷ��ǿա� 
Tree *CreateNode(Elemtype elem){//����һ���µ����ڵ� 
	Tree *node=(Tree *)malloc(sizeof(Tree));
	node->data=elem;
	node->LTree=NULL;
	node->RTree=NULL;
	node->LExist=false;//��ʼ�������������� ��־���� 
	node->RExist=false;//��ʼ��������������
	return node;
}

Tree *Create(Elemtype *data,int len){//���ظ��ڵ㡣 
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	int i=0;//��ʾ�����±�ı仯 
	Tree *root=CreateNode(data[i++]);
	Tree *P=root;//��ʾ���ڵ�ı仯 
	Push(S,P);//�����ڵ�ѹ��ȥ 
	while(i<len){
		if(data[i]!=NULLVALUE&&P->LExist==false){
		//��������и���������Ϊ��ֵ���ҵ�ǰ��û����������������������� ������Ҳ���� 
			Tree *newLTree=CreateNode(data[i++]);//�����±�Ҫ��һ 
			P->LTree=newLTree;
			P->LExist=true;
			P=P->LTree;
			Push(S,P);//����ǰ�ڵ�ѹ��ȥ��һֱѹ��ߣ� 
		}else if(data[i]!=NULLVALUE&&P->RExist==false){
		//��������и���������Ϊ��ֵ���ҵ�ǰ��û�����������������������
			Tree *newRTree=CreateNode(data[i++]);
			P->RTree=newRTree;
			P->RExist=true;
			P=P->RTree;
			Push(S,P);
		}else if(data[i]==NULLVALUE&&P->LExist==false){
		//��������и�������Ϊ��ֵ���ҵ�ǰ��û�������� 
			P->LExist=true;//�����������ڱ�־��Ϊ���ˣ�����ʵ���ϲ����� 
			i++;
		}else if(data[i]==NULLVALUE&&P->RExist==false){
		//��������и�������Ϊ��ֵ���ҵ�ǰ��û�������� 
			P->RExist=true;//�����������ڱ�־��Ϊ���ˣ�����ʵ���ϲ����� 
			i++;
		}
		if(P->LExist==true&&P->RExist==true)
		//������������������ˣ���ջ 
			P=Pop(S);
	}
	return root;
} 


//***����ݹ������� ***
//����˼�룺�ݹ���ڣ���������
//��������ڵ㣬�ٵݹ�������������ݹ���������� 
void PreOrder(Tree *tree){
	if(tree==NULL)
		return ;
	cout<<tree->data<<"  ";
	PreOrder(tree->LTree);
	PreOrder(tree->RTree);
}

//***����ǵݹ�������***
//����˼�룺���������һֱѹջ��ѹջ��ͬʱ�����������
//ѹ����ߵ����һ�����ٵ�ջ����һ���ʹ�������������� 
void PreOrder2(Tree *tree){
	Tree *P=tree;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	while(P!=NULL||IsEmpty(S)==false){
		while(P!=NULL){//һֱѹջ 
			cout<<P->data<<"  ";
			Push(S,P);
			P=P->LTree;
		}
		if(IsEmpty(S)==false){//һ�ε�һ�� 
			P=Pop(S);
			P=P->RTree;
		}
	}
	cout<<endl;
}

//***����ݹ�������***
//����˼�룺�ݹ���ڣ���������
//�ȵݹ��������������������ڵ㣬�ݹ���������� 
void InOrder(Tree *tree){
	if(tree==NULL)
		return ;
	InOrder(tree->LTree);
	cout<<tree->data<<"  ";
	InOrder(tree->RTree);
} 

//***����ǵݹ�������***
//����˼�룺���������һֱѹջ��ѹ����ߵ����һ�����ٵ�ջ��
//��ջ��ͬʱ�������������������ѹջ���������ٷ����ҡ� 
void InOrder2(Tree *tree){
	Tree *P=tree;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	while(P!=NULL||IsEmpty(S)==false){
		while(P!=NULL){//���һֱѹջ��������� 
			Push(S,P);
			P=P->LTree;
		}
		if(IsEmpty(S)==false){
			P=Pop(S);//��ջ 
			cout<<P->data<<"  ";//��� 
			P=P->RTree;//�������� 
		}
	}
	cout<<endl;
}


//***����ݹ�������***
//����˼�룺�ݹ���ڣ���������
//�ȵݹ�������������ݹ��������������������ڵ� 
void PostOrder(Tree *tree){
	if(tree==NULL)
		return ;
	PostOrder(tree->LTree);
	PostOrder(tree->RTree);
	cout<<tree->data<<"  ";
} 

//***����ǵݹ�������***
//��ǰ�������ͬ��ǰ����������ֻ��һ���������������
//����˼�룺���õ�ǰ�ڵ��ǰһ���ڵ㣬���ڻ��ݡ��Ƚ����ڵ�ѹջ
//ÿ�λ�ȡջ��Ԫ�أ�ջ��Ԫ�ص����Ҷ�����˲��ܽ����������ջ 
void PostOrder2(Tree *tree){
	Tree *cur=tree;
	Tree *pre=NULL;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	Push(S,cur);//���ڵ�ѹջ 
	while(IsEmpty(S)==false){
		cur=GetTop(S);//��ȡջ�� 
		if((cur->LTree==NULL&&cur->RTree==NULL)||
			((pre!=NULL)&&(pre==cur->LTree||pre==cur->RTree))){
		//�����ǰ�ڵ�����������Ϊ�գ����൱����������������ˣ�����ǰ�ڵ����
		//���ߣ���ǰ�ڵ����������������ˣ�����ǰ�ڵ����
			cout<<cur->data<<"  ";
			Pop(S);//��ջ 
			pre=cur;//�ı�ǰһ���ڵ��ָ��	
		}else{//���������ǰ�ڵ㣬Ҳ��������������û��� 
			if(cur->RTree!=NULL)
				Push(S,cur->RTree);//��������ջ����Ϊ��ջʱ�����������ȳ�ջ 
			if(cur->LTree!=NULL)
				Push(S,cur->LTree);//��������ջ 
		}
	}
	cout<<endl;
}


//***��α���***
//����˼�룺���ڵ���ӣ�ÿ�λ�ȡ��ͷԪ�أ����Ӳ������
//��������ӣ����������
void Gradation(Tree *tree,Queue *Q){
	EnQueue(Q,tree);//���ڵ���� 
	while(Q->rear!=Q->front){//ֱ�����ӵĶ������ 
		tree=Q->data[Q->front];
		cout<<DeQueue(Q)->data<<"  ";
		if(tree->LTree!=NULL)
			EnQueue(Q,tree->LTree);
		if(tree->LTree!=NULL)
			EnQueue(Q,tree->RTree);
	}
}

//***��ȣ��ݹ�***
//����˼�룺�ݹ���ڣ��������Ϊ0
//�������=���ڵ�+����������Ⱥ����������������ģ� 
int Depth(Tree *tree){
	int d,d1,d2;//��ʱ��������Ϊ���ŵݹ�ֵ��仯���ֱ��ʾ
			//����ȣ���������ȣ���������� 
	if(tree==NULL)
		return 0;
	d1=Depth(tree->LTree);//�ݹ���������� 
	d2=Depth(tree->RTree);//�ݹ���������� 
	d=1+(d1>d2?d1:d2);//���Ҫȡ��������������� 
	return d;
}

//***��������һԪ�أ�ǰ��ݹ鷨***
//����˼�룺����ǰ��ݹ��ң��ڱ���������������� 
Tree *Find(Tree *tree,Elemtype elem){
	Tree *newtree=NULL;
	if(tree!=NULL){
		if(tree->data==elem)
			newtree=tree;
		else{
			if(newtree==NULL)//����� 
				newtree=Find(tree->LTree,elem);
			if(newtree==NULL)
				newtree=Find(tree->RTree,elem);
		}
	}
	return newtree;
} 
 
int main(){
	Elemtype data[]={1,2,4,0,0,5,0,0,3,6,0,0,7};
	//����ĸ���һ��Ҫ�п�ֵ�ı�ʾ�������˷ѿռ� 
	int len=sizeof(data)/sizeof(data[0]);
	Tree *tree;
	int start=0;
	Queue *Q=(Queue *)malloc(sizeof(Queue));
	Init(Q);
	Create(&tree,data,start,len);
	PreOrder(tree);cout<<endl;
	InOrder(tree);cout<<endl;
	PostOrder(tree);cout<<endl;
	Gradation(tree,Q);cout<<endl;
	cout<<Depth(tree)<<endl;
	cout<<Find(tree,4)->data<<endl;

	Tree *tree=Create(data,len);
	PreOrder2(tree);
	InOrder2(tree);
	PostOrder2(tree);
	return 0;
} 
