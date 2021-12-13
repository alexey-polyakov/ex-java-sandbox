package ex.spring.context.annotationbasedconfig;

import ex.spring.context.annotationbasedconfig.service.AnnotationBasedService;
import ex.spring.context.annotationbasedconfig.service.Dependency;
import ex.spring.context.annotationbasedconfig.service.NonRegisteredDependency;
import ex.spring.context.annotationbasedconfig.service.impl.NonRegisteredDependencyImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@RequiredArgsConstructor
public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    @Getter
    private final Dependency dependency;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);
        Demo demo = context.getBean(Demo.class);
        Dependency dependency = demo.getDependency();
        dependency.doSomething();

        log.info("-------------------------------- \n");
        AnnotationBasedService annotationBasedService = context.getBean(AnnotationBasedService.class);
        annotationBasedService.doSomething();

        log.info("-------------------------------- \n");
        NonRegisteredDependency nonRegisteredDependency = new NonRegisteredDependencyImpl();
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) context.getAutowireCapableBeanFactory();
        beanFactory.registerSingleton("nonRegisteredDependency", nonRegisteredDependency);
        nonRegisteredDependency = (NonRegisteredDependency) context.getBean("nonRegisteredDependency");
        nonRegisteredDependency.doSomething();
    }
}

