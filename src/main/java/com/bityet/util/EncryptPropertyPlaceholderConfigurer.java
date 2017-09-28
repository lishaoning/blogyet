package com.bityet.util;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

/**
 * Created by Administrator on 2017/2/14.
 */
public class EncryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{

    private String []encryptPropNames={"jdbc.username","jdbc.password"};

    @Override
    protected String convertProperty(String propertyName,String propertyValue){
        if(this.isEncryptProperty(propertyName)){
            try {
                String decryptPrppertyValue = EncryptUtil.getDecryptString(propertyValue);
                return decryptPrppertyValue;
            }catch(Exception e) {
                return propertyValue;
            }
        }else{
            return propertyValue;
        }
    }


    private boolean isEncryptProperty(String propertyName){
        for(String encryptPropName:encryptPropNames){
            if(encryptPropName.equals(propertyName)){
                return true;
            }
        }
        return false;
    }
}
