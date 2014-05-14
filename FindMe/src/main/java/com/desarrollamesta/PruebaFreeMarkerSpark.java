package com.desarrollamesta;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wisog
 * Date: 20/04/14
 * Time: 07:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class PruebaFreeMarkerSpark {
    public static void main (String [] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                PruebaFreeMarkerSpark.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                try {
                    Template helloTemplate = configuration.getTemplate("hello.ftl");
                    Map<String, Object> helloMap = new HashMap<String, Object>();
                    helloMap.put("name", "Cesar");
                    helloTemplate.process(helloMap, writer);
                } catch (Exception e) {
                    halt(500);
                    e.printStackTrace();
                }
                return writer;
            }
        });
        Spark.get(new Route("/users/:thing") {
            @Override
            public Object handle(Request request, Response response) {
                StringWriter writer = new StringWriter();
                writer.write("Welcome " + request.params("thing"));
                return writer;
            }
        });
    }
}
