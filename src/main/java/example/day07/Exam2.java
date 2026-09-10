/*package example.day07;

import org.apache.el.lang.FunctionMapperImpl.Function;

interface Calculator{ int plus(int x , int y);} //추상메소드
public class Exam2 {
    public static void main(String[] args) {
        //1. 구현체: 추상메소드(인터페이스) 구현한 객체
        //2. 익명구현체: 추상메소드 구현한 클래스 없이 직접(1회성) 구현 
        // 인터페이스 변수명 = new 인터페이스() { 추상메소드 };
        //List<Member>
        //3. 람다표현식
        Calculator calc2 = ( x , y ) ->  { return x + y ;};
        //3. 람다표현식 사용하는 인터페이스들
        Function< Integer, Integer > function = (x) -> {return x * 2;}; 
        System.out.println(function.apply(3));
        
        suplier<Integer> suplier = ()
        System.out.println(supplier.get());

        Consumer<인수타입> consumer = (str) -> {}
        consumer.accept("유재석");
        // Predicate<Integer>isPosittive

        //활용처 : 으; 4깆; 직접적인 사용이 아닌 API(남이 만든 클래스 엉덩이 )
        for (String string : args) {
            
        }
}
*/