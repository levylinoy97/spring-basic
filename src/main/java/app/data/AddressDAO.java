package app.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

@Repository
public class AddressDAO {
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @PostConstruct
    public void init() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/basic-spring-db");
        dataSource.setUsername("linoy");
        dataSource.setPassword("LinoySQL2610");
        final Properties connProps = new Properties();
        connProps.setProperty("serverTimezone", "UTC");
        dataSource.setConnectionProperties(connProps);

        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    /*@Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }*/

    public int count() {
        String sql = "select count(*) from address";
        return jdbcTemplate.queryForObject(sql, null, Integer.class);
    }

    public void deleteAll() {
        String sql = "truncate address";
        jdbcTemplate.execute(sql);
    }

    /*public void deleteByPK(String address1, String city, String country, String zipcode) {
        String sql = "delete from address where address1 = :address1 and city = :city and country = :country and zipcode = :zipcode";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("address1", address1);
        parameters.put("city", city);
        parameters.put("country", country);
        parameters.put("zipcode", zipcode);
        namedParameterJdbcTemplate.update(sql, parameters);
    }*/
}
