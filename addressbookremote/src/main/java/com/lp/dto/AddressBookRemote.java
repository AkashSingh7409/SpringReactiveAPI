package com.lp.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookRemote {

    private Integer id;
    private String landmark;
    private String city;
    private Long zipCode;
    private String state;

}
