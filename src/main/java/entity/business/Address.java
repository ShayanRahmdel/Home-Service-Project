package entity.business;

import base.entity.BaseEntity;
import entity.users.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity<Integer> {


    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String city;

    private String address;

    @Column(unique = true)
    private String postalCode;

    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;

    @OneToOne(mappedBy = "address")
    private Order order;

}