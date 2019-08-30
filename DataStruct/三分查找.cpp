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

void Input(int data[],int n){
	cout<<"Please input "<<n-1<<" figures!"<<endl;
	for(int i=1;i<n;i++)
		cin>>data[i];
}

int Select(int data[],int key,int n){//可以缩小1/3或2/3 
	int low=1;
	int high=n; 
	int mid1,mid2;
	while(low<=high){
		mid1=low+(high-1)/3;
		mid2=low+2*(high-1)/3;
		if(key==data[mid1]) return mid1;
		if(key>data[mid1])
			low=mid1+1;
		else
			high=mid1-1;
	}
	return error;
} 

int Selected(int data[],int key,int n){//可以缩小2/3
	int low=1;
	int high=n; 
	int mid1,mid2;
	while(low<=high){
		mid1=low+(high-1)/3;
		mid2=low+2*(high-1)/3;
		if(key==data[mid1]) return mid1;
		if(key==data[mid2]) return mid2;
		if(key>data[mid1])
			low=mid1+1;
		else
			high=mid1-1;
		if(key<data[mid2])
			high=mid2-1;
		else
			low=mid2+1;
	}
	return error;
} 

int main(){
	int data[10];
	int n=sizeof(data)/sizeof(data[0]);
	Input(data,n);
	cout<<"Input your figure:"<<endl;
	cin>>data[0];
	cout<<Select(data,data[0],n)<<endl;
	cout<<Selected(data,data[0],n)<<endl;
	return 0;
} 
