package com.kaptan.data.factorydata.entity;

import com.kaptan.data.factorydata.constant.DatabaseConstant;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Where(clause = DatabaseConstant.DELETE_WHERE_CLAUSE)
@Entity
@Table(name = User.TABLE_NAME)
@Access(AccessType.FIELD)
@Getter
@Setter
public class User extends AbstractEntity implements Serializable {

  public static final String TABLE_NAME = "T_USER";
  public static final String JOIN_COLUMN = "C_USERID";
  private static final long serialVersionUID = 1L;
  private static final String SEQUENCE_NAME = TABLE_NAME + "_SEQ";
  private static final String MAPPER_ENTITY_NAME = "user";

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_GENERATOR_NAME)
  @SequenceGenerator(name = SEQUENCE_GENERATOR_NAME, sequenceName = SEQUENCE_NAME, initialValue = DatabaseConstant.SEQ_INITIAL_VALUE, allocationSize = 1)
  private Long id;

  @Column(name = "C_USERNAME", unique = true, nullable = false)
  private String username;

  @Column(name = "C_EMPLOYEE_NUMBER", unique = true, updatable = false)
  private String employeeNumber;

  @Column(name = "C_EMAIL", unique = true, nullable = false)
  private String email;

  @Column(name = "C_PASSWORD")
  private String password;

  @Column(name = "C_FAIL_ATTEMPT_COUNT")
  private Integer failAttemptCount;

  @Column(name = "C_PASSWORD_END_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date passwordEndDate;

  @Column(name = "C_LAST_LOGIN_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLoginDate;

  @Column(name = "C_PASSWORD_CHANGE_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date passwordChangeDate;

  @Column(name = "C_OTP_REQUIRED")
  private Boolean otpRequired;

  @Column(name = "C_ENABLED")
  private Boolean activated = Boolean.TRUE;

  @Column(name = "C_RESET_KEY")
  private String resetKey;

  @Column(name = "C_NANE")
  private String name;

  @Column(name = "C_LAST_NAME")
  private String lastName;

  @Column(name = "C_RESET_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date resetDate;

  @Column(name = "C_LAST_LOCK_DATE")
  @Temporal(TemporalType.TIMESTAMP)
  private Date lastLockDate;

  @Column(name = "C_PHONE_NUMBER")
  private String phoneNumber;

}
