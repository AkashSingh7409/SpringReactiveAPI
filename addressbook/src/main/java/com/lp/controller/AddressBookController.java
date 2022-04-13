package com.lp.controller;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import com.lp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookServices addressBookServices;

    @PostMapping("/saveData")
    public Mono<AddressBookDto> saveData(@RequestBody AddressBookDto addressBookDto) {
        return addressBookServices.saveData(addressBookDto);
    }

    @GetMapping("/getAllData")
    public Flux<AddressBookDto> getAllData() {
        return addressBookServices.getAllData();
    }

    @GetMapping("/getData/{id}")
    public Mono<AddressBookDto> getData(@PathVariable Integer id) {
        return addressBookServices.getData(id);
    }

    @PutMapping("/updateData")
    public Mono<AddressBookDto> updateData(@RequestBody AddressBook addressBook) {
        return addressBookServices.updateData(addressBook);
    }

    @DeleteMapping("/deleteData/{id}")
    public Mono<Void> deleteData(Integer id) {
        return addressBookServices.deleteData(id);
    }
}
