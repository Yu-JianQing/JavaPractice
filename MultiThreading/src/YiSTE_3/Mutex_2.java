package YiSTE_3;

public final class Mutex_2 {
	private int locks;//����������һ���߳̿����϶����
	private Thread owner;//��ǰ�߳�
	
	public synchronized void lock(){
		Thread me=Thread.currentThread();
		while(locks>0&&owner!=me){//�������Ҳ����ҵ�
			try {
				wait();//����������ȴ�
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		assert locks==0||owner==me;//whileһ���˳���ζ��Ҫôû���˻��ߵ�ǰ�������Լ���
		owner=me;//������
		locks++;//����������1
	}
	
	public synchronized void unlock(){
		Thread me=Thread.currentThread();
		if(owner!=me||locks==0){//����ʱ����ǰ�������ҵĻ���û����
			return ;//���ܽ���
		}
		assert owner==me&&locks>0;//if������Ҳ����˵����������������ҵ�
		locks--;//�Լ�����
		if(locks==0){//���Լ�������������������ô��û�еĻ�
			owner=null;//ӵ����Ϊ��
			notifyAll();//���������߳�
		}
	}
}
