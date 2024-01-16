package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.Address;
import repository.AddressRepository;

import javax.persistence.EntityManager;

public class AddressRepositoryImpl extends BaseEntityRepositoryImpl<Address,Integer>
implements AddressRepository {
    public AddressRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Address> getEntityClass() {
        return Address.class;
    }
}
