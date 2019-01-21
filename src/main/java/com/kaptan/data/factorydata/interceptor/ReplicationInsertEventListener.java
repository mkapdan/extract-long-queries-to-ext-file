package com.kaptan.data.factorydata.interceptor;

import com.kaptan.data.factorydata.entity.Person;
import com.kaptan.data.factorydata.entity.User;
import org.hibernate.FlushMode;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.PostInsertEvent;
import org.hibernate.event.spi.PostInsertEventListener;
import org.hibernate.persister.entity.EntityPersister;

public class ReplicationInsertEventListener
  implements PostInsertEventListener {

  public static final ReplicationInsertEventListener INSTANCE =
    new ReplicationInsertEventListener();

  @Override
  public void onPostInsert(
    PostInsertEvent event)
    throws HibernateException {
    final Object entity = event.getEntity();

    if (entity instanceof User) {
      User usr = (User) entity;

      event.getSession().createNativeQuery(
        "INSERT INTO T_USER_OLD (id, FIRST_NAME) " +
          "VALUES (:id, :firstName)")
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
