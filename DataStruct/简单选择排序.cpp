#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define flag -32768

//����˼�룺��������ѡ����С�ķ���ǰ�棬�ٴ�ʣ�µ�Ԫ����ѡ��С�ģ�ѭ�������������г��� 
//ѡ��СԪ�ط�����ÿ��ѭ����Ĭ�ϵ�һ��Ԫ��Ϊ��С�Ĳ���¼�±꣬�������б����С�ģ���¼���±�
//����ִ��ֱ��һ��ִ���꣬Ȼ��Ƚϵ�һ��Ԫ�ص��±��Ƿ����¼���±�һ�£��񣬽��� 

typedef int Elemtype;

Elemtype *Order(Elemtype *data,int datasize){
	for(int i=1;i<datasize;i++){
		int k=i;//��¼��СԪ���±꣬ÿһ��Ĭ�϶��ǵ�һ��Ԫ������С��
				//ͬʱ�ж��±��Ƿ����˱仯 
		for(int j=i+1;j<datasize;j++)//ѡ����СԪ�ز���¼���±� 
			if(data[j]<data[k])
				k=j;
		if(i!=k){//�±�仯˵����Сֵ�����ǵ�һ��Ԫ�� 
			int t=data[i];
			data[i]=data[k];
			data[k]=t;
		}
	} 
}

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}
 
int main(){
	Elemtype data[]={flag,2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	return 0;
} 
