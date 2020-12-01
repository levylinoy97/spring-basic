package app.beans;

import app.annotations.LevSampleAnnotation;
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Scope("prototype")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@LevSampleAnnotation
public class Address {
    @NonNull
    private String address1;
    private String address2;
    @NonNull
    private String city;
    private String zipCode;
    @NonNull
    private String country;

    @PostConstruct
    public void init() {
        System.out.println(getClass().getSimpleName() + " in @PostConstruct");
    }
}
