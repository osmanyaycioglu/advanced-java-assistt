package com.assistt.training.advanced.java.annotations;


import lombok.*;

@Data
@PropFile("src/main/resources/my.properties")
public class AppProp {
    @Prop("deneme.text1")
    private String text1;
    @Prop("deneme.app.version")
    private String appVersion;
    @Prop("deneme.app.port")
    private Integer appPort;
    @Prop("deneme.desc")
    private String desc;

}
