package Week2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SUM4{
  public int target;
  public List<Integer> mang;
  public SUM4(int target,List<Integer> mang){
    this.target = target;
    this.mang = mang;
  }
  public List<List<Integer>> Find(){
    Collections.sort(mang);
    List<List<Integer>> kq = new ArrayList<>();
    int sz=mang.size();
    for (int i=0;i<sz-3;i++){
      for (int j=i+1;j<sz-2;j++){
        int k=j+1;
        int m=sz-1;
        while (k<m){
          int tong =mang.get(i)+mang.get(j)+mang.get(k)+mang.get(m);
          if (tong==target){
            kq.add(Arrays.asList(mang.get(i), mang.get(j), mang.get(k), mang.get(m)));
            k+=1;
            m-=1;
          } else if (tong < target) {
            k+=1;
          }
          else{
            m-=1;
          }

        }
      }
    }
    return kq;
  }
}
/*
1. Ý tưởng cốt lõi:Sử dụng phương pháp Kết hợp Sắp xếp (Sorting) và Con trỏ hai đầu(Two Pointers).
 Bằng cách cố định 2 số đầu tiên và dùng 2 con trỏ quét 2 số còn lại từ 2 đầu mảng, ta giảm độ phức tạp từ $O(N^4)$ (vét cạn 4 vòng lặp) xuống $O(N^3)$.
2. Các bước thực hiện từng bước:Sắp xếp mảng:Sắp xếp mảng mang theo thứ tự tăng dần bằng Collections.sort(mang) để phục vụ cho kỹ thuật con trỏ hai đầu
Cố định 2 số đầu tiên:Dùng vòng lặp i duyệt số thứ nhất từ index 0 đến sz - 4.Dùng vòng lặp j duyệt số thứ hai từ index i + 1 đến sz - 3.
3.Quét Two Pointers cho 2 số còn lại:Khởi tạo con trỏ trái k = j + 1 và con trỏ phải m = sz - 1.
Trong khi k < m, tính tổng: tong = mang[i] + mang[j] + mang[k] + mang[m]
So sánh tong với target:Nếu tong == target:
  Lưu bộ 4 số [mang[i], mang[j], mang[k], mang[m]] vào danh sách kết quả kq, sau đó dịch k sang phải (k++) và m sang trái (m--).
  Nếu tong < target: Tăng k (k++) để tăng tổng.
  Nếu tong > target: Giảm m (m--) để giảm tổng.
4.Trả về kết quả: Sau khi duyệt hết các vòng lặp, trả về danh sách kq.
 */