package example.day06;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name = "board")
@Table@NoArgsConstructor@AllArgsConstructor@Builder@Data
public class BoardEntity {
    private Integer bno;
    private String bname;

    //단방향 참조
    @ManyToOne //M:1
    @JoinColumn(name = "cno") //FK이름 지정, 주로 pk와 동일하게
    private CategoryEntity categoryEntity;
    //양방향 참조
    @OneToMany(mappedBy = "boardEntity")
    @ToString.Exclude
    @Builder.Default
    private List<ReplyEntity> replyList = new ArrayList<>();
}
