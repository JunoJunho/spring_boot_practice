package com.junojunho;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("amazon")
public class AmazonProperties {

    private String associatedId;

    public void setAssociatedId(String associatedId){
        this.associatedId = associatedId;
    }

    public String getAssociatedId(){
        return this.associatedId;
    }
}
