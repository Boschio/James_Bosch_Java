import java.util.*;

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {

        List<Customer> customers = new ArrayList<>();

        Collections.sort(customerData, Comparator.comparing(o -> o[0]));

        for (int i=0;i<customerData.size();i++) {
            if (customers.isEmpty() || Integer.parseInt(customerData.get(i)[0]) != customers.get(customers.size()-1).getId()) {
                Customer c = new Customer();
                AccountRecord a = new AccountRecord();

                c.setId(Integer.parseInt(customerData.get(i)[0]));
                c.setName(customerData.get(i)[1]);
                a.setCharge(Integer.parseInt(customerData.get(i)[2]));
                a.setChargeDate(customerData.get(i)[3]);
                c.getCharges().add(a);
                customers.add(c);
            }

            else if (Integer.parseInt(customerData.get(i)[0]) == customers.get(customers.size()-1).getId()) {
                Customer lastC = customers.get(customers.size()-1);
                AccountRecord a = new AccountRecord();

                a.setCharge(Integer.parseInt(customerData.get(i)[2]));
                a.setChargeDate(customerData.get(i)[3]);

                lastC.getCharges().add(a);

            }
        }

        System.out.println("Positive accounts:");
        for (int i = 0;i < customers.size();i++) {
            if (customers.get(i).getBalance() >= 0) {
                System.out.println(customers.get(i).toString());
            }
        }
        System.out.println("Negative accounts:");
        for (int i = 0;i < customers.size();i++) {
            if (customers.get(i).getBalance() < 0) {
                System.out.println(customers.get(i).toString());
            }
        }
    }
}
