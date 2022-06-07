package besysoft.tienda.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Accessors(fluent = true) @Getter
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private Double salary;

    @JsonManagedReference
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "seller")
    private List<Product> productList;

}
