package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Address;
import repository.AddressRepository;
import service.AddressService;

public class AddressServiceImpl extends BaseEntityServiceImpl<Address,Integer, AddressRepository>
implements AddressService {
    public AddressServiceImpl(AddressRepository repository) {
        super(repository);
    }
}
