package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import entity.business.Address;
import entity.business.DutyCategory;
import entity.business.Order;
import entity.business.SubDuty;
import entity.enumration.OrderStatus;
import entity.users.Customer;
import repository.CustomerRepository;
import service.*;
import util.Validate;

import javax.persistence.PersistenceException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.List;


public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, Integer, CustomerRepository>
        implements CustomerService {

    private final DutyCategoryService dutyCategoryService;
    private final SubDutyService subDutyService;
    private final OrderService orderService;
    private final AddressService addressService;
    public CustomerServiceImpl(CustomerRepository repository,
                               DutyCategoryService dutyCategoryService,
                               SubDutyService subDutyService,
                               OrderService orderService,AddressService addressService) {
        super(repository);
        this.dutyCategoryService = dutyCategoryService;
        this.subDutyService = subDutyService;
        this.orderService=orderService;
        this.addressService=addressService;
    }

    @Override
    public Customer signUp(Customer customer) {
        try {
            if (Validate.nameValidation(customer.getFirstName()) &&
                    Validate.nameValidation(customer.getLastName()) &&
                    Validate.emailValidation(customer.getEmail()) &&
                    Validate.passwordValidation(customer.getPassword())) {
                repository.saveOrUpdate(customer);
                return customer;
            }
        }catch (PersistenceException e){
            System.out.println("Error saving customer");
        }
        return customer;
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        try {
            if (Validate.passwordValidation(newPassword)){
                repository.changePassword(email, oldPassword, newPassword);
            }else throw new IllegalArgumentException();
        }catch (IllegalArgumentException e){
            System.out.println("Error: check password");
        }

    }

    @Override
    public Order createOrder(Order order, Integer category, Integer subDutyId,Integer customerId) {
        Collection<DutyCategory> allDutyCategory = dutyCategoryService.findAll();
        System.out.println(allDutyCategory);
        List<SubDuty> subDuties = subDutyService.seeSubDutyByCategory(category);
        System.out.println(subDuties);
        try {
            SubDuty subDuty = subDutyService.findById(subDutyId).orElseThrow(PersistenceException::new);
            if (isValidDateAndTime(order.getWorkDate(), order.getTimeDate())) {
                assert subDuty != null;
                if (isValidPrice(subDuty,order.getProposedPrice())) {
                    order.setSubDuty(subDuty);
                    order.setComment(null);
                    order.setOrderStatus(OrderStatus.Waiting_Expert_Sugestion);
                    order.setAddress(null);
                    orderService.saveOrUpdate(order);

                }
            }
            return order;
        }catch (PersistenceException e) {
            System.out.println("Error: saving order:");
        }
        return order;

        }

    @Override
    public Address createAddress(Address address,Integer customerId,Integer orderId) {
       try {
           Customer customer = repository.findById(customerId).orElseThrow(()->new PersistenceException("cant find customer"));
           Order order = orderService.findById(orderId).orElseThrow(()->new PersistenceException("Cant find order"));
           if (Validate.cityValidation(address.getCity())&& Validate.postalValidation(address.getPostalCode())
                   && Validate.isValidCity(address.getState())) {
               address.setCustomer(customer);
               addressService.saveOrUpdate(address);

               assert order != null;
               order.setAddress(address);
               orderService.saveOrUpdate(order);
               order.setAddress(address);
               orderService.saveOrUpdate(order);
           }
           return address;
       }catch (PersistenceException e){
           System.out.println(e.getMessage());
       }
       return address;
    }



    boolean isValidDateAndTime(LocalDate date, LocalTime time){
        if (date.isBefore(LocalDate.now()) && time.isBefore(LocalTime.now())) {
            System.out.println("Your date is before");
            return false;
        }
        return true;
    }

    boolean isValidPrice(SubDuty subDuty,Double price){
        Double basePrice = subDuty.getBasePrice();
        if (price< basePrice){
            System.out.println("Your price is less than BasePrice");
            return false;
        }
        return true;
    }
}

