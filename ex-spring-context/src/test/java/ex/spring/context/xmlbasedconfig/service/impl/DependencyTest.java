package ex.spring.context.xmlbasedconfig.service.impl;

import ex.spring.context.xmlbasedconfig.service.Dependency;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "/test-spring-context.xml")
@DisplayName("Test should check that Dependency initialized properly")
class DependencyTest {

    @Autowired
    private Dependency dependency;

    @Test
    @DisplayName("should check that dependency is not null")
    void shouldCheckThatObjectNonNull() {
        Assertions.assertThat(dependency).isNotNull();
    }
}
