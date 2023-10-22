package com.assistt.training.advanced.java.customer.rest.mappers;

import com.assistt.training.advanced.java.customer.rest.models.AddressRest;
import com.assistt.training.advanced.java.customer.rest.models.CustomerRest;
import com.assistt.training.advanced.java.customer.rest.models.PhoneRest;
import com.assistt.training.advanced.java.customer.services.models.Address;
import com.assistt.training.advanced.java.customer.services.models.Customer;
import com.assistt.training.advanced.java.customer.services.models.Phone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICustomerMapper {

    ICustomerMapper mapper = Mappers.getMapper(ICustomerMapper.class);

    // @Mapping(source = "phones",target = "phoneRests")
    Customer toCustomer(CustomerRest customer);

    CustomerRest toCustomer(Customer customer);

    Address toAddress(AddressRest address);

    AddressRest toAddress(Address address);

    Phone toPhone(PhoneRest phone);

    PhoneRest toPhone(Phone phone);

    Set<Phone> toPhonesRest(Set<PhoneRest> phone);

    Set<PhoneRest> toPhones(Set<Phone> phone);

}
