package step06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {

  public static void main(String[] args) {
    ApplicationContext context = new ClassPathXmlApplicationContext(
        "step06/application-context01.xml");
    
    System.out.println(context.getBean("c1"));
    System.out.println(context.getBean("c2"));
    System.out.println(context.getBean("c3"));
    
    Object instance = context.getBean("c1");
    Class<?> clazz = instance.getClass();
    System.out.println(clazz.getName());
  }

}
