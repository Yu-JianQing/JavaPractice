#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2	
#define max 100
//基本思想：从LB中取出一元素，判断该元素是否在LA中，如果不在则插入LA中

typedef struct{
	int *elem;
	int length;
}sqlist;

void Init(sqlist &L){
	L.elem=new int[max];
	L.length=0;
}  

void Create(sqlist &L){
	int amount;
	cout<<"input the length of list:"<<endl;
	cin>>amount;
	cout<<"input some figures:"<<endl;
	for(int i=0;i<amount;i++){
		cin>>L.elem[i];
		L.length++;
	}
}

void Print(sqlist &L){
	for(int i=0;i<L.length;i++){
		cout<<L.elem[i]<<endl;
	}
}

void Combine(sqlist &LA,sqlist &LB){//合并两个表,合并到一个表中 
	for(int i=0;i<LB.length;i++){
		int count=0;//设置一个信号，用于指示两个表中是否有相同的元素，有的话count>0,没有的话count=0 
		for(int j=0;j<LA.length;j++){
			if(LB.elem[i]==LA.elem[j])
				count++;
		}
		if(count==0)
		LA.elem[LA.length++]=LB.elem[i];
	}
}

int main(){
	sqlist LA,LB;
	Init(LA);
	Init(LB);
	Create(LA);
	Create(LB);
	Combine(LA,LB);
	Print(LA);
	return 0;
} 
