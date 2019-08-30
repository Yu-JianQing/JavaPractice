#include <iostream>
using namespace std;
#include <stdlib.h>
#include <cmath>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define maxsize 100

//基本思想：1.递归：找一个数作为整个数列的中间数（此处选择的是第一个），比这个数大的放右边，
//比这个数小的放左边。然后在对左边和右边的数列做同样操作，最后形成有序的。由此可知，需要数列的
//起始位置和终止位置，设置两个指针分别指向他们，然后不断地与选定的值比较，分左右组。 
//2.非递归：其实就是用栈来储存起始位置与终止位置。 

typedef int Elemtype;

//非递归用到的栈 
typedef struct Stack{
	Elemtype data[maxsize];
	int top;
};

void Init(Stack *S){
	S->top=0;
}

void Push(Stack *S,Elemtype elem){
	if(S->top==maxsize-1){
		cout<<"Stack is full!"<<endl;
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

bool IsEmpty(Stack *S){
	if(S->top==0) return true;
	else return false;
} 
//end非递归用到的栈 

int Partition(Elemtype *data,int start,int tail){//找到中间值所在位置，并将数列分为左右两组 
	int low=start;
	int high=tail;
	Elemtype elem=data[low];//临时变量保存用到的可能会被覆盖的值 
	while(low<high){
		while((low<high)&&(data[high]>elem))	high--;
		if(low<high){
			data[low]=data[high];//直接覆盖设定的中间值 
			low++;
		}	
		while((low<high)&&(data[low]<elem))	low++;
		if(low<high){
			data[high]=data[low];//因为data[high]已经被挪走了，可以直接被覆盖 
			high--;
		}
	}	
	data[low]=elem;//找到的那个位置就是中间的位置，中间位置的数也已经被挪走了，可以直接被覆盖
	return low;
} 

//递归实现 
void Order(Elemtype *data,int start,int tail){
	if(data==NULL||start>=tail)	return ;//递归出口 
	if(start<tail){//开始和终止指针移到中间表示找到中间位置，到最后肯定不论哪个分组都是两指针在中间，也不用往上返回 
		int mid=Partition(data,start,tail);
		Order(data,start,mid-1);//递归左边组 
		Order(data,mid+1,tail);//递归右边组 
	}
}

//非递归实现 
void Order2(Elemtype *data,int start,int tail){
	if(data==NULL||tail-start<1) return ;//tail-start<1其实就是tail=start 
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	Push(S,tail);//先压入后面的指针 
	Push(S,start);//再压入前面的指针 
	while(!IsEmpty(S)){
		start=Pop(S);//取出前面的指针 
		tail=Pop(S);//取出后面的指针 
		int mid=Partition(data,start,tail);//找到中间值 
		if(tail>mid+1){//右半边 
			Push(S,tail);
			Push(S,mid+1);//改变前面指针 
		}
		if(mid-1>start){//左半边 
			Push(S,mid-1);//改变后面指针
			Push(S,start);
		}
	}
} 


void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Stack s;
	Elemtype data[]={35,2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	//Order(data,0,datasize-1);
	Order2(data,0,datasize-1);
	Print(data,datasize);
	return 0;
} 
