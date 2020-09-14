package com.example.cloudprovider;


public class ThreadTest  extends Thread{

    private  String threadName;
    /**
     * 需要给线程传递参数 需要使用 有参构造函数
     */
    public  ThreadTest(String threadName){
        //通过构造函数传递的参数为当前线程类赋值
        this.threadName = threadName;
    }
    //线程逻辑方法 线程就绪之后 获取到cpu执行权限 执行run方法
    @Override
    public  void  run(){
        for (int i = 0; i <100 ; i++) {
            //线程休眠后 线程进入阻塞状态
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(threadName+":"+i);
        }
    }
}
