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
    private Integer id;

    @Column(nullable=false, unique = true)
    @NotNull(message="Login required")
    @NotEmpty(message="Login required")
    @Email(message="Login should be email")
    private String login;

    private String password;

    @ManyToOne(optional=false)
    private People people;

    @Temporal(TemporalType.DATE)
    private Date passwordUpdated = new Date();

    @Temporal(TemporalType.DATE)
    private Date createdDate = new Date();

    @Temporal(TemporalType.DATE)
    private Date lastAccess = new Date();

    @OneToMany(cascade=CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="user_id")
    private Set<UserRule> rules = new HashSet<UserRule>();

    private boolean active;

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
