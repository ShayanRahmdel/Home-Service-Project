package entity.business;

import base.entity.BaseEntity;
import entity.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Comment extends BaseEntity<Integer> {
    @Column(length = 50)
    private String comment;

    @Max(value=10, message = "Your score is greater than 10")
    @Min(value =0,message = "Your score is less than 0")
    private Integer score;

    @OneToOne(mappedBy = "comment")
    private Order order;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

}
