package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "roles")
@Data
@NoArgsConstructor
public class Role {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String label;

    public Role(String label) {
        this.label = label;
    }

}
