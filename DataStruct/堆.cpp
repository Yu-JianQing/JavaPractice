#include <iostream>
using namespace std;
#include <stdlib.h>
#define min -1
#define max 100
 
typedef struct Node{
	int capacity;//�ѵ��������ܹ����ԷŶ��ٽڵ� 
	int size;//ʵ�ʽڵ��� 
	int *list;//����ڵ� 
}*Heap;

Heap Create(){
	Heap heap=(Node *)malloc(sizeof(Node));
	if(heap==NULL)
		return NULL;
	heap->capacity=max;
	heap->size=0;
	heap->list=(int *)malloc(sizeof(int)*(heap->capacity+1));
	heap->list[0]=min;
	return heap;
}

bool isFull(Heap heap){
	return heap->capacity==heap->size?true:false;
}

Heap Insert(int elem){
	
}

int main(){
	
	return 0;
} 
