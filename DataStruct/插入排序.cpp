#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define flag -32768//����ռ������ĵ�0��λ�� 

//����˼�룺�������в����������С�
//��������һ�����������裺��λ��Ԫ��Ӧ�ò����ģ������գ���Ϊ�������Ԫ��Ų��һ��λ�ã������� 
//��ͬ�Ķ�λ�������²�ͬ�Ĳ����㷨 

typedef int Elemtype;

void Order(Elemtype *data,int datasize){//˳��λ���Ĳ������� 
	for(int i=2;i<datasize;i++){//����һ��Ԫ����Ϊ�������У��ӵڶ�����ʼ���ϲ����������� 
		data[0]=data[i];//�����0��λ�ô�ŵ�ǰҪ�����Ԫ�� 
		int j=i-1; //j��ʾ�������е����һ��Ԫ�ص�λ�� 
		while(data[0]<data[j]){//�������������һ��λ����ǰ�Ƚ�ֱ���ȵ���Ҫ����Ԫ��С��Ԫ�� 
			data[j+1]=data[j];
			j--;
		}//��ʱj��ʾ������Ԫ�ص�ǰһ��λ�� 
		data[j+1]=data[0];
	}
} 


//���ֶ�λ���Ĳ������� 
//���ֲ����ǻ����Ѿ��ź�������У��������������Ǵ���������λ�� 
void HalfSort(Elemtype *data,int datasize){
	int start;
	int tail;
	int mid;
	for(int i=2;i<datasize;i++){
		data[0]=data[i];//�����0��λ�ô�ŵ�ǰҪ�����Ԫ�� 
		start=1;
		tail=i-1;
		mid=(start+tail)/2;
		//��λ 
		while((data[0]>=data[mid]&&data[0]<=data[mid+1])==false){//ֱ��������Ԫ�ر������λ�õ�ǰһ��Ԫ�ش󣬱Ⱥ�һ��Ԫ��С 
			 if(data[0]>data[mid])
				start=mid+1;
			else
				tail=mid-1;
			mid=(start+tail)/2;
		}//��λ��֮���mid�������λ�õ�ǰһ�������mid+1����Ҫ�����λ��
		
		//���ղ��� 
		for(int j=i;j>mid+1;j--)
			data[j]=data[j-1];
		data[mid+1]=data[0];
	} 
}

void Print(Elemtype *data,int datasize){
	for(int i=1;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Elemtype data[]={flag,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	HalfSort(data,datasize);
	Print(data,datasize);
	return 0;
} 
