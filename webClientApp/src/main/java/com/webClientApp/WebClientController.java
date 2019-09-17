package com.webClientApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class WebClientController {

  @Autowired
  private WebClientClass wcClass;


  @RequestMapping("/")
  public String call(){

    //System.out.println(getTime());
    wcClass.getAllResponses();
    //System.out.println(getTime());

    return "Loading ...";
  }

  public String getTime() {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    return (dtf.format(now));
  }

}
