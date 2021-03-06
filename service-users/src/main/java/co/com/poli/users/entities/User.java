package co.com.poli.users.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@Entity
@Table(name="users")
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, unique = true)
    private long id;

    @NotEmpty(message = "Este campo es obligatorio, por favor ingrese los datos solicitados")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Este campo es obligatorio, por favor ingrese los datos solicitados")
    @Column(name="lastname")
    private String lastname;

    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
