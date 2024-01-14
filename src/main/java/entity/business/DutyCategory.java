package entity.business;


import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DutyCategory extends BaseEntity<Integer> {

    @Column(nullable = false,unique = true)
    private String title;

    @OneToMany(mappedBy = "dutyCategory")
    private List<SubDuty> subDuties;

    public DutyCategory(Integer integer) {
        super(integer);
    }

    @Override
    public String toString() {
        return "DutyCategory id " + getId()+"\n" +
                "title" + title+"\n";
    }


}
