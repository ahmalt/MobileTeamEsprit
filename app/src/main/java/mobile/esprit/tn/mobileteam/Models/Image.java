package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Image
{
  private java.util.Date created;
  private String Url;
  private String objectId;
  private java.util.Date updated;
  private String ownerId;
  public java.util.Date getCreated()
  {
    return created;
  }

  public String getUrl()
  {
    return Url;
  }

  public void setUrl( String Url )
  {
    this.Url = Url;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public Image save()
  {
    return Backendless.Data.of( Image.class ).save( this );
  }

  public Future<Image> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Image> future = new Future<Image>();
      Backendless.Data.of( Image.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Image> callback )
  {
    Backendless.Data.of( Image.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Image.class ).remove( this );
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
      Backendless.Data.of( Image.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Image.class ).remove( this, callback );
  }

  public static Image findById( String id )
  {
    return Backendless.Data.of( Image.class ).findById( id );
  }

  public static Future<Image> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Image> future = new Future<Image>();
      Backendless.Data.of( Image.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Image> callback )
  {
    Backendless.Data.of( Image.class ).findById( id, callback );
  }

  public static Image findFirst()
  {
    return Backendless.Data.of( Image.class ).findFirst();
  }

  public static Future<Image> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Image> future = new Future<Image>();
      Backendless.Data.of( Image.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Image> callback )
  {
    Backendless.Data.of( Image.class ).findFirst( callback );
  }

  public static Image findLast()
  {
    return Backendless.Data.of( Image.class ).findLast();
  }

  public static Future<Image> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Image> future = new Future<Image>();
      Backendless.Data.of( Image.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Image> callback )
  {
    Backendless.Data.of( Image.class ).findLast( callback );
  }

  public static BackendlessCollection<Image> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Image.class ).find( query );
  }

  public static Future<BackendlessCollection<Image>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Image>> future = new Future<BackendlessCollection<Image>>();
      Backendless.Data.of( Image.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Image>> callback )
  {
    Backendless.Data.of( Image.class ).find( query, callback );
  }
}