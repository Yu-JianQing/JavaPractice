#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define hashsize 20		//hash表的长度 
#define NULLVALUE -10000	//当表中某一位置为空时标记为NULLVALUE 

//基本思想：取关键字被一个不大于哈希表长的数除以的余数作为哈希地址 
//采用开放地址法加1解决冲突 

typedef struct HashTable{
	int elem[hashsize];//存放数据的地方 
	int size;//有效数字 
};

void Init(HashTable *hash){
	for(int i=0;i<hashsize;i++)
		hash->elem[i]=NULLVALUE;
	hash->size=0;
}

int GetAD(int elem){
	return elem%hashsize;	//hash函数
}

void Insert(HashTable *hash,int elem){
	int ad=GetAD(elem);
	while(hash->elem[ad]!=NULLVALUE){
		ad=GetAD(ad+1);	//解决冲突的办法：加1 
		if(ad==GetAD(elem))//直到检查完整个哈希表都没有空位了即地址又重新回到了原位 
			return ;
	}
	hash->elem[ad]=elem;
	hash->size++;
}

void Create(HashTable *hash,int data[],int datasize){
	for(int i=0;i<datasize;i++)
		Insert(hash,data[i]);
}

int Select(HashTable *hash,int elem){
	int ad=GetAD(elem);
	while(hash->elem[ad]!=elem){
		ad=GetAD(ad+1);
		if(hash->elem[ad]==NULLVALUE||ad==GetAD(elem))//数可能没在表中的情况 
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
					11,12,13,14,15,16,17,18,19,20}; 
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
