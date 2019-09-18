package com.sh.timeslot.service;

import com.github.javafaker.Address;
import com.sh.timeslot.db.entity.Branch;
import com.sh.timeslot.db.entity.Company;
import com.github.javafaker.Faker;
import com.sh.timeslot.db.entity.Contact;
import com.sh.timeslot.model.request.AddressRequest;
import com.sh.timeslot.model.request.CompanyRequest;

import java.util.TimeZone;

public class FakerData {

    private static  String email = "test@gmail.com.test";
    private  static Faker faker = new Faker();


    public   static CompanyRequest generateCompanyRequest(){

        com.github.javafaker.Company comp =  faker.company();
        Address addr = faker.address();
        AddressRequest address = AddressRequest.builder().zipCode(addr.zipCode())
                .state(addr.state())
                .addressOne(addr.streetAddress())
                .city(addr.cityName())
                .addressTwo(addr.secondaryAddress())
                .build();

        return  CompanyRequest.builder()
                .email(email)
                .name(comp.name() )
                .address(address)
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }

    public   static  com.sh.timeslot.db.entity.Company generateCompany(){
        com.github.javafaker.Company comp =  faker.company();
        Company company = new Company();
        company.setEmail(email);
        company.setIdentifier(2L);
        company.setName(comp.name());
        company.setAddress(generateAddress());
        return company;

    }

    public static com.sh.timeslot.db.entity.Address generateAddress(){
        Address addr = faker.address();
        return  com.sh.timeslot.db.entity.Address.builder().zipCode(addr.zipCode())
                .state(addr.state())
                .addressOne(addr.streetAddress())
                .city(addr.cityName())
                .addressTwo(addr.secondaryAddress())
                .build();

    }

    public static  Branch  generateBranch(Long  branchId){
        Branch branch = new Branch();
        com.github.javafaker.Company comp =  faker.company();
        branch.setName(comp.name());
        branch.setTimezone(TimeZone.getDefault().getID());
        branch.setContact(generateContact());
        branch.setIdentifier(branchId);
        return branch;
    }

    public static Contact generateContact(){

       return Contact.builder().address(generateAddress())
        .email(email).phone(faker.phoneNumber().phoneNumber()).build();

    }

}
