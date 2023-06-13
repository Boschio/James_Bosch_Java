import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {

    Customer customer1;
    Customer customer2;
    Customer customer3;

    @BeforeEach
    public void setUp() {
        customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Test");

        customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Test2");

        customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Test3");

        for (int i = 0; i<10;i++) {
            customer1.getCharges().add(new AccountRecord());
            customer1.getCharges().get(customer1.getCharges().size()-1).setCharge(i*1000);
            customer1.getCharges().get(customer1.getCharges().size()-1).setChargeDate("01-01-1991");

            customer2.getCharges().add(new AccountRecord());
            customer2.getCharges().get(customer2.getCharges().size()-1).setCharge(i*-1000);
            customer2.getCharges().get(customer2.getCharges().size()-1).setChargeDate("01-01-1991");

            customer3.getCharges().add(new AccountRecord());
            if (i % 2 == 0) {
                customer3.getCharges().get(customer3.getCharges().size()-1).setCharge(i*1000);
            } else {
                customer3.getCharges().get(customer3.getCharges().size()-1).setCharge(i*-1000);
            }
            customer3.getCharges().get(customer3.getCharges().size()-1).setChargeDate("01-01-1991");
        }
    }

    @Test
    public void testGetBalance() {
        // All positive charges
        assertEquals(45000, customer1.getBalance());
        // All negative charges
        assertEquals(-45000, customer2.getBalance());
        // Mixed positive and negative charges
        assertEquals(-5000, customer3.getBalance());
    }

    @Test
    public void testToString() {
        assertEquals(("\nID: " + customer1.getId() + "\nName: " + customer1.getName() + "\nBalance: " + customer1.getBalance() + "\n-------------------------\n"), customer1.toString());
        assertEquals(("\nID: " + customer2.getId() + "\nName: " + customer2.getName() + "\nBalance: " + customer2.getBalance() + "\n-------------------------\n"), customer2.toString());
        assertEquals(("\nID: " + customer3.getId() + "\nName: " + customer3.getName() + "\nBalance: " + customer3.getBalance() + "\n-------------------------\n"), customer3.toString());
    }
}