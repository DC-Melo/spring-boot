package com.dc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 * 
 * @Controller + @ResponseBody = @RestController
 */
// @Controller
// @ResponseBody
@RestController
public class HelloController {

  @RequestMapping("/")
  public String Hello() {
    return "Hello World, Spring Boot!";
  }
}
