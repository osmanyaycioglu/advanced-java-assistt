package com.assistt.training.advanced.java.customer.rest.mappers;

import com.assistt.training.advanced.java.customer.rest.models.CustomerRest;
import com.assistt.training.advanced.java.customer.services.models.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueCheckStrategy = NullValueCheckStrategy.ON_IMPLICIT_CONVERSION, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface ICustomerMapper {

    ICustomerMapper mapper = Mappers.getMapper(ICustomerMapper.class);

    Customer toCustomer(CustomerRest customer);

    CustomerRest toCustomer(Customer customer);


}
