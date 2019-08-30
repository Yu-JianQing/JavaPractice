#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2	
#define maxsize 100

//基本思想：前提：拥有根据数据表建立的索引表
//块的划分：块间有序，块内可无序。 并且前一块中的所有元素必须小于后一块中的所有元素 
//索引表特点：拥有每一块的最大值和每一块的第一个元素的起始位置。
//过程就是按照索引表先找出元素所在的块，再从块中找元素 

typedef int Elemtype;
typedef struct IndexType{//索引表 
	int start;//每块的起始位置 
	Elemtype max;//每块中的最大值 
};

int Select(Elemtype data[],IndexType index[],int indexsize,Elemtype elem){
	int i=0;
	for(;i<indexsize;i++)//找块 
		if(elem<index[i].max)
			break;
	while(elem!=data[index[i].start]){//在块中找元素 
		index[i].start++;
	}
	return index[i].start;
}//不论找块还是找元素都可采用二分查找 

int main(){
	Elemtype data[]={8,14,6,9,10,22,34,18,19,31,40,38,54,66,46,71,78,68,80,85,100,94,88,96,87};
	IndexType index[]={{0,14},{5,34},{10,66},{15,85},{20,100}}; 
	int indexsize=sizeof(index)/sizeof(index[0]);
	cout<<Select(data,index,indexsize,80)<<endl;
	return 0;
}
