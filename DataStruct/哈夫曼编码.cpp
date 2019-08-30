#include <iostream>
using namespace std;
#include <stdlib.h>
#include <string.h>//只用到了字符串的复制 

#define N 4//要编码的字母的个数 
#define M 2*N-1//哈夫曼树所有节点个数，因为要编码的字母肯定都是树的叶子节点，所以树一共有2n-1个结点 
#define NU -1//代表没有数值 
#define MAX 1000//定义一个常量比较大小的时候用 

typedef char Elemtype;

typedef char* HfmCode[N+1];//里面存放的是要编码字母对应的哈弗曼编码，数组中的每一项对应一个编码 

typedef struct HNode{//哈夫曼树的节点 
	int weight;//节点的权值 
	int parent;//该节点的父节点 
	int lchild;
	int rchild;
}; 

typedef struct Mins{//定义两个最小值，这在合成哈夫曼树时总是选择两个权值最小的树合并有关 
	int min1;
	int min2;
};

Mins selectMins(HNode *HfmTree,int end){//从所有树中选出两个权值最小的，end表示的是从第一个树开始到哪个树结束 
	Mins mins;//存放最小两个树的下标，因为区分不同节点是通过下标来区分的（这里的树和节点可以理解为一个概念） 
	mins.min1=mins.min2=0;//初始化因为还没有找到，所以初始化为0 
	HfmTree[mins.min1].weight=MAX;//初始化他们所代表的树的权值 
	for(int i=1;i<=end;i++)//从给出的范围内找一个权值最小的 
		if(HfmTree[i].parent==0)//并且不能是有父节点的，有父节点说明这个节点已经在一个树中了，不能再合并到其他树中 
			mins.min1=HfmTree[mins.min1].weight>HfmTree[i].weight?i:mins.min1;//比较各节点的权值取最小的那个 
	for(int j=1;j<=end;j++)//再找另一个最小的 
		if(HfmTree[j].parent==0&&j!=mins.min1)//同样父节点不能为0，并且不能是之前找到的那个最小的 
			mins.min2=HfmTree[mins.min2].weight>HfmTree[j].weight?j:mins.min2;
	return mins; //返回这两个树的下标 
}

void Init(HNode *HfmTree,int *w){//初始化哈夫曼树，w是一个数组存放要编码字母的权值 
	for(int i=1;i<=N;i++){//先初始化叶子节点，也就是要编码字母的个数（数组第一个不存值） 
		HfmTree[i].weight=w[i];//权值 
		HfmTree[i].lchild=0;
		HfmTree[i].rchild=0;
		HfmTree[i].parent=0;//父节点暂时都没有 
	}
	for(int j=N+1;j<=M;j++){//再初始化中间节点，也就是由两最小权值叶子节点合成的节点 
		HfmTree[j].weight=0;//中间节点此时还没有权值 
		HfmTree[j].lchild=0;
		HfmTree[j].rchild=0;
		HfmTree[j].parent=0;//没有父节点（一开始不论什么节点都自己独成一个树） 
	}
}

void Create(HNode *HfmTree){//开始创建哈夫曼树 
	for(int i=N+1;i<M+1;i++){//创建哈夫曼树的过程就是将一个个的树不断合并的过程 
		Mins mins=selectMins(HfmTree,i-1);//找出所有树中权值最小的两个树，注意第二个参数因为每循环一次便有两个树
								//合并成一个新树，此时新树没有父节点 
		HfmTree[mins.min1].parent=i;//最小的这两个树成为当前下标所表示的节点的子树 
		HfmTree[mins.min2].parent=i;
		HfmTree[i].lchild=mins.min1;//更新完那两个树的父节点，也要更新父节点的左右子树否则联系不起来 
		HfmTree[i].rchild=mins.min2;
		HfmTree[i].weight=HfmTree[mins.min1].weight+HfmTree[mins.min2].weight;//更新权值 
	}
}

void Print(HNode *HfmTree,Elemtype *ch){//打印哈夫曼树 
	cout<<"chars "<<"weight "<<"parent "<<"lchild "<<"rchild"<<endl;
	for(int i=1;i<=M;i++){
		if(i<=N)//如果是叶子节点则它们有权值 
			cout<<ch[i]<<"   "<<HfmTree[i].weight<<"   "<<HfmTree[i].parent<<"   "<<HfmTree[i].lchild<<"   "<<HfmTree[i].rchild<<endl;
		else//不是没有权值 
			cout<<"-"<<"   "<<HfmTree[i].weight<<"   "<<HfmTree[i].parent<<"   "<<HfmTree[i].lchild<<"   "<<HfmTree[i].rchild<<endl;	
	}
}

void Encoding(HNode *HfmTree,HfmCode &hfmcode){//编码，将给出的字母根据构造出来的哈夫曼树进行编码 
	for(int i=1;i<=N;i++){//对于给出的字母一个一个地编码 
		int start=N-1;//由于编码是从上往下编，也可以从下往上编，此处选用第二种。
					//因为n个叶子节点路经最长为n-1，则一共需要n-1个空间 
		int par=HfmTree[i].parent;//par表示当前要编码字母所在节点的父节点，以便一层一层地往上编码 
		int lch=i;//lch表示当前要编码字母所在节点的父节点的孩子 
		char code[N];//code储存字母形成的编码 
		code[N-1]='\0';//令最后一个空间为结束符，因为一共就需要n-1，别忘了还有0. 
		while(par!=0){//当往上到父节点时当前字母编码结束 
			if(HfmTree[par].lchild==lch)//如果当前要编码字母所在节点的父节点的左孩子恰好是当前节点 
				code[--start]='0';//那么编码一位为0 
			else
				code[--start]='1';//右孩子为1 
			lch=par;//编码完一位，重新更新当前要编码字母所在节点的父节点的孩子  
			par=HfmTree[par].parent;//更新父节点 
		}//至此编码完一个字母 
		hfmcode[i]=(char *)malloc((N-start)*sizeof(char));//开辟一个空间以存放字母的编码 
		strcpy(hfmcode[i],&code[start]);//将编码完放入code数组中的码截取出来放到开辟的空间中 
	}
}

void PrintCode(HfmCode hfmcode,Elemtype *ch){//打印字母及其编码 
	for(int i=1;i<=N;i++)
		cout<<ch[i]<<":"<<hfmcode[i]<<endl;
}

char *Decoding(HNode *hfmtree,char *ch,char *testCode,int len){//解码，将给出的01序列解码，ch数组为序列中包含的字母，
 								//hfmtree是字母的编码方式，testCode是01序列，len是序列长度 
	int i=0;//用于计数 ，计序列的数 
	int p=M;//编码是从下往上编的，解码要从上往下解，p表示父节点，初始化为根 
	char recode[20];//解出来的字符串放到recode中去 
	int j=0;//用于计数，计recode的数 
	while(i<len){//遍历序列 
		if(testCode[i]=='0')//如果当前位为0，说明编码是沿左子树编码的 
			p=hfmtree[p].lchild;
		else//否则沿右子树编码 
			p=hfmtree[p].rchild;
		if(p<=N){//若果父节点小于等于N了说明已经到达叶子节点了，因为最长路径为n-1 .
			recode[j]=ch[p];//此时找到叶子节点下标，取出对应字母放入recode中 
			j++;
			p=M;//一个字母完成后再找下一个字母更新父节点 
		}
		i++;
	}
	recode[j]='\0';//最后插入结束符 
	return recode;//返回解码 
}

int main(){
	HNode HfmTree[M+1];//有M+1个空间，第0个不用 
	Elemtype ch[N+1]={'?','a','b','c','d'};//有n+1个空间第0个不用 ，表示要编码的字母 
	int w[N+1]={NU,30,5,10,20};//表示各个字母的权值 
	
	Init(HfmTree,w);
	Create(HfmTree);
	Print(HfmTree,ch);
	cout<<endl;
	HfmCode hfmcode;
	Encoding(HfmTree,hfmcode);
	PrintCode(hfmcode,ch);
	
	char testCode[]="01000101101110";//abaccda
	int len=sizeof(testCode)/sizeof(char);
	char *recode=Decoding(HfmTree,ch,testCode,len);
	cout<<recode<<endl;
	return 0;
} 
