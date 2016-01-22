package v07.command;

import java.util.ArrayList ;
import java.util.HashMap;

import v07.Student;

// Command 규칙 적용
public class StudentListCommand implements Command {
  public void execute(HashMap<String,Object> params) {
    ArrayList<Student> list = (ArrayList<Student>)params.get("list");
    
    Student student = null;
    for (int i = 0; i < list.size(); i++) {
      student = list.get(i); // 제네릭 적용! 타입 캐스팅 필요 없다.
      if (student == null) 
        continue;
      System.out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
