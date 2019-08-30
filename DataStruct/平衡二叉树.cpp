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
//ƽ�����ӣ��������ĸ߶ȼ�ȥ�������ĸ߶�
//��ƽ�����Ӿ���ֵ���ڵ���2ʱ�㲻��ƽ��� 
//��ƽ��-->ƽ�⣺
//1.�ж��ĸ�λ�õĽڵ㵼�²�ƽ�⣬����ڵ���ǵ�һ��ƽ������
//���ڵ���2�Ľڵ�
//2.����ת�ָ�ƽ�⣺��Ϊ��������ʱ�룩��������˳ʱ�룩
//���Բ�ƽ��ڵ�Ϊ���������нڵ��ƽ�����Ӷ�Ϊ����ʱ����ƽ������Ϊ1�Ľڵ���Ϊ��ת�ᣬ����ƽ��ڵ�����
//���Բ�ƽ��ڵ�Ϊ���������нڵ��ƽ�����Ӷ�Ϊ����ʱ����ƽ������Ϊ-1�Ľڵ���Ϊ��ת�ᣬ����ƽ��ڵ����� 
//���Բ�ƽ��ڵ�Ϊ���������нڵ��ƽ�����������ʱ����Ҫ����������ת��һ������ƽ�����Ӿ���ֵΪ1�Ľڵ���
//	Ϊ��ת�ᣬ��ƽ������Ϊ0�Ľڵ����������������Ҹ��󣩣�֮����γ�����ǰ���������ͬ�����Σ�����ǰ��������ת 

typedef int Elemtype;

typedef struct AVLNode{
	int height;//���� 
	Elemtype data;
	struct AVLNode *LTree;
	struct AVLNode *RTree;
}; 

int max(int x,int y){
	return x>y?x:y;
}
int getH(AVLNode *tree){//��ȡ���ĸ߶ȡ� 
	return tree?tree->height:-1;//���ݸ߶ȵĶ��壺���ĸ߶ȣ�depth��Ϊ���нڵ������Ρ�Լ����
					//�����ĸ߶�Ϊ-1��ֻ��һ���ڵ�����ĸ߶�Ϊ0
}

AVLNode *R_Rotate(AVLNode *root){//���� 
	AVLNode *left=root->LTree;//�½�һ��ָ��ָ����������� 
	root->LTree=left->RTree;//���������ȥ������ָ�����������Ϊ�� 
	left->RTree=root;//�������ȥ�ĸ����·Ż�����ʹ֮��Ϊԭ�ȸ���������������������ʱ
					//�µĸ�Ϊԭ�ȸ��������� 
	
	root->height=max(getH(root->LTree),getH(root->RTree))+1;//������̬�����仯�����߿��ܻᷢ���仯 
	left->height=max(getH(left->LTree),getH(left->RTree))+1;//��ǰ���ĸ߶�ȡ�����������������ֵ+1 
	return left;//���ظ� 
}

AVLNode * L_Rotate(AVLNode *root){//���� 
	AVLNode *right=root->RTree;//������������������ 
	root->RTree=right->LTree;
	right->LTree=root;
	
	root->height=max(getH(root->LTree),getH(root->RTree))+1;
	right->height=max(getH(right->LTree),getH(right->RTree))+1;
	return right;
}

AVLNode *LR_Rotate(AVLNode *root){//������������������ʵ��������������������ʵ�� 
	root->LTree=L_Rotate(root->LTree);//�������Ƕ�ƽ������Ϊ0���������в�������������ƽ������Ϊ0������
									//��Ϊ���������� 
	return R_Rotate(root);//�������Ƕ�ƽ�����Ӿ���ֵΪ1���������в��� 
}

AVLNode *RL_Rotate(AVLNode *root){//��������������ͬ������ 
	root->RTree=R_Rotate(root->RTree);
	return L_Rotate(root);
}

AVLNode *Add(AVLNode *tree,Elemtype data){//�ݹ����һ�����ڵ� 
	if(tree==NULL){//�ݹ���ڣ������Ϊ�� 
		tree=(AVLNode *)malloc(sizeof(AVLNode));//Ϊ�վ��½�һ�����ڵ� 
		tree->data=data;//��ֵ 
		tree->height=0;
		tree->LTree=NULL;
		tree->RTree=NULL;
		return tree;//�����ϣ����� 
	}//����Ϊ�վ�Ҫ���Ǽ��������������������� 
	else if(data>tree->data){//�������������е�ǰ�ڵ��ֵ�� 
		tree->RTree=Add(tree->RTree,data);//���������м� 
		//�������õĵݹ������е��˴�ʱ�Ѿ�ȷ�������ĸ�λ���ˣ���ʱ��Ҫ���Ǽӽ�ȥ��ƽ��ƽ��Ҫ��Ҫ�任 
		if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//���ƽ�����ӵľ���ֵ����2��ƽ����Ҫ�任 
			if(getH(tree->RTree->LTree)>getH(tree->RTree->RTree))//���ڽڵ��ǲ����������ϣ�������ƽ��
			//˵������������������һ����һ���ͣ�����������������������������������ߣ���˵���˽ڵ����������
			//���������ϣ��������������� 
				tree=RL_Rotate(tree); 
			else//����������������������� 
				tree=L_Rotate(tree);//���� 
	}	
	else if(data<tree->data){//�������������е�ǰ�ڵ��ֵ��С 
		tree->LTree=Add(tree->LTree,data);//���������м�
		if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//���ƽ�����ӵľ���ֵ����2��ƽ����Ҫ�任
			if(getH(tree->LTree->LTree)>getH(tree->LTree->RTree))//���ڽڵ��ǲ����������ϣ�������ƽ��
			//˵������������������һ����һ���ͣ�����������������������������������ߣ���˵���˽ڵ����������
			//���������ϣ�������  
				tree=R_Rotate(tree); 
			else//����������������������� 
				tree=LR_Rotate(tree);//������������ 
	}
	else if(data==tree->data)//�����������ͬ��ֵ�������� 
		return tree;
	tree->height=max(getH(tree->LTree),getH(tree->RTree))+1;//���벢�ұ任�����߸��� 
	return tree;//�������� 
}

//void Create(AVLNode **tree,Elemtype *data,int len){
//	for(int i=0;i<len;i++)
//		*tree=Add(*tree,data[i]);
//}

AVLNode *Remove(AVLNode *tree,Elemtype elem){//ɾ������ĳһ�ڵ� 
	if(tree==NULL) return tree;//���������� 
	if(tree->data>elem)//�ж�Ҫɾ�Ľڵ����ĸ�λ�ã������е�ǰ�ڵ�ֵС 
		tree->LTree=Remove(tree->LTree,elem);//����������������λ�ã����õݹ�һֱ�ҵ���Ӧ��λ�÷�������
									//������Ϊ��ɾ���������нڵ㣬�������仯�� 
	else if(tree->data<elem) //�����е�ǰ�ڵ�ֵ�� 
		tree->RTree=Remove(tree->RTree,elem);//ԭ��������ͬ 
	else if(tree->data==elem){//�����е�ǰ�ڵ�ֵ��ͬ 
		if(tree->LTree&&tree->RTree){//�ж�Ҫɾ���Ľڵ���û����������������� 
			AVLNode *p=tree->RTree;//����������������С�ĵ��µĸ���Ҳ�����������������ĵ��µĸ����˴�ѡǰ�� 
			while(p->LTree)//������������С�Ľڵ� 
				p=p->LTree;
			tree->data=p->data;//���¸��е�ֵ����������ֵ֮�󣬳�������û������(������)������µĸ��� 
			tree->RTree=Remove(tree->RTree,p->data);//���õݹ齫�ҵ����Ǹ�������Ľڵ�ɾ������Ϊ���Ѿ����� 
		}else{//���Ҫɾ���Ľڵ������������������������������������� 
			AVLNode *p=(tree->LTree)?tree->LTree:tree->RTree;//���������������������½��ڵ�ָ��Ҫɾ���ڵ��������
			//����ָ��Ҫɾ���ڵ������������Ϊ�����Ϊ�µĸ� 
			free(tree);//���ɵĸ��ͷ� 
			return p;//�����µĸ� 
		}
	}
	
	if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//����ͬ����һ����Ҫ��Ҫ�任�Լ��������� 
		if(getH(tree->RTree->LTree)>getH(tree->RTree->RTree))
				tree=RL_Rotate(tree); 
		else
			tree=L_Rotate(tree);
	if(abs(getH(tree->LTree)-getH(tree->RTree))==2)			
		if(getH(tree->LTree->LTree)>getH(tree->LTree->RTree))
				tree=R_Rotate(tree); 
		else if(tree->LTree==NULL)
			tree=LR_Rotate(tree);
	tree->height=max(getH(tree->LTree),getH(tree->RTree))+1;
	return tree;//�������� 
} 

void PreOrder(AVLNode *tree){//ǰ����� 
	if(tree==NULL)
		return ;
	cout<<tree->data<<"  ";
	PreOrder(tree->LTree);
	PreOrder(tree->RTree);
}

int main(){
	AVLNode *tree=NULL;
	Elemtype data[]={3,2,1,4,5,6,8,7,10,9};
	int len=sizeof(data)/sizeof(data[0]);
//	Create(&tree,data,len);���ַ�������Ҳ���� 
	for(int i=0;i<len;i++)
		tree=Add(tree,data[i]);
	PreOrder(tree);
	cout<<endl;
	tree=Remove(tree,8);
	PreOrder(tree);
	return 0;
} 
