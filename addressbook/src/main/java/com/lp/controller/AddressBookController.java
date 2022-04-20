package com.lp.controller;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import com.lp.exception.DataNotFoundException;
import com.lp.services.AddressBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/addressBook")
public class AddressBookController {

    @Autowired
    private AddressBookServices addressBookServices;

//    @PostMapping("/saveData")
//    public Mono<ResponseEntity<AddressBookDto>> create(@RequestBody AddressBookDto addressBookDto) {
//        return addressBookServices.saveData(addressBookDto)
//                .map(s -> ResponseEntity.ok(s))
//                .defaultIfEmpty(ResponseEntity.notFound().build());
//    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/saveData")
    public Mono<AddressBookDto> create(@RequestBody AddressBookDto addressBookDto) {
        return addressBookServices.saveData(addressBookDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getAllData")
    public Flux<AddressBookDto> getAllData() {
        return addressBookServices.getAllData();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getData/{id}")
    public Mono<AddressBookDto> getData(@PathVariable(required = true) Integer id) {
        return addressBookServices.getData(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException()));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getDataByState/{state}")
    public Flux<AddressBookDto> getDataByState(@PathVariable(required = true) String state) {
        return addressBookServices.getDataByState(state)
                .switchIfEmpty(Mono.error(new DataNotFoundException()));
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/updateData/{id}")
    public Mono<AddressBookDto> updateData(@PathVariable(required = true) Integer id, @RequestBody AddressBook addressBook) {
        return addressBookServices.updateData(id, addressBook);
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/deleteData/{id}")
    public Mono<Void> deleteData(@PathVariable(required = true) Integer id) {
        return addressBookServices.deleteData(id)
                .switchIfEmpty(Mono.error(new DataNotFoundException()));
    }
}
