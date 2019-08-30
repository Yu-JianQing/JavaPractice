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
#define maxsize 100

//fibonacci数列特点：从第三个数开始，后一个的数等于其前两个数之和
//基本思想：1.递归：按表达式写即可
//2.非递归，由数列特点知需要三个指针，分别指向要求的位置，还有其前两个位置。 

//递归 
int F(int n){
	if(n<=1)	return n;//递归出口 
	if(n>1)		return F(n-1)+F(n-2);//递归完成后就已经得到想要的数，不用再返回了。 
}

//非递归 
int F2(int n){
	int pre=0;
	int now=1;
	if(n<=1)	return n;
	if(n>1){
		for(int i=1;i<n;i++){
			int next=pre+now;
			pre=now;
			now=next;
		}
		return now;
	}
} 

int main(){
	int n=8;
	cout<<F2(n)<<endl;
	return 0;
}
