package example.day09.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Table;

@Entity 
@Table(name = "board")
@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor 
public class ApiEntity {
    //  board (idx, subject, name, regdate, content)
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer idx;

    @Column 
    private String subject;

    @Column
    private String name;

    @Column
    private String regdate;

    @Column
    private String content;

}

