package com.example.cloudprovider;


public class ThreadTest  extends Thread{

    private  String threadName;
    /**
     * ��Ҫ���̴߳��ݲ��� ��Ҫʹ�� �вι��캯��
     */
    public  ThreadTest(String threadName){
        //ͨ�����캯�����ݵĲ���Ϊ��ǰ�߳��ำֵ
        this.threadName = threadName;
    }
    //�߳��߼����� �߳̾���֮�� ��ȡ��cpuִ��Ȩ�� ִ��run����
    @Override
    public  void  run(){
        for (int i = 0; i <100 ; i++) {
            //�߳����ߺ� �߳̽�������״̬
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName+":"+i);
        }
    }
}
