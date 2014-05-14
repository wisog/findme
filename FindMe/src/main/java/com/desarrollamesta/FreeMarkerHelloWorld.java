package com.desarrollamesta;

/**
 * Created with IntelliJ IDEA.
 * User: wisog
 * Date: 20/04/14
 * Time: 07:12 PM
 * To change this template use File | Settings | File Templates.
 */

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkerHelloWorld {
    public static void main(String [] args){
        Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                FreeMarkerHelloWorld.class, "/");
        try {
            Template helloTemplate = configuration.getTemplate("hello.ftl");
            StringWriter writer = new StringWriter();
            Map<String, Object> helloMap = new HashMap<String, Object>();
            helloMap.put("name", "Cesar");

            helloTemplate.process(helloMap, writer);
            System.out.println(writer);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
