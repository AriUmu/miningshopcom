package mining.model;

import lombok.Data;

import javax.persistence.*;
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
    private Set<User> users;


    @ManyToMany(mappedBy = "product", fetch = FetchType.EAGER)
    public Set<User> getUsers(){
        return users;
    }



}


