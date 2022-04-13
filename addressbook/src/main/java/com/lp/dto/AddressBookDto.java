package com.lp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddressBookDto {

    private Integer id;
    private String landmark;
    private String city;
    private Long zipCode;
    private String state;
}
