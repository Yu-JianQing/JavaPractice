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

//����˼�룺ǰ�᣺ӵ�и������ݱ�����������
//��Ļ��֣�������򣬿��ڿ����� ����ǰһ���е�����Ԫ�ر���С�ں�һ���е�����Ԫ�� 
//�������ص㣺ӵ��ÿһ������ֵ��ÿһ��ĵ�һ��Ԫ�ص���ʼλ�á�
//���̾��ǰ������������ҳ�Ԫ�����ڵĿ飬�ٴӿ�����Ԫ�� 

typedef int Elemtype;
typedef struct IndexType{//������ 
	int start;//ÿ�����ʼλ�� 
	Elemtype max;//ÿ���е����ֵ 
};

int Select(Elemtype data[],IndexType index[],int indexsize,Elemtype elem){
	int i=0;
	for(;i<indexsize;i++)//�ҿ� 
		if(elem<index[i].max)
			break;
	while(elem!=data[index[i].start]){//�ڿ�����Ԫ�� 
		index[i].start++;
	}
	return index[i].start;
}//�����ҿ黹����Ԫ�ض��ɲ��ö��ֲ��� 

int main(){
	Elemtype data[]={8,14,6,9,10,22,34,18,19,31,40,38,54,66,46,71,78,68,80,85,100,94,88,96,87};
	IndexType index[]={{0,14},{5,34},{10,66},{15,85},{20,100}}; 
	int indexsize=sizeof(index)/sizeof(index[0]);
	cout<<Select(data,index,indexsize,80)<<endl;
	return 0;
}
