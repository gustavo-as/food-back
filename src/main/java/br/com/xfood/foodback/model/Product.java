package br.com.xfood.foodback.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
@Entity
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @ManyToOne(optional=false)
    private ClientCompany clientCompany;

    @Column(nullable=false)
    @NotEmpty(message="Code is Required")
    private String code;

    @Column(nullable=false)
    @NotEmpty(message="Description is Required")
    private String description;

    @Column(precision=10,scale=2)
    private BigDecimal value = BigDecimal.ZERO;

}
