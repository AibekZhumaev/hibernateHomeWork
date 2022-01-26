package peaksoft.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Zha_Aibek@mail.com
 */
@Configuration
@ComponentScan(basePackages = "peaksoft")
@PropertySource("classpath:application.properties")
public class ConfigurationBeans {
}
