import java.lang.reflect.*;
import java.util.*;

class SomeClass {
    public static int a = 10;
    public static int b = 20;
    public static int c = 40;
}

class HelloWorld {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<String, String>();
        try{
            SomeClass sc = new SomeClass();

            Field[] fields = SomeClass.class.getDeclaredFields();

            for(int i = 0; i < fields.length; i++) {


                Object value = fields[i].get(sc);
                Object fieldName = fields[i].getName();




                map.put(fieldName.toString(), value.toString());
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        for (Map.Entry<String, String> e : map.entrySet()) {
            System.out.println("Key: " + e.getKey() + " Value: " + e.getValue());
        }
    }
}