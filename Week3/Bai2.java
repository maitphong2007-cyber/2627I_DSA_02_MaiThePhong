package Week3;
import edu.princeton.cs.algs4.Stack;
public class Bai2 {
  public static boolean isBalanced(String s){
    Stack<Character> stack =new Stack<>();
    int size = s.length();
    for (int i=0;i<size;i++){
      char c= s.charAt(i);
      if (c=='[' || c=='(' || c=='{'){
        stack.push(c);
      }
      else if(c==']' || c=='}' || c==')'){
        if (stack.isEmpty()==true){
          return false;
        }
        char d=stack.pop();
        if (!((c==')' && d=='(') || (c=='}' && d=='{') || (c==']' && d=='['))){
          return false;
        }
      }
    }
    return stack.isEmpty()==true;
  }

  static void main(String[] args) {
    String s1="[{}]()";
    String s2="[{]][[()";
    System.out.println("s1" + Bai2.isBalanced(s1));
    System.out.println("s2" + Bai2.isBalanced(s2));
  }
}
