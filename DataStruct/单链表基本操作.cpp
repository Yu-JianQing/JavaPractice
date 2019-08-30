#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2	

typedef int elemtype; 
typedef struct Node{
	elemtype elem;
	struct Node *next;
}Node; 

void Init(Node *node){
	node->elem=0; 
	node->next=NULL;
}

void HeadInsert(Node *node,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	newnode->next=node->next;
	node->next=newnode;
}

void LastInsert(Node *node,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	Node *p=node;
	for(;p->next!=NULL;p=p->next);
	newnode->next=p->next;//必须这么写 
	p->next=newnode;
	//newnode->next==NULL;这样插进去后会无限循环 
}

void Create(Node *node){
	int count;
	elemtype elem;
	cout<<"input the count of nodes:"<<endl;
	cin>>count;
	for(int i=0;i<count;i++){
		cout<<"input a number:"<<endl;
		cin>>elem;
		HeadInsert(node,elem);
	}
}

void Remove(Node *node,int pos){
	Node *p=node;
	for(int i=0;i<pos-1;i++)
		p=p->next;
	Node *q=p->next;
	p->next=q->next;//必须要有连接的桥梁，新建一个节点就是一个桥梁 
	free(q);
//	p->next=p->next;
//	free(p);
} 

void Print(Node *node){
	for(Node *newnode=node->next;newnode!=NULL;newnode=newnode->next)
		cout<<newnode->elem<<"  ";
	cout<<endl;
}

//单链表的排序类似冒泡排序，但由于是链表的形式来回
//交换位置不方便，所以只交换相邻节点中的数据即可 

int main(){
	Node *node;
	node=(Node *)malloc(sizeof(Node));//必须在这写才属于全局变量 
	Init(node);
	Create(node);
	Print(node);
	LastInsert(node,10);
	Print(node);
	Remove(node,2);
	Print(node);
	return 0;
} 
