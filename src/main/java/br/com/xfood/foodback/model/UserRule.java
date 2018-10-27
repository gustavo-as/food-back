package br.com.xfood.foodback.model;

import br.com.xfood.foodback.model.enumerator.EnumUserRule;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class UserRule implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumUserRule rule;

}
