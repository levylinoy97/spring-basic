package app;

import app.conf.BasicConfiguration;
import app.conf.BasicDbConfiguration;
import app.data.AddressDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BasicConfiguration.class, BasicDbConfiguration.class);
        /*Customer customer = ctx.getBean(Customer.class);

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
        System.out.println("the balance is: " + account.getBalance());*/
        AddressDAO dao = ctx.getBean(AddressDAO.class);
        System.out.println("Number of addresses: " + dao.count());

        /*dao.deleteAll();
        System.out.println("Deleted all");*/

        dao.deleteByPK("1", "1","1","1");
        System.out.println("Deleted by PK: 1, 1, 1, 1");

        ctx.close();
    }
}
