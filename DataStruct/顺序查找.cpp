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

//����˼�룺��0��������ҵ�Ԫ�أ�Ȼ��ӵ�һ�������������ֱ���ҵ����0����ͬ��Ԫ�� 

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
	int n=sizeof(data)/sizeof(data[0]);//����ĳ��Ȳ��ܷ��ں�������������Ϊ����Ϊ����ʱ�����ݵ���ָ��
	//�������������ָ��Ĵ�С�������鳤�ȣ�ֻ����������ٽ��䵱�������Ĳ���ʹ�� 
	Input(data,n);
	cout<<"Input your figure:"<<endl;
	cin>>data[0];//data[0]���ڴ����Ҫ���ҵ�ֵ 
	cout<<Select(data,data[0])<<endl;
	return 0;
} 
