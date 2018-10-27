package br.com.xfood.foodback.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Purchase implements Serializable {

    private static final long serialVersionUID=1L;

    @Id
    private Long id;

    private String status = "OPEN";

    @Temporal(TemporalType.DATE)
    private Date data=new Date();

    /**
     * Is our client.
     */
    @ManyToOne(optional = false)
    private ClientCompany clientCompany;

    /**
     * Is the customer of commerce.
     */
    @ManyToOne(optional = false)
    private People buyer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "purchase_id")
    private List<PurchaseItem> items = new ArrayList<PurchaseItem>();

}