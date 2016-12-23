package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Events
{
  private java.util.Date updated;
  private String name;
  private String description;
  private java.util.Date created;
  private java.util.Date eventdate;
  private String ownerId;
  private String objectId;
  private java.util.List<Video> medias;

  public static Events findById(String id)
  {
    return Backendless.Data.of(Events.class).findById(id);
  }

  public static Future<Events> findByIdAsync(String id)
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Events> future = new Future<Events>();
      Backendless.Data.of(Events.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<Events> callback)
  {
    Backendless.Data.of(Events.class).findById(id, callback);
  }

  public static Events findFirst()
  {
    return Backendless.Data.of(Events.class).findFirst();
  }

  public static Future<Events> findFirstAsync()
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Events> future = new Future<Events>();
      Backendless.Data.of(Events.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<Events> callback)
  {
    Backendless.Data.of(Events.class).findFirst(callback);
  }

  public static Events findLast()
  {
    return Backendless.Data.of(Events.class).findLast();
  }

  public static Future<Events> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Events> future = new Future<Events>();
      Backendless.Data.of(Events.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<Events> callback)
  {
    Backendless.Data.of(Events.class).findLast(callback);
  }

  public static BackendlessCollection<Events> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(Events.class).find(query);
  }

  public static Future<BackendlessCollection<Events>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Events>> future = new Future<BackendlessCollection<Events>>();
      Backendless.Data.of(Events.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Events>> callback)
  {
    Backendless.Data.of(Events.class).find(query, callback);
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getEventdate() {
    return eventdate;
  }

  public void setEventdate(java.util.Date eventdate)
  {
    this.eventdate = eventdate;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.List<Video> getMedias() {
    return medias;
  }

  public void setMedias(java.util.List<Video> medias) {
    this.medias = medias;
  }

  public Events save() {
    return Backendless.Data.of(Events.class).save(this);
  }

  public Future<Events> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Events> future = new Future<Events>();
      Backendless.Data.of(Events.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<Events> callback)
  {
    Backendless.Data.of(Events.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(Events.class).remove(this);
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
      Backendless.Data.of(Events.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(Events.class).remove(this, callback);
  }
}