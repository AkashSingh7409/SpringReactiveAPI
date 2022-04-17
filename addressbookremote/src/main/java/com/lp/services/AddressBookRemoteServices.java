package com.lp.services;

import com.lp.entity.AddressBookRemote;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AddressBookRemoteServices {

    public Mono<AddressBookRemote> saveRemoteData(AddressBookRemote addressBookRemote);
    public Mono<AddressBookRemote> getRemoteData(Integer id);
    public Flux<AddressBookRemote> getAllRemoteData();
    public Mono<AddressBookRemote> updateRemoteData(AddressBookRemote addressBookRemote);
    public Mono<Void> deleteRemoteData(Integer id);

}
