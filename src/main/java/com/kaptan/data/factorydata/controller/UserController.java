package com.kaptan.data.factorydata.controller;

import com.kaptan.data.factorydata.bo.UserBo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/jpa-query")
@RequiredArgsConstructor
public class UserController {

  private final UserBo userBo;

  @GetMapping(path = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getMyNameDueToChannel(@RequestParam("channel") String channel, @RequestParam("name") String name) {
    return userBo.getMyName(channel, name);
  }

}
