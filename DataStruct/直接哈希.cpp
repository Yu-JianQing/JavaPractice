#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2	
#define maxsize 20 
typedef int Elemtype;

//����˼�룺����ͨ���۲쿴���ݺʹ洢��ַ֮��Ĺ�ϵ�ó�hash���������������ݺ���
//���ڵĵ�ַһһ��Ӧ 

int *hash(int data[],int n){
	int *address=new int[maxsize];
	for(int i=0;i<n;i++)
		address[i]=data[i]-1945;//������洢֮��Ĺ�ϵ 
	return address;
}

int main(){
	int data[]={1945,1953,1982,1952,1957,1985,1999,1967,1978};
	int n=sizeof(data)/sizeof(data[0]);
	int *p=hash(data,n);
	for(int i=0;i<n;i++)
		cout<<p[i]<<endl;
	return 0;
} 

//С֪ʶ�㣺�����ķ�������ʱ����ʱ���Ƿ���������׵�ַҲ����һ��ָ��
//�����ں����еı������Ǿֲ��������������飩��ֻ��ͨ��new�����Ŀռ�Ų��Ǿֲ�����������ȫ�ֱ��� 
