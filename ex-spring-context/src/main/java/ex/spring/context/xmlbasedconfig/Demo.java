package ex.spring.context.xmlbasedconfig;

import ex.spring.context.xmlbasedconfig.service.XmlBasedService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        XmlBasedService bean = context.getBean(XmlBasedService.class);
        bean.doSomething();
    }
}
