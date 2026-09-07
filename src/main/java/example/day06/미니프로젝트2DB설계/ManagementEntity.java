/*package example.day06.미니프로젝트2DB설계;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table (name = "management")
@NoArgsConstructor @AllArgsConstructor @Builder @Data 
public class ManagementEntity extends BaseTime {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer mno;
    private LocalDate mdate;
    private String mstatus;
    private LocalDate in_date;
    private LocalDate out_date;

    @ManyToOne
    @JoinColumn (name = "pno")
    private ProductEntity productEntity;
}
*/