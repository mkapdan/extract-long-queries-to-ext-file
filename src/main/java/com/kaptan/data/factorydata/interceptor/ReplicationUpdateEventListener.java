package com.kaptan.data.factorydata.interceptor;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.entity.User;
import org.hibernate.FlushMode;
import org.hibernate.event.spi.PostUpdateEvent;
import org.hibernate.event.spi.PostUpdateEventListener;
import org.hibernate.persister.entity.EntityPersister;

public class ReplicationUpdateEventListener
  implements PostUpdateEventListener {

  public static final ReplicationUpdateEventListener INSTANCE =
    new ReplicationUpdateEventListener();

  @Override
  public void onPostUpdate(
    PostUpdateEvent event) {
    final Object entity = event.getEntity();

    if (entity instanceof User) {
      User usr = (User) entity;

      event.getSession().createNativeQuery(
        "UPDATE T_USER_OLD " +
          "SET FIRST_NAME = :firstName " +
          "WHERE id = :id")
        .setParameter("id", usr.getId())
        .setParameter("firstName", usr.getName())
        .setFlushMode(FlushMode.MANUAL)
        .executeUpdate();
    }
  }

  @Override
  public boolean requiresPostCommitHanding(
    EntityPersister persister) {
    return false;
  }
}
