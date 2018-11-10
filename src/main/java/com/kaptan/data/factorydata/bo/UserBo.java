package com.kaptan.data.factorydata.bo;

import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.factories.FactoryService;
import com.kaptan.data.factorydata.service.BasicUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserBo {

  private final FactoryService factoryService;

  public String getMyName(String param, String name) {

    ChannelType channelType = ChannelType.getFromString(param);
    BasicUserService basicUserService = factoryService.getMyService(channelType);
    return basicUserService.getUserData(name);
  }

}
