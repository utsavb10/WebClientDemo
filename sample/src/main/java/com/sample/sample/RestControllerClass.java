package com.sample.sample;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class RestControllerClass {

  @RequestMapping("/sample/space")
  public String responseMethod(){
    System.out.println("Start Service 1"+getTime());
    try{
      Thread.sleep(5000);
    } catch(InterruptedException ie){
      ie.printStackTrace();
    }
    System.out.println("End Service 1");

    return "Response Service 1";
  }

  public String getTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    return (dtf.format(now));
  }
}
