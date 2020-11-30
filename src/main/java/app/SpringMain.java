package app;

import app.beans.Account;
import app.beans.Address;
import app.beans.Customer;
import app.conf.BasicConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BasicConfiguration.class);
        Customer customer = ctx.getBean(Customer.class);

        customer.setId("1");
        customer.setFirstName("Linoy");
        customer.setLastName("Levi");
        customer.getAddress().setAddress1("10 Dawning St.");
        customer.getAddress().setCity("London");
        customer.getAddress().setCountry("UK");

        Address address = ctx.getBean(Address.class);
        System.out.println("Address " + address.getCountry());

        System.out.println("Created customer: " + customer.getFirstName() + " from: " + customer.getAddress().getCountry());

        Account account = ctx.getBean(Account.class);
        account.setBalance("100");
        System.out.println("the balance is: " + account.getBalance());

        ctx.close();
    }
}
