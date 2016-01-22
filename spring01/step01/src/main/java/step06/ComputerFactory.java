package step06;

public class ComputerFactory {
  public static Computer createComputer(String type) {
    System.out.println("createComputer()");
    
    Computer computer = new Computer();
    
    switch (type) {
    case "game":
      computer.model = "울트라 게이밍 No.1";
      computer.maker = "용산컴";
      computer.ram = 16;
      computer.speed = 4.2f;
      break;
    case "develop":
      computer.model = "웹개발수퍼컴";
      computer.maker = "비트컴";
      computer.ram = 32;
      computer.speed = 3.0f;
      break;
    default:
      computer.model = "사무용날쌘돌이";
      computer.maker = "아무나컴";
      computer.ram = 2;
      computer.speed = 2.0f;
    }
    
    return computer;
  }
}
