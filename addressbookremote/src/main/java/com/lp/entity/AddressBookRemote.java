package com.lp.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBookRemote {

    @Id
    private Integer id;
    private String landmark;
    private String city;
    private Long zipCode;
    private String state;

}
