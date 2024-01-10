package entity.business;


import base.entity.BaseEntity;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubDuty extends BaseEntity<Integer> {
    @Column(nullable = false,unique = true)
    private String title;

    @Column(nullable = false)
    private String aboutService;

    @Column(nullable = false)
    private Double basePrice;

    @ManyToMany
    private Set<Expert> experts;


}
