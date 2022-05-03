package com.lp.services;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressBookServices {

    Mono<AddressBookDto> saveData(AddressBookDto addressBookDto);
    Flux<AddressBookDto> getAllData();
    Mono<AddressBookDto> getData(Integer id);
    Mono<AddressBookDto> updateData(AddressBook addressBook);
    Mono<Void> deleteData(Integer id);
    Flux<AddressBookDto> getDataByState(String state);

}
