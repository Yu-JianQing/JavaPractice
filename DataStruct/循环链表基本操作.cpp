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
typedef struct List{
	Node *head;//头结点 
	Node *tail;//尾指针 
	int size;
};

void Init(List *list){
	list->head=(Node *)malloc(sizeof(Node));
	list->head->next=list->head;
	list->tail=list->head;
	list->size=0;
}

void HeadInsert(List *list,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	newnode->next=list->head->next;
	list->head->next=newnode;
	if(list->size==0){
		list->tail=newnode;
		newnode->next=list->head;
	}
	list->size++;
}

void LastInsert(List *list,elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	list->tail->next=newnode;
	newnode->next=list->head;
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

void Remove(List *list,int pos){
	Node *p=list->head;
	for(int i=0;i<pos-1;i++)
		p=p->next;
	Node *q=p->next;
	if(pos==list->size){
		p->next=list->head;
		list->tail=p;
	}else{
		p->next=q->next;
	}
		
	free(q);
	list->size--;
}

void Print(List *list){
	Node *p=list->head->next;
	while(list->head!=p){
		cout<<p->elem<<endl;
		p=p->next;
	}
}

int main(){
	List *list;
	list=(List *)malloc(sizeof(List));//必须在这写才属于全局变量 
	Init(list);
	Create(list);
	Print(list);
	LastInsert(list,10);
	Print(list);
	Remove(list,2);
	Print(list);
	return 0;
} 
