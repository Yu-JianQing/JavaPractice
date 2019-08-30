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

//����˼�룺1.�ݹ飺���ϵرȽϵ�һ�������һ��λ��ֵ�Ƿ���ȼ��ɡ� 

//�ݹ� 
bool Judge(string &S,int start,int tail){
	if(start==tail)	return true;//�ݹ���� 
	if(tail>start){//ֱ����ָ���Ƶ��м� 
		if(S[start]==S[tail])
			return Judge(S,++start,--tail);
		else
			return false;
	}
}


//�ǵݹ�
bool Judge2(string &S,int start,int tail){
	if(start==tail)	return true;
	if(tail>start){
		while(tail>start){
			if(S[start]==S[tail]){//ѭ�������в����ж�ÿ�εĵ�һ�������һ��λ��ֵ�Ƿ����
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
	//c++string���Ƿ�װ�õ��࣬����string��ʵ��������һ��ָ�룬ָ��ָ��һ������ַ����ĵ�ַ 
	cout<<Judge(S,0,S.length()-1)<<endl;;
	cout<<Judge2(S,0,S.length()-1)<<endl;;
	return 0;
}
