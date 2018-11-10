package com.kaptan.data.factorydata.entity;

import com.kaptan.data.factorydata.constant.EntityStatusType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@Access(AccessType.FIELD)
public abstract class AbstractEntity implements Serializable {

  protected static final String SEQUENCE_GENERATOR_NAME = "SP_SEQUENCE_GENERATOR";

  @Version
  @Column(name = "C_VERSION")
  private Integer version;

  @Column(name = "C_JVM_PROCESS_ID")
  private String jvmProcessId;

  @Column(name = "C_HOST_NAME")
  private String hostName;

  @Column(name = "C_HOST_ADDRESS")
  private String hostAddress;

  @Column(name = "C_DATE_CREATED", updatable = false)
  private LocalDateTime creationDate;

  @Column(name = "C_DATE_UPDATED")
  private LocalDateTime updateDate;

  @Enumerated(EnumType.STRING)
  @Column(name = "C_STATE")
  private EntityStatusType entityStatusType = EntityStatusType.ACTIVE;

  @Column(name = "C_CREATE_USER")
  private String createUser;

  @Column(name = "C_UPDATE_USER")
  private String updatedUser;

  public abstract Long getId();

  public abstract void setId(Long id);

}
