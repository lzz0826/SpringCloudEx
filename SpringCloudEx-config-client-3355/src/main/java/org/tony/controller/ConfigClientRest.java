package org.tony.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {


  @Value("${spring.application.name}")
  public String applicationName;


  @Value("${eureka.client.service-url.defaultZone}")
  public String defaultZone;

  @Value("${server.port}")
  public String port;


  @GetMapping("/getConfig")
  public String getConfig(){
    String str = "applicationName"+applicationName+"\t"+"defaultZone"+defaultZone+"\t"+
        "port"+port;
    System.out.println(str);
    return str;
  }





}
