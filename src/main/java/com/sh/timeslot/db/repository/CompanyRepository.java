package com.sh.timeslot.db.repository;


import com.sh.timeslot.db.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CompanyRepository extends MongoRepository<Company, String > {



}

