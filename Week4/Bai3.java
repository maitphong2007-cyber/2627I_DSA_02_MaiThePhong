package Week4;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

  /*
   * Complete the 'insertionSort1' function below.
   *
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. INTEGER_ARRAY arr
   */

  public static void insertionSort1(int n, List<Integer> arr) {
    // Write your code here
    boolean ok = false;
    int k=arr.get(n-1);
    int j=n-2;
    while (j>=0 && ok==false){
      if (k<arr.get(j)){
        arr.set(j+1,arr.get(j));
        j--;
        System.out.println(arr.toString().replaceAll("[\\[\\],]",""));
      }
      else{
        ok=true;
      }
    }
    arr.set(j+1,k);
    System.out.println(arr.toString().replaceAll("[\\[\\],]",""));
  }

}

public class Bai3 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

    List<Integer> arr = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      int arrItem = Integer.parseInt(arrTemp[i]);
      arr.add(arrItem);
    }

    Result.insertionSort1(n, arr);

    bufferedReader.close();
  }
}
