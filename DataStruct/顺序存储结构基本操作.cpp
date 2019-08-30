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
#define list_size 100
#define list_increment 10

typedef int elemtype;
typedef struct sqlist{
	elemtype *elem;
	int length;
	int size;
}; 

void Init(sqlist &L){
	L.size=list_size;
	L.length=0;
	L.elem=(elemtype *)malloc(sizeof(elemtype)*L.size);
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

elemtype selectOfPos(sqlist &L,int pos){//按位置查找 
	if(pos>=0&&pos-1<L.length)
		return L.elem[pos];	
	else
		return error;
}

int selectOfValue(sqlist &L,elemtype elem){//按数值查找 
	for(int i=0;i<L.length;i++)
		if(L.elem[i]==elem)	
			return i;
	return false;
}

void Insert(sqlist &L,int pos,elemtype elem){//在某个位置插入一个元素 
	if(pos<0||L.length==L.size) exit(overflow);
	int count=L.length++;
	for(;pos<count;count--)
		L.elem[count]=L.elem[count-1];
	L.elem[pos]=elem;
}

void Remove(sqlist &L,int pos){//在某个位置删除一个元素 
	if(pos<0||pos>L.length) exit(overflow);
	for(;pos<L.length;pos++)
		L.elem[pos]=L.elem[pos+1];
	L.length--; 
}

void Print(sqlist &L){
	for(int i=0;i<L.length;i++){
		cout<<L.elem[i]<<endl;
	}
}

int main(){
	sqlist LA;
	Init(LA);
	Create(LA);
	cout<<selectOfPos(LA,2)<<endl;
	cout<<selectOfValue(LA,3)<<endl;
	Print(LA);
	Insert(LA,2,7);
	Print(LA);
	Remove(LA,2);
	Print(LA);
	return 0;
}
