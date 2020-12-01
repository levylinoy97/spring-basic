package app.mappers;

import app.beans.Address;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressMapper implements RowMapper<Address> {
    public Address mapRow(ResultSet resultSet, int i) throws SQLException {
        return Address.builder()
                .address1("address1")
                .address2("address2")
                .city("city")
                .country("country")
                .zipCode("zipcode").build();
    }
}
