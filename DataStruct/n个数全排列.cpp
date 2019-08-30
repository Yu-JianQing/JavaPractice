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

//����˼�룺1.�ݹ飺ȫ���п��Կ����Ǵ�ǰ����һ����һ������ȷ����
//ֻҪÿ������ȷ������һ��������ɡ����Եݹ麯��һ��Ҫ������������һ����
//��ʼλ��һ���ǽ���λ�á��ݹ�ʱ���ǲ����޸Ŀ�ʼλ��������ȷ��һ������
//2.�ǵݹ飺ǰ�᣺�����������ǵ������У�������Ҫ�Ƚ�������
//���е�ȫ����������һ�����ĺ�һ����С�ģ������������ǵݼ��źõģ�321��
//��С�������ǵ����źõģ�123������ôȫ���п�������С�������������Ĺ��ɹ���.
//�������������ص��Ǻ���һ�����ܱ�ǰ��һ�������������������ָ�룺һ��ָ��ǰ
//һ������һ��ָ���һ������ֻҪ��һ������ǰһ����������Ҫ��ǰһ������������ȥ�� 
// ����Ҳ����ǰ��������������������ԭ���ǣ������е����λ�ÿ�ʼ��������ǰ�ң��ұ�ǰһ����
//��ĵ�Ҫ�Ⱥ�һ����С�ģ��ҵ��󽻻�����Ϊ�����ҵ�������Ӧ��λ�������¸�������С�ġ�
//����1243->1342���ڰ�λ��3�Ǽ�2֮�����ҵ�����С���� 
//������Ϻ���Ҫ��ǰһ�����ĺ������н��еߵ�����ΪҪ��֤
//�����Ǵ�С������˳��ؽ��У�������ߵ���С�ĵ������棬��֪����һ�����϶���ǰ��һ����Ҳ���ǵ���ȥ��
//�Ǹ��������������п϶���ȵߵ���Ҫ��һ�ߵ�֮��������оͻ��ɱ�ԭ�ȵĴ�Ȳ��ߵ���С��
//����һ���γɵ������Ǳȿ�ʼ��С�������һ�������Ȼ�������γɵ������а���ͬ���������й��ɣ�
//ֱ��ǰһ�����ƶ����ʼ��λ���������ʹ���û���ĸ������ǰ��С������ȫ������ɡ� 
 

typedef int Elemtype;

void Swap(Elemtype &e1,Elemtype &e2){//�˴���������д��ַ����д�Ļ����Ƕ�������ʱ����������
//û�ж�ԭ���ݲ�������ַ��ָ�붼�Ƕ�ʵʵ���ڵ�λ��������ݲ����� 
	Elemtype t=e1;
	e1=e2;
	e2=t;
}

//�ݹ� 
void Arrange(Elemtype *data,int start,int tail){
	if(start==tail){//��ǰ��������ȷ���������һ��ʱ��ɣ������ 
		for(int i=0;i<=tail;i++)
			cout<<data[i]<<"  ";
		cout<<endl;
		return ;//�ݹ���� 
	}		
	else{
		for(int j=start;j<=tail;j++){//��ǰ��������ȷ��
			Swap(data[start],data[j]);//ÿ��λ�ö������������е��κ�һ������
			//��ǰλ�õ���������λ�õ������н�����ʵ�֡�����ȷ����һ������ 
			Arrange(data,start+1,tail);//�޸Ŀ�ʼλ����ȷ����һ���� 
			Swap(data[start],data[j]);//�ݹ���ɺ���Ҫ���Ϸ��أ��ݹ�ʱ�����ֽ⣬����ʱ�������� 
		}
	}
}
//end�ݹ�

//�ǵݹ�
void Reversal(Elemtype *data,int start,int tail){//�ߵ����� 
	while(start<tail)
		Swap(data[start++],data[tail--]);
}

void Print(Elemtype *data,int tail){
	for(int i=0;i<=tail;i++)
			cout<<data[i]<<"  ";
	cout<<endl;
}

void Arrange2(Elemtype *data,int tail){
	Print(data,tail);
	int before=tail;
//	int before=tail-1;/*���ܰ�ע�Ͳ���д���й�ϵ��ǰ��ָ�룬�����*/ 
//	int after=tail; 
	while(before!=0){//ֱ����0��Ԫ�� 
		int after=before;
		before--;
		if(data[after]>data[before]){//��һ������ǰһ������ǰһ�����滻�㡣 
			int bigger=after;
			for(int i=tail;i>=after;i--){//���滻���Ǵ����һλ��ʼ��һֱ
							//����һ����λ�õı�ǰһ������Ⱥ�һ����С����Сֵ��
				if(data[i]>data[before]&&data[i]<data[bigger])
					bigger=i;
			}
			Swap(data[before],data[bigger]);
			Reversal(data,after,tail);//���� 
			Print(data,tail); //�ߵ� 
			before=tail;//�γ��µ����к������´������еĺ�����ǰ�� 
		}
//		after=before;
//		before--;
	}
} 
//end�ǵݹ� 

int main(){
	Elemtype data[]={1,2,3};
	int datasize=sizeof(data)/sizeof(data[0]);
//	Arrange(data,0,datasize-1);
	Arrange2(data,datasize-1);
	return 0;
}
