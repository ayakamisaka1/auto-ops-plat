package xsj.auto.ops.plat.infrastructure.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(
        basePackages = "xsj.auto.ops.plat.infrastructure.repository",
        repositoryImplementationPostfix = "Impl"
)
@EntityScan(basePackages = "xsj.auto.ops.plat.domain.entity")
public class JpaConfig {
}
