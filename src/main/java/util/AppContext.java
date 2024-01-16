package util;

import repository.*;
import repository.impl.*;
import service.*;
import service.impl.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AppContext {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY;
    private static final EntityManager ENTITY_MANAGER;

    private static final AdminRepository ADMIN_REPOSITORY;
    private static final CustomerRepository CUSTOMER_REPOSITORY;
    private static final ExpertRepository EXPERT_REPOSITORY;
    private static final OrderRepository ORDER_REPOSITORY;
    private static final WorkSuggestionRepository WORK_SUGGESTION_REPOSITORY;
    private static final CommentRepository COMMENT_REPOSITORY;
    private static final WalletRepository WALLET_REPOSITORY;
    private static final DutyCategoryRepository DUTY_CATEGORY_REPOSITORY;
    private static final SubDutyRepository SUB_DUTY_REPOSITORY;
    private static final AddressRepository ADDRESS_REPOSITORY;

    private static final CustomerService CUSTOMER_SERVICE;
    private static final ExpertService EXPERT_SERVICE;
    private static final OrderService ORDER_SERVICE;
    private static final WorkSuggestionService WORK_SUGGESTION_SERVICE;
    private static final CommentService COMMENT_SERVICE;
    private static final WalletService WALLET_SERVICE;
    private static final DutyCategoryService DUTY_CATEGORY_SERVICE;
    private static final SubDutyService SUB_DUTY_SERVICE;
    private static final AdminService ADMIN_SERVICE;
    private static final AddressService ADDRESS_SERVICE;




    static {
        ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("default");
        ENTITY_MANAGER = ENTITY_MANAGER_FACTORY.createEntityManager();
        ADMIN_REPOSITORY = new AdminRepositoryImpl(ENTITY_MANAGER);
        CUSTOMER_REPOSITORY = new CustomerRepositoryImpl(ENTITY_MANAGER);
        EXPERT_REPOSITORY = new ExpertRepositoryImpl(ENTITY_MANAGER);
        ORDER_REPOSITORY = new OrderRepositoryImpl(ENTITY_MANAGER);
        WORK_SUGGESTION_REPOSITORY = new WorkSuggestionRepositoryImpl(ENTITY_MANAGER);
        WALLET_REPOSITORY = new WalletRepositoryImpl(ENTITY_MANAGER);
        COMMENT_REPOSITORY = new CommentRepositoryImpl(ENTITY_MANAGER);
        DUTY_CATEGORY_REPOSITORY = new DutyCategoryRepositoryImpl(ENTITY_MANAGER);
        SUB_DUTY_REPOSITORY = new SubDutyRepositoryImpl(ENTITY_MANAGER);
        ADDRESS_REPOSITORY = new AddressRepositoryImpl(ENTITY_MANAGER);



        ORDER_SERVICE = new OrderServiceImpl(ORDER_REPOSITORY);
        WORK_SUGGESTION_SERVICE = new WorkSuggestionServiceImpl(WORK_SUGGESTION_REPOSITORY);
        WALLET_SERVICE = new WalletServiceImpl(WALLET_REPOSITORY);
        COMMENT_SERVICE = new CommentServiceImpl(COMMENT_REPOSITORY);
        SUB_DUTY_SERVICE = new SubDutyServiceImpl(SUB_DUTY_REPOSITORY);
        DUTY_CATEGORY_SERVICE = new DutyCategoryServiceImpl(DUTY_CATEGORY_REPOSITORY);
        ADDRESS_SERVICE = new AddressServiceImpl(ADDRESS_REPOSITORY);
        EXPERT_SERVICE = new ExpertServiceImpl(EXPERT_REPOSITORY,ORDER_SERVICE);
        CUSTOMER_SERVICE = new CustomerServiceImpl(CUSTOMER_REPOSITORY,DUTY_CATEGORY_SERVICE,SUB_DUTY_SERVICE,ORDER_SERVICE,ADDRESS_SERVICE);
        ADMIN_SERVICE = new AdminServiceImpl(ADMIN_REPOSITORY,EXPERT_SERVICE,CUSTOMER_SERVICE,DUTY_CATEGORY_SERVICE,SUB_DUTY_SERVICE);


    }

    public static void init() {
        System.out.println("initialize DateBase");
    }

    public static CustomerService getCustomerService(){
        return CUSTOMER_SERVICE;
    }

    public static ExpertService getExpertService(){
        return EXPERT_SERVICE;
    }

    public static AdminService getAdminService(){
        return ADMIN_SERVICE;
    }
}
