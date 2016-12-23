package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Technology
{
  private String ownerId;
  private java.util.Date created;
  private String objectId;
  private java.util.Date updated;

  public static Technology findById(String id)
  {
    return Backendless.Data.of(Technology.class).findById(id);
  }

  public static Future<Technology> findByIdAsync(String id)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Technology> future = new Future<Technology>();
      Backendless.Data.of(Technology.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<Technology> callback)
  {
    Backendless.Data.of(Technology.class).findById(id, callback);
  }

  public static Technology findFirst()
  {
    return Backendless.Data.of(Technology.class).findFirst();
  }

  public static Future<Technology> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Technology> future = new Future<Technology>();
      Backendless.Data.of(Technology.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<Technology> callback)
  {
    Backendless.Data.of(Technology.class).findFirst(callback);
  }

  public static Technology findLast()
  {
    return Backendless.Data.of(Technology.class).findLast();
  }

  public static Future<Technology> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Technology> future = new Future<Technology>();
      Backendless.Data.of(Technology.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<Technology> callback)
  {
    Backendless.Data.of(Technology.class).findLast(callback);
  }

  public static BackendlessCollection<Technology> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(Technology.class).find(query);
  }

  public static Future<BackendlessCollection<Technology>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Technology>> future = new Future<BackendlessCollection<Technology>>();
      Backendless.Data.of(Technology.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Technology>> callback)
  {
    Backendless.Data.of(Technology.class).find(query, callback);
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId() {
    return objectId;
  }

  public java.util.Date getUpdated() {
    return updated;
  }

  public Technology save() {
    return Backendless.Data.of(Technology.class).save(this);
  }

  public Future<Technology> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Technology> future = new Future<Technology>();
      Backendless.Data.of(Technology.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<Technology> callback)
  {
    Backendless.Data.of(Technology.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(Technology.class).remove(this);
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
      Backendless.Data.of(Technology.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(Technology.class).remove(this, callback);
  }
}