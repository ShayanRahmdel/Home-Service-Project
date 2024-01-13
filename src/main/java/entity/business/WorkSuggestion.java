package entity.business;

import base.entity.BaseEntity;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class WorkSuggestion extends BaseEntity<Integer> {

    private LocalDate suggestedDate;

    private Time suggestedBeginTime;

    private Double suggestedPrice;

    private String suggestedWorkTime;

    @ManyToOne(fetch = FetchType.EAGER)
    private Expert expert;

    @ManyToOne(fetch = FetchType.EAGER)
    private Order order;

}
