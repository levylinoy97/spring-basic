package app;

import app.conf.BasicConfiguration;
import app.beans.Account;
import app.beans.Address;
import app.beans.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BasicConfiguration.class);
        Customer customer = ctx.getBean(Customer.class);

        Account account = ctx.getBean(Account.class);

        customer.setId("1");
        customer.setFirstName("Linoy");
        customer.setLastName("Levi");
        customer.getAddress().setAddress1("10 Dawning St.");
        customer.getAddress().setCity("London");
        customer.getAddress().setCountry("UK");

        Address address = ctx.getBean(Address.class);
        System.out.println("Address " + address.getCountry());

        System.out.println("Created customer: " + customer.getFirstName() + " from: " + customer.getAddress().getCountry());

        ctx.close();
    }
}
