package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Calendar
{
  private String objectId;
  private String name;
  private String ownerId;
  private java.util.Date created;
  private java.util.Date updated;
  public String getObjectId()
  {
    return objectId;
  }

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

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public Calendar save()
  {
    return Backendless.Data.of( Calendar.class ).save( this );
  }

  public Future<Calendar> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Calendar> future = new Future<Calendar>();
      Backendless.Data.of( Calendar.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Calendar> callback )
  {
    Backendless.Data.of( Calendar.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Calendar.class ).remove( this );
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
      Backendless.Data.of( Calendar.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Calendar.class ).remove( this, callback );
  }

  public static Calendar findById( String id )
  {
    return Backendless.Data.of( Calendar.class ).findById( id );
  }

  public static Future<Calendar> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Calendar> future = new Future<Calendar>();
      Backendless.Data.of( Calendar.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Calendar> callback )
  {
    Backendless.Data.of( Calendar.class ).findById( id, callback );
  }

  public static Calendar findFirst()
  {
    return Backendless.Data.of( Calendar.class ).findFirst();
  }

  public static Future<Calendar> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Calendar> future = new Future<Calendar>();
      Backendless.Data.of( Calendar.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Calendar> callback )
  {
    Backendless.Data.of( Calendar.class ).findFirst( callback );
  }

  public static Calendar findLast()
  {
    return Backendless.Data.of( Calendar.class ).findLast();
  }

  public static Future<Calendar> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Calendar> future = new Future<Calendar>();
      Backendless.Data.of( Calendar.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Calendar> callback )
  {
    Backendless.Data.of( Calendar.class ).findLast( callback );
  }

  public static BackendlessCollection<Calendar> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Calendar.class ).find( query );
  }

  public static Future<BackendlessCollection<Calendar>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Calendar>> future = new Future<BackendlessCollection<Calendar>>();
      Backendless.Data.of( Calendar.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Calendar>> callback )
  {
    Backendless.Data.of( Calendar.class ).find( query, callback );
  }
}