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

//基本思想：用除留取余法作为hash函数，用链地址法解决冲突 

typedef int Elemtype;

typedef struct Node{//链表节点 
	Elemtype elem;
	struct Node *next;
};

typedef struct HashNode{//hash节点 
//	int serial;//当前节点编号，不再需要因为用除留取余法地址就是编号 
	int count;//当前节点包含多少数据（链了多少Node） 
	Node *first;//链的第一个节点 
	Node *tail;//链的最后一个节点 
};

void Init(HashNode *hashtable){
	for(int i=0;i<hashsize;i++){
		hashtable[i].count=0;
		hashtable[i].first=NULL;
		hashtable[i].tail=hashtable[i].first;
	}
} 

int GetAD(int elem){
	return elem%hashsize;	//hash函数
}

void Insert(HashNode *hashtable,Elemtype elem){//链地址法解决冲突 
	int ad=GetAD(elem);
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;//尾插法插入新节点 
	newnode->next=NULL;
	Node *p=hashtable[ad].first;
	if(hashtable[ad].first==NULL){
		hashtable[ad].first=newnode;
		hashtable[ad].tail=hashtable[ad].first;
	}else{
		hashtable[ad].tail->next=newnode; 
		hashtable[ad].tail=hashtable[ad].tail->next;
	}
	hashtable[ad].count++;
}

void Creat(HashNode *hashtable,Elemtype data[],int datasize){
	for(int i=0;i<datasize;i++)
		Insert(hashtable,data[i]);
}

int Select(HashNode *hashtable,Elemtype elem){
	int count=0;//记录要查找的数据在当前链表中处于第几个的位置 
	int ad=GetAD(elem);
	Node *p=hashtable[ad].first;
	while(p->elem!=elem){
		p=p->next;
		count++;
		if(p==NULL)
			return error;
	}
	return count;
}

void Remove(HashNode *hashtable,Elemtype elem){
	int ad=GetAD(elem);
	int count=Select(hashtable,elem);
	if(count==error)	return ;//考虑到这个数没在表中 
	Node *p=hashtable[ad].first+count-1;//删除节点 
	Node *q=p->next;
	p->next=q->next;
	free(q);
	hashtable[ad].count--;
}

void Print(HashNode *hashtable){
	for(int i=0;i<hashsize;i++){
		cout<<"The "<<i<<" list has "<<hashtable[i].count<<" numbers"<<endl;
		Node *p=hashtable[i].first;
		while(p!=NULL){
			cout<<p->elem<<"  ";
			p=p->next;
		}
		cout<<endl;
	}
}

int main(){
	Elemtype data[]={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
	int datasize=sizeof(data)/sizeof(data[0]);
	HashNode *hashtable=new HashNode[hashsize];
	Init(hashtable);
	Creat(hashtable,data,datasize);
	Print(hashtable);
	cout<<Select(hashtable,10)<<endl;
	Remove(hashtable,10);
	Print(hashtable);
	return 0;
}
