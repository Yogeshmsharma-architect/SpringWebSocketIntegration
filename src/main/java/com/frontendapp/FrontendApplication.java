package com.frontendapp;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration // Spring Boot Auto Configuration
@ComponentScan(basePackages = "com.frontendapp")

public class FrontendApplication /* uncomment to build war extends SpringBootServletInitializer*/ {

    //Uncomment to build war
    /*@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return configureApplication(builder);
    }
*/

    private static SpringApplicationBuilder configureApplication(SpringApplicationBuilder builder) {
        return builder.sources(FrontendApplication.class).bannerMode(Banner.Mode.OFF);
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(FrontendApplication.class, args);
        //configureApplication(new SpringApplicationBuilder()).run(args);

    }

}
