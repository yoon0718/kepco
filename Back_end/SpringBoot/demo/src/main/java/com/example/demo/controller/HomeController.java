package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
  @RequestMapping("/")
  public String home() {
    log.trace("trace!");
    log.debug("debug!");
    log.info("info!");
    log.warn("warn!");
    log.error("error!");
    return "home";
  }
}
