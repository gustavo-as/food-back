package br.com.xfood.foodback.model;

import br.com.xfood.foodback.model.enumerator.EnumUf;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class County implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "county_seq")
    @SequenceGenerator(name = "county_seq", sequenceName = "county_seq", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(nullable = false)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumUf uf;

    @Column(unique = true, nullable = false)
    private Integer codigoIbge;

    private Integer codigoTc;
}