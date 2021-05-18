package com.memberdetails.registers.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.memberdetails.registers.model.MemberDetails;

public interface MemberDetailsRegisterRepository extends MongoRepository<MemberDetails, String> {

}
