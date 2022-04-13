package com.lp.repository;

import com.lp.entity.AddressBook;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressBookRepo extends ReactiveMongoRepository<AddressBook, Integer> {
}
