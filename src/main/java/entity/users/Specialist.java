package entity.users;

import base.entity.BaseUserEntity;
import entity.enumration.Confirmation;
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
public class Specialist extends User {

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;

    @Enumerated(EnumType.STRING)
    private Confirmation confirmation;

    private Byte image;


}
