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
//基本思想：线性表LC初始为空。一次扫描LA和LB中的元素，比较当前元素的值，
//将较小的元素插入LC的表尾，直到一个线性表扫描完，然后将未完成的那个线性表的余下元素逐个插入到LC的表尾 

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
	cout<<"input some sequentital figures:"<<endl;
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

void Combine(sqlist &LA,sqlist &LB,sqlist &LC){
	int i=0,j=0;
	int m=LA.length,n=LB.length;
	while(i<m&&j<n){//两个线性表都还没处理完 
		if(LA.elem[i]>=LB.elem[j]){
				LC.elem[LC.length]=LB.elem[j];
				LC.length++;j++;
			}else{
				LC.elem[LC.length]=LA.elem[j];
				LC.length++;i++;
			}
	}
	while(i<m){//LA没处理完 
		LC.elem[LC.length]=LA.elem[i];
		LC.length++;
		i++;
	}
	while(j<m){//LB没处理完 
		LC.elem[LC.length]=LB.elem[j];
		LC.length++;
		j++;
	}
}

int main(){
	sqlist LA,LB,LC;
	Init(LA);
	Init(LB);
	Init(LC);
	Create(LA);
	Create(LB);
	Combine(LA,LB,LC);
	Print(LC);
	
	return 0;
} 
