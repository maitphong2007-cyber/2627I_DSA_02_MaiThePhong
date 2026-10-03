package Week4;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result5 {

  /*
   * Complete the 'insertionSort2' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort2(int n, List<Integer> arr) {
    // Write your code here
    if (n == 1) {
      System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
      return;
    }
    for (int i=1;i<n;i++){
      int k=arr.get(i);
      int j=i-1;
      while (j>=0 && k<arr.get(j)){
        arr.set(j+1,arr.get(j));
        j-=1;
      }
      arr.set(j+1,k);
      System.out.println(arr.toString().replaceAll("[\\[\\],]", ""));
    }
  }

}

public class Bai5 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    Result5.insertionSort2(n, arr);

    bufferedReader.close();
  }
}

