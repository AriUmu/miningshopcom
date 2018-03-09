package mining.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private Long id;
    private String nameProduct;
    private Double price;
    private String status;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Long> users = new HashSet<>();


    @ManyToMany(mappedBy = "product", fetch = FetchType.EAGER)
    public Set<Long> getUsers(){
        return users;
    }



}


