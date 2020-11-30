package app.beans;

import app.annotations.LevSampleAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Customer {
    private String id;
    private String firstName;
    private String lastName;
    private Address address;

    public Customer() {
        System.out.println(getClass().getSimpleName() + " in c-tor");
    }

    @Autowired
    public void setAddress(Address address){
        this.address = address;
        System.out.println(getClass().getSimpleName() + " in @Autowired");
    }

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " in @PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println(getClass().getSimpleName() + " in @PreDestroy");
    }

    public String getId() {
        return id;
    }

    @LevSampleAnnotation
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }
}
