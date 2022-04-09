package ex.spring.context.javabasedconfig.config;

import ex.spring.context.javabasedconfig.service.Dependency;
import ex.spring.context.javabasedconfig.service.JavaBasedConfigService;
import ex.spring.context.javabasedconfig.service.impl.DependencyImpl;
import ex.spring.context.javabasedconfig.service.impl.JavaBasedConfigServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // will work without this annotation
public class JavaBasedConfig {

    @Bean
    Dependency dependency() {
        return new DependencyImpl();
    }

    // method injection
    @Bean
    JavaBasedConfigService javaBasedConfigService(Dependency dependency) {
        return new JavaBasedConfigServiceImpl(dependency);
    }
}
