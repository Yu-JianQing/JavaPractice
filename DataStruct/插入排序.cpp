#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define flag -32768//用于占用数组的第0个位置 

//基本思想：无序序列插入无序序列。
//插入排序一般有三个步骤：定位（元素应该插在哪）、挤空（即为待插入的元素挪出一个位置）、插入 
//不同的定位方法导致不同的插入算法 

typedef int Elemtype;

void Order(Elemtype *data,int datasize){//顺序定位法的插入排序 
	for(int i=2;i<datasize;i++){//将第一个元素视为有序序列，从第二个开始不断插入有序序列 
		data[0]=data[i];//数组第0个位置存放当前要插入的元素 
		int j=i-1; //j表示有序序列的最后一个元素的位置 
		while(data[0]<data[j]){//从有序序列最后一个位置往前比较直到比到比要插入元素小的元素 
			data[j+1]=data[j];
			j--;
		}//此时j表示带插入元素的前一个位置 
		data[j+1]=data[0];
	}
} 


//二分定位法的插入排序 
//二分查找是基于已经排好序的序列，而插入排序正是从有序中找位置 
void HalfSort(Elemtype *data,int datasize){
	int start;
	int tail;
	int mid;
	for(int i=2;i<datasize;i++){
		data[0]=data[i];//数组第0个位置存放当前要插入的元素 
		start=1;
		tail=i-1;
		mid=(start+tail)/2;
		//定位 
		while((data[0]>=data[mid]&&data[0]<=data[mid+1])==false){//直到待插入元素比其插入位置的前一个元素大，比后一个元素小 
			 if(data[0]>data[mid])
				start=mid+1;
			else
				tail=mid-1;
			mid=(start+tail)/2;
		}//定位完之后第mid是其插入位置的前一个，则第mid+1是其要插入的位置
		
		//挤空插入 
		for(int j=i;j>mid+1;j--)
			data[j]=data[j-1];
		data[mid+1]=data[0];
	} 
}

void Print(Elemtype *data,int datasize){
	for(int i=1;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Elemtype data[]={flag,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	HalfSort(data,datasize);
	Print(data,datasize);
	return 0;
} 
