package com.desarrollamesta;

/**
 * Created with IntelliJ IDEA.
 * User: wisog
 * Date: 20/04/14
 * Time: 06:59 PM
 * To change this template use File | Settings | File Templates.
 */

import spark.Request;
import spark.Response;
import spark.Route;
import spark.Spark;

public class SparkHelloWorld {
    public static void main (String [] args){
        Spark.get(new Route("/") {
            @Override
            public Object handle(Request request, Response response) {
                return "Hello World Spark";  //To change body of implemented methods use File | Settings | File Templates.
            }
        });
    }
}
