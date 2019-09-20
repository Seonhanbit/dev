package edu.ssafy.chap11.dom;

import java.util.ArrayList;


public class MyDOMMain {
    public static void main(String[] args){

        ArrayList<Check> list=new MyDOMParser().getContent("http://localhost:8080/result.xml");
        for(  Check c: list){
        	System.out.println(c);
        }
    }
   }
