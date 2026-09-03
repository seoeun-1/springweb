package example.day05;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor@AllArgsConstructor@Builder
@Setter@Getter@ToString
public class TestDto { // 서버 계층간 이동객체(controller에서는 엔티티 사용금지)
    private Integer no;
    private String name;
    private String descri;
    private Integer price;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;

    public TestEntity toEntity(){
        return TestEntity.builder()
        .name(this.name)
        .descri(this.descri)
        .price(this.price)
        .build();
    }
    //static란? 인스턴스 없이 호출가능 메소드/변수 
    public static TestDto from(TestEntity testEntity){
        return TestDto.builder()
        .name(testEntity.getName())
        .descri(testEntity.getDescri())
        .price(testEntity.getPrice())
        .createDate(testEntity.getCreateDate())
        .updateDate(testEntity.getUpdateDate())
        .no(testEntity.getNo())
        .build();
    }
}
