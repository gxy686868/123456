package com.example.cloudprovider;

import org.junit.jupiter.api.Test;

public class RunThread{

    @Test
    public void ThreadTest(){

    }
    public static void main(String[] args) {
        //在主线程中新建一个子线程 线程处于新建状态
        ThreadTest A = new ThreadTest("A");
        ThreadTest B = new ThreadTest("B");
        ThreadTest C = new ThreadTest("C");
        ThreadTest D = new ThreadTest("D");
        A.start();
        B.start();
        C.start();
        D.start();

    }

}
