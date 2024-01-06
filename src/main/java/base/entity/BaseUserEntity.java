package base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseUserEntity<ID extends Serializable> implements Serializable {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    @Column(length = 8)
    private String password;

    private LocalDate signUpDate;
}
