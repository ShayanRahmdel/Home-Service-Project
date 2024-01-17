package entity.users;

import base.entity.BaseEntity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Setter
@Getter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User extends BaseEntity<Integer> {
    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(unique = true,nullable = false)
    private String email;

    @Column(length = 8,nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate signUpDate;

    @Column(nullable = false)
    private LocalTime signUpTime;


}
