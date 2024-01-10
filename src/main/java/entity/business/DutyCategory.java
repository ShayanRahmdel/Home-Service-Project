package entity.business;


import base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DutyCategory extends BaseEntity<Integer> {

    @Column(nullable = false,unique = true)
    private String title;

}
