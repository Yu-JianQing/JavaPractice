#include <iostream>
using namespace std;
#include <stdlib.h>
#include <cmath>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2

//����˼�룺ÿһ�����򶼽�������С��Ԫ��ð������棬ֱ��ð����һ��Ԫ��Ϊֹ 

typedef int Elemtype;

void Order(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++){//������ÿðһ�˾�ð��һ������Ԫ�طź��棬��Ҫ��ÿ����ð������������ 
		for(int j=0;j<datasize-i-1;j++){//ÿһ����������Ԫ����Ҫ�ȽϵĴ���
									//����i��Ԫ���������Ի��Ǵӵ�һ����ʼð 
			if(data[j]>data[j+1]){//���� 
				Elemtype elem=data[j]+data[j+1];
				data[j]=elem-data[j];
				data[j+1]=elem-data[j];
//				Elemtype elem=data[j+1];
//				data[j+1]=data[j];
//				data[j]=elem;
			}
		}
	}
} 

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Elemtype data[]={35,2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	return 0;
} 
