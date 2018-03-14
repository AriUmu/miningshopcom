package mining.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;

    @Basic
    @Column(name = "name_product")
    private String nameProduct;

    @Basic
    @Column(name = "price")
    private Double price;

    @Basic
    @Column(name = "status")
    private String status;
}


