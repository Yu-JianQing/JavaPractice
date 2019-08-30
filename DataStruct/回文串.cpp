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

//基本思想：1.递归：不断地比较第一个和最后一个位置值是否相等即可。 

//递归 
bool Judge(string &S,int start,int tail){
	if(start==tail)	return true;//递归出口 
	if(tail>start){//直到两指针移到中间 
		if(S[start]==S[tail])
			return Judge(S,++start,--tail);
		else
			return false;
	}
}


//非递归
bool Judge2(string &S,int start,int tail){
	if(start==tail)	return true;
	if(tail>start){
		while(tail>start){
			if(S[start]==S[tail]){//循环过程中不断判断每次的第一个和最后一个位置值是否相等
				start++;
				tail--;
			}
		else
			return false;
		}
	}
	return true;
}
 

int main(){
	string S;
	cout<<"input a string:"<<endl;
	cin>>S;
	//string *p=S;
	//c++string类是封装好的类，声明string其实是声明了一个指针，指针指向一个存放字符串的地址 
	cout<<Judge(S,0,S.length()-1)<<endl;;
	cout<<Judge2(S,0,S.length()-1)<<endl;;
	return 0;
}
