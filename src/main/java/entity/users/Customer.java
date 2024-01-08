package entity.users;

import base.entity.BaseUserEntity;
import entity.enumration.TypeUser;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Customer extends User {

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;
}
