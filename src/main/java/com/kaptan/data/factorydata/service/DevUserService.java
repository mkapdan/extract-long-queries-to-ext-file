package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevUserService implements BasicUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public String getUserData(String name) {
    return userRepository.findUserWithNamed(name).getEmail();
  }

  @Override
  public boolean supports(ChannelType channelType) {
    return ChannelType.DEV.equals(channelType);
  }
}
