package com.desarrollamesta;

import freemarker.template.Configuration;
import freemarker.template.Template;
import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: wisog
 * Date: 20/04/14
 * Time: 08:59 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestLanguages {
    public static void main (String [] args) {

        final Configuration configuration = new Configuration();
        configuration.setClassForTemplateLoading(
                TestLanguages.class, "/");

        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                try{
                    Map<String, Object> langsMap = new HashMap<String, Object>();
                    langsMap.put("languages", Arrays.asList("java", "C#", "Perl", "C", "Python"));

                    Template langsPickerTemplate = configuration.getTemplate("home.html");
                    StringWriter writer = new StringWriter();
                    langsPickerTemplate.process(langsMap, writer);
                    return writer;
                } catch (Exception e){
                    halt(500);
                    return null;
                }
            }
        });

        Spark.post(new Route("/selected_language") {
            @Override
            public Object handle(Request request, Response response) {
                final String lang = request.queryParams("language");
                if (lang == null)
                    return "Just pick one asshole!";
                return "You selected " + lang;
            }
        });
    }
}
