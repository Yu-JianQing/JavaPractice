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
	struct Tree *LTree;//左子树 
	struct Tree *RTree;//右子树 
	bool LExist;//左子树是否存在，在非递归创建中使用 
	bool RExist;//右子树是否存在，在非递归创建中使用 
};

//***栈 ***
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
	//注意：获得栈顶元素，并不需要将栈顶元素弹出也就是不能改变top的值 
	int top=S->top-1;
	return S->data[top];
}

bool IsEmpty(Stack *S){
	if(S->top==0)	return true;
	else	return false;
}
//***end栈***

//***层次遍历用到的队列 ***
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
//***end队列 ***

//***递归建立*** 
//基本思想：递归出口：大于数组长度或者遇到空值置为空树
//创建根，递归创建左子树，递归创建右子树 
void Create(Tree **tree,Elemtype *data,int &start,int len){
	//注意：1.要用双指针来与main中定义的Tree *tree产生联系，因为main中的tree是全局变量，指向空
	//指向到create时确实tree指向了生成的树，但一旦函数完成指针又回到指向空的状态，这就是
	//因为函数中参数都是局部变量。用了双指针后，传的参数时tree指针的地址，则一旦函数结束，tree
	//不再指向空，而是指向新建的树。（双指针相当于地址）
	//2.start是标识创建树时用到的数组开始位
	//注意start也要用地址表示，因为递归时执行的也是函数，则局部变量可能会变，要用传址。 
	if(start>=len||data[start]==NULLVALUE){
		//如果长度大于给出数组的长度或数组中有空值则将树置为空 
		*tree=NULL;//在函数中，tree是指向树的指针，*tree是树，**tree是指向tree指针地址的指针 
		return ;
	}
	else{
		*tree=(Tree *)malloc(sizeof(Tree));
		(*tree)->data=data[start];//赋值 
		Create(&(*tree)->LTree,data,++start,len);//创建左子树 
		Create(&(*tree)->RTree,data,++start,len);//创建右子树 
	}
}

//***非递归建立***
//基本思想：沿着最左边一直压栈，压栈的同时创建左子树，
//压到左边的最后一个，再弹栈，弹一个就创建一个右子树。
//到最后一个的标志是最后一个节点左右子树都存在并且都是空。 
Tree *CreateNode(Elemtype elem){//创建一个新的树节点 
	Tree *node=(Tree *)malloc(sizeof(Tree));
	node->data=elem;
	node->LTree=NULL;
	node->RTree=NULL;
	node->LExist=false;//初始，左子树不存在 标志作用 
	node->RExist=false;//初始，右子树不存在
	return node;
}

Tree *Create(Elemtype *data,int len){//返回根节点。 
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	int i=0;//表示数组下标的变化 
	Tree *root=CreateNode(data[i++]);
	Tree *P=root;//表示树节点的变化 
	Push(S,P);//将根节点压进去 
	while(i<len){
		if(data[i]!=NULLVALUE&&P->LExist==false){
		//如果数组中给出的数不为空值，且当前树没有左子树则给它创建左子树 ，空树也算树 
			Tree *newLTree=CreateNode(data[i++]);//数组下标要加一 
			P->LTree=newLTree;
			P->LExist=true;
			P=P->LTree;
			Push(S,P);//将当前节点压进去（一直压左边） 
		}else if(data[i]!=NULLVALUE&&P->RExist==false){
		//如果数组中给出的数不为空值，且当前树没有右子树则给它创建右子树
			Tree *newRTree=CreateNode(data[i++]);
			P->RTree=newRTree;
			P->RExist=true;
			P=P->RTree;
			Push(S,P);
		}else if(data[i]==NULLVALUE&&P->LExist==false){
		//如果数组中给出的数为空值，且当前树没有左子树 
			P->LExist=true;//将左子树存在标志置为有了，但是实际上不存在 
			i++;
		}else if(data[i]==NULLVALUE&&P->RExist==false){
		//如果数组中给出的数为空值，且当前树没有左子树 
			P->RExist=true;//将右子树存在标志置为有了，但是实际上不存在 
			i++;
		}
		if(P->LExist==true&&P->RExist==true)
		//如果左右子树都存在了，则弹栈 
			P=Pop(S);
	}
	return root;
} 


//***先序递归遍历输出 ***
//基本思想：递归出口：空树返回
//先输出根节点，再递归输出左子树，递归输出右子树 
void PreOrder(Tree *tree){
	if(tree==NULL)
		return ;
	cout<<tree->data<<"  ";
	PreOrder(tree->LTree);
	PreOrder(tree->RTree);
}

//***先序非递归遍历输出***
//基本思想：沿着最左边一直压栈，压栈的同时输出左子树，
//压到左边的最后一个，再弹栈，弹一个就创建输出右子树。 
void PreOrder2(Tree *tree){
	Tree *P=tree;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	while(P!=NULL||IsEmpty(S)==false){
		while(P!=NULL){//一直压栈 
			cout<<P->data<<"  ";
			Push(S,P);
			P=P->LTree;
		}
		if(IsEmpty(S)==false){//一次弹一个 
			P=Pop(S);
			P=P->RTree;
		}
	}
	cout<<endl;
}

//***中序递归遍历输出***
//基本思想：递归出口：空树返回
//先递归输出左子树，再输出根节点，递归输出右子树 
void InOrder(Tree *tree){
	if(tree==NULL)
		return ;
	InOrder(tree->LTree);
	cout<<tree->data<<"  ";
	InOrder(tree->RTree);
} 

//***中序非递归遍历输出***
//基本思想：沿着最左边一直压栈，压到左边的最后一个，再弹栈，
//弹栈的同时输出左子树，再右子树压栈，右子树再分左右。 
void InOrder2(Tree *tree){
	Tree *P=tree;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	while(P!=NULL||IsEmpty(S)==false){
		while(P!=NULL){//左边一直压栈，但不输出 
			Push(S,P);
			P=P->LTree;
		}
		if(IsEmpty(S)==false){
			P=Pop(S);//弹栈 
			cout<<P->data<<"  ";//输出 
			P=P->RTree;//换右子树 
		}
	}
	cout<<endl;
}


//***后序递归遍历输出***
//基本思想：递归出口：空树返回
//先递归输出左子树，递归输出右子树，再输出根节点 
void PostOrder(Tree *tree){
	if(tree==NULL)
		return ;
	PostOrder(tree->LTree);
	PostOrder(tree->RTree);
	cout<<tree->data<<"  ";
} 

//***后序非递归遍历输出***
//与前序和中序不同，前序和中序回溯只回一步，但后序回两步
//基本思想：设置当前节点和前一个节点，用于回溯。先将根节点压栈
//每次获取栈顶元素，栈顶元素的左右都输出了才能将其输出并弹栈 
void PostOrder2(Tree *tree){
	Tree *cur=tree;
	Tree *pre=NULL;
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	Push(S,cur);//根节点压栈 
	while(IsEmpty(S)==false){
		cur=GetTop(S);//获取栈顶 
		if((cur->LTree==NULL&&cur->RTree==NULL)||
			((pre!=NULL)&&(pre==cur->LTree||pre==cur->RTree))){
		//如果当前节点左右子树都为空，则相当于左右子树都输出了，将当前节点输出
		//或者，当前节点的左右子树都输出了，将当前节点输出
			cout<<cur->data<<"  ";
			Pop(S);//弹栈 
			pre=cur;//改变前一个节点的指向	
		}else{//不能输出当前节点，也就是左右子树还没输出 
			if(cur->RTree!=NULL)
				Push(S,cur->RTree);//右子树进栈，因为出栈时就是左子树先出栈 
			if(cur->LTree!=NULL)
				Push(S,cur->LTree);//左子树进栈 
		}
	}
	cout<<endl;
}


//***层次遍历***
//基本思想：根节点入队，每次获取队头元素，出队并输出，
//左子树入队，右子树入队
void Gradation(Tree *tree,Queue *Q){
	EnQueue(Q,tree);//根节点入队 
	while(Q->rear!=Q->front){//直到进队的都输出了 
		tree=Q->data[Q->front];
		cout<<DeQueue(Q)->data<<"  ";
		if(tree->LTree!=NULL)
			EnQueue(Q,tree->LTree);
		if(tree->LTree!=NULL)
			EnQueue(Q,tree->RTree);
	}
}

//***深度，递归***
//基本思想：递归出口：空树深度为0
//树的深度=根节点+（左子树深度和右子树深度中最深的） 
int Depth(Tree *tree){
	int d,d1,d2;//临时变量，因为随着递归值会变化，分别表示
			//总深度，左子树深度，右子树深度 
	if(tree==NULL)
		return 0;
	d1=Depth(tree->LTree);//递归左子树深度 
	d2=Depth(tree->RTree);//递归右子树深度 
	d=1+(d1>d2?d1:d2);//深度要取左右子树中最深的 
	return d;
}

//***在树中找一元素，前序递归法***
//基本思想：按照前序递归找，在遍历中添加条件即可 
Tree *Find(Tree *tree,Elemtype elem){
	Tree *newtree=NULL;
	if(tree!=NULL){
		if(tree->data==elem)
			newtree=tree;
		else{
			if(newtree==NULL)//必须加 
				newtree=Find(tree->LTree,elem);
			if(newtree==NULL)
				newtree=Find(tree->RTree,elem);
		}
	}
	return newtree;
} 
 
int main(){
	Elemtype data[]={1,2,4,0,0,5,0,0,3,6,0,0,7};
	//数组的给出一定要有空值的表示，所以浪费空间 
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
