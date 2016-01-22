/*
 * 주제: 자바 핵심 클래스 - String (4)
 */
package step06;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Exam04 {

  public static void main(String[] args) {
    //Escape 문자: 특별한 기능을 수행하는 문자
    //1) 줄 바꿈 문자 삽입:
    //   \r(carrage return) => Unicode 0x000d => \u000d
    //   \n(line feed) => Unicode 0x000a  => \u000a
    
    //=> 각 문자의 유니코드 값을 출력하여 줄바꿈 문자의 유니코드 값을 확인한다.
    toHexFromString("Hello,\r\n World");
    
    //=> 문자열에 줄 바꿈 코드를 넣을 때 보통 \n만 사용한다.
    toHexFromString("Hello,\n World");
    
    //=> Windows와 Unix의 줄 바꿈 코드 값
    //   Windows:   Carrage Return(CR) 0x0d
    //              Line Feed(LF) 0x0a
    //   => 윈도는 타자기에서 줄 바꿈을 참조하여 만들었다.
    //   Unix :     Line Feed(LF) - 0x0a
       
    //2) 임의의 유니코드 삽입하기: 예) \u0020 
    toHexFromString("ABC\u0020abc");
    toHexFromString("ABC\uac00\uac01abc");
    
    //3) 탭 코드 넣기: 예) \t
    toHexFromString("ABC\tabc");
    
    //4) 백스페이스: 예) \b
    toHexFromString("ABC\babc");
    
    //5) 역슬래시 출력: 예) \\
    toHexFromString("ABC\\abc");
    System.out.print("c:\\javaide\\workspace");
    System.out.print("c:/javaide/workspace"); 
    // => 파일 경로 
    //    유닉스 : / (슬래시) 사용
    //    윈도   : \ (역슬래시) 사용
    //    자바는 윈도와 유닉스 상관없이 그냥 /를 사용해도 된다.
    
    //6) 큰 따옴표 출력: 예) \"
    toHexFromString("ABC\"ab\"c");
    toHexFromString("ABC'ab'c"); //문자열에서는 \' 이렇게 사용할 필요가 없다.
    System.out.println('\''); // 문자에서 작은 따옴표를 표현하고 싶을 때 사용한다.
    System.out.println("<htm><body><h1>hahaha</h1><a href=\"http://www.naver.com\">뇌이버</a></body></html>");
    
  }
  
  static void toHexFromString(String s) {
    System.out.println("--------------------");
    System.out.println(s);
    System.out.println("--------------------");
    for (int i = 0; i < s.length(); i++) {
      System.out.printf("%x\n", (int)s.charAt(i));
    }
  }

}





