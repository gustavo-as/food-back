package br.com.xfood.foodback.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
@Entity
public class People implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String companyName;

    @Column(unique=true)
    private String cpfCnpj;

    private String whatsappNumber;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate = new Date();

    private String genre;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private String email;

    private String street;

    private String number;

    private String observation;

    private String zipCode;

    @ManyToOne
    private County county;

}