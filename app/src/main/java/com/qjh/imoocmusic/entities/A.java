package com.qjh.imoocmusic.entities;

public class A {
    static {
        System.out.println("static A");
    }

    public void print() {
        System.out.println("A.print()");

    }

    public A() {
        System.out.println("I am A");
        int temp;
        for (int i=0; i<arr.length-1; i++) {
            for (int j=0; j<arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
    int[] arr = {2,1,8,7,12,6,7,9,4,10};


}
