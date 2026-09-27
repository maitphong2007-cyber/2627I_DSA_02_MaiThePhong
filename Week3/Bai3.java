package Week3;

import edu.princeton.cs.algs4.Stack;

import java.util.Scanner;

public class Bai3 {
  static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    Stack<Integer> pushstack=new Stack<>();
    Stack<Integer> popstack=new Stack<>();
    int n= sc.nextInt();
    for (int i=0;i<n;i++){
      int j=sc.nextInt();
      if (j == 1) {
        int value = sc.nextInt();
        pushstack.push(value);
      }
      else if(j==2 || j==3){
        if (popstack.isEmpty()==true){
          while (pushstack.isEmpty() == false) {
            popstack.push(pushstack.pop());
          }
        }
        if (popstack.isEmpty()==false){
          if (j==2) {
            popstack.pop();
          }
          else if (j==3) {
            System.out.println(popstack.peek());
          }
        }
      }
    }
    sc.close();
  }
}
