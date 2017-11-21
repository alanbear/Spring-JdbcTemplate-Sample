import lombok.extern.log4j.Log4j;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

/**
 * @class Spring_JdbcTemplate_Test
 * @author alan.hsieh
 * @purpose AP開發練習
 * @createTime 2017/11/17 下午1:16
 */
@Log4j
public class Spring_JdbcTemplate_Test {

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

        log.info("########## start execute Spring_JdbcTemplate_Test ##########");

        Class.forName("com.mysql.jdbc.Driver");
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:mysql://172.19.1.111:3306/m058001_dev");
        basicDataSource.setUsername("sa_user");
        basicDataSource.setPassword("usersa");
        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");

        dataSource = basicDataSource;
        jdbcTemplate = new JdbcTemplate(dataSource);
        testDB();

        log.info("########## execute Spring_JdbcTemplate_Test end ##########");
	}

	private static void testDB() {

        List rows = jdbcTemplate.queryForList("SELECT * FROM sys_settings where setting_key = 'aws_s3_access_key' ");
        log.info(rows.toString());
        log.info("select done");

	}


}
