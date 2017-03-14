package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Video
{
  private java.util.Date updated;
  private String objectId;
  private String youtubeId;
  private String ownerId;
  private String name;
  private String imageUrl;
  private Integer uploaded;
  private String url;
  private String size;
  private java.util.Date created;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getYoutubeId()
  {
    return youtubeId;
  }

  public void setYoutubeId( String youtubeId )
  {
    this.youtubeId = youtubeId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getImageUrl()
  {
    return imageUrl;
  }

  public void setImageUrl( String imageUrl )
  {
    this.imageUrl = imageUrl;
  }

  public Integer getUploaded()
  {
    return uploaded;
  }

  public void setUploaded( Integer uploaded )
  {
    this.uploaded = uploaded;
  }

  public String getUrl()
  {
    return url;
  }

  public void setUrl( String url )
  {
    this.url = url;
  }

  public String getSize()
  {
    return size;
  }

  public void setSize( String size )
  {
    this.size = size;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public Video save()
  {
    return Backendless.Data.of( Video.class ).save( this );
  }

  public Future<Video> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Video> future = new Future<Video>();
      Backendless.Data.of( Video.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Video> callback )
  {
    Backendless.Data.of( Video.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Video.class ).remove( this );
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
      Backendless.Data.of( Video.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Video.class ).remove( this, callback );
  }

  public static Video findById( String id )
  {
    return Backendless.Data.of( Video.class ).findById( id );
  }

  public static Future<Video> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Video> future = new Future<Video>();
      Backendless.Data.of( Video.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Video> callback )
  {
    Backendless.Data.of( Video.class ).findById( id, callback );
  }

  public static Video findFirst()
  {
    return Backendless.Data.of( Video.class ).findFirst();
  }

  public static Future<Video> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Video> future = new Future<Video>();
      Backendless.Data.of( Video.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Video> callback )
  {
    Backendless.Data.of( Video.class ).findFirst( callback );
  }

  public static Video findLast()
  {
    return Backendless.Data.of( Video.class ).findLast();
  }

  public static Future<Video> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Video> future = new Future<Video>();
      Backendless.Data.of( Video.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Video> callback )
  {
    Backendless.Data.of( Video.class ).findLast( callback );
  }

  public static BackendlessCollection<Video> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Video.class ).find( query );
  }

  public static Future<BackendlessCollection<Video>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Video>> future = new Future<BackendlessCollection<Video>>();
      Backendless.Data.of( Video.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Video>> callback )
  {
    Backendless.Data.of( Video.class ).find( query, callback );
  }
}