package io.jameshalearning.retailmanydataapi.product;

import io.jameshalearning.retailmanydataapi.price.ProductPrice;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "one_product")
public class Product implements Serializable {

    private static final long serialVersionUID = -6346108765001125095L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ProductPrice> productPrices = new ArrayList<>();

    public void setProductPrices(List<ProductPrice> productPrices) {
        this.productPrices = productPrices;
        productPrices.forEach(productPrice -> productPrice.setProduct(this));
    }
}