#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2

//ϣ�������ǲ���������Ż����ǱȽ�����Ĳ������� 
//����˼�룺�Ƚ����а����ض��Ĳ������飬Ȼ��������ֱ�Ӳ��������ٲ���
//������С��ֱ����Ϊ1��������ֱ�Ӳ������򵫴�ʱ�ѻ����������Բ����ƶ��ܶ���� 

typedef int Elemtype;

Elemtype *Order(Elemtype *data,int datasize){
	for(int gap=datasize/2;gap>0;gap=gap/2){//�������ݼ���ʽ���顣һ��Ĳ���ȡֵ��������
											//���ϵس�2�����������ݼ��ķ�ʽ����Ч�� 
		for(int i=gap;i<datasize;i++){//������һ�����򡣰�ֱ�Ӳ������򷽷���
									//����ʱ�����ֻ��һ��Ԫ����һ���������������Զ��ֿգ��ȴ���һ�� 
		//i=gap���Ǵ�һ��ĵڶ���Ԫ�ؿ�ʼ�����������м�����ֱ�Ӳ������򷽷���
		//iÿ��һ�Σ��ͻ�ӵ�ǰ��������һ�飬���ν��У�ֱ�����һ��Ԫ��Ҳ�����һ�� 
			Elemtype x=data[i];//�洢Ҫ�����Ԫ�� 
			int j=i-gap;
			while(x<data[j]&&j>=0){//��Ҫ�����λ��
				//ע�⣺ѭ�������о�����Ҫ���ּ��ţ���Ϊ���˿��ܳ���<0�������������ڵ����⡣ 
				data[j+gap]=data[j];
				j=j-gap;
			}//��ʱj��j-gapλ�ã�Ҫ����Ԫ�ص�λ����j 
//			 !
//			 !
//			 !
//			\/
//		for��while֮���ת�� 
//			for(int j=i-gap;x<data[j]&&j>=0;j=j-gap;)
//				data[j+gap]=data[j];
			data[j+gap]=x;
		}
	} 
	return data;
}

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}

int main(){
	Elemtype data[]={2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	Order(data,datasize);
	Print(data,datasize);
	return 0;
} 
