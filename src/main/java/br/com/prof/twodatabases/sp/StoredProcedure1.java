package br.com.prof.twodatabases.sp;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import br.com.prof.twodatabases.entity.Users;
import br.com.prof.twodatabases.repository.UsersRepository;

//@Component
public class StoredProcedure1 {

//    private static final Logger log = LoggerFactory.getLogger(StoredProcedure1.class);
//
//    @Autowired
//    @Qualifier("jdbcBookRepository")
//    private UsersRepository userRepository;
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    private SimpleJdbcCall simpleJdbcCall;
//
//    @PostConstruct
//    void init() {
//        jdbcTemplate.setResultsMapCaseInsensitive(true);
//        simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withProcedureName("get_book_by_id");
//
//    }
//
//    private static final String SQL_STORED_PROC = ""
//            + " CREATE OR REPLACE PROCEDURE get_book_by_id "
//            + " ("
//            + "  p_id IN BOOKS.ID%TYPE,"
//            + "  o_name OUT BOOKS.NAME%TYPE,"
//            + "  o_price OUT BOOKS.PRICE%TYPE"
//            + " ) AS"
//            + " BEGIN"
//            + "  SELECT NAME, PRICE INTO o_name, o_price from BOOKS WHERE ID = p_id;"
//            + " END;";
//
//
//    public void start() {
//
//        log.info("Creating Store Procedures and Function...");
//        jdbcTemplate.execute(SQL_STORED_PROC);
//
//        /* Test Stored Procedure */
//        Users users = findById(2L).orElseThrow(IllegalArgumentException::new);
//        
//        // Book{id=2, name='Mkyong in Java', price=1.99}
//        System.out.println(users);
//
//
//    }
//
//    Optional<Users> findById(Long id) {
//
//        SqlParameterSource in = new MapSqlParameterSource()
//                .addValue("p_id", id);
//
//        Optional result = Optional.empty();
//
//        try {
//
//            Map out = simpleJdbcCall.execute(in);
//
//            if (out != null) {
//                Users user = new Users();
//                user.setId(id);
//                user.setName((String) out.get("O_NAME"));
//                user.setEmail((String) out.get("O_EMAIL"));
//                result = Optional.of(user);
//            }
//
//        } catch (Exception e) {
//            System.err.println(e.getMessage());
//        }
//
//        return result;
//    }

}
