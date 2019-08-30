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

//����˼�룺�ó���ȡ�෨��Ϊhash������������ַ�������ͻ 

typedef int Elemtype;

typedef struct Node{//����ڵ� 
	Elemtype elem;
	struct Node *next;
};

typedef struct HashNode{//hash�ڵ� 
//	int serial;//��ǰ�ڵ��ţ�������Ҫ��Ϊ�ó���ȡ�෨��ַ���Ǳ�� 
	int count;//��ǰ�ڵ�����������ݣ����˶���Node�� 
	Node *first;//���ĵ�һ���ڵ� 
	Node *tail;//�������һ���ڵ� 
};

void Init(HashNode *hashtable){
	for(int i=0;i<hashsize;i++){
		hashtable[i].count=0;
		hashtable[i].first=NULL;
		hashtable[i].tail=hashtable[i].first;
	}
} 

int GetAD(int elem){
	return elem%hashsize;	//hash����
}

void Insert(HashNode *hashtable,Elemtype elem){//����ַ�������ͻ 
	int ad=GetAD(elem);
	Node *newnode=(Node *)malloc(sizeof(Node));
	newnode->elem=elem;//β�巨�����½ڵ� 
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
	int count=0;//��¼Ҫ���ҵ������ڵ�ǰ�����д��ڵڼ�����λ�� 
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
	if(count==error)	return ;//���ǵ������û�ڱ��� 
	Node *p=hashtable[ad].first+count-1;//ɾ���ڵ� 
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
