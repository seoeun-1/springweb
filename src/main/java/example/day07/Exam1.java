package example.day07;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

public class Exam1 {
    public static void main(String[] args) {
        //서로 다른 클래스의 메소드 호출 하는 방법
        //메소드란? 상호작용(2개 이상의 개체 주고 (인수M) 받는 (리턴1))
        //1. 인스턴스 생성하여 메소드호출
            TestService testService = new TestService();
            int result1 = testService.plus(3, 5);
        //2. 싱글톤
            //TestService testService = TestService.getInstance();
            //int result2 = testService.plus(3 , 5 );
        //3.메소드가 static이면
            int result3 = TestService.plus2(10, 5);

        //4. 스프링방식:
            //@component(자동인스턴스생성)@Autowired(인스턴스호출)
            //@Autowired private TestService testService2;
            //int result4 = testService2.plus(10 , 5);
        //인스턴스(주체p) VS static(주체x)

        //5. 사칙연산
        int x = 10 + 2 + 5 ; //17

        TestService t3 = new TestService();
        t3.개별호출().밥먹기();
        //t3.개별호출() --> Student(신동엽)
        //Student(신동엽).밥먹기();
    }
}

@Component 
class TestService{

    //private  TestService(){}
    //private  static  final TestService instaince = new TestService();
    //public static TestService getInstance(){return  instaince;}

    int plus( int x , int y ){return  x + y;}
    static int plus2( int x , int y ){return  x + y;}

    List<Student> list = new ArrayList<>();
    TestService(){
        list.add(new Student("강호동"));
        list.add(new Student("신동엽"));
    }
    Student 개별호출(){return list.get(1);}
}

class Student{
    String name;
    Student(String name){
        this.name = name;
    }
    void 밥먹기(){
        System.out.println(this.name + "밥 먹는다.");
    }
}