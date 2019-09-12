#include <iostream>
using namespace std;
#include <stdlib.h>

#define row 10//定义迷宫的行数 
#define col 10//迷宫的列数 
#define INF 1000//定义无穷大 
#define maxsize 100//定义队列的最大容量 
#define error 0//定义错误时返回0 

typedef struct Point{//定义一个点，包含横坐标和纵坐标 
				//将迷宫上的各个位置都抽象成一个点，此问题就是在坐标轴上从初始点到终点 
	int x;
	int y;
};

typedef struct Queue{//定义队列 
	Point data[maxsize];//队列中要储存的元素是坐标轴上的点，最大容量是maxsize 
	int front;//队头指针 
	int rear;//队尾指针 
}; 

void Init(Queue *Q){//初始化队列 
	Q->front=Q->rear=0;//头和尾都指向0，表示没有元素 
}

void EnQueue(Queue *Q,Point elem){//入队 
	Q->data[Q->rear]=elem;//将元素放入队列中尾指针指向的位置空间 
	Q->rear++;//尾指针向后移动一位 
}

bool isEmpty(Queue *Q){//判空 
	return Q->rear==0?true:false;//如果队尾指向0则为空 
}

Point DeQueue(Queue *Q){//出队 
	if(Q->rear==Q->front)//如果队列中没有元素 
		return {-INF,-INF};//则返回点的最小值，表示不存在元素 
	Point elem=Q->data[Q->front];//取出队头指针指向的元素 
	Q->front++;//取出后头指针向下移一位，以便下次操作 
	return elem;//返回取出的元素 
}
//求解迷宫，利用了图的宽度优先遍历算法和回溯法 
int BFS(char maze[][col],Point &S,Point &E){//maze为迷宫，S为初始点，E为终点 
	int dist[row][col];
	//定义一个距离向量，表示从初始点出发到各个点的距离dist[x][y]相当于迷宫上的一个点 
	for(int i=0;i<row;i++)//将距离向量初始化 
		for(int j=0;j<col;j++)
			dist[i][j]=INF;//令初始点到迷宫中其余个点的距离为无穷大 
	Point direct[4]={{-1,0},
	//定义每一步的走向，一个点到它相邻的点一共四种走法，即往上走一步 
					 {1,0},//往下 
					 {0,-1},//往左 
					 {0,1}};//往右 
	Queue *Q;
	Q=(Queue *)malloc(sizeof(Queue));//为队列开辟空间 
	Init(Q);
	EnQueue(Q,S);//将初始点入队 
	dist[S.x][S.y]=0;//令自己到自己的距离为0 
	while(!isEmpty(Q)){//判队列是否为空 
		Point cur=DeQueue(Q);//声明当前点是队列中的第一个元素，将它从队列中拿出来 
		if(cur.x==E.x&&cur.y==E.y)//判断这个点是不是终点 
			break;//如果是就找到了 
		for(int i=0;i<4;i++){//如果不是便要向周围四个方向试探看哪个方向能够进行下一步 
			Point p={cur.x+direct[i].x,cur.y+direct[i].y};//下一步要走的点 
			if(p.x>=0&&p.x<row&&p.x>=0&&p.y<col&&maze[p.x][p.y]!='#'&&dist[p.x][p.y]==INF){
						//如果下一步要走的点在迷宫的范围之内，
						//并且不能触碰到墙壁，而且这个点不能是已经走过的点 
				EnQueue(Q,p);//符合条件将这个点入队，形成新的初始点 
				dist[p.x][p.y]=dist[cur.x][cur.y]+1;//初始点到这个点的距离为上一个点的距离加一 
			}
		}
	}//当循环完时也就是队列元素为空时代表迷宫中所有能走的点都走到了，并且找到了一条到终点的路径 
	cout<<"到达迷宫所有点的距离为："<<endl<<endl;
	for(int i=0;i<row;i++){//输出初始点到各个点的路径 
		for(int j=0;j<col;j++)
			cout<<dist[i][j]<<"  ";
		cout<<endl;
	}
	return dist[E.x][E.y];//返回到终点的路径 
}

int main(){
	char maze[row][col]={{'#','S','#','#','#','#','#','#','.','#'},//这是迷宫图 
					{'.','.','.','.','.','.','#','.','.','#'}, 
					{'.','#','.','#','#','.','#','#','.','#'}, 
					{'.','#','.','.','.','.','.','.','.','.',},
					{'#','#','.','#','#','.','#','#','#','#'},
					{'.','.','.','.','#','.','.','.','.','#'},
					{'.','#','.','#','#','#','#','#','.','#'},
					{'.','.','.','.','.','.','.','.','.','.'},
					{'.','#','#','#','#','.','#','#','#','.'},
					{'.','.','.','.','.','.','.','.','E','#'}, 
					};
	cout<<"迷宫如下（S表示入口，E表示出口）"<<endl<<endl;
	for(int i=0;i<row;i++){//打印迷宫 
		for(int j=0;j<col;j++)
			cout<<maze[i][j]<<"  ";
		cout<<endl;
	}
	Point S;//定义初始点 
	Point E;//定义终点 
	for(int i=0;i<row;i++)
		for(int j=0;j<col;j++){
			if(maze[i][j]=='S')//给初始点赋值 
				S={i,j};
			if(maze[i][j]=='E')//给终点赋值 
				E={i,j};
		}
	int d=BFS(maze,S,E);//获得路径长 
	cout<<endl;
	cout<<"到达迷宫终点的距离是："<<endl; 
	cout<<d<<endl;;
	return 0;
} 
