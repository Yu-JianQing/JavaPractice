#include <iostream>
using namespace std;
#include <stdlib.h>
#include <string.h>//ֻ�õ����ַ����ĸ��� 

#define N 4//Ҫ�������ĸ�ĸ��� 
#define M 2*N-1//�����������нڵ��������ΪҪ�������ĸ�϶���������Ҷ�ӽڵ㣬������һ����2n-1����� 
#define NU -1//����û����ֵ 
#define MAX 1000//����һ�������Ƚϴ�С��ʱ���� 

typedef char Elemtype;

typedef char* HfmCode[N+1];//�����ŵ���Ҫ������ĸ��Ӧ�Ĺ��������룬�����е�ÿһ���Ӧһ������ 

typedef struct HNode{//���������Ľڵ� 
	int weight;//�ڵ��Ȩֵ 
	int parent;//�ýڵ�ĸ��ڵ� 
	int lchild;
	int rchild;
}; 

typedef struct Mins{//����������Сֵ�����ںϳɹ�������ʱ����ѡ������Ȩֵ��С�����ϲ��й� 
	int min1;
	int min2;
};

Mins selectMins(HNode *HfmTree,int end){//����������ѡ������Ȩֵ��С�ģ�end��ʾ���Ǵӵ�һ������ʼ���ĸ������� 
	Mins mins;//�����С���������±꣬��Ϊ���ֲ�ͬ�ڵ���ͨ���±������ֵģ���������ͽڵ�������Ϊһ����� 
	mins.min1=mins.min2=0;//��ʼ����Ϊ��û���ҵ������Գ�ʼ��Ϊ0 
	HfmTree[mins.min1].weight=MAX;//��ʼ�����������������Ȩֵ 
	for(int i=1;i<=end;i++)//�Ӹ����ķ�Χ����һ��Ȩֵ��С�� 
		if(HfmTree[i].parent==0)//���Ҳ������и��ڵ�ģ��и��ڵ�˵������ڵ��Ѿ���һ�������ˣ������ٺϲ����������� 
			mins.min1=HfmTree[mins.min1].weight>HfmTree[i].weight?i:mins.min1;//�Ƚϸ��ڵ��Ȩֵȡ��С���Ǹ� 
	for(int j=1;j<=end;j++)//������һ����С�� 
		if(HfmTree[j].parent==0&&j!=mins.min1)//ͬ�����ڵ㲻��Ϊ0�����Ҳ�����֮ǰ�ҵ����Ǹ���С�� 
			mins.min2=HfmTree[mins.min2].weight>HfmTree[j].weight?j:mins.min2;
	return mins; //���������������±� 
}

void Init(HNode *HfmTree,int *w){//��ʼ������������w��һ��������Ҫ������ĸ��Ȩֵ 
	for(int i=1;i<=N;i++){//�ȳ�ʼ��Ҷ�ӽڵ㣬Ҳ����Ҫ������ĸ�ĸ����������һ������ֵ�� 
		HfmTree[i].weight=w[i];//Ȩֵ 
		HfmTree[i].lchild=0;
		HfmTree[i].rchild=0;
		HfmTree[i].parent=0;//���ڵ���ʱ��û�� 
	}
	for(int j=N+1;j<=M;j++){//�ٳ�ʼ���м�ڵ㣬Ҳ����������СȨֵҶ�ӽڵ�ϳɵĽڵ� 
		HfmTree[j].weight=0;//�м�ڵ��ʱ��û��Ȩֵ 
		HfmTree[j].lchild=0;
		HfmTree[j].rchild=0;
		HfmTree[j].parent=0;//û�и��ڵ㣨һ��ʼ����ʲô�ڵ㶼�Լ�����һ������ 
	}
}

void Create(HNode *HfmTree){//��ʼ������������ 
	for(int i=N+1;i<M+1;i++){//�������������Ĺ��̾��ǽ�һ�����������Ϻϲ��Ĺ��� 
		Mins mins=selectMins(HfmTree,i-1);//�ҳ���������Ȩֵ��С����������ע��ڶ���������Ϊÿѭ��һ�α���������
								//�ϲ���һ����������ʱ����û�и��ڵ� 
		HfmTree[mins.min1].parent=i;//��С������������Ϊ��ǰ�±�����ʾ�Ľڵ������ 
		HfmTree[mins.min2].parent=i;
		HfmTree[i].lchild=mins.min1;//���������������ĸ��ڵ㣬ҲҪ���¸��ڵ����������������ϵ������ 
		HfmTree[i].rchild=mins.min2;
		HfmTree[i].weight=HfmTree[mins.min1].weight+HfmTree[mins.min2].weight;//����Ȩֵ 
	}
}

void Print(HNode *HfmTree,Elemtype *ch){//��ӡ�������� 
	cout<<"chars "<<"weight "<<"parent "<<"lchild "<<"rchild"<<endl;
	for(int i=1;i<=M;i++){
		if(i<=N)//�����Ҷ�ӽڵ���������Ȩֵ 
			cout<<ch[i]<<"   "<<HfmTree[i].weight<<"   "<<HfmTree[i].parent<<"   "<<HfmTree[i].lchild<<"   "<<HfmTree[i].rchild<<endl;
		else//����û��Ȩֵ 
			cout<<"-"<<"   "<<HfmTree[i].weight<<"   "<<HfmTree[i].parent<<"   "<<HfmTree[i].lchild<<"   "<<HfmTree[i].rchild<<endl;	
	}
}

void Encoding(HNode *HfmTree,HfmCode &hfmcode){//���룬����������ĸ���ݹ�������Ĺ����������б��� 
	for(int i=1;i<=N;i++){//���ڸ�������ĸһ��һ���ر��� 
		int start=N-1;//���ڱ����Ǵ������±࣬Ҳ���Դ������ϱ࣬�˴�ѡ�õڶ��֡�
					//��Ϊn��Ҷ�ӽڵ�·���Ϊn-1����һ����Ҫn-1���ռ� 
		int par=HfmTree[i].parent;//par��ʾ��ǰҪ������ĸ���ڽڵ�ĸ��ڵ㣬�Ա�һ��һ������ϱ��� 
		int lch=i;//lch��ʾ��ǰҪ������ĸ���ڽڵ�ĸ��ڵ�ĺ��� 
		char code[N];//code������ĸ�γɵı��� 
		code[N-1]='\0';//�����һ���ռ�Ϊ����������Ϊһ������Ҫn-1�������˻���0. 
		while(par!=0){//�����ϵ����ڵ�ʱ��ǰ��ĸ������� 
			if(HfmTree[par].lchild==lch)//�����ǰҪ������ĸ���ڽڵ�ĸ��ڵ������ǡ���ǵ�ǰ�ڵ� 
				code[--start]='0';//��ô����һλΪ0 
			else
				code[--start]='1';//�Һ���Ϊ1 
			lch=par;//������һλ�����¸��µ�ǰҪ������ĸ���ڽڵ�ĸ��ڵ�ĺ���  
			par=HfmTree[par].parent;//���¸��ڵ� 
		}//���˱�����һ����ĸ 
		hfmcode[i]=(char *)malloc((N-start)*sizeof(char));//����һ���ռ��Դ����ĸ�ı��� 
		strcpy(hfmcode[i],&code[start]);//�����������code�����е����ȡ�����ŵ����ٵĿռ��� 
	}
}

void PrintCode(HfmCode hfmcode,Elemtype *ch){//��ӡ��ĸ������� 
	for(int i=1;i<=N;i++)
		cout<<ch[i]<<":"<<hfmcode[i]<<endl;
}

char *Decoding(HNode *hfmtree,char *ch,char *testCode,int len){//���룬��������01���н��룬ch����Ϊ�����а�������ĸ��
 								//hfmtree����ĸ�ı��뷽ʽ��testCode��01���У�len�����г��� 
	int i=0;//���ڼ��� �������е��� 
	int p=M;//�����Ǵ������ϱ�ģ�����Ҫ�������½⣬p��ʾ���ڵ㣬��ʼ��Ϊ�� 
	char recode[20];//��������ַ����ŵ�recode��ȥ 
	int j=0;//���ڼ�������recode���� 
	while(i<len){//�������� 
		if(testCode[i]=='0')//�����ǰλΪ0��˵��������������������� 
			p=hfmtree[p].lchild;
		else//���������������� 
			p=hfmtree[p].rchild;
		if(p<=N){//�������ڵ�С�ڵ���N��˵���Ѿ�����Ҷ�ӽڵ��ˣ���Ϊ�·��Ϊn-1 .
			recode[j]=ch[p];//��ʱ�ҵ�Ҷ�ӽڵ��±꣬ȡ����Ӧ��ĸ����recode�� 
			j++;
			p=M;//һ����ĸ��ɺ�������һ����ĸ���¸��ڵ� 
		}
		i++;
	}
	recode[j]='\0';//����������� 
	return recode;//���ؽ��� 
}

int main(){
	HNode HfmTree[M+1];//��M+1���ռ䣬��0������ 
	Elemtype ch[N+1]={'?','a','b','c','d'};//��n+1���ռ��0������ ����ʾҪ�������ĸ 
	int w[N+1]={NU,30,5,10,20};//��ʾ������ĸ��Ȩֵ 
	
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
