package base.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseEntity<ID extends Serializable> implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Column(nullable = false,unique = true)
    private String title;
}
