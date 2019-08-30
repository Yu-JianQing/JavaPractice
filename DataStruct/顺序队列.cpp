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

typedef int Elemtype;
typedef struct Queue{
	Elemtype data[maxsize];
	int front;
	int rear;
}; 

void Init(Queue *Q){
	//Q=(Queue *)malloc(sizeof(Queue));不能写在这里，必须在main中创建空间，因为在这里这是局部变量 
	Q->front=Q->rear=0;
}

void EnQueue(Queue *Q,Elemtype elem){
	Q->data[Q->rear]=elem;
	Q->rear++;
}

Elemtype DeQueue(Queue *Q){
	if(Q->rear==Q->front)
		return error;
	Elemtype elem=Q->data[Q->front];
	Q->front++;
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
	if(Q->rear==Q->front){
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
