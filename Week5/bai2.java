package Week5;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

  public static int introTutorial(int V, List<Integer> arr) {
    Integer[] a = arr.toArray(new Integer[0]);

    naturalMergeSort(a);

    int left = 0;
    int right = a.length - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (a[mid] == V) {
        return mid;
      } else if (a[mid] > V) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return -1;
  }

  private static void naturalMergeSort(Integer[] a) {
    int n = a.length;
    if (n <= 1) return;

    Integer[] aux = new Integer[n];
    boolean sorted = false;

    while (!sorted) {
      sorted = true;
      int lo = 0;

      while (lo < n) {
        int mid = lo;
        while (mid < n - 1 && a[mid].compareTo(a[mid + 1]) <= 0) {
          mid++;
        }

        if (mid == n - 1) {
          if (lo == 0) sorted = true;
          break;
        }

        int hi = mid + 1;
        while (hi < n - 1 && a[hi].compareTo(a[hi + 1]) <= 0) {
          hi++;
        }

        merge(a, aux, lo, mid, hi);

        lo = hi + 1;
        sorted = false;
      }
    }
  }

  private static void merge(Integer[] a, Integer[] aux, int lo, int mid, int hi) {
    for (int k = lo; k <= hi; k++) {
      aux[k] = a[k];
    }

    int i = lo, j = mid + 1;
    for (int k = lo; k <= hi; k++) {
      if (i > mid)                  a[k] = aux[j++];
      else if (j > hi)              a[k] = aux[i++];
      else if (aux[j].compareTo(aux[i]) < 0) a[k] = aux[j++];
      else                          a[k] = aux[i++];
    }
  }
}

public class bai2 {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

    int V = Integer.parseInt(bufferedReader.readLine().trim());

    int n = Integer.parseInt(bufferedReader.readLine().trim());

    List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
        .map(Integer::parseInt)
        .collect(toList());

    int result = Result.introTutorial(V, arr);

    bufferedWriter.write(String.valueOf(result));
    bufferedWriter.newLine();

    bufferedReader.close();
    bufferedWriter.close();
  }
}