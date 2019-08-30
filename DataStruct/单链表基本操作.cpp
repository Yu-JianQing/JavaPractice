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
	newnode->next=p->next;//������ôд 
	p->next=newnode;
	//newnode->next==NULL;�������ȥ�������ѭ�� 
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
	p->next=q->next;//����Ҫ�����ӵ��������½�һ���ڵ����һ������ 
	free(q);
//	p->next=p->next;
//	free(p);
} 

void Print(Node *node){
	for(Node *newnode=node->next;newnode!=NULL;newnode=newnode->next)
		cout<<newnode->elem<<"  ";
	cout<<endl;
}

//���������������ð�����򣬵��������������ʽ����
//����λ�ò����㣬����ֻ�������ڽڵ��е����ݼ��� 

int main(){
	Node *node;
	node=(Node *)malloc(sizeof(Node));//��������д������ȫ�ֱ��� 
	Init(node);
	Create(node);
	Print(node);
	LastInsert(node,10);
	Print(node);
	Remove(node,2);
	Print(node);
	return 0;
} 
