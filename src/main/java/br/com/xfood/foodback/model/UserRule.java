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
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_rule_seq")
    @SequenceGenerator(name="user_rule_seq", sequenceName="user_rule_seq", allocationSize=1, initialValue=1)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EnumUserRule rule;

}
