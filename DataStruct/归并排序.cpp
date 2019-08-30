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
#define flag -32768

//基本思想：将数列不断划分，直到划分的序列有序，然后再将有序序列合并 
//1.递归：将数列不断地分为左右两部分，直到左右两个数列变为有序序列为止，（划分到一个元素一组时肯定有序）然后
//不断地将左右有序序列合并成新的有序序列，直到合并完为止 。划分时需要前后两个指针，不断地将数列划分。 
//从上到下划分再从下到上合并 
//2.非递归：直接从下到上合并，同样需要开始和结束位置。然后在合并中同样也需要每个组的前后两个指针 

typedef int Elemtype;

void Merge(Elemtype *data,int start,int tail){
	int mid=(start+tail)/2;
	int *p=(Elemtype *)malloc((tail-start+1)*sizeof(Elemtype));//合并两个固定长度的有序表，需要一个新的空间存储 
								//空间的容量就是数组的长度 
	int Lstart=start;//左部分起始地址 
	int Rstart=mid+1;//右部分起始地址 
	int k=0;
	//合并两个有序表 
	while(Lstart<=mid&&Rstart<=tail){
		if(data[Lstart]>=data[Rstart])
			p[k++]=data[Rstart++];
		else
			p[k++]=data[Lstart++];
	}
	while(Lstart<=mid)
		p[k++]=data[Lstart++];
	while(Rstart<=mid)
		p[k++]=data[Rstart++];
//	data=p;不能这么写，因为data表示的是数组的首地址，一般来说是不可更改的，它只指向数组。 
	for(int i=0;i<k;i++)//将p中的数拷贝到data中 
		data[start+i]=p[i];
	free(p);
}


//递归实现:先自上而下分割再自下而上合并 
void Order(Elemtype *data,int start,int tail){
	if(data==NULL||start>=tail)//递归出口：当划分的数列只有一个元素时肯定是有序的 
        return ;
	int mid=(start+tail)/2;
	Order(data,start,mid);//划分的左部分 
	Order(data,mid+1,tail);//划分的右部分 
	Merge(data,start,tail);//合并两个有序数列：由于两个数组是由一个数组划分的，
							//所以只传递那个未划分前的数组即可 
} 

//递归的代码实现过程：将数组划分为只有一个数组的元素时，已经递归到最后一层
//然后再往上返回，在返回的过程中属于递归的程序代码不会再执行一遍，会忽略掉
//并且是按照递归的先后顺序进行向上返回，返回过程中会执行递归下面的程序 



//非递归实现：直接自下而上合并 
//(1,2),(3,4),(5,6),(7,8) 
//(1 2,3 4),5 6，7 8
//(1 2 3 4，5 6 7 8)
//1  2  3  4  5  6  7  8
//自下而上时是相当于直接从递归的第二层开始的 
void Order2(Elemtype *data,int start,int tail){
	int Lmin,Lmax;//左半部分的开始和结束 
	int Rmin,Rmax;//右半部分的开始和结束
	int length=tail-start+1;//数列长度 
	for(int i=1;i<=length;i=2*i){//一共需合并多少趟：n=2的m次方，是以2的指数增长的 
		for(Lmin=start;Lmin<length-i;Lmin=Rmax+1){//一趟需要合并多少组：因为每一趟的分组组数与i相同
											//*	 //i也是每次分组，组内左部分或右部分的长度 
												//则最后一个分组的左部分的开始位置一定不会超过右半部分的开始位置
												//length-i就是最后一组右半部分的开始 
			Lmax=Lmin+i-1;//左半部分的最后位置为开始位置+组内长度-1 
			Rmin=Lmax+1;
			Rmax=Rmin+i-1;//同理左半部分 
			Merge(data,Lmin,Rmax);//两两分组合并 
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
	//Order(data,0,datasize-1);//传进去的表示数组末尾的参数应该是datasize-1，因为数组从0开始 
	Order2(data,0,datasize-1); 
	Print(data,datasize);
	return 0;
} 
