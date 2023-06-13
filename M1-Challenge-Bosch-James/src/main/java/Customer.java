import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        int balance = 0;

        for (AccountRecord charge: this.getCharges()) {
            balance += charge.getCharge();
        }

        return balance;
    }

    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        return ("\nID: " + this.id + "\nName: " + this.name + "\nBalance: " + this.getBalance() + "\n-------------------------\n");
    }
}
