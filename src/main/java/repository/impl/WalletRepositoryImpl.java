package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import entity.business.Wallet;
import repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl extends BaseEntityRepositoryImpl<Wallet, Integer> implements WalletRepository {
    public WalletRepositoryImpl(EntityManager entityManager) {
        this.entityManager=entityManager;
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}
