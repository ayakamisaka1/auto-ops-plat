package xsj.auto.ops.plat.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "xsj.auto.ops.plat")
@EnableJpaRepositories(
        basePackages = "xsj.auto.ops.plat.infrastructure.repository"
)
@EntityScan(
        basePackages = "xsj.auto.ops.plat.infrastructure.jpaEntity"
)
public class AutoOpsPlatAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(AutoOpsPlatAppApplication.class, args);
    }

}
