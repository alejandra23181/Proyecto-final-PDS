package co.com.poli.showtimes.entities;

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

    @Temporal(TemporalType.TIME)
    @Column(name = "date")
    private Date date;

    @ElementCollection
    @Column(name = "movies_id")
    private  List<Long> movies;

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
