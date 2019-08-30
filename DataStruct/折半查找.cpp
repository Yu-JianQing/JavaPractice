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

//基本思想：前提是有序表，通过一次次地与中间位置的数比较，得出所找的数在前半段还是后半段，直到找到 

void Input(int data[],int n){
	cout<<"Please input "<<n-1<<" figures!"<<endl;
	for(int i=1;i<n;i++)
		cin>>data[i];
}

int Select(int data[],int key,int n){
	int low=1;
	int high=n-1; 
	int mid=(low+high)/2;
	while(key!=data[mid]){//或者判断条件换成low<=high也可以，因为low==high的时候就是最后一次比较了，
	//要么找到等于mid要么没找到，那下面的条件就会变成=，<,>三种情况 
		if(key>data[mid])
			low=mid+1;
		else
			high=mid-1;
		mid=(low+high)/2;
	}
	return mid;
} 

int main(){
	int data[10];
	int n=sizeof(data)/sizeof(data[0]);
	Input(data,n);
	cout<<"Input your figure:"<<endl;
	cin>>data[0];
	cout<<Select(data,data[0],n)<<endl;
	return 0;
} 
