#include <iostream>
using namespace std;
#include <stdlib.h>
#define min -1
#define max 100
 
typedef struct Node{
	int capacity;//堆的容量，总共可以放多少节点 
	int size;//实际节点数 
	int *list;//储存节点 
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
