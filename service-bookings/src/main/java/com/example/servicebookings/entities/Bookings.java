package com.example.servicebookings.entities;

import com.example.servicebookings.model.Showtime;
import com.example.servicebookings.model.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Table(name="bookings")

public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false, unique = true)
    private Long id;

    @Column(name="user_id")
    private Long userId;
    @Transient
    private User user;

    @Column(name="showtime_id")
    private Long showtimeId;
    @Transient
    private Showtime showtime;

    @ElementCollection
    @Column(name="movies_id")
    private List<Long> movies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bookings bookings = (Bookings) o;
        return Objects.equals(id, bookings.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
