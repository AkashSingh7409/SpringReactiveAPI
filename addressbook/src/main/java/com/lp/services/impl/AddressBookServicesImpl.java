package com.lp.services.impl;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import com.lp.exception.EmptyInputException;
import com.lp.exception.ListEmptyException;
import com.lp.mapper.MapStruct;
import com.lp.repository.AddressBookRepo;
import com.lp.services.AddressBookServices;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AddressBookServicesImpl implements AddressBookServices {

    @Autowired
    private AddressBookRepo addressBookRepo;

    @Override
    public Mono<AddressBookDto> saveData(AddressBookDto addressBookDto) {
        if(addressBookDto.getState().isEmpty()) {
            throw new EmptyInputException();
        }
        return addressBookRepo.save(MapStruct.INSTANCE.dtoToEntity(addressBookDto)).map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Flux<AddressBookDto> getAllData() {
       return addressBookRepo.findAll()
               .map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Mono<AddressBookDto> getData(Integer id) {
        return addressBookRepo.findById(id).map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Flux<AddressBookDto> getDataByState(String state) {
        return addressBookRepo.findByState(state).map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Mono<AddressBookDto> updateData(Integer id, AddressBook addressBook) {
        return addressBookRepo.findById(id)
                .map(addUpdate -> {
                    addUpdate.setLandmark(addressBook.getLandmark());
                    addUpdate.setCity(addressBook.getCity());
                    addUpdate.setZipCode(addressBook.getZipCode());
                    return addUpdate;
                })
                .flatMap(addUpdate -> addressBookRepo.save(addressBook))
                .map(MapStruct.INSTANCE::entityToDto);
    }

    @Override
    public Mono<Void> deleteData(Integer id) {
        return addressBookRepo.deleteById(id);
    }

}
