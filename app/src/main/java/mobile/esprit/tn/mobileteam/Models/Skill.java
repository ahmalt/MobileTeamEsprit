package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Skill
{
  private String ownerId;
  private java.util.Date updated;
  private java.util.Date created;
  private String objectId;
  private String name;

  public static Skill findById(String id)
  {
    return Backendless.Data.of(Skill.class).findById(id);
  }

  public static Future<Skill> findByIdAsync(String id)
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Skill> future = new Future<Skill>();
      Backendless.Data.of(Skill.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<Skill> callback)
  {
    Backendless.Data.of(Skill.class).findById(id, callback);
  }

  public static Skill findFirst()
  {
    return Backendless.Data.of(Skill.class).findFirst();
  }

  public static Future<Skill> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Skill> future = new Future<Skill>();
      Backendless.Data.of(Skill.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<Skill> callback)
  {
    Backendless.Data.of(Skill.class).findFirst(callback);
  }

  public static Skill findLast()
  {
    return Backendless.Data.of(Skill.class).findLast();
  }

  public static Future<Skill> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Skill> future = new Future<Skill>();
      Backendless.Data.of(Skill.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<Skill> callback)
  {
    Backendless.Data.of(Skill.class).findLast(callback);
  }

  public static BackendlessCollection<Skill> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(Skill.class).find(query);
  }

  public static Future<BackendlessCollection<Skill>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Skill>> future = new Future<BackendlessCollection<Skill>>();
      Backendless.Data.of(Skill.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Skill>> callback)
  {
    Backendless.Data.of(Skill.class).find(query, callback);
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated() {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public Skill save() {
    return Backendless.Data.of(Skill.class).save(this);
  }

  public Future<Skill> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Skill> future = new Future<Skill>();
      Backendless.Data.of(Skill.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<Skill> callback)
  {
    Backendless.Data.of(Skill.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(Skill.class).remove(this);
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of(Skill.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(Skill.class).remove(this, callback);
  }
}