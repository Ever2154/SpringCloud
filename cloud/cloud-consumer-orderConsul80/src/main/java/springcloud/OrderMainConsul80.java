package springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/**
 * @ClassNameOrderMain80
 * @Description
 * @Author 黄皓
 * @Date2020/6/5 13:57
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})

public class OrderMainConsul80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMainConsul80.class, args);
    }
}
