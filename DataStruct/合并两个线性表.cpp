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
//����˼�룺��LB��ȡ��һԪ�أ��жϸ�Ԫ���Ƿ���LA�У�������������LA��

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

void Combine(sqlist &LA,sqlist &LB){//�ϲ�������,�ϲ���һ������ 
	for(int i=0;i<LB.length;i++){
		int count=0;//����һ���źţ�����ָʾ���������Ƿ�����ͬ��Ԫ�أ��еĻ�count>0,û�еĻ�count=0 
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
