package step16.ex02;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
  public static void main(String[] args) {
    BufferedReader in = null;
    PrintStream out = null;
    
    try (
      //1) 서버에 연결
      Socket socket = new Socket("localhost", 8888);
    ) {
      in = new BufferedReader(
          new InputStreamReader(
            socket.getInputStream()));
  
      out = new PrintStream(socket.getOutputStream()); 

      out.println("Hello!");
      String message = in.readLine();
      
      System.out.println(message);
      
    } catch (Exception e) {
      e.printStackTrace();
      
    } finally {
      try {in.close();} catch (Exception e) {}
      try {out.close();} catch (Exception e) {}
    }
  }
}
