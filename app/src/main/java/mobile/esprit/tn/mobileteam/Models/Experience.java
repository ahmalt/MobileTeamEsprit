package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Experience
{
  private String ownerId;
  private java.util.Date created;
  private String name;
  private String objectId;
  private java.util.Date updated;
  private Entreprise Entreprise;

  public static Experience findById(String id)
  {
    return Backendless.Data.of(Experience.class).findById(id);
  }

  public static Future<Experience> findByIdAsync(String id)
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Experience> future = new Future<Experience>();
      Backendless.Data.of(Experience.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<Experience> callback)
  {
    Backendless.Data.of(Experience.class).findById(id, callback);
  }

  public static Experience findFirst()
  {
    return Backendless.Data.of(Experience.class).findFirst();
  }

  public static Future<Experience> findFirstAsync()
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Experience> future = new Future<Experience>();
      Backendless.Data.of(Experience.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<Experience> callback)
  {
    Backendless.Data.of(Experience.class).findFirst(callback);
  }

  public static Experience findLast()
  {
    return Backendless.Data.of(Experience.class).findLast();
  }

  public static Future<Experience> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Experience> future = new Future<Experience>();
      Backendless.Data.of(Experience.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<Experience> callback)
  {
    Backendless.Data.of(Experience.class).findLast(callback);
  }

  public static BackendlessCollection<Experience> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(Experience.class).find(query);
  }

  public static Future<BackendlessCollection<Experience>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Experience>> future = new Future<BackendlessCollection<Experience>>();
      Backendless.Data.of(Experience.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Experience>> callback)
  {
    Backendless.Data.of(Experience.class).find(query, callback);
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getName() {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public Entreprise getEntreprise() {
    return Entreprise;
  }

  public void setEntreprise(Entreprise Entreprise)
  {
    this.Entreprise = Entreprise;
  }

  public Experience save()
  {
    return Backendless.Data.of(Experience.class).save(this);
  }

  public Future<Experience> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Experience> future = new Future<Experience>();
      Backendless.Data.of(Experience.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<Experience> callback)
  {
    Backendless.Data.of(Experience.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(Experience.class).remove(this);
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
      Backendless.Data.of(Experience.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(Experience.class).remove(this, callback);
  }
}