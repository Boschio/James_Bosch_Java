package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CustomerRepositoryTests {

    @Autowired
    CustomerRepository customerRepository;

    @BeforeEach
    public void setUp() throws Exception {
        customerRepository.deleteAll();
    }

    @Test
    public void shouldGetAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Bosch");
        customer.setEmail("Test@test.com");
        customer.setCompany("Bosch Inc.");
        customer.setPhone("123-456-7890");
        customer.setAddress1("55 Broadway Ave.");
        customer.setAddress2("#5F");
        customer.setCity("Manhattan");
        customer.setState("NY");
        customer.setPostalCode("10001");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        customer = new Customer();
        customer.setFirstName("Chipp");
        customer.setLastName("Zanuff");
        customer.setEmail("guilty@gear.com");
        customer.setCompany("Arc System Works");
        customer.setPhone("111-555-9999");
        customer.setAddress1("69 Fast Ln.");
        customer.setAddress2("");
        customer.setCity("Bronx");
        customer.setState("NY");
        customer.setPostalCode("10463");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        List<Customer> customerList = customerRepository.findAll();

        assertEquals(customerList.size(), 2);
    }

    @Test
    public void shouldCreateCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("James");
        customer.setLastName("Bosch");
        customer.setEmail("Test@test.com");
        customer.setCompany("Bosch Inc.");
        customer.setPhone("123-456-7890");
        customer.setAddress1("55 Broadway Ave.");
        customer.setAddress2("#5F");
        customer.setCity("Manhattan");
        customer.setState("NY");
        customer.setPostalCode("10001");
        customer.setCountry("USA");

        customer = customerRepository.save(customer);

        Optional<Customer> customer1 = customerRepository.findById(customer.getId());
        assertEquals(customer1.get(), customer);
    }

    @Test
    public void shouldUpdateCustomer() {

    }

    @Test
    public void shouldDeleteCustomerById() {

    }

    @Test
    public void shouldGetCustomerById() {

    }

    @Test
    public void shouldGetCustomersByState() {

    }

}
