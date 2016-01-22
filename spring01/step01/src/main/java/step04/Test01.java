package step04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step04/application-context01.xml");
    
    Computer c1 = (Computer)context.getBean("c1");
    Computer c2 = (Computer)context.getBean("c2");
    Computer c3 = (Computer)context.getBean("c3");
    
    System.out.println(c1);
    System.out.println(c2);
    System.out.println(c3);
  }

}
