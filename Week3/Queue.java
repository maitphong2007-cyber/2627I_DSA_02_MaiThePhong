package Week3;

public class Queue<T> {
  private T[] mang;
  private int head,tail,amount;
  public Queue(int size){
    mang=(T[]) new Object[size];
    head=0;
    amount=0;
    tail=0;
  }
  public void enqueue(T value){
    if (amount==mang.length){
      System.out.println("queue is full");
      return;
    }
    mang[tail]=value;
    tail=(tail+1)%mang.length;
    amount+=1;
  }
  public T dequeue(){
    if(amount==0){
      System.out.println("Queue is empty");
      return null;
    }
    T item=mang[head];
    mang[head]=null;
    head=(head+1)%mang.length;
    amount-=1;
    return item;
  }
  public boolean isEmpty(){
    return amount==0;
  }

}
