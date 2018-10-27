package br.com.xfood.foodback.model;

import br.com.xfood.foodback.model.enumerator.EnumState;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class County implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EnumState state;

}