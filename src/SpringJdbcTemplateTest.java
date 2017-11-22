import lombok.extern.log4j.Log4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @class SpringJdbcTemplateTest
 * @author alan.hsieh
 * @purpose AP開發練習
 * @createTime 2017/11/17 下午1:16
 */
@Log4j
public class SpringJdbcTemplateTest {

    private static DataSource dataSource;
    private static JdbcTemplate jdbcTemplate;

    /**
	 * @method main
	 * @purpose 主方法
	 * @author alan.hsieh
	 * @createTime 2017/11/20 上午9:52
	 * @param args no use
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception{

        log.info("########## start execute SpringJdbcTemplateTest ##########");

        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:h2:./DB/test:testDB");
        basicDataSource.setUsername("sa");
        basicDataSource.setPassword("");
        basicDataSource.setDriverClassName("org.h2.Driver");

        dataSource = basicDataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        testDB();

        log.info("########## execute SpringJdbcTemplateTest end ##########");
	}

	private static void testDB() {

        List rows = jdbcTemplate.queryForList("SELECT * FROM employee");
        log.info(rows.toString());
        log.info("select done");

	}


}
