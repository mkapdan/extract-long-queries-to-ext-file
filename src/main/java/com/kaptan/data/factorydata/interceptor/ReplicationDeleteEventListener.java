package com.kaptan.data.factorydata.interceptor;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.entity.User;
import org.hibernate.FlushMode;
import org.hibernate.event.spi.PreDeleteEvent;
import org.hibernate.event.spi.PreDeleteEventListener;

public class ReplicationDeleteEventListener
  implements PreDeleteEventListener {

  public static final ReplicationDeleteEventListener INSTANCE =
    new ReplicationDeleteEventListener();

  @Override
  public boolean onPreDelete(
    PreDeleteEvent event) {
    final Object entity = event.getEntity();

    if (entity instanceof User) {
      User user = (User) entity;

      event.getSession().createNativeQuery(
        "DELETE FROM T_USER " +
          "WHERE id = :id")
        .setParameter("id", user.getId())
        .setFlushMode(FlushMode.MANUAL)
        .executeUpdate();
    }

    return false;

  }
}
