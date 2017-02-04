package com.travelbest.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "routes")
@Data
@NoArgsConstructor
public class Route {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String title;

    private String description;

    private String image;

    public Route(String title, String description, String image) {
        this.setTitle(title);
        this.setDescription(description);
        this.setImage(image);
    }

}
