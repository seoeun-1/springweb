/*package example.day06.미니프로젝트2DB설계;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale.Category;

import example.day06.미니프로젝트2DB설계.ProductDto.ProductDtoBuilder;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.ToString;

@Entity @Table (name="product")
public class ProductEntity {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer pno;

    @Column (nullable = false)
    private String pname;

    @Column (nullable = false)
    private int pprice;

    @Column (nullable = false)
    private boolean pstatus;

    // FK
    @ManyToOne
    @JoinColumn (name = "cno")
    private CategoryEntity categoryEntity;

    @OneToMany(mappedBy = "productEntity")
    @ToString.Exclude
    @Builder.Default
    List<ManagementEntity> managementList = new ArrayList<>();

    public Integer getPno() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPno'");
    }

    public Object getPprice() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPprice'");
    }

    public Object isPstatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPstatus'");
    }

    public Object getCreateDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCreateDate'");
    }

    public Object getUpdateDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUpdateDate'");
    }

    public static ProductDtoBuilder builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }

    public String getPname() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPname'");
    }

}
*/
