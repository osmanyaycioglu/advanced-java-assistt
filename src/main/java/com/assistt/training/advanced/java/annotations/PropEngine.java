package com.assistt.training.advanced.java.annotations;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class PropEngine<T> {

    public T readProp(final Class<T> clazz) {
        try {
            // Create Instance
            Constructor<T> constructorLoc  = clazz.getConstructor();
            T              tLoc            = constructorLoc.newInstance();
            // Read PropFile Annotaton
            PropFile       propFileAnnoLoc = clazz.getAnnotation(PropFile.class);
            if (propFileAnnoLoc == null) {
                return null;
            }
            String          fileToReadLoc      = propFileAnnoLoc.value();
            Properties      propertiesLoc      = new Properties();
            File            fileLoc            = new File(fileToReadLoc);
            FileInputStream fileInputStreamLoc = new FileInputStream(fileLoc);
            propertiesLoc.load(fileInputStreamLoc);
            // Read Field Annotations
            Field[]         declaredFieldsLoc  = clazz.getDeclaredFields();
            for (Field declaredFieldLoc : declaredFieldsLoc) {
                Prop propAnnoLoc = declaredFieldLoc.getAnnotation(Prop.class);
                if (propAnnoLoc != null) {
                    String propertyLoc = propertiesLoc.getProperty(propAnnoLoc.value());
                    declaredFieldLoc.setAccessible(true);
                    Class<?> typeLoc = declaredFieldLoc.getType();
                    if (String.class.equals(typeLoc)){
                        declaredFieldLoc.set(tLoc,propertyLoc);
                    } else if (Integer.class.equals(typeLoc)) {
                        declaredFieldLoc.set(tLoc, Integer.parseInt(propertyLoc));
                    } else if ("int".equals(typeLoc.getName())) {
                        declaredFieldLoc.setInt(tLoc, Integer.parseInt(propertyLoc));
                    }
                }
            }
            return tLoc;
        } catch (Exception eParam) {
            eParam.printStackTrace();
            return null;
        }
    }

}
