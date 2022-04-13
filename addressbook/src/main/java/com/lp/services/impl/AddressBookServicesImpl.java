package com.lp.services.impl;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import com.lp.mapper.MapStruct;
import com.lp.repository.AddressBookRepo;
import com.lp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AddressBookServicesImpl implements AddressBookServices {

    @Autowired
    private AddressBookRepo addressBookRepo;

    @Override
    public Mono<AddressBookDto> saveData(AddressBookDto addressBookDto) {
        return addressBookRepo.save(MapStruct.INSTANCE.dtoToEntity(addressBookDto)).map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Flux<AddressBookDto> getAllData() {
        return addressBookRepo.findAll().map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Mono<AddressBookDto> getData(Integer id) {
        return addressBookRepo.findById(id).map(MapStruct.INSTANCE::entityToDto);
    }

//  ---------- Wrong Approach ----------

//    @Override
//    public Mono<AddressBook> updateData(AddressBook addressBook) {
//        return addressBookRepo.findById(addressBook.getId())
////                .doOnNext(e -> e.setId(id))
////                .map(e -> addressBook)
//                .flatMap(e -> {
//                    e.setLandmark(addressBook.getLandmark());
//                    e.setCity(addressBook.getCity());
//                    e.setZipCode(addressBook.getZipCode());
//                    e.setState(addressBook.getState());
//                    return addressBookRepo.save(addressBook);
//                });
////                .flatMap(addressBookRepo::save);
//    }

    @Override
    public Mono<AddressBookDto> updateData(AddressBook addressBook) {
        return addressBookRepo.findById(addressBook.getId())
                .map(e -> addressBook)
                .flatMap(addressBookRepo::save)
                .map(MapStruct.INSTANCE::entityToDto);
//                .doOnNext(e -> e.setId(id))
//                .map(e -> addressBook)
//                .flatMap(addressBookRepo::save);

    }

    @Override
    public Mono<Void> deleteData(Integer id) {
        return addressBookRepo.deleteById(id);
    }
}
