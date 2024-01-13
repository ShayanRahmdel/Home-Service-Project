package entity.business;

import base.entity.BaseEntity;
import entity.enumration.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "order_table")
public class Order extends BaseEntity<Integer> {

    private Double proposedPrice;

    private String jobDescription;

    private LocalDate workDate;

    private Time timeDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne(fetch = FetchType.EAGER)
    private SubDuty subDuty;

    @OneToOne
    private Comment comment;


    @OneToMany(mappedBy = "order")
    private List<WorkSuggestion> workSuggestions;

}
