package com.assistt.training.advanced.java.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadPropertyAnno {

    public static void main(String[] args) throws Exception {
        PropEngine<AppProp> propPropEngineLoc = new PropEngine<>();
        AppProp             appPropLoc        = propPropEngineLoc.readProp(AppProp.class);
        System.out.println(appPropLoc);
    }

}
