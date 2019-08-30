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

//����˼�룺1.�ݹ飺��һ������Ϊ�������е��м������˴�ѡ����ǵ�һ���������������ķ��ұߣ�
//�������С�ķ���ߡ�Ȼ���ڶ���ߺ��ұߵ�������ͬ������������γ�����ġ��ɴ˿�֪����Ҫ���е�
//��ʼλ�ú���ֹλ�ã���������ָ��ֱ�ָ�����ǣ�Ȼ�󲻶ϵ���ѡ����ֵ�Ƚϣ��������顣 
//2.�ǵݹ飺��ʵ������ջ��������ʼλ������ֹλ�á� 

typedef int Elemtype;

//�ǵݹ��õ���ջ 
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
//end�ǵݹ��õ���ջ 

int Partition(Elemtype *data,int start,int tail){//�ҵ��м�ֵ����λ�ã��������з�Ϊ�������� 
	int low=start;
	int high=tail;
	Elemtype elem=data[low];//��ʱ���������õ��Ŀ��ܻᱻ���ǵ�ֵ 
	while(low<high){
		while((low<high)&&(data[high]>elem))	high--;
		if(low<high){
			data[low]=data[high];//ֱ�Ӹ����趨���м�ֵ 
			low++;
		}	
		while((low<high)&&(data[low]<elem))	low++;
		if(low<high){
			data[high]=data[low];//��Ϊdata[high]�Ѿ���Ų���ˣ�����ֱ�ӱ����� 
			high--;
		}
	}	
	data[low]=elem;//�ҵ����Ǹ�λ�þ����м��λ�ã��м�λ�õ���Ҳ�Ѿ���Ų���ˣ�����ֱ�ӱ�����
	return low;
} 

//�ݹ�ʵ�� 
void Order(Elemtype *data,int start,int tail){
	if(data==NULL||start>=tail)	return ;//�ݹ���� 
	if(start<tail){//��ʼ����ָֹ���Ƶ��м��ʾ�ҵ��м�λ�ã������϶������ĸ����鶼����ָ�����м䣬Ҳ�������Ϸ��� 
		int mid=Partition(data,start,tail);
		Order(data,start,mid-1);//�ݹ������ 
		Order(data,mid+1,tail);//�ݹ��ұ��� 
	}
}

//�ǵݹ�ʵ�� 
void Order2(Elemtype *data,int start,int tail){
	if(data==NULL||tail-start<1) return ;//tail-start<1��ʵ����tail=start 
	Stack *S=(Stack *)malloc(sizeof(Stack));
	Init(S);
	Push(S,tail);//��ѹ������ָ�� 
	Push(S,start);//��ѹ��ǰ���ָ�� 
	while(!IsEmpty(S)){
		start=Pop(S);//ȡ��ǰ���ָ�� 
		tail=Pop(S);//ȡ�������ָ�� 
		int mid=Partition(data,start,tail);//�ҵ��м�ֵ 
		if(tail>mid+1){//�Ұ�� 
			Push(S,tail);
			Push(S,mid+1);//�ı�ǰ��ָ�� 
		}
		if(mid-1>start){//���� 
			Push(S,mid-1);//�ı����ָ��
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
