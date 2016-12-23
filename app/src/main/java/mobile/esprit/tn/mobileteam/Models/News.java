package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class News
{
  private String ownerId;
  private String objectId;
  private java.util.Date created;
  private java.util.Date updated;
  private String name;
  private String description;
  private java.util.List<Video> medias;

  public static News findById(String id)
  {
    return Backendless.Data.of(News.class).findById(id);
  }

  public static Future<News> findByIdAsync(String id)
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<News> future = new Future<News>();
      Backendless.Data.of(News.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<News> callback)
  {
    Backendless.Data.of(News.class).findById(id, callback);
  }

  public static News findFirst()
  {
    return Backendless.Data.of(News.class).findFirst();
  }

  public static Future<News> findFirstAsync()
  {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<News> future = new Future<News>();
      Backendless.Data.of(News.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<News> callback)
  {
    Backendless.Data.of(News.class).findFirst(callback);
  }

  public static News findLast()
  {
    return Backendless.Data.of(News.class).findLast();
  }

  public static Future<News> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<News> future = new Future<News>();
      Backendless.Data.of(News.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<News> callback)
  {
    Backendless.Data.of(News.class).findLast(callback);
  }

  public static BackendlessCollection<News> find(BackendlessDataQuery query)
  {
    return Backendless.Data.of(News.class).find(query);
  }

  public static Future<BackendlessCollection<News>> findAsync(BackendlessDataQuery query)
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<News>> future = new Future<BackendlessCollection<News>>();
      Backendless.Data.of(News.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<News>> callback)
  {
    Backendless.Data.of(News.class).find(query, callback);
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated() {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  public java.util.List<Video> getMedias()
  {
    return medias;
  }

  public void setMedias(java.util.List<Video> medias)
  {
    this.medias = medias;
  }

  public News save() {
    return Backendless.Data.of(News.class).save(this);
  }

  public Future<News> saveAsync() {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<News> future = new Future<News>();
      Backendless.Data.of(News.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<News> callback)
  {
    Backendless.Data.of(News.class).save(this, callback);
  }

  public Long remove()
  {
    return Backendless.Data.of(News.class).remove(this);
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
      Backendless.Data.of(News.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback)
  {
    Backendless.Data.of(News.class).remove(this, callback);
  }
}