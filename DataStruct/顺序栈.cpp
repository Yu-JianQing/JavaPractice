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
typedef struct Stack{
	Elemtype data[maxsize];
	int top;
};

void Init(Stack *S){
	S->top=0;
}

void Push(Stack *S,Elemtype elem){
	if(S->top==maxsize-1){
		cout<<"Stack is full!"<<endl;cout<<111;
		return ;
	}
	S->data[S->top]=elem;
	S->top++;
}

Elemtype Pop(Stack *S){
	Elemtype elem;
	if(S->top==0){
		cout<<"Stack is empty!"<<endl;
		return error;
	}
	elem=S->data[--S->top];
	return elem;
}

void Create(Stack *S){
	int count;
	Elemtype elem;
	cout<<"input the count of numbers:"<<endl;
	cin>>count;
	for(int i=0;i<count;i++){
		cout<<"input a figure:"<<endl;
		cin>>elem;
		Push(S,elem);
	}
}

void Insert(Stack *S,int pos,Elemtype elem){
	//top不用提前加1，因为它已经在最上面的一个无数据的空间上 
	int len=S->top;
	for(int p=pos-1;p<S->top;p++,len--)
		S->data[len]=S->data[len-1];//S->data[len]=S->data[--len];不能这么写，因为它会先算--len再算整体 
	S->data[pos-1]=elem;
	S->top++;
}

void Remove(Stack *S){
	Pop(S);
}

void RemoveOfPos(Stack *S,int pos){
	for(pos=pos-1;pos<S->top;pos++)
		S->data[pos]=S->data[pos+1];
	S->top--;
}

void Destory(Stack *S){
	S->top=0;	
}

void Print(Stack *S){
	if(S->top==0){
		cout<<"Stack is empty!"<<endl;
		return ;
	}
	for(int i=0;i<S->top;i++)
		cout<<S->data[i]<<"  ";
	cout<<endl;
} 

int main(){
	Stack *S;
	S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	Create(S);
	Print(S);
	Insert(S,2,5);
	Print(S);
	Remove(S);
	Print(S);
	RemoveOfPos(S,2);
	Print(S);
	Destory(S);
	Print(S);
	return 0;
}
