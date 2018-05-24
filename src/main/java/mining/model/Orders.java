package mining.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ORDERS")
public class Orders {

    public Orders(Long idUser, Long idProduct) {
        this.idUser = idUser;
        IdProduct = idProduct;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long id;

    @Column(name = "user_id")
    private Long idUser;

    @Column(name = "product_id")
    private Long IdProduct;
}


