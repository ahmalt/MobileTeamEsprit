package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Award
{
  private java.util.Date updated;
  private String name;
  private String objectId;
  private String description;
  private String ownerId;
  private java.util.Date created;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( String description )
  {
    this.description = description;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public Award save()
  {
    return Backendless.Data.of( Award.class ).save( this );
  }

  public Future<Award> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Award> future = new Future<Award>();
      Backendless.Data.of( Award.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Award> callback )
  {
    Backendless.Data.of( Award.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Award.class ).remove( this );
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
      Backendless.Data.of( Award.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Award.class ).remove( this, callback );
  }

  public static Award findById( String id )
  {
    return Backendless.Data.of( Award.class ).findById( id );
  }

  public static Future<Award> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Award> future = new Future<Award>();
      Backendless.Data.of( Award.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Award> callback )
  {
    Backendless.Data.of( Award.class ).findById( id, callback );
  }

  public static Award findFirst()
  {
    return Backendless.Data.of( Award.class ).findFirst();
  }

  public static Future<Award> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Award> future = new Future<Award>();
      Backendless.Data.of( Award.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Award> callback )
  {
    Backendless.Data.of( Award.class ).findFirst( callback );
  }

  public static Award findLast()
  {
    return Backendless.Data.of( Award.class ).findLast();
  }

  public static Future<Award> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Award> future = new Future<Award>();
      Backendless.Data.of( Award.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Award> callback )
  {
    Backendless.Data.of( Award.class ).findLast( callback );
  }

  public static BackendlessCollection<Award> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Award.class ).find( query );
  }

  public static Future<BackendlessCollection<Award>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Award>> future = new Future<BackendlessCollection<Award>>();
      Backendless.Data.of( Award.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Award>> callback )
  {
    Backendless.Data.of( Award.class ).find( query, callback );
  }
}