package com.example.goloko.service;
 import org.springframework.stereotype.Service;

 @Service
public class GreetingService {

     public String getGreeting(String name){
         return String.format("Hello %s!", name);
     }
}
