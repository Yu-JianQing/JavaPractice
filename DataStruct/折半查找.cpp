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

//����˼�룺ǰ���������ͨ��һ�δε����м�λ�õ����Ƚϣ��ó����ҵ�����ǰ��λ��Ǻ��Σ�ֱ���ҵ� 

void Input(int data[],int n){
	cout<<"Please input "<<n-1<<" figures!"<<endl;
	for(int i=1;i<n;i++)
		cin>>data[i];
}

int Select(int data[],int key,int n){
	int low=1;
	int high=n-1; 
	int mid=(low+high)/2;
	while(key!=data[mid]){//�����ж���������low<=highҲ���ԣ���Ϊlow==high��ʱ��������һ�αȽ��ˣ�
	//Ҫô�ҵ�����midҪôû�ҵ���������������ͻ���=��<,>������� 
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
