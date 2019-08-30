#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define SIZE 23 	//用作hash运算，最好是素数 
#define hashsize 50
#define NULLVALUE -32768

//基本思想：用除留取余法作为hash函数，用再哈希法解决冲突 

typedef int Elemtype;
typedef struct HashTable{
	Elemtype elem[hashsize];//存放数据 
	int size;//有效数据 
};

void Init(HashTable *hash){
	for(int i=0;i<hashsize;i++)
		hash->elem[i]=NULLVALUE;
	hash->size=0;
}

int GetAD(int elem){
	return elem%SIZE;	//hash函数
}

void Insert(HashTable *hash,int elem){
	int ad=GetAD(elem);
	if(hash->elem[ad]==NULLVALUE)
		hash->elem[ad]=elem;
	else
		hash->elem[GetAD(elem+10)]=elem;	//解决冲突：再哈希 
	hash->size++;
}

void Create(HashTable *hash,int data[],int datasize){
	for(int i=0;i<datasize;i++)
		Insert(hash,data[i]);
}

int Select(HashTable *hash,int elem){
	int ad=GetAD(elem);
	if(hash->elem[ad]!=elem){
		ad=GetAD(elem+SIZE);
		if(hash->elem[ad]==NULLVALUE)//数可能没在表中的情况 
			return -1;
	}
	return ad;
}

void Remove(HashTable *hash,int elem){
	int ad=Select(hash,elem);
	if(ad==error)	return ;//考虑到这个数没在表中 
	hash->elem[ad]=NULLVALUE;
	hash->size--;
}

void Print(HashTable *hash){
	for(int i=0;i<hashsize;i++)
		cout<<hash->elem[i]<<"  ";
	cout<<endl;
}

int main(){
	int data[20]={1,2,3,4,5,6,7,8,21,10,
					23,24,13,14,28,16,17,18,19,20}; 
	int datasize=sizeof(data)/sizeof(data[0]);
	HashTable *hash=(HashTable *)malloc(sizeof(HashTable));
	Init(hash);
	Create(hash,data,datasize);
	Print(hash);
	cout<<Select(hash,10)<<endl;
	Remove(hash,10);
	Print(hash);
	return 0;
}
