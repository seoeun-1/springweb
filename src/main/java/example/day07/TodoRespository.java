package example.day07;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository 
public interface TodoRespository extends JpaRespository<TodoEntity,Integer>{
    //extends JpaRepository< 조작할엔티티명. PK명
    //1. CRUD 메소드 제공: .save() .findAll() .fidndById() .deleteById() 등등
    //2. 쿼리메소드 : SQL 자성하지 않고 추상메소드 이름으로 쿼리 자동 생성<카멜 표기법>
    // 반환타입 findBy 필드명(타입 매개변수명); 주의할 점: 필드명에  대소분자(카멜)규칙 , 존재하는 필드명 기능
    TodoEntity findByTitle(String title);
    List<TodoEntity> findByTitleAndContent( String title , String content);
    Map<String,Object>findByTitleOrContent(String title, String contnet);
    //2.네이트브쿼리: SQL 직접 작성, 추상메소드 이름은 아무거나
    //추상메소드 위에 @Query(value = "직접SQL" , )
    //SQL 매개변수 대입시 ? 대신에 :매개변수명
    @Query(value = "SELECT * FROM todo WHERE title = ?" , nativeQuery = true)
    TodoEntity myquery1(String title);
    @Query(value = "select * from todo where tutle = :title and content = :contnet" , nativeQuery = true)
    List<TodoEntity> myquery2(String title , String content);
    @Query(value = "select * from todo where tutle = :title or content = :contnet" , nativeQuery = true)
    Map<String,Object> myquery3(String title , String content);
}
