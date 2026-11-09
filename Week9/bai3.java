package Week9;
import java.util.*;
import java.io.*;


public class bai3 {

  public static void preOrder( Node root ) {

    if( root == null)
      return;

    System.out.print(root.data + " ");
    preOrder(root.left);
    preOrder(root.right);

  }

 /* Node is defined as :
 class Node
    int data;
    Node left;
    Node right;

    */

  public static Node insert(Node root,int data) {
    if (root==null){
      return new Node(data);
    }
    else if (root.data<data){
      root.right= insert(root.right,data);
    }
    else if (root.data>data){
      root.right= insert(root.left,data);
    }
    return root;
  }

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0) {
      int data = scan.nextInt();
      root = insert(root, data);
    }
    scan.close();
    preOrder(root);
  }
}