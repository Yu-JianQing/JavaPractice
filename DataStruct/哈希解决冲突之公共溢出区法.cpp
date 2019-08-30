#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define hashsize 5
#define NULLVALUE -32768

//����˼�룺�ó���ȡ�෨��Ϊhash�������ù���������������ͻ 

typedef int Elemtype;
typedef struct HashTable{
	Elemtype *elem;//ָ��δ������ݴ�ŵ�ַ 
	Elemtype *extraelem;//ָ������� 
	int count;//�����Ԫ�صĸ��� 
};

void Init(HashTable *hashtable){
	hashtable->elem=(Elemtype *)malloc(sizeof(Elemtype));
	hashtable->extraelem=(Elemtype *)malloc(sizeof(Elemtype));
	hashtable->count=0;
	for(int i=0;i<hashsize;i++){//�������������������Ϊ�� 
		hashtable->elem[i]=NULLVALUE;
		hashtable->extraelem[i]=NULLVALUE;
	}
} 

int GetAD(int elem){
	return elem%hashsize;	//hash����
}

void Insert(HashTable *hashtable,Elemtype elem){
	int ad=GetAD(elem);
	if(hashtable->elem[ad]==NULLVALUE)
		hashtable->elem[ad]=elem;
	else if(hashtable->count!=hashsize)
		hashtable->extraelem[hashtable->count++]=elem;//�����ͻ 
	else
		return ;
}

void Create(HashTable *hashtable,Elemtype data[],int datasize){
	for(int i=0;i<datasize;i++)
		Insert(hashtable,data[i]);
}

int Select(HashTable *hashtable,Elemtype elem){
	int ad=GetAD(elem);
	int count=0;
	if(hashtable->elem[ad]!=NULLVALUE)
		return ad;
	else{
		while(hashtable->extraelem[count]!=elem)
			count++;
		return count;
	}
	return error;
}

void Remove(HashTable *hashtable,Elemtype elem){
	int ad=GetAD(elem);
	int count=0;
	if(hashtable->elem[ad]!=NULLVALUE)
		hashtable->elem[ad]=NULLVALUE;
	else{
		while(hashtable->extraelem[count]!=elem)
			count++;
		hashtable->extraelem[count]=NULLVALUE;
	}
}

void Print(HashTable *hashtable){
	for(int i=0;i<hashsize;i++)
		cout<<hashtable->elem[i]<<"  ";
	cout<<endl;
	for(int j=0;j<hashsize;j++)
		cout<<hashtable->extraelem[j]<<"  ";
	cout<<endl;
}


int main(){
	Elemtype data[]={1,2,3,4,5,6,7,8,9,10};
	int datasize=sizeof(data)/sizeof(data[0]);
	HashTable *hashtable=(HashTable *)malloc(sizeof(HashTable));
	Init(hashtable);
	Create(hashtable,data,datasize);
	Print(hashtable);
	cout<<Select(hashtable,4)<<endl;
	Remove(hashtable,4);
	Print(hashtable);
	return 0;
} 
