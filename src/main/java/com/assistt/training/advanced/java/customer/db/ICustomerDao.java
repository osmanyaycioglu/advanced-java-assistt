package com.assistt.training.advanced.java.customer.db;

import com.assistt.training.advanced.java.customer.services.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.LockModeType;
import java.util.List;
import java.util.stream.Stream;

public interface ICustomerDao extends JpaRepository<Customer,Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    Customer getCustomerByCustomerId(Long customerId);

    List<Customer> findByNameAndSurname(String name,String surname);

    Stream<Customer> findByNameAndSurnameOOrderBySurname(String name, String surname);

    @Query("select c from Customer c where c.name=?1")
    List<Customer> s1(String xyz);


    @Query(value = "select * from musteri c where c.name=?1",nativeQuery = true)
    List<Customer> s2(String xyz);

    @Query("select c.name,c.surname from Customer c where c.name=?1")
    List<Object[]> s3(String xyz);


    @Query("select new com.assistt.training.advanced.java.customer.db.QueryObj(c.name,c.surname) from Customer c where c.name=?1")
    List<QueryObj> s4(String xyz);

}
