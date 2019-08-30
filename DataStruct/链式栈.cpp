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
#define INITSIZE 100
#define INCREMENT 10

typedef int Elemtype;
typedef struct Stack{
	Elemtype *top;
	Elemtype *base;
	int size; 
};

void Init(Stack *S){
	S->base=(Elemtype *)malloc(INITSIZE*sizeof(Elemtype));
	S->top=S->base;
	S->size=0;
}

void Push(Stack *S,Elemtype elem){ 
	if(S->size==INITSIZE-1){
		S->base=(Elemtype *)realloc(S->base,(S->size+INCREMENT)*sizeof(Elemtype));
		S->top=S->base+INITSIZE;//重新分配后栈底指针可能变化，栈顶也重新定义
	}
	*S->top=elem;
	S->top++;
	S->size++;
}

Elemtype Pop(Stack *S){
	Elemtype elem;
	if(S->top==S->base)
		return error;
	S->top--;
	S->size--;
	return elem=*S->top;
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
	S->size++;//先加一，注意哪里实哪里虚 
	S->top++;
	Elemtype *p=S->top-1;
	Elemtype *q=S->base+pos-1;
	for(int n=pos;n<S->size;n++,p--)//若是从1开始，则从POS+1到最后（n）整体向后移一位，则一共需要n-pos+1次 
		*p=*(p-1);
	*q=elem;
} 

void Remove(Stack *S){
	Pop(S);
}

void RemoveOfPos(Stack *S,int pos){
	S->top=S->base+pos;
	for(pos=pos-1;pos<S->size;pos++)
		*S->top=*(++S->top);
	S->size--;
}

void Destory(Stack *S){
	S->top=NULL;
	S->size=0;
	free(S->base);	
}

void Print(Stack *S){
	if(S->size==0){
		cout<<"Stack is empty!"<<endl;
		return ;
	}
	S->top=S->base;
	for(int i=S->size;i>0;i--){
		cout<<*S->top<<"  ";
		S->top++;
	}
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
