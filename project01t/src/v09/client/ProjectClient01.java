package v09.client;

import java.util.Scanner;

public class ProjectClient01 {
  
  private void execute() {
    try (
      Scanner keyboard = new Scanner(System.in);  
    ) 
    {
      String command = null;
      
      while (true) {
        System.out.print("명령> ");
        command = keyboard.nextLine();
        System.out.println(command);
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) {
    ProjectClient01 client = new ProjectClient01();
    client.execute();
  }
}
