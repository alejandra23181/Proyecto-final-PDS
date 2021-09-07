package co.com.poli.showtimes.entities;

import co.com.poli.showtimes.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name="showtimes")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Showtimes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, unique = true)
    private long id;

    @NotEmpty(message = "Este campo es obligatorio, por favor ingrese los datos solicitados")
    @Column(name = "date")
    private String date;

    private Long MovieId;
    @Transient
    private Showtimes showtimes;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Showtimes showtimes = (Showtimes) o;
        return id == showtimes.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
