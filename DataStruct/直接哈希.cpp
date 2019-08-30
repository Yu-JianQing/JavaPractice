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

//基本思想：就是通过观察看数据和存储地址之间的关系得出hash函数，进而将数据和其
//所在的地址一一对应 

int *hash(int data[],int n){
	int *address=new int[maxsize];
	for(int i=0;i<n;i++)
		address[i]=data[i]-1945;//数据与存储之间的关系 
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

//小知识点：函数的返回类型时数组时，是返回数组的首地址也就是一个指针
//所有在函数中的变量都是局部变量（包括数组），只有通过new出来的空间才不是局部变量，属于全局变量 
