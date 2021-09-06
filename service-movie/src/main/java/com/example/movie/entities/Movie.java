package com.example.movie.entities;

import lombok.*;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Objects;

@Setter
@Getter
@Entity
@Table(name="movie")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false,nullable = false,unique = true)
    private Long id;

    @NotEmpty(message = "Este campo es obligatorio, por favor ingrese los datos solicitados")
    @Column(name="title")
    private String title;

    @NotEmpty(message = "Este campo es obligatorio, por favor ingrese los datos solicitados")
    @Column(name="director")
    private String director;

    @Column(name="rating")
    @Range(min=1,max=5)
    private Integer rating;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
