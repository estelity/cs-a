package com.example;

public class Test {
    public static void main(String[] args){
        mystery(3);
    }

    public static void mystery(int n){
        int k;
        for (k=0; k < n; k++){
            mystery(k);
            System.out.println(n);
        }
    }
}
