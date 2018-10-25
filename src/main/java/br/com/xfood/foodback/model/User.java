package br.com.xfood.foodback.model;

import br.com.xfood.foodback.model.enumerator.EnumProfile;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 2279569997435996789L;

    @Id
    private Integer id;

    @Email(message = "Invalid Email")
    @NotBlank(message = "Email Required")
    private String email;

    @NotBlank(message = "Password Required")
    @Size(min = 6, message = "Required 6 Characters")
    private String password;

    private EnumProfile enumProfile;
}
