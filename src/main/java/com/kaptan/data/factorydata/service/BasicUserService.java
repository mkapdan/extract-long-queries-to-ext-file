package com.kaptan.data.factorydata.service;

import com.kaptan.data.factorydata.factories.ChannelBasedFactory;

public interface BasicUserService extends ChannelBasedFactory {

  String getUserData(String name);
}
