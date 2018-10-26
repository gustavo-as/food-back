package br.com.xfood.foodback.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Entity
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator="people_seq", strategy= GenerationType.SEQUENCE)
    @SequenceGenerator(name="people_seq", sequenceName="people_seq", allocationSize=1, initialValue=1)
    private Integer id;

    private String nome;

    private String nomeFantasia;

    @Column(unique=true)
    private String cpfCnpj;

    private String docIdentificacao;

    private String celular;

    @Temporal(TemporalType.DATE)
    private Date dataCadastro = new Date();

    @Enumerated(EnumType.STRING)
    private String sexo;

    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    private String email;

    private String logradouro;

    private String bairro;

    private String complemento;

    private String numero;

    private String cep;

    @ManyToOne
    private County county;

}