package entity.business;

import base.entity.BaseEntity;
import entity.users.Customer;
import entity.users.Expert;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Wallet extends BaseEntity<Integer> {

    private Double amount;

    @OneToOne(mappedBy = "wallet")
    private Customer customer;

    @OneToOne(mappedBy = "wallet")
    private Expert expert;

    public Wallet(Double amount) {
        this.amount = amount;
    }
}
