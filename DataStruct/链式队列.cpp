#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2	
#define maxsize 100

typedef bool Status;
typedef int Elemtype;

typedef struct Node{
	Elemtype elem;
	struct Node *next; 
};
typedef struct Queue{
	struct Node *front;
	struct Node *rear;
	int length;
};

void Init(Queue *Q){
	Q->front=Q->rear=(Node *)malloc(sizeof(Node));
	Q->length=0;
} 

Status IsEmpty(Queue *Q){
	if(Q->front==Q->rear)
		return true;
	return false;
}
	
void EnQueue(Queue *Q,Elemtype elem){
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;
	newnode->next=NULL;
	Q->rear->next=newnode;
	Q->rear=newnode;
	Q->length++;
}

Elemtype DeQueue(Queue *Q){
	if(IsEmpty(Q))
		return error;
	Elemtype elem=Q->front->elem;
	Node *p=Q->front->next;
	Q->front->next=Q->front->next->next;
	free(p);
	Q->length--;
	return elem;
}

void Create(Queue *Q){
	int count;
	Elemtype elem;
	cout<<"input the count of numbers:"<<endl;
	cin>>count;
	for(int i=0;i<count;i++){
		cout<<"input a figure:"<<endl;
		cin>>elem;
		EnQueue(Q,elem);
	}
}

void Remove(Queue *Q){
	DeQueue(Q);
}

void Clear(Queue *Q){
	Q->rear=Q->front;
	Node *p=Q->front->next;
	Q->front->next=NULL;
	Node *q;
	while(p){
		q=p;
		p=p->next;
		free(q);
	}
	Q->length=0;
}

void Destory(Queue *Q){
	while(Q->front!=NULL){//从头往尾删 
		Q->rear=Q->front->next;
		free(Q->front);
		Q->front=Q->rear;
	}
	cout<<"The Queue is destoried!"<<endl;
}

void Print(Queue *Q){
	if(IsEmpty(Q)){
		cout<<"Queue is empty!"<<endl;
		return ;
	}
	Node *p=Q->front->next;
	while(p->next!=NULL){
		cout<<p->elem<<"  ";
		p=p->next;
	} 
	cout<<p->elem<<"  ";
	cout<<endl;
}

int main(){
	Queue *Q;
	Q=(Queue *)malloc(sizeof(Queue));
	Init(Q);
	Create(Q);
	Print(Q);
	Remove(Q);
	Print(Q);
	Clear(Q);
	Print(Q);
	Destory(Q);
	return 0;
}

//注：一般没有链式循环队列，因为循环队列解决的是当长度有限时数据存储产生的假溢出现象。 
