package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.entity.User;
import com.kaptan.data.factorydata.enums.ChannelType;
import com.kaptan.data.factorydata.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
public class DevUserService implements BasicUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  @Transactional
  public String getUserData(String name) {
    User user= userRepository.findUserWithNamed(name);
    User newOne=new User();
    newOne.setName("Random");
    newOne.setUsername("Mustafa"+new Random().nextInt());
    newOne.setEmail("asasasa"+new Random().nextInt());
    userRepository.save(newOne);
    return user.getEmail();
  }

  @Override
  public boolean supports(ChannelType channelType) {
    return ChannelType.DEV.equals(channelType);
  }
}
