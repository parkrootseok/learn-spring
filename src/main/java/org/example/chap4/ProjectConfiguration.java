package org.example.chap4;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ComponentScan(
        basePackages = {"org.example.chap4.proxies", "org.example.chap4.repositories", "org.example.chap4.services"}
)
@Configuration
public class ProjectConfiguration {
}
