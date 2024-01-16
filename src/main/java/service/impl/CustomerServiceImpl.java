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
    public String signUp(Customer customer) {
        if (Validate.nameValidation(customer.getFirstName()) &&
                Validate.nameValidation(customer.getLastName()) &&
                Validate.emailValidation(customer.getEmail()) &&
                Validate.passwordValidation(customer.getPassword())) {
            repository.saveOrUpdate(customer);
            return "success";
        }
        return "your customer not save";
    }

    @Override
    public void changePassword(String email, String oldPassword, String newPassword) {
        repository.changePassword(email, oldPassword, newPassword);

    }

    @Override
    public Order createOrder(Order order, Integer category, Integer subDutyId, Address address,Integer customerId) {
        Collection<DutyCategory> allDutyCategory = dutyCategoryService.findAll();
        System.out.println(allDutyCategory);
        List<SubDuty> subDuties = subDutyService.seeSubDutyByCategory(category);
        System.out.println(subDuties);

        Customer customer = repository.findById(customerId).orElse(null);

        SubDuty subDuty = subDutyService.findById(subDutyId).orElse(null);
        if (isValidDateAndTime(order.getWorkDate(),order.getTimeDate()) &&
        isValidPrice(subDuty,order.getProposedPrice())){
                order.setAddress(address);
                order.setSubDuty(subDuty);
                order.setComment(null);
                order.setOrderStatus(OrderStatus.Waiting_Expert_Sugestion);
                order.setAddress(null);
                orderService.saveOrUpdate(order);

            }
        return order;
        }

    @Override
    public Address createAddress(Address address,Integer customerId,Integer orderId) {
        Customer customer = repository.findById(customerId).orElse(null);
        Order order = orderService.findById(orderId).orElse(null);
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

