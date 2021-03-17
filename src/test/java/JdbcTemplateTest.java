import com.atguigu.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;

public class JdbcTemplateTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    JdbcTemplate jdbcTemplate = ioc.getBean(JdbcTemplate.class);

    @Test
    public void test01() throws SQLException {
        String sql = "UPDATE tbl_admin SET a_password = ? where a_id = ?";
        int update = jdbcTemplate.update(sql, "12345", 1);
        System.out.println("update = " + update);

    }
    @Test
    public void test02(){
        BookService bookService = ioc.getBean(BookService.class);
        bookService.checkout("Tom", "ISBN-001");
        System.out.println("结账完成");
    }
}
