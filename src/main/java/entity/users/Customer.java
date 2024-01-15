package entity.users;


import entity.business.Address;
import entity.business.Comment;
import entity.business.Wallet;
import entity.enumration.TypeUser;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Customer extends User {

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    @OneToMany(mappedBy = "customer")
    private List<Comment> comments;

    @OneToOne(cascade = CascadeType.ALL)
    private Wallet wallet;

    @OneToMany(mappedBy = "customer")
    private List<Address> addresses;

    @Override
    public String toString() {
        return "Customer id " + getId()+"\n"+
                "Customer name " + getFirstName()+" "+ getLastName()+"\n"+
                "Customer email " + getEmail() +"\n"+
                "Customer password " + getPassword();
    }
}
