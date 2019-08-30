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

//基本思想：每一趟排序都将最大或最小的元素冒到最后面，直到冒到第一个元素为止 

typedef int Elemtype;

void Order(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++){//趟数。每冒一趟就冒出一个最大的元素放后面，需要将每个数冒到后面才算结束 
		for(int j=0;j<datasize-i-1;j++){//每一趟相邻两个元素需要比较的次数
									//后面i个元素有序，所以还是从第一个开始冒 
			if(data[j]>data[j+1]){//交换 
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
