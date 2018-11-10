package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.entity.User;
import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestUserService implements BasicUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional(propagation = Propagation.SUPPORTS)
  public String getUserData(String name) {
    User user = userRepository.findUserByUsername(name);
    return user.getUsername();
  }

  @Override
  public boolean supports(ChannelType channelType) {
    return ChannelType.TEST.equals(channelType);
  }
}
