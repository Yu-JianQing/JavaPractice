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
#define flag -32768

//����˼�룺�����в��ϻ��֣�ֱ�����ֵ���������Ȼ���ٽ��������кϲ� 
//1.�ݹ飺�����в��ϵط�Ϊ���������֣�ֱ�������������б�Ϊ��������Ϊֹ�������ֵ�һ��Ԫ��һ��ʱ�϶�����Ȼ��
//���ϵؽ������������кϲ����µ��������У�ֱ���ϲ���Ϊֹ ������ʱ��Ҫǰ������ָ�룬���ϵؽ����л��֡� 
//���ϵ��»����ٴ��µ��Ϻϲ� 
//2.�ǵݹ飺ֱ�Ӵ��µ��Ϻϲ���ͬ����Ҫ��ʼ�ͽ���λ�á�Ȼ���ںϲ���ͬ��Ҳ��Ҫÿ�����ǰ������ָ�� 

typedef int Elemtype;

void Merge(Elemtype *data,int start,int tail){
	int mid=(start+tail)/2;
	int *p=(Elemtype *)malloc((tail-start+1)*sizeof(Elemtype));//�ϲ������̶����ȵ��������Ҫһ���µĿռ�洢 
								//�ռ��������������ĳ��� 
	int Lstart=start;//�󲿷���ʼ��ַ 
	int Rstart=mid+1;//�Ҳ�����ʼ��ַ 
	int k=0;
	//�ϲ���������� 
	while(Lstart<=mid&&Rstart<=tail){
		if(data[Lstart]>=data[Rstart])
			p[k++]=data[Rstart++];
		else
			p[k++]=data[Lstart++];
	}
	while(Lstart<=mid)
		p[k++]=data[Lstart++];
	while(Rstart<=mid)
		p[k++]=data[Rstart++];
//	data=p;������ôд����Ϊdata��ʾ����������׵�ַ��һ����˵�ǲ��ɸ��ĵģ���ָֻ�����顣 
	for(int i=0;i<k;i++)//��p�е���������data�� 
		data[start+i]=p[i];
	free(p);
}


//�ݹ�ʵ��:�����϶��·ָ������¶��Ϻϲ� 
void Order(Elemtype *data,int start,int tail){
	if(data==NULL||start>=tail)//�ݹ���ڣ������ֵ�����ֻ��һ��Ԫ��ʱ�϶�������� 
        return ;
	int mid=(start+tail)/2;
	Order(data,start,mid);//���ֵ��󲿷� 
	Order(data,mid+1,tail);//���ֵ��Ҳ��� 
	Merge(data,start,tail);//�ϲ������������У�����������������һ�����黮�ֵģ�
							//����ֻ�����Ǹ�δ����ǰ�����鼴�� 
} 

//�ݹ�Ĵ���ʵ�ֹ��̣������黮��Ϊֻ��һ�������Ԫ��ʱ���Ѿ��ݹ鵽���һ��
//Ȼ�������Ϸ��أ��ڷ��صĹ��������ڵݹ�ĳ�����벻����ִ��һ�飬����Ե�
//�����ǰ��յݹ���Ⱥ�˳��������Ϸ��أ����ع����л�ִ�еݹ�����ĳ��� 



//�ǵݹ�ʵ�֣�ֱ�����¶��Ϻϲ� 
//(1,2),(3,4),(5,6),(7,8) 
//(1 2,3 4),5 6��7 8
//(1 2 3 4��5 6 7 8)
//1  2  3  4  5  6  7  8
//���¶���ʱ���൱��ֱ�Ӵӵݹ�ĵڶ��㿪ʼ�� 
void Order2(Elemtype *data,int start,int tail){
	int Lmin,Lmax;//��벿�ֵĿ�ʼ�ͽ��� 
	int Rmin,Rmax;//�Ұ벿�ֵĿ�ʼ�ͽ���
	int length=tail-start+1;//���г��� 
	for(int i=1;i<=length;i=2*i){//һ����ϲ������ˣ�n=2��m�η�������2��ָ�������� 
		for(Lmin=start;Lmin<length-i;Lmin=Rmax+1){//һ����Ҫ�ϲ������飺��Ϊÿһ�˵ķ���������i��ͬ
											//*	 //iҲ��ÿ�η��飬�����󲿷ֻ��Ҳ��ֵĳ��� 
												//�����һ��������󲿷ֵĿ�ʼλ��һ�����ᳬ���Ұ벿�ֵĿ�ʼλ��
												//length-i�������һ���Ұ벿�ֵĿ�ʼ 
			Lmax=Lmin+i-1;//��벿�ֵ����λ��Ϊ��ʼλ��+���ڳ���-1 
			Rmin=Lmax+1;
			Rmax=Rmin+i-1;//ͬ����벿�� 
			Merge(data,Lmin,Rmax);//��������ϲ� 
		}
	} 
} 

void Print(Elemtype *data,int datasize){
	for(int i=0;i<datasize;i++)
		cout<<data[i]<<"  ";
	cout<<endl;
}
 
int main(){
	Elemtype data[]={35,2,12,45,4,53,3,7,16,25,34,38,29};
	int datasize=sizeof(data)/sizeof(int);
	//Order(data,0,datasize-1);//����ȥ�ı�ʾ����ĩβ�Ĳ���Ӧ����datasize-1����Ϊ�����0��ʼ 
	Order2(data,0,datasize-1); 
	Print(data,datasize);
	return 0;
} 
