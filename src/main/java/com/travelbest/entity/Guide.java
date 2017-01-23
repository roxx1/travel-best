package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity(name = "guides")
@Data
@NoArgsConstructor
public class Guide implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Email
    private String email;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String surname;

    @Column(name = "middle_name")
    private String middleName;

    @Column(unique = true)
    private String phone;

    public Guide(String email, String name, String surname, String middleName) {
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
    }

}
