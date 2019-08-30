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

//***前序递归建立树*** 
typedef int Elemtype;
typedef struct Tree{
	Elemtype data;
	struct Tree *LTree;
	struct Tree *RTree;
	bool IsLTree;
};
void Create(Tree **tree,Elemtype *data,int &start,int len){
	if(start>=len||data[start]==NULLVALUE){
		*tree=NULL;
		return ;
	}
	else{
		*tree=(Tree *)malloc(sizeof(Tree));
		(*tree)->data=data[start];
		Create(&(*tree)->LTree,data,++start,len);
		Create(&(*tree)->RTree,data,++start,len);
	}
}
//***end前序递归建立树*** 

Tree *FindMinNode(Tree *tree){//cout<<tree->data<<endl;
	if(tree==NULL)
		return NULL;
	Tree *cur=tree;
	while(cur->LTree!=NULL)
		cur=cur->LTree; 
	return cur;
}

Elemtype FindMinValue(Tree *tree){
	Tree *Min=FindMinNode(tree);
	return Min->data;
}

Tree *FindMaxNode(Tree *tree){
	if(tree==NULL)
		return NULL;
	Tree *cur=tree;
	while(cur->RTree!=NULL)
		cur=cur->RTree;
	return cur;
}

Elemtype FindMaxValue(Tree *tree){
	Tree *Max=FindMaxNode(tree);
	return Max->data;
}

Tree *Find(Tree *tree,Elemtype elem){
	if(tree==NULL)
		return NULL;
	if(tree->data==elem)
		return tree;
	else if(tree->data>elem)
		Find(tree->LTree,elem);
	else 
		Find(tree->RTree,elem);
}

void Add(Tree *tree,Elemtype elem){
	if(tree==NULL){
		tree=(Tree *)malloc(sizeof(Tree));
		tree->data=elem;
	}else if(elem>tree->data&&tree->RTree==NULL){
		tree->RTree=(Tree *)malloc(sizeof(Tree));
		tree->RTree->data=elem;
	}else if(elem<tree->data&&tree->LTree==NULL){
		tree->LTree=(Tree *)malloc(sizeof(Tree));
		tree->LTree->data=elem;
	}else if(elem>tree->data&&tree->RTree!=NULL)
		Add(tree->RTree,elem);
	else if(elem<tree->data&&tree->LTree!=NULL)
		Add(tree->LTree,elem);
}

void Remove(){
	
}

int main(){
	Elemtype data[]={4,2,1,0,0,3,0,0,6,5,0,0,7};
	int len=sizeof(data)/sizeof(data[0]);
	Tree *tree;
	int start=0;
	Create(&tree,data,start,len);
//	Tree *Min=FindMinNode(tree);
//	cout<<Min->data<<endl;
//	Tree *Max=FindMaxNode(tree);
//	cout<<Max->data<<endl;
	cout<<Find(tree,2)->data<<endl;
	Add(tree,10);
	cout<<Find(tree,10)->data<<endl;
	return 0;
} 
