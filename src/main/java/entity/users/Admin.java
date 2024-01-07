package entity.users;

import base.entity.BaseUserEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Setter
@Getter
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin extends BaseUserEntity<Long> {
}
