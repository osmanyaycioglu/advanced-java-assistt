package com.assistt.training.advanced.java.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadProperty {

    public static void main(String[] args) throws Exception {
        Properties      propertiesLoc      = new Properties();
        File            fileLoc            = new File("src/main/resources/my.properties");
        FileInputStream fileInputStreamLoc = new FileInputStream(fileLoc);
        propertiesLoc.load(fileInputStreamLoc);
        AppProp appPropLoc = new AppProp();
        appPropLoc.setText1(propertiesLoc.getProperty("deneme.text1"));
        appPropLoc.setAppVersion(propertiesLoc.getProperty("deneme.app.version"));
        appPropLoc.setAppPort(Integer.parseInt(propertiesLoc.getProperty("deneme.app.port")));
        System.out.println("okunan : " + appPropLoc);
    }

}
