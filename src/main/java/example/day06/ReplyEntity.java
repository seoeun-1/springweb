/*package example.day06;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "reply")
@Table@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class ReplyEntity {
    @Id
    private Integer rno;
    private String rname;
    //단방향 참조
    @ManyToOne( cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name = "bno")
    private BoardEntity boardEntity;
}

/*
    영속성이란? 자바는 여구 저장이 불가능 하므로 DB 매핑/연결하여 영속성(영구저장) 표현

    @ManyToOne( cascade = 영속성제야조건)
    CascadeType.REMOVE : 만일 부모엔티티가 삭제되면 자식 엔티티 샅이 삭제된다.
    CascadeType.MERGE : 만일 부모 엔티티가 수정된면 자식 엔티티 수정 같이 반영된다.
    CascadeType.DETACH : 만일 부모 엔티티가 영속(연결)해제 하면 자식 엔티티 같이 해제한다.
    CascadeType.REFRESH : 만약 부모 엔티티가 재호출(갱신) 되면 자식 엔티티 같이 갱신한다.
    CascadeType.PERSIST : 만약 부모 엔티티가 저장하면 자식 엔티티 같이 저장된다.
    CascadeType.ALL : 위 속성들을 모두 사용

    FetchType.LAZY : 해당 엔티티 조회시 자식(참조) 엔티티 불러오지 않는다. 
        -초기 로딩 빠르다, 재사용성 느리다 , 필요한 정보만 불러온다.<지연로딩>
    FetchType.EAGER : 해당 엔티티 조회시 자식(참조) 엔티티 (즉시) 불러온다. -부모 조회시 자식 포함
        -기본값 , 초기 로딩 느리다 , 재사용성 빠르다 , 불필요한 정보까지 불러온다<성능저하>
*/