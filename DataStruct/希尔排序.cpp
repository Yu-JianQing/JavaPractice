#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2

//希尔排序是插入排序的优化，是比较特殊的插入排序 
//基本思想：先将数列按照特定的步长分组，然后组内用直接插入排序，再步长
//慢慢变小，直到变为1，则变成了直接插入排序但此时已基本有序，所以不需移动很多次数 

typedef int Elemtype;

Elemtype *Order(Elemtype *data,int datasize){
	for(int gap=datasize/2;gap>0;gap=gap/2){//按步长递减方式分组。一般的步长取值方法就是
											//不断地除2，但按素数递减的方式更有效。 
		for(int i=gap;i<datasize;i++){//分组后的一趟排序。按直接插入排序方法。
									//分组时会出现只有一个元素在一个组的情况，它会自动轮空，等待下一组 
		//i=gap就是从一组的第二个元素开始向有序数列中加运用直接插入排序方法。
		//i每加一次，就会从当前组跳到下一组，依次进行，直到最后一个元素也即最后一组 
			Elemtype x=data[i];//存储要插入的元素 
			int j=i-gap;
			while(x<data[j]&&j>=0){//找要插入的位置
				//注意：循环条件中尽量不要出现减号，因为减了可能出现<0不再数组区域内的问题。 
				data[j+gap]=data[j];
				j=j-gap;
			}//此时j在j-gap位置，要插入元素的位置是j 
//			 !
//			 !
//			 !
//			\/
//		for和while之间的转换 
//			for(int j=i-gap;x<data[j]&&j>=0;j=j-gap;)
//				data[j+gap]=data[j];
			data[j+gap]=x;
		}
	} 
	return data;
}

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Elemtype data[]={2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	return 0;
} 
