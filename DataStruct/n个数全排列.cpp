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

//基本思想：1.递归：全排列可以看成是从前往后一个数一个数的确定，
//只要每个数都确定了则一次排序完成。所以递归函数一定要有两个参数：一个是
//开始位置一个是结束位置。递归时就是不断修改开始位置来不断确定一次排序。
//2.非递归：前提：给出的数列是递增数列，不是需要先进行排序。
//数列的全排列中总有一个最大的和一个最小的，则最大的数便是递减排好的（321）
//最小的数便是递增排好的（123）。那么全排列可以是最小的数从最大的数的过渡过程.
//由于最大的数的特点是后面一个数总比前面一个数大，则可以设置两个指针：一个指向前
//一个数，一个指向后一个数。只要后一个数比前一个数大，则需要将前一个数换到后面去， 
// 至少也得是前后两个数交换。交换的原则是：从序列的最后位置开始，依次往前找，找比前一个数
//大的但要比后一个数小的，找到后交换。因为这样找的数在相应的位置上是下个序列最小的。
//就是1243->1342，在百位上3是继2之后能找到的最小数。 
//交换完毕后还需要将前一个数的后面数列进行颠倒，因为要保证
//过渡是从小到大有顺序地进行，如果不颠倒则小的调到后面，已知后面一个数肯定比前面一个数也就是调过去的
//那个大，则这样的序列肯定会比颠倒的要大，一颠倒之后这个序列就会变成比原先的大比不颠倒的小。
//这样一次形成的排序是比开始最小的排序大一点的排序，然后将排序形成的新序列按照同样方法进行过渡，
//直到前一个数移动到最开始的位置则这样就代表没有哪个后面大前面小的数。全排列完成。 
 

typedef int Elemtype;

void Swap(Elemtype &e1,Elemtype &e2){//此处交换必须写地址，不写的话就是对两个临时变量操作，
//没有对原数据操作。地址和指针都是对实实在在的位置里的内容操作。 
	Elemtype t=e1;
	e1=e2;
	e2=t;
}

//递归 
void Arrange(Elemtype *data,int start,int tail){
	if(start==tail){//从前往后依次确定，到最后一个时完成，输出。 
		for(int i=0;i<=tail;i++)
			cout<<data[i]<<"  ";
		cout<<endl;
		return ;//递归出口 
	}		
	else{
		for(int j=start;j<=tail;j++){//从前往后依次确定
			Swap(data[start],data[j]);//每个位置都可以是数列中的任何一个数，
			//当前位置的数与其他位置的数进行交换来实现。至此确定完一个数。 
			Arrange(data,start+1,tail);//修改开始位不断确定下一个数 
			Swap(data[start],data[j]);//递归完成后需要往上返回，递归时交换分解，返回时交换返回 
		}
	}
}
//end递归

//非递归
void Reversal(Elemtype *data,int start,int tail){//颠倒函数 
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
//	int before=tail-1;/*不能按注释部分写带有关系的前后指针，会出错*/ 
//	int after=tail; 
	while(before!=0){//直到第0个元素 
		int after=before;
		before--;
		if(data[after]>data[before]){//后一个数比前一个数大，前一个是替换点。 
			int bigger=after;
			for(int i=tail;i>=after;i--){//被替换点是从最后一位开始找一直
							//到后一个数位置的比前一个数大比后一个数小的最小值点
				if(data[i]>data[before]&&data[i]<data[bigger])
					bigger=i;
			}
			Swap(data[before],data[bigger]);
			Reversal(data,after,tail);//交换 
			Print(data,tail); //颠倒 
			before=tail;//形成新的序列后再重新从新序列的后面往前找 
		}
//		after=before;
//		before--;
	}
} 
//end非递归 

int main(){
	Elemtype data[]={1,2,3};
	int datasize=sizeof(data)/sizeof(data[0]);
//	Arrange(data,0,datasize-1);
	Arrange2(data,datasize-1);
	return 0;
}
