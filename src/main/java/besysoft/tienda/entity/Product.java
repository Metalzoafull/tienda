package besysoft.tienda.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
//import javax.persistence.Table;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
//@Accessors(fluent = true) @Getter
//@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String name;

    @Column
    @NonNull
    private Double price;

    @Column
    @NonNull
    private String category;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "seller", nullable = true, updatable = true)
    private Seller seller;

}
