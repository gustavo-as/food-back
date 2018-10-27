package br.com.xfood.foodback.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
public class PurchaseItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @Column(nullable=false)
    private Integer number;

    @ManyToOne(optional = false)
    private Product product;

    @Column(length=500)
    private String comments;

    /**
     * Data inicial da reserva do estoque.
     * Normalmente esta data inicia com a inclusao do item no orçamento
     */
    @Temporal(TemporalType.TIMESTAMP)
    private Date purchaseDate;

    @ManyToOne
    private Purchase purchase;

    @Column(precision=10,scale=2, nullable=false)
    private BigDecimal amount = BigDecimal.ZERO;

    @Column(precision=10,scale=2, nullable=false)
    private BigDecimal unitaryValue = BigDecimal.ZERO;

    @Version
    private Long version;

    @Column(precision=10,scale=2)
    private BigDecimal discountValue = BigDecimal.ZERO;

    @Column(precision=10,scale=2)
    private BigDecimal purchaseValue = BigDecimal.ZERO;

}
