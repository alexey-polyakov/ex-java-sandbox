package ex.spring.context.xmlbasedconfig.service.impl;

import ex.spring.context.xmlbasedconfig.service.Dependency;
import ex.spring.context.xmlbasedconfig.service.XmlBasedService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequiredArgsConstructor
public class XmlBasedServiceImpl implements XmlBasedService {

    private static final Logger log = LoggerFactory.getLogger(XmlBasedServiceImpl.class);

    private final Dependency dependency;

    @Override
    public void doSomething() {
        dependency.doSomething();
        log.info(">>>> doSomething from XmlBasedServiceImpl");
    }
}
