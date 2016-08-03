package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Diplomat
{
  private String name;
  private String ownerId;
  private String objectId;
  private java.util.Date created;
  private java.util.Date updated;
  private University Unisersities;
  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public University getUnisersities()
  {
    return Unisersities;
  }

  public void setUnisersities( University Unisersities )
  {
    this.Unisersities = Unisersities;
  }

                                                    
  public Diplomat save()
  {
    return Backendless.Data.of( Diplomat.class ).save( this );
  }

  public Future<Diplomat> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Diplomat> future = new Future<Diplomat>();
      Backendless.Data.of( Diplomat.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Diplomat> callback )
  {
    Backendless.Data.of( Diplomat.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Diplomat.class ).remove( this );
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
      Backendless.Data.of( Diplomat.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Diplomat.class ).remove( this, callback );
  }

  public static Diplomat findById( String id )
  {
    return Backendless.Data.of( Diplomat.class ).findById( id );
  }

  public static Future<Diplomat> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Diplomat> future = new Future<Diplomat>();
      Backendless.Data.of( Diplomat.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Diplomat> callback )
  {
    Backendless.Data.of( Diplomat.class ).findById( id, callback );
  }

  public static Diplomat findFirst()
  {
    return Backendless.Data.of( Diplomat.class ).findFirst();
  }

  public static Future<Diplomat> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Diplomat> future = new Future<Diplomat>();
      Backendless.Data.of( Diplomat.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Diplomat> callback )
  {
    Backendless.Data.of( Diplomat.class ).findFirst( callback );
  }

  public static Diplomat findLast()
  {
    return Backendless.Data.of( Diplomat.class ).findLast();
  }

  public static Future<Diplomat> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Diplomat> future = new Future<Diplomat>();
      Backendless.Data.of( Diplomat.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Diplomat> callback )
  {
    Backendless.Data.of( Diplomat.class ).findLast( callback );
  }

  public static BackendlessCollection<Diplomat> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Diplomat.class ).find( query );
  }

  public static Future<BackendlessCollection<Diplomat>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Diplomat>> future = new Future<BackendlessCollection<Diplomat>>();
      Backendless.Data.of( Diplomat.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Diplomat>> callback )
  {
    Backendless.Data.of( Diplomat.class ).find( query, callback );
  }
}