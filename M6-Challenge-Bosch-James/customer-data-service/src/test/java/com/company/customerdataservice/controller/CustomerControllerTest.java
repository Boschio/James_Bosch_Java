package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @MockBean
    private CustomerRepository repository;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper mapper = new ObjectMapper();
    private Customer customer;

    @BeforeEach
    public void setUp() throws Exception {
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
    }

    @Test
    void shouldGetCustomers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateCustomer() throws Exception {
        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customers")
                .content(inputJson)
                .contentType(MediaType.APPLICATION_JSON))
                    .andDo(print())
                    .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdateCustomer() throws Exception {
        customer.setCity("Bronx");
        String inputJson = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customers")
                        .content(inputJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customers/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldGetCustomerById() throws Exception {
        mockMvc.perform(get("/customers/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void shouldGetCustomersByState() throws Exception {
        mockMvc.perform(get("/customers/state/NY"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
