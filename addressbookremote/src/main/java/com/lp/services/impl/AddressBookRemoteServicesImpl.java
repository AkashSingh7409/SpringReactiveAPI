package com.lp.services.impl;

import com.lp.dto.AddressBookRemote;
import com.lp.services.AddressBookRemoteServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class AddressBookRemoteServicesImpl implements AddressBookRemoteServices {

    @Autowired
    private WebClient.Builder webClientBuilder;

    @Value("${externalURL}")
    private String url;


    @Override
    public Mono<AddressBookRemote> saveRemoteData(AddressBookRemote addressBookRemote) {
        return  webClientBuilder.build()
            .post()
            .uri(url + "/saveData")
            .body(Mono.just(addressBookRemote), AddressBookRemote.class)
            .retrieve()
            .bodyToMono(AddressBookRemote.class);
    }

    @Override
    public Mono<AddressBookRemote> getRemoteData(Integer id) {
        return webClientBuilder.build()
            .get()
            .uri(url + "/getData/{id}", id)
            .retrieve()
            .bodyToMono(AddressBookRemote.class);
//           .block();
    }

    @Override
    public Flux<AddressBookRemote> getAllRemoteData() {
        return webClientBuilder.build()
            .get()
            .uri(url + "/getAllData")
            .retrieve()
            .bodyToFlux(AddressBookRemote.class);
    }

    @Override
    public Mono<AddressBookRemote> updateRemoteData(AddressBookRemote addressBookRemote) {
        return webClientBuilder.build()
            .put()
            .uri(url + "/updateData", addressBookRemote.getId())
            .body(Mono.just(addressBookRemote), AddressBookRemote.class)
            .retrieve()
            .bodyToMono(AddressBookRemote.class);
    }

    @Override
    public Mono<Void> deleteRemoteData(Integer id) {
        return webClientBuilder.build()
            .delete()
            .uri(url + "/deleteData/{id}", id)
            .retrieve()
            .bodyToMono(Void.class);
    }

}
