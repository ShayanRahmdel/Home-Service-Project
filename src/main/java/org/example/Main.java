package org.example;


import entity.business.Address;
import entity.business.DutyCategory;
import entity.business.Order;
import entity.business.SubDuty;
import entity.users.Customer;
import entity.users.Expert;
import util.AppContext;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        AppContext.init();

        seeAllOrderByExpert();

    }

    public static Customer signUpCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Shayan");
        customer.setLastName("Rahmdel");
        customer.setEmail("shayan@gmail.com");
        customer.setPassword("Shayan2!");
        customer.setSignUpDate(LocalDate.now());
        customer.setSignUpTime(LocalTime.of(12, 0, 0));
        return AppContext.getCustomerService().signUp(customer);

    }
    public static Expert signUpExpert() throws IOException {
        File imageFile = new File("C:\\Users\\Shayan\\Desktop\\IMG-20201021-WA0005.jpg");
        Expert expert = new Expert();
        expert.setFirstName("Ali");
        expert.setLastName("Alavi");
        expert.setEmail("ali@gmail.com");
        expert.setPassword("Shayan1@");
        expert.setSignUpDate(LocalDate.now());
        expert.setSignUpTime(LocalTime.of(10, 0, 0));
        AppContext.getExpertService().signUp(expert,imageFile);

        return expert;

    }

    public static void  saveImage(){
        String path ="C:\\Users\\Shayan\\Desktop\\HomeServiceProject\\HomeServiceProject\\src\\main\\java\\image.jpa";
        AppContext.getExpertService().saveImage(path,5);
    }

    public static void changeExpertPassword(){
        AppContext.getExpertService().changePassword("ali@gmail.com","Shayan1@","Shayan1!");
    }

    public static void changeCustomerPassword(){
        AppContext.getCustomerService().changePassword("shayan1@gmail.com","Shayan1!","Shayan2!");
    }

    public static void seeAllCustomer(){
        System.out.println(AppContext.getAdminService().seeAllCustomer());
    }

    public static void  seeAllExpert(){
        System.out.println(AppContext.getAdminService().seeAllExpert());
    }

    public static DutyCategory createDutyCategory(){
        DutyCategory dutyCategory = new DutyCategory();
        dutyCategory.setTitle("cleaning");
       return AppContext.getAdminService().createDutyCategory(dutyCategory);

    }
    public static void createSubduty(){
        SubDuty subDuty = new SubDuty();
        subDuty.setDescription("home cleaning");
        subDuty.setBasePrice(1000.0);
        AppContext.getAdminService().createSubDuty(subDuty, 2);
    }


    public static List<DutyCategory> seeAllDutyCategory(){
        return AppContext.getAdminService().seeAllDutyCategories();
    }

    public static List<SubDuty> seeAllSubDuty(){
        return AppContext.getAdminService().seeAllSubDuty();
    }

    public static List<SubDuty> seeSubDutyByCategory(){
        return AppContext.getAdminService().seeSubDutyByCategory(2);
    }

    public static void confirmExpert(){
        AppContext.getAdminService().confirmExpert(2);
    }
    public static void addExpertToSubDuty(){
        AppContext.getAdminService().addExpertInSubDuty(2,8);
    }

    public static void createOrder(){
        Order order = new Order();
        order.setProposedPrice(3000.0);
        order.setJobDescription("repair tv");
        order.setTimeDate(LocalTime.of(10,1,1));
        order.setWorkDate(LocalDate.of(2024,10,1));
        AppContext.getCustomerService().createOrder(order, 2, 7, 1);

    }
    public static void createAddress(){
        Address address = new Address();
        address.setCity("tehran");
        address.setState("tehran");
        address.setAddress("sabalan");
        address.setPostalCode("1615795517");
        AppContext.getCustomerService().createAddress(address, 1, 3);

    }
    public static void  seeAllOrderByExpert(){
        List<Order> orders = AppContext.getExpertService().seeOrder(2);
        System.out.println(orders);
    }

    public static Order acceptOrder(){
        return AppContext.getExpertService().acceptOrder(5);
    }
}