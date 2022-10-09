package com.company.springbootcrudbasic.mapper;

import com.company.springbootcrudbasic.dto.PersonDto;
import com.company.springbootcrudbasic.entities.Person;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

//@Mapper(config = PersonMapper2.class)
public interface PersonMapper2 {

    PersonMapper2 INSTANCE = Mappers.getMapper( PersonMapper2.class );

    @Mapping(source = "id", target = "id")
    @Mapping(source = "fistName", target = "fistName")
    PersonDto personToPersonDto(Person person);

/*
    @Mapper(config = MapperSpringConfig.class)
    public interface CarMapper extends Converter<Car, CarDto> {
        @Mapping(target = "seats", source = "seatConfiguration")
        CarDto convert(Car car);
    }
    */

}
