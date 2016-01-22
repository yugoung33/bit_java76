package step05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test02 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step05/application-context02.xml");
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
  }

}
