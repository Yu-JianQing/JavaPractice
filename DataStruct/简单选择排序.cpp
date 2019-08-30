#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define flag -32768

//基本思想：从数列中选出最小的放最前面，再从剩下的元素中选最小的，循环增加有序序列长度 
//选最小元素方法：每次循环都默认第一个元素为最小的并记录下标，若发现有比其更小的，记录下下标
//依次执行直到一趟执行完，然后比较第一个元素的下标是否与记录的下标一致，否，交换 

typedef int Elemtype;

Elemtype *Order(Elemtype *data,int datasize){
	for(int i=1;i<datasize;i++){
		int k=i;//记录最小元素下标，每一趟默认都是第一个元素是最小的
				//同时判断下标是否发生了变化 
		for(int j=i+1;j<datasize;j++)//选出最小元素并记录其下标 
			if(data[j]<data[k])
				k=j;
		if(i!=k){//下标变化说明最小值不再是第一个元素 
			int t=data[i];
			data[i]=data[k];
			data[k]=t;
		}
	} 
}

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}
 
int main(){
	Elemtype data[]={flag,2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	return 0;
} 
