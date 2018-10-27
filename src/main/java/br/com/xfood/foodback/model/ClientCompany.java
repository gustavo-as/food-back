package br.com.xfood.foodback.model;

import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Data
@Entity
public class ClientCompany implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Integer id;

    @OneToOne(cascade= CascadeType.ALL)
    private People people = new People();

}
