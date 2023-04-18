package com.lojavirtual.backend.controllers;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Hello {
  
  @GetMapping(value = "/")
  public String hello() {
    return "Olá mundo " + new Date();
  }
  
}
