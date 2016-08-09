package com.model;

import java.util.HashMap;
import java.util.Map;

/**
 * @（#）:ContainerBean
 * @description:
 * @author: xuxb 16/8/2
 * @version: Version 1.0
 */
public class ContainerBean {

    /** bean ID*/
    private String id;

    /**bean class*/
    private String type;

    /**
     * Bean Property
     * HashMap的key就是Bean 的 Id ，HasMap 的value是这个Bean
     * */
    private Map<String, Object> properties = new HashMap<String, Object>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
