package io.jameshalearning.retailmanydataapi.price;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.jameshalearning.retailmanydataapi.product.Product;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Table(name = "many_product_price")
public class ProductPrice implements Serializable {

    private static final long serialVersionUID = -4207597182912798894L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "value")
    private String value;

    @Column(name = "currency_code")
    private String currencyCode;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    @JsonIgnore
    private Product product;

}