package ex.spring.context.annotationbasedconfig.service.impl;

import ex.spring.context.annotationbasedconfig.service.AnnotationBasedService;
import ex.spring.context.annotationbasedconfig.service.Dependency;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnotationBasedServiceImpl implements AnnotationBasedService {

    private static final Logger log = LoggerFactory.getLogger(AnnotationBasedServiceImpl.class);

    private final Dependency dependency;

    @Override
    public void doSomething() {
        dependency.doSomething();
        log.info(">>>> doSomething from AnnotationBasedServiceImpl");
    }
}
