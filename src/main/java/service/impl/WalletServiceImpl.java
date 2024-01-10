package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Comment;
import entity.business.Wallet;
import repository.CommentRepository;
import repository.WalletRepository;
import service.CommentService;
import service.WalletService;

public class WalletServiceImpl extends BaseEntityServiceImpl<Wallet,Integer, WalletRepository>
        implements WalletService {
    public WalletServiceImpl(WalletRepository repository) {
        super(repository);
    }
}
