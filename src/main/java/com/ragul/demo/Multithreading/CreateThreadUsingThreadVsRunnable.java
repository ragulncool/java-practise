package com.ragul.demo.Multithreading;

public class CreateThreadUsingThreadVsRunnable {
    public static void main(String args[]){

    }
}
//COMPILE ERROR - Class cannot extend multiple classes
//class A extends B,Thread{
//
//}

  class A extends B implements Runnable{
      @Override
      public void run() {

      }
  }

        class B{

        }