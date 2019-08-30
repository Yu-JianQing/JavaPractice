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
	struct Node *pro;
	struct Node *next;
}Node;
typedef struct List{
	Node *head;//头指针 
	Node *tail;//尾指针 
	int size;
};
void Init(List *list){
	Node *node=(Node *)malloc(sizeof(Node));
	node->pro=NULL;
	node->next=NULL;
	list->head=node;
	list->tail=node;
	list->size=0;
}

void HeadInsert(List *list,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	if(list->size!=0){
		newnode->next=list->head->next;
		list->head->next->pro=newnode;
	}else{
		newnode->next=NULL;
		list->tail=newnode;
	}
	list->head->next=newnode;
	newnode->pro=list->head;
	list->size++;
}

void LastInsert(List *list,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	newnode->next=NULL;
	list->tail->next=newnode;
	newnode->pro=list->tail;
	list->tail=newnode;
	list->size++;
}

void Create(List *list){
	int count;
	elemtype elem;
	cout<<"input the count of nodes:"<<endl;
	cin>>count;
	for(int i=0;i<count;i++){
		cout<<"input a number:"<<endl;
		cin>>elem;
		HeadInsert(list,elem);
	}
}

void Reserve(List *list){
	Node *newnode=(Node *)malloc(sizeof(Node));
	Node *p=list->tail;
	list->tail=newnode;
	while(list->head!=p){
		list->tail->next=p;
		p=p->pro;//必须先把p指向其前一个节点否则改变后找不到其前驱 
		p->next->pro=list->tail;
		list->tail=list->tail->next;
	}
	list->tail->next=NULL;
	free(list->head);
	list->head=newnode;
} 

void Remove(List *list,int pos){
	Node *p=list->head->next;
	for(int i=0;i<pos-2;i++)
		p=p->next;
	if(pos==list->size){
		free(list->tail);
		p->next=NULL;
		list->tail=p;
	}else{
		Node *q=p->next;
		p->next=q->next;
		q->next->pro=p;
		free(q);
	}
	list->size--;
} 

void Print(List *list){
	Node *p=list->head->next;
	while(p!=NULL){
		cout<<p->elem<<"  ";
		p=p->next;
	}
	cout<<endl;
}

int main(){
	List *list;
	list=(List *)malloc(sizeof(List));//必须在这写才属于全局变量 
	Init(list);
	Create(list);
	Print(list);
	LastInsert(list,10);
	Print(list);
	Reserve(list);
	Remove(list,2);
	Print(list);
	
	return 0;
}
