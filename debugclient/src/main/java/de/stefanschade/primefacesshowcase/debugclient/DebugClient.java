package de.stefanschade.primefacesshowcase.debugclient;

import de.stefanschade.primefacesshowcase.debugclient.rest.HelloWorldClient;

public class DebugClient {


    public static void main(String[] args) {

        HelloWorldClient hwc = new HelloWorldClient();
//        System.out.println("***********************************************");
//        System.out.println("*    Retrieving an Object from                *");
//        System.out.println("*    http://localhost:8080/helloworld         *");
//        System.out.println("***********************************************");
//        System.out.println();
//        hwc.JerseyHelloWorld();

        System.out.println();
        System.out.println("***************************************************************************");
        System.out.println("*    Retrieving a List of Objects from                                    *");
        System.out.println("*    http://localhost:8080/helloworldlist                                 *");
        System.out.println("*                                                                         *");
        System.out.println("*                compliments to                                           *");
        System.out.println("*   http://www.adam-bien.com/roller/abien/entry/jax_rs_retrieving_a_list  *");
        System.out.println("*                                                                         *");
        System.out.println("***************************************************************************");
        System.out.println();
        hwc.JerseyHelloWorldList();

        hwc.JerseyClientForShowcase();

        //

    }


}