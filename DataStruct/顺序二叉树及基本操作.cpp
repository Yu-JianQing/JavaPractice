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

//基本思想：将二叉树按照逻辑创建出来，顺序指的是地址连续 
//若根节点为i，其左子树为2*i+1，右子树为2*i+2（i从0开始）
//i从1开始，子树为2*i，右子树为2*i+1
//这里是按从0开始的 

typedef int Elemtype;

typedef struct Tree{
	Elemtype data;
	struct Tree *LTree;
	struct Tree *RTree;
};

//非递归建立
Tree* Create(Elemtype *data,int len){ 
	//将所有能用到的节点放在一个连续的空间 
	Tree *tree=(Tree *)malloc(len*sizeof(Tree));
	for(int i=0;i<len;i++){ //仅仅是将用到的节点赋值，没有建立联系 
		tree[i].data=data[i];
		tree[i].LTree=NULL;
		tree[i].RTree=NULL;
	}
	for(int j=0;j<=len/2-1;j++){//开始建立联系，len/2-1是最后一个内部节点
			//因为建立联系是上一层与下一层建立联系，到倒数第二层就结束，建立完毕 
		if(2*j+1<=len-1)//判断有没有左子树，由于是不分完全还是不完全二叉树，只要是个二叉树就能
				//用这种方法建立，则最后一个左子树节点可能就是数组的最后一个元素 
			tree[j].LTree=&tree[2*j+1];
		if(2*j+2<=len-1)//判断有没有右子树，同理 
			tree[j].RTree=&tree[2*j+2];
	}
	return tree;
}

//前序遍历 
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
	//有缺点，不能识别空值 
	int len=sizeof(data)/sizeof(data[0]);
	root=Create(data,len);
	PreOrder(root);
	return 0;
} 
