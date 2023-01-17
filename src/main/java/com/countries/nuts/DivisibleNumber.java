package com.countries.nuts;

public class DivisibleNumber {
  public static void main(String[] args) {
    int number = 30;
    for (int i = 1; i <= number; i++){
        if (i % 3 == 0 && i % 5 == 0){
            System.out.println("Visual Nuts");
        }else if (i % 3 == 0){
            System.out.println("Visual");
        } else if (i % 5 == 0){
            System.out.println("Nuts");
        } else {
            System.out.println(i);
        }
    }
  }
}
