package com.mindex.challenge.dao;

import com.mindex.challenge.data.Compensation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
/* Author: Shaivya Chandra
*  Purpose: CompensationDao for connecting to MongoDB*/
@Repository
public interface CompensationRepository extends MongoRepository<Compensation, String> {
    //Find Employee by Id
    Compensation findByEmployeeId(String employeeId);
}
