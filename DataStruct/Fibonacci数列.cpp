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

//fibonacci�����ص㣺�ӵ���������ʼ����һ������������ǰ������֮��
//����˼�룺1.�ݹ飺�����ʽд����
//2.�ǵݹ飬�������ص�֪��Ҫ����ָ�룬�ֱ�ָ��Ҫ���λ�ã�������ǰ����λ�á� 

//�ݹ� 
int F(int n){
	if(n<=1)	return n;//�ݹ���� 
	if(n>1)		return F(n-1)+F(n-2);//�ݹ���ɺ���Ѿ��õ���Ҫ�����������ٷ����ˡ� 
}

//�ǵݹ� 
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
