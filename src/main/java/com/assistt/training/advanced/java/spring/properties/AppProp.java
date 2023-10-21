package com.assistt.training.advanced.java.spring.properties;


import com.assistt.training.advanced.java.annotations.Prop;
import com.assistt.training.advanced.java.annotations.PropFile;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "deneme")
public class AppProp {
    private String text1;
    private String appVersion;
    private Integer appPort;
    private String desc;
    private List<String> cities;

}
