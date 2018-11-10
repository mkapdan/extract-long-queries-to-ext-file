package com.kaptan.data.factorydata.factories;

import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.service.BasicUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FactoryService {

  private final List<BasicUserService> basicUserServiceList;

  @Autowired
  public FactoryService(List<BasicUserService> basicUserServiceList) {
    this.basicUserServiceList = basicUserServiceList;
  }

  public BasicUserService getMyService(ChannelType channelType) {
    return basicUserServiceList.stream()
      .filter(s -> s.supports(channelType))
      .findFirst()
      .orElseThrow(IllegalArgumentException::new);
  }

}
