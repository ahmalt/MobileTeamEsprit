package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class University
{
  private String ownerId;
  private java.util.Date created;
  private String objectId;
  private java.util.Date updated;

  public static University findById(String id)
  {
    return Backendless.Data.of(University.class).findById(id);
  }

  public static Future<University> findByIdAsync(String id)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<University> future = new Future<University>();
      Backendless.Data.of(University.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<University> callback)
  {
    Backendless.Data.of(University.class).findById(id, callback);
  }

  public static University findFirst()
  {
    return Backendless.Data.of(University.class).findFirst();
  }

  public static Future<University> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<University> future = new Future<University>();
      Backendless.Data.of(University.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<University> callback)
  {
    Backendless.Data.of(University.class).findFirst(callback);
  }

  public static University findLast()
  {
    return Backendless.Data.of(University.class).findLast();
  }

  public static Future<University> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<University> future = new Future<University>();
      Backendless.Data.of(University.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<University> callback)
  {
    Backendless.Data.of(University.class).findLast(callback);
  }

  public static BackendlessCollection<University> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(University.class).find(query);
  }

  public static Future<BackendlessCollection<University>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<University>> future = new Future<BackendlessCollection<University>>();
      Backendless.Data.of(University.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<University>> callback)
  {
    Backendless.Data.of(University.class).find(query, callback);
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

  public University save() {
    return Backendless.Data.of(University.class).save(this);
  }

  public Future<University> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<University> future = new Future<University>();
      Backendless.Data.of(University.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<University> callback)
  {
    Backendless.Data.of(University.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(University.class).remove(this);
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
      Backendless.Data.of(University.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(University.class).remove(this, callback);
  }
}