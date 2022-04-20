package com.lp.repository;

import com.lp.entity.AddressBook;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface AddressBookRepo extends ReactiveMongoRepository<AddressBook, Integer> {

    @Query(value = "{ 'state' : ?0 }")
    Flux<AddressBook> findByState(String state);
}
