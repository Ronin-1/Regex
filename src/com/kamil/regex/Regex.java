package com.kamil.regex;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.stream.IntStream;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.stream.IntStream;

  
public class Regex {
    public String in = "Keyspace: p3graphite\n\tRead Count: 32342\n\tReadLatency: 0.23423 ms.\n\tWrite Count: 32423\n\n--------";
//Keyspace: p3graphite,Read Count: 32342,ReadLatency: 0.23423 ms.,Write Count: 32423,,
    //loop strings between two commas, up to : is the key, the rest is the value


    public String x = in.replaceAll( "\t", "" );
    public String csv = x.replaceAll( "\n", "#" );
    public char arr[] = csv.toCharArray();
    public String key;
    public String value;
    public String output;
    public int counter;

    public void replace() {
        System.out.println( csv );
        System.out.println( arr );

        HashMap<String, String> map = new HashMap<String, String>();
        ArrayList<String> temp = new ArrayList<>();
        //String  [] temp;
        //temp = new String[200];


//        IntStream.range(0, csv.length()).forEach( i-> {
//            System.out.println( csv.charAt( i ));
//
//        });

        IntStream.range( 0, csv.length() ).forEach( i -> {
            if (csv.charAt( i ) != ':' && csv.charAt( i ) != '#') {
                //System.out.println("not : or ^");
                temp.add( Character.toString( csv.charAt( i ) ) );
                System.out.println(temp);

            } else {
                counter++;
                System.out.println( counter );
                if (counter == 1) {
                    System.out.println( "got a key" );
                }
                System.out.println( temp );
                System.out.println( (String.join( ",", temp ).replaceAll( ",", "" )) );
                //
                if (counter == 1) {
                    key = String.join( ",", temp ).replaceAll( ",", "" );
                    key = key + ":";
                } else {
                    value = String.join( ",", temp ).replaceAll( ",", "" );
                    map.put( key, value );
                    System.out.println( "got a map" );
                    System.out.println( map );

                    key = "";
                    value = "";
                    counter = 0;

                }

                temp.clear();

            }

        } );


    }

}

