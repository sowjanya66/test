package com.example.demo;



public class Test
{
     /* See below - I have marked the constructor as static */
     public  Test()
     {
         System.out.println("Hello");
         System.out.println((int)'A');
     }
     
     public final void test1()
     {
    	 System.out.println("hi");
     }
     
   
     public static void main(String args[])
     {
         /*Below: I'm trying to create an object of the class
          *that should invoke the constructor
          */
         Test1 obj = new Test1();
         obj.test1();
         
         
     }
}


