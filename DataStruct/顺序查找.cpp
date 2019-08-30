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

//基本思想：第0个放需查找的元素，然后从第一个依次往后查找直到找到与第0个相同的元素 

void Input(int data[],int n){
	cout<<"Please input "<<n-1<<" figures!"<<endl;
	for(int i=1;i<n;i++)
		cin>>data[i];
}

int Select(int data[],int key){
	int i=1;
	while(data[i]!=key)
		i++;
	return i;
} 

int main(){
	int data[6];
	int n=sizeof(data)/sizeof(data[0]);//数组的长度不能放在函数中这样求，因为数组为参数时，传递的是指针
	//这样算出来的是指针的大小不是数组长度，只能先算出来再将其当做函数的参数使用 
	Input(data,n);
	cout<<"Input your figure:"<<endl;
	cin>>data[0];//data[0]用于存放需要查找的值 
	cout<<Select(data,data[0])<<endl;
	return 0;
} 
