package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Entreprise
{
  private String objectId;
  private String ownerId;
  private String name;
  private java.util.Date created;
  private java.util.Date updated;

  public static Entreprise findById(String id)
  {
    return Backendless.Data.of(Entreprise.class).findById(id);
  }

  public static Future<Entreprise> findByIdAsync(String id)
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Entreprise> future = new Future<Entreprise>();
      Backendless.Data.of(Entreprise.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<Entreprise> callback)
  {
    Backendless.Data.of(Entreprise.class).findById(id, callback);
  }

  public static Entreprise findFirst()
  {
    return Backendless.Data.of(Entreprise.class).findFirst();
  }

  public static Future<Entreprise> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Entreprise> future = new Future<Entreprise>();
      Backendless.Data.of(Entreprise.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<Entreprise> callback)
  {
    Backendless.Data.of(Entreprise.class).findFirst(callback);
  }

  public static Entreprise findLast()
  {
    return Backendless.Data.of(Entreprise.class).findLast();
  }

  public static Future<Entreprise> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Entreprise> future = new Future<Entreprise>();
      Backendless.Data.of(Entreprise.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<Entreprise> callback)
  {
    Backendless.Data.of(Entreprise.class).findLast(callback);
  }

  public static BackendlessCollection<Entreprise> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(Entreprise.class).find(query);
  }

  public static Future<BackendlessCollection<Entreprise>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Entreprise>> future = new Future<BackendlessCollection<Entreprise>>();
      Backendless.Data.of(Entreprise.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Entreprise>> callback)
  {
    Backendless.Data.of(Entreprise.class).find(query, callback);
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public Entreprise save() {
    return Backendless.Data.of(Entreprise.class).save(this);
  }

  public Future<Entreprise> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Entreprise> future = new Future<Entreprise>();
      Backendless.Data.of(Entreprise.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<Entreprise> callback)
  {
    Backendless.Data.of(Entreprise.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(Entreprise.class).remove(this);
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
      Backendless.Data.of(Entreprise.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(Entreprise.class).remove(this, callback);
  }
}