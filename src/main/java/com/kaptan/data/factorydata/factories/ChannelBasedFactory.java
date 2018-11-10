package com.kaptan.data.factorydata.factories;

import com.kaptan.data.factorydata.enums.ChannelType;

public interface ChannelBasedFactory {

  boolean supports(ChannelType channelType);
}
