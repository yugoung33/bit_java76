package v10.server.servlet;

import java.io.PrintStream;
import java.util.ArrayList ;
import java.util.HashMap;

import v10.server.dao.StudentDao;
import v10.server.domain.Student;



// Command 규칙 적용
public class StudentListServlet implements Servlet {
  StudentDao studentDao;
  
  public void setStudentDao(StudentDao studentDao) {
    this.studentDao = studentDao;
  }

  public void service(HashMap<String,Object> params) {
    ArrayList<Student> list = studentDao.selectList();
    PrintStream out = (PrintStream)params.get("out");
    
    Student student = null;
    for (int i = 0; i < list.size(); i++) {
      student = list.get(i); // 제네릭 적용! 타입 캐스팅 필요 없다.
      if (student == null) 
        continue;
      out.printf("%d %s %s %s %s\n", 
          i, 
          student.getName(),
          student.getEmail(),
          student.getTel(),
          student.getCid());
    }
  }
}
