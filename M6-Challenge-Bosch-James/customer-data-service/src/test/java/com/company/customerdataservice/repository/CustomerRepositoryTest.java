package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(classes = CustomerRepositoryTest.class)
public class CustomerRepositoryTest {

    @MockBean
    @Autowired
    private CustomerRepository customerRepository;
    private Customer customer;
    private Customer customer2;

    @BeforeEach
    public void setUp() throws Exception {
//        customerRepository.deleteAll();

        customer = new Customer();
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
        customer.setId(1);

        customer = customerRepository.save(customer);

        customer2 = new Customer();
        customer2.setFirstName("Chipp");
        customer2.setLastName("Zanuff");
        customer2.setEmail("guilty@gear.com");
        customer2.setCompany("Arc System Works");
        customer2.setPhone("111-555-9999");
        customer2.setAddress1("69 Fast Ln.");
        customer2.setAddress2("");
        customer2.setCity("Morristown");
        customer2.setState("NJ");
        customer2.setPostalCode("10463");
        customer2.setCountry("USA");
        customer2.setId(2);

        customer2 = customerRepository.save(customer2);

    }

    @Test
    public void shouldGetAllCustomers() {
        List<Customer> customerList = customerRepository.findAll();

        assertEquals(customerList.size(), 2);
    }

    @Test
    public void shouldCreateCustomer() {
        Customer c = new Customer();
        c.setFirstName("J");
        c.setLastName("B");
        c.setEmail("Test@test.com");
        c.setCompany("Netflix");
        c.setPhone("123-456-7890");
        c.setAddress1("Somewhere Pl.");
        c.setAddress2("");
        c.setCity("Florida");
        c.setState("NY");
        c.setPostalCode("12342");
        c.setCountry("USA");

        c = customerRepository.save(c);

        Optional<Customer> c1 = customerRepository.findById(c.getId());
        assertEquals(c1.get(), c);
    }

    @Test
    public void shouldUpdateCustomer() {
        customer.setCompany("Capcom Inc.");

        customerRepository.save(customer);
        assertEquals(customerRepository.findById(1).get().getCompany(), "Capcom Inc.");
    }

    @Test
    public void shouldDeleteCustomerById() {
        customer = customerRepository.save(customer);

        customerRepository.deleteById(customer.getId());

        Optional<Customer> c1 = customerRepository.findById(customer.getId());
        assertFalse(c1.isPresent());
    }

    @Test
    public void shouldGetCustomerById() {
        Optional<Customer> customerFromRepo = customerRepository.findById(1);
        assertEquals(customerFromRepo.get(), customer);
    }

    @Test
    public void shouldGetCustomersByState() {
        List<Customer> customerList = customerRepository.findCustomersByState("NY");
        assertEquals(1, customerList.size());
    }

}
