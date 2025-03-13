package com.ragul.demo.Multithreading.NotifyAndNotifyAll;

//mix of output would be random
public class WithoutNotifyAndNotifyAll {

   
    public static void main(String[] args) {
        WithoutNotifyAndNotifyAll printer = new WithoutNotifyAndNotifyAll();
        Thread numberThread = new Thread(() -> printer.printNumbers());
        Thread letterThread = new Thread(() -> printer.printLetters());
        numberThread.start();
        letterThread.start();
    }
    public void printNumbers() {
        for (int i = 1; i <= 26; i++) { // Adjust the range as needed
                System.out.print(i + " ");
            }
        }
    public void printLetters() {
        for (char c = 'A'; c <= 'Z'; c++) { // Adjust the range as needed
                System.out.print(c + " ");
        }
    }
}