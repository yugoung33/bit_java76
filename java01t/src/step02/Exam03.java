/*
 * 주제: 도구가 들어있는 경로(패키지 경로)를 등록하기 
 * - 문법
 *   import 패키지경로.*;
 *   import 패키지경로.도구명;
 */
package step02;

// 컴파일러에게 Calendar 도구가 어느 경로에 있는지 알려준다.
import java.util.Calendar; // 컴파일 할 때만 참조하고, 컴파일 버려진다.


public class Exam03 {
  public static void main(String[] args) {
    // 1970년 1월 1일 0시 0분 0초부터 지금까지 경과된 시간(밀리초)
    long t = System.currentTimeMillis();
    System.out.println(t);
    
    // 현재 달력 정보를 달라고 요청한다.
    Calendar 달력정보 = Calendar.getInstance();
    int i = 달력정보.get(1); // 년도
    System.out.println(i);
    i = 달력정보.get(2); // 월 
    System.out.println(i+1);
    i = 달력정보.get(5); // 일
    System.out.println(i);
    i = 달력정보.get(7); // 요일
    System.out.println(i);
    i = 달력정보.get(10); // 시
    System.out.println(i);
    i = 달력정보.get(12); // 분
    System.out.println(i);
    i = 달력정보.get(13); // 초
    System.out.println(i);
    
    // System은 java.lang 경로에 있다. 왜 경로를 지정하지 않는가?
    // - java.lang 경로는 기본으로 등록되어 있기 때문에
    //   System 도구를 사용할 때 지정할 필요가 없다.
    //
    // 그 외 다른 경로의 도구는 반드시 그 경로를 지정해야 한다.
    // 예) java.util.Calendar.getInstance(); 
    
  }
}






