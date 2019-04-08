package com.qjh.imoocmusic.entities;

public class B extends A {
    static {
        System.out.println("static B");
    }

    @Override
    public void print() {
        System.out.println("B.print()");
    }

    public B() {
        System.out.println("I am B");
    }
}
