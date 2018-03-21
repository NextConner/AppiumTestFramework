package service.servicesImplement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import service.TestJpa;

@Service
public class ImplTestJpa implements TestJpa{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addUserByName(String userName) {

    }

    @Override
    public void deleteUserByName(String userName) {

        jdbcTemplate.update("delete from USER where NAME =?",userName); //占位符

    }


}
