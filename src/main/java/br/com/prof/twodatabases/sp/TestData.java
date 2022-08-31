package br.com.prof.twodatabases.sp;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import br.com.prof.twodatabases.entity.Users;
import br.com.prof.twodatabases.repository.UsersRepository;

//@Component
public class TestData {

//    private static final Logger log = LoggerFactory.getLogger(TestData.class);
//
//    @Autowired
//    @Qualifier("jdbcUsersRepository")
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private static final String SQL_CREATE_TABLE = ""
//            + " CREATE TABLE USERSPROC"
//            + " ("
//            + "  ID number GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),"
//            + "  NAME varchar2(100) NOT NULL,"
//            + "  EMAIL number(15, 2) NOT NULL,"
//            + "  CONSTRAINT book_pk PRIMARY KEY (ID)"
//            + " )";
//
//    public void start() {
//        createTestData(true);
//    }
//
//    void createTestData(boolean dropTable) {
//
//        log.info("Creating tables for testing...1");
//
//        if (dropTable) {
//            jdbcTemplate.execute("DROP TABLE BOOKS");
//        }
//
//        jdbcTemplate.execute(SQL_CREATE_TABLE);
//
//        List<Users> users = Arrays.asList(
//                new Users(1l,"jose", "jose@gmail.com"),
//                new Users(2l,"lu", "lu@gmail.com"),
//                new Users(3l,"belem", "belem@gmail.com")
//        );
//
//        log.info("[SAVE]");
//        users.forEach(user -> {
//            log.info("Saving...{}", user.getName());
//            usersRepository.save(user);
//        });
//
//    }

}
