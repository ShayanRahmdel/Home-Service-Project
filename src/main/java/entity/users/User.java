package entity.users;

import base.entity.BaseUserEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Setter
@Getter
public class User extends BaseUserEntity<Long> {
}
