package ex.spring.context.packagescan.mainpackage;

import ex.spring.context.packagescan.mainpackage.service.PackageScanService;
import ex.spring.context.packagescan.parallelpackage.ParallelConfig;
import ex.spring.context.packagescan.parallelpackage.ParallelPackageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(ParallelConfig.class)
@ComponentScan
public class Demo {

    private static final Logger log = LoggerFactory.getLogger(Demo.class);

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Demo.class);

        PackageScanService packageScanService = context.getBean(PackageScanService.class);
        packageScanService.doSomething();

        ParallelPackageService parallelPackageService = context.getBean(ParallelPackageService.class);
        parallelPackageService.doSomething();

        ParallelConfig parallelConfig = context.getBean(ParallelConfig.class);
        log.info(">>>> parallelConfig {}", parallelConfig);
    }
}
