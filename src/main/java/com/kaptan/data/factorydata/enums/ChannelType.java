package com.kaptan.data.factorydata.enums;

import java.util.stream.Stream;

public enum ChannelType {
  TEST("test"),
  DEV("dev"),
  PROD("prod");

  private String codeStr;

  ChannelType(String codeStr) {
    this.codeStr = codeStr;
  }

  public static ChannelType getFromString(String str) {
    return Stream.of(values())
      .filter(en -> en.codeStr.equalsIgnoreCase(str))
      .findFirst()
      .orElseThrow(IllegalArgumentException::new);
  }

}
