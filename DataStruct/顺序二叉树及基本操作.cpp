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

//����˼�룺�������������߼�����������˳��ָ���ǵ�ַ���� 
//�����ڵ�Ϊi����������Ϊ2*i+1��������Ϊ2*i+2��i��0��ʼ��
//i��1��ʼ������Ϊ2*i��������Ϊ2*i+1
//�����ǰ���0��ʼ�� 

typedef int Elemtype;

typedef struct Tree{
	Elemtype data;
	struct Tree *LTree;
	struct Tree *RTree;
};

//�ǵݹ齨��
Tree* Create(Elemtype *data,int len){ 
	//���������õ��Ľڵ����һ�������Ŀռ� 
	Tree *tree=(Tree *)malloc(len*sizeof(Tree));
	for(int i=0;i<len;i++){ //�����ǽ��õ��Ľڵ㸳ֵ��û�н�����ϵ 
		tree[i].data=data[i];
		tree[i].LTree=NULL;
		tree[i].RTree=NULL;
	}
	for(int j=0;j<=len/2-1;j++){//��ʼ������ϵ��len/2-1�����һ���ڲ��ڵ�
			//��Ϊ������ϵ����һ������һ�㽨����ϵ���������ڶ���ͽ������������ 
		if(2*j+1<=len-1)//�ж���û���������������ǲ�����ȫ���ǲ���ȫ��������ֻҪ�Ǹ�����������
				//�����ַ��������������һ���������ڵ���ܾ�����������һ��Ԫ�� 
			tree[j].LTree=&tree[2*j+1];
		if(2*j+2<=len-1)//�ж���û����������ͬ�� 
			tree[j].RTree=&tree[2*j+2];
	}
	return tree;
}

//ǰ����� 
void PreOrder(Tree *tree){
	if(tree==NULL)
		return ;
	cout<<tree->data<<"  ";
	PreOrder(tree->LTree);
	PreOrder(tree->RTree);
}

int main(){
	Tree *root=NULL;
	Elemtype data[]={1,2,3,4,5,6,7,8,9};
	//��ȱ�㣬����ʶ���ֵ 
	int len=sizeof(data)/sizeof(data[0]);
	root=Create(data,len);
	PreOrder(root);
	return 0;
} 
