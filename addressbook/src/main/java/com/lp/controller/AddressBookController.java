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

    @GetMapping("/getData/{id}")
    public Mono<ResponseEntity<AddressBookDto>> getData(@PathVariable(required = true) Integer id) {
        return addressBookServices.getData(id)
            .map(u -> ResponseEntity.ok(u))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/getDataByState/{state}")
    public Flux<AddressBookDto> getDataByState(@PathVariable(required = true) String state) {
        return addressBookServices.getDataByState(state);
    }

    @PutMapping("/updateData/{id}")
    public Mono<ResponseEntity<AddressBookDto>> updateData(@RequestBody AddressBook addressBook) {
        return addressBookServices.updateData(addressBook)
            .map(updatedUser -> ResponseEntity.ok(updatedUser))
            .defaultIfEmpty(ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/deleteData/{id}")
    public Mono<ResponseEntity<String>> deleteData(@PathVariable(required = true) Integer id) {
        return addressBookServices.deleteData(id)
            .map(r -> ResponseEntity.ok().body("Data deleted successfully"))
            .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
