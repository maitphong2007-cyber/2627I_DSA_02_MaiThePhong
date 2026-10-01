package Week4;
import java.util.*;

class Student{
  private int id;
  private String fname;
  private double cgpa;
  public Student(int id, String fname, double cgpa) {
    super();
    this.id = id;
    this.fname = fname;
    this.cgpa = cgpa;
  }
  public int getId() {
    return id;
  }
  public String getFname() {
    return fname;
  }
  public double getCgpa() {
    return cgpa;
  }
}

//Complete the code
public class Bai04
{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int testCases = Integer.parseInt(in.nextLine());

    List<Student> studentList = new ArrayList<Student>();
    while(testCases>0){
      int id = in.nextInt();
      String fname = in.next();
      double cgpa = in.nextDouble();

      Student st = new Student(id, fname, cgpa);
      studentList.add(st);

      testCases--;
    }
    int n=studentList.size();
    for (int i=0;i<n;i++){
      Student s=studentList.get(i);
      int index=i;
      for(int j=i+1;j<n;j++){
        if (s.getCgpa()<studentList.get(j).getCgpa()){
          s=studentList.get(j);
          index=j;
        }
        else if (s.getCgpa()==studentList.get(j).getCgpa()){
          if (s.getFname().compareTo(studentList.get(j).getFname())>0) {
            s = studentList.get(j);
            index=j;
          }
          else if (s.getFname().compareTo(studentList.get(j).getFname())==0){
            if (s.getId()>studentList.get(j).getId()){
              s=studentList.get(j);
              index=j;
            }
          }
        }
      }
      studentList.set(index,studentList.get(i));
      studentList.set(i,s);
    }

    for(Student st: studentList){
      System.out.println(st.getFname());
    }
  }
}




