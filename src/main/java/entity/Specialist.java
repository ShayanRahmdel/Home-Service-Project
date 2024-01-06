package entity;

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
public class Specialist extends BaseUserEntity<Long> {

    @Enumerated(EnumType.STRING)
    private TypeUser typeUser;


    private Byte image;
}
