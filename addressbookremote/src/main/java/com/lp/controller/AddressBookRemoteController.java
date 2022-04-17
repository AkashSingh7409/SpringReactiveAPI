package com.lp.controller;

import com.lp.entity.AddressBookRemote;
import com.lp.services.AddressBookRemoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/addressBookRemote")
public class AddressBookRemoteController {

    @Autowired
    private AddressBookRemoteServices addressBookRemoteServices;

    @PostMapping("/saveRemoteData")
    public Mono<AddressBookRemote> saveRemoteData(@RequestBody AddressBookRemote addressBookRemote) {
        return addressBookRemoteServices.saveRemoteData(addressBookRemote);
    }

    @GetMapping("/getRemoteData/{id}")
    public Mono<AddressBookRemote> getRemoteData(@PathVariable Integer id) {
        return addressBookRemoteServices.getRemoteData(id);
    }

    @GetMapping("/getAllRemoteData")
    public Flux<AddressBookRemote> getAllRemoteData() {
        return addressBookRemoteServices.getAllRemoteData();
    }

    @PutMapping("/updateRemoteData")
    public Mono<AddressBookRemote> updateRemoteData(@RequestBody AddressBookRemote addressBookRemote) {
        return addressBookRemoteServices.updateRemoteData(addressBookRemote);
    }

    @DeleteMapping("/deleteRemoteData/{id}")
    public Mono<Void> deleteRemoteData(@PathVariable Integer id) {
        return addressBookRemoteServices.deleteRemoteData(id);
    }

}
