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
typedef struct Queue{
	Elemtype data[maxsize];
	int front;
	int rear;
};

void Init(Queue *Q){
	Q->front=Q->rear=0;
}

Status IsEmpty(Queue *Q){
	if(Q->front==Q->rear)//不用担心循环队列满了时候会不会也是头等于尾，这是不可
	//能的，最多只能是尾在头的前一个位置上 
		return true;
	return false;
}

Status IsFull(Queue *Q){
	if((Q->rear+1)%maxsize==Q->front)
		return true;
	return false;
} 

void EnQueue(Queue *Q,Elemtype elem){
	if(IsFull(Q)==true) return ;
	Q->data[Q->rear%maxsize]=elem;//循环的体现% 
	Q->rear=(++Q->rear)%maxsize;
}

Elemtype DeQueue(Queue *Q){
	if(IsEmpty(Q))
		return error;
	Elemtype elem=Q->data[Q->front];
	Q->front=(++Q->front)%maxsize;
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
	Q->front=Q->rear=0;
}

void Destory(Queue *Q){
	free(Q);
	cout<<"The Queue is destoried!"<<endl;
}

void Print(Queue *Q){
	if(IsEmpty(Q)){
		cout<<"Queue is empty!"<<endl;
		return ;
	}
	for(int p=Q->front;p<Q->rear;p++)
		cout<<Q->data[p]<<"  ";
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
