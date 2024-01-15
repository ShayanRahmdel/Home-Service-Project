package entity.business;


import base.entity.BaseEntity;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubDuty extends BaseEntity<Integer> {

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private Double basePrice;

    @ManyToMany
    private Set<Expert> experts;

    @ManyToOne(fetch = FetchType.EAGER)
    private DutyCategory dutyCategory;

    @Override
    public String toString() {
        return "SubDuty id "+ getId() +"\n"+
                "description " + description +"\n"+
                "basePrice " + basePrice + "\n"+
                "========================="+"\n";
    }

    public SubDuty(Integer integer) {
        super(integer);
    }
}
