package br.com.xfood.foodback.model;

import br.com.xfood.foodback.model.enumerator.EnumUserRule;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="user_seq")
    @SequenceGenerator(name="user_seq", sequenceName="user_seq", allocationSize=1, initialValue=1)
    private Integer id;

    @Column(nullable=false, unique = true)
    @NotNull(message="Login required")
    @NotEmpty(message="Login required")
    @Email(message="Login should be email")
    private String login;

    private String senha;

    @ManyToOne(optional=false)
    private People people;

    @Temporal(TemporalType.DATE)
    private Date dataAlteracaoSenha = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataCriacao = new Date();

    @Temporal(TemporalType.DATE)
    private Date dataUltimoAcesso = new Date();

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="user_id")
    private Set<UserRule> rules = new HashSet<UserRule>();

    private boolean ativo;

    public void addRule(EnumUserRule enumUserRule){
        if(!isContainsRule(enumUserRule)){
            UserRule userRule = new UserRule();
            userRule.setRule(enumUserRule);
            rules.add(userRule);
        }
    }

    public boolean isContainsRule(EnumUserRule enumUserRule){
        for(UserRule p : rules){
            if(p.getRule() == enumUserRule){
                return true;
            }
        }
        return false;
    }

}
