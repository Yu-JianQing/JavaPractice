#include <iostream>
using namespace std;
#include <stdlib.h>
#define true 1
#define false 0
#define ok 1
#define error 0
#define infeasible -1
#define overflow -2
#define NULLVALUE 0
//平衡因子：左子树的高度减去右子树的高度
//当平衡因子绝对值大于等于2时便不是平衡的 
//不平衡-->平衡：
//1.判断哪个位置的节点导致不平衡，这个节点就是第一个平衡因子
//大于等于2的节点
//2.再旋转恢复平衡：分为左旋（逆时针）和右旋（顺时针）
//当以不平衡节点为子树的所有节点的平衡因子都为正数时，以平衡因子为1的节点作为旋转轴，将不平衡节点右旋
//当以不平衡节点为子树的所有节点的平衡因子都为负数时，以平衡因子为-1的节点作为旋转轴，将不平衡节点左旋 
//当以不平衡节点为子树的所有节点的平衡因子有异号时，需要进行两次旋转，一次是以平衡因子绝对值为1的节点作
//	为旋转轴，将平衡因子为0的节点左旋或右旋（正右负左），之后便形成了与前两种情况相同的情形，便依前两种来旋转 

typedef int Elemtype;

typedef struct AVLNode{
	int height;//树高 
	Elemtype data;
	struct AVLNode *LTree;
	struct AVLNode *RTree;
}; 

int max(int x,int y){
	return x>y?x:y;
}
int getH(AVLNode *tree){//获取树的高度。 
	return tree?tree->height:-1;//根据高度的定义：树的高度（depth）为树中节点的最大层次。约定：
					//空树的高度为-1，只有一个节点的树的高度为0
}

AVLNode *R_Rotate(AVLNode *root){//右旋 
	AVLNode *left=root->LTree;//新建一个指针指向根的左子树 
	root->LTree=left->RTree;//将根分离出去即将根指向的左子树置为空 
	left->RTree=root;//将分离出去的根重新放回树内使之成为原先根的左子树的右子树，此时
					//新的根为原先根的左子树 
	
	root->height=max(getH(root->LTree),getH(root->RTree))+1;//树的形态发生变化后树高可能会发生变化 
	left->height=max(getH(left->LTree),getH(left->RTree))+1;//当前树的高度取决于左右子树的最高值+1 
	return left;//返回根 
}

AVLNode * L_Rotate(AVLNode *root){//左旋 
	AVLNode *right=root->RTree;//操作步骤与右旋相似 
	root->RTree=right->LTree;
	right->LTree=root;
	
	root->height=max(getH(root->LTree),getH(root->RTree))+1;
	right->height=max(getH(right->LTree),getH(right->RTree))+1;
	return right;
}

AVLNode *LR_Rotate(AVLNode *root){//先左旋后右旋，它的实现依赖于左旋与右旋的实现 
	root->LTree=L_Rotate(root->LTree);//先左旋是对平衡因子为0的子树进行操作，左旋过后平衡因子为0的子树
									//成为树的左子树 
	return R_Rotate(root);//后右旋是对平衡因子绝对值为1的子树进行操作 
}

AVLNode *RL_Rotate(AVLNode *root){//先右旋后左旋，同理上述 
	root->RTree=R_Rotate(root->RTree);
	return L_Rotate(root);
}

AVLNode *Add(AVLNode *tree,Elemtype data){//递归添加一个树节点 
	if(tree==NULL){//递归出口：如果树为空 
		tree=(AVLNode *)malloc(sizeof(AVLNode));//为空就新建一个树节点 
		tree->data=data;//赋值 
		tree->height=0;
		tree->LTree=NULL;
		tree->RTree=NULL;
		return tree;//添加完毕，返回 
	}//树不为空就要考虑加在左子树还是右子树上 
	else if(data>tree->data){//如果这个数比树中当前节点的值大 
		tree->RTree=Add(tree->RTree,data);//从右子树中加 
		//由于是用的递归则运行到此处时已经确定加在哪个位置了，此时就要考虑加进去后还平不平衡要不要变换 
		if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//如果平衡因子的绝对值等于2则不平衡需要变换 
			if(getH(tree->RTree->LTree)>getH(tree->RTree->RTree))//由于节点是插在右子树上，则插入后不平衡
			//说明右子树的左右子树一个高一个低，如果右子树的左子树比右子树的右子树高，则说明此节点插在右子树
			//的左子树上，则先右旋后左旋 
				tree=RL_Rotate(tree); 
			else//否则插在右子树的右子树上 
				tree=L_Rotate(tree);//左旋 
	}	
	else if(data<tree->data){//如果这个数比树中当前节点的值大小 
		tree->LTree=Add(tree->LTree,data);//从左子树中加
		if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//如果平衡因子的绝对值等于2则不平衡需要变换
			if(getH(tree->LTree->LTree)>getH(tree->LTree->RTree))//由于节点是插在左子树上，则插入后不平衡
			//说明左子树的左右子树一个高一个低，如果左子树的左子树比左子树的右子树高，则说明此节点插在左子树
			//的左子树上，则右旋  
				tree=R_Rotate(tree); 
			else//否则插在左子树的右子树上 
				tree=LR_Rotate(tree);//先左旋后右旋 
	}
	else if(data==tree->data)//如果树中有相同的值不做操作 
		return tree;
	tree->height=max(getH(tree->LTree),getH(tree->RTree))+1;//插入并且变换后树高更新 
	return tree;//返回树根 
}

//void Create(AVLNode **tree,Elemtype *data,int len){
//	for(int i=0;i<len;i++)
//		*tree=Add(*tree,data[i]);
//}

AVLNode *Remove(AVLNode *tree,Elemtype elem){//删除树中某一节点 
	if(tree==NULL) return tree;//空树，返回 
	if(tree->data>elem)//判断要删的节点在哪个位置，比树中当前节点值小 
		tree->LTree=Remove(tree->LTree,elem);//在树的左子树中找位置，运用递归一直找到相应的位置返回左子
									//树，因为是删除左子树中节点，左子树变化了 
	else if(tree->data<elem) //比树中当前节点值大 
		tree->RTree=Remove(tree->RTree,elem);//原理与上相同 
	else if(tree->data==elem){//与树中当前节点值相同 
		if(tree->LTree&&tree->RTree){//判断要删除的节点有没有左右子树，如果有 
			AVLNode *p=tree->RTree;//可以让右子树中最小的当新的根，也可以让左子树中最大的当新的根，此处选前者 
			while(p->LTree)//找右子树中最小的节点 
				p=p->LTree;
			tree->data=p->data;//更新根中的值，更新完了值之后，除了树高没更新外(最后更新)这便是新的根了 
			tree->RTree=Remove(tree->RTree,p->data);//运用递归将找到的那个顶替根的节点删掉，因为根已经更新 
		}else{//如果要删除的节点有左子树无右子树或者有右子树无左子树 
			AVLNode *p=(tree->LTree)?tree->LTree:tree->RTree;//若有左子树无右子树则新建节点指向要删除节点的左子树
			//否则指向要删除节点的右子树，因为它会成为新的根 
			free(tree);//将旧的根释放 
			return p;//返回新的根 
		}
	}
	
	if(abs(getH(tree->LTree)-getH(tree->RTree))==2)//以下同插入一样看要不要变换以及更新树高 
		if(getH(tree->RTree->LTree)>getH(tree->RTree->RTree))
				tree=RL_Rotate(tree); 
		else
			tree=L_Rotate(tree);
	if(abs(getH(tree->LTree)-getH(tree->RTree))==2)			
		if(getH(tree->LTree->LTree)>getH(tree->LTree->RTree))
				tree=R_Rotate(tree); 
		else if(tree->LTree==NULL)
			tree=LR_Rotate(tree);
	tree->height=max(getH(tree->LTree),getH(tree->RTree))+1;
	return tree;//返回树根 
} 

void PreOrder(AVLNode *tree){//前序遍历 
	if(tree==NULL)
		return ;
	cout<<tree->data<<"  ";
	PreOrder(tree->LTree);
	PreOrder(tree->RTree);
}

int main(){
	AVLNode *tree=NULL;
	Elemtype data[]={3,2,1,4,5,6,8,7,10,9};
	int len=sizeof(data)/sizeof(data[0]);
//	Create(&tree,data,len);这种方法创建也可以 
	for(int i=0;i<len;i++)
		tree=Add(tree,data[i]);
	PreOrder(tree);
	cout<<endl;
	tree=Remove(tree,8);
	PreOrder(tree);
	return 0;
} 
