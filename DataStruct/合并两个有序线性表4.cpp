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
//����˼�룺���Ա�LC��ʼΪ�ա�һ��ɨ��LA��LB�е�Ԫ�أ��Ƚϵ�ǰԪ�ص�ֵ��
//����С��Ԫ�ز���LC�ı�β��ֱ��һ�����Ա�ɨ���꣬Ȼ��δ��ɵ��Ǹ����Ա������Ԫ��������뵽LC�ı�β 

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
	while(i<m&&j<n){//�������Ա���û������ 
		if(LA.elem[i]>=LB.elem[j]){
				LC.elem[LC.length]=LB.elem[j];
				LC.length++;j++;
			}else{
				LC.elem[LC.length]=LA.elem[j];
				LC.length++;i++;
			}
	}
	while(i<m){//LAû������ 
		LC.elem[LC.length]=LA.elem[i];
		LC.length++;
		i++;
	}
	while(j<m){//LBû������ 
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
