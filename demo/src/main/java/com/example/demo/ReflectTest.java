package com.example.demo;

import java.lang.reflect.Field;


public class ReflectTest{
 int x;
public  int y;

public String name = "hello";

 ReflectTest(int x, int y) {
this.x = x;
this.y = y;
}

public static void main(String args[]) throws Exception, NoSuchFieldException
{
// Get the parameter value
       ReflectTest test = new ReflectTest(3, 5);
                // Get the object bytecode  
       Class cls = test.getClass();

                //getField can only get visible variables  
                Field fd1 = cls.getField("y");//The returned value is not a variable of the test object, but a Field object. So the following must pass the get method to the specified ReflectTest object to get the value
       System.out.println("value1:" + fd1.get(test));


                //getDeclaredField can get private variables  
       Field fd2 = cls.getDeclaredField("x");
     
                fd2.setAccessible(true);//Set private property accessible  
       System.out.println("value1:" + fd2.get(test));
//value1:5  value1:3

Field[] fields = test.getClass().getFields();//Get all object properties 
for(Field field:fields){
	
if( field.getType() == String.class){
	
  String oldStr = (String) field.get(test);//return the original character
  System.out.println(oldStr);
  System.out.println(field.getType() + "   " + String.class);
}
}
}
}

//So