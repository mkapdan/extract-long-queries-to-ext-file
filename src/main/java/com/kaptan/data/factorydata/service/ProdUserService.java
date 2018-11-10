package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.entity.User;
import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdUserService implements BasicUserService {

  @Autowired
  private UserRepository userRepository;

  @Override public String getUserData(String name) {
    User user = userRepository.selectByName(name);
    return user.getUsername();
  }

  @Override public boolean supports(ChannelType channelType) {
    return ChannelType.PROD.equals(channelType);
  }
}
