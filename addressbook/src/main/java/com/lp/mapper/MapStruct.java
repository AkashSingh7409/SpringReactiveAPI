package com.lp.mapper;

import com.lp.dto.AddressBookDto;
import com.lp.entity.AddressBook;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapStruct {

    MapStruct INSTANCE = Mappers.getMapper(MapStruct.class);

    AddressBookDto entityToDto(AddressBook addressBook);
    AddressBook dtoToEntity(AddressBookDto addressBookDto);
}
