package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Media
{
  private java.util.Date updated;
  private String objectId;
  private String ownerId;
  private String name;

  public Project getProject() {
    return project;
  }

  public void setProject(Project project) {
    this.project = project;
  }

  private Project project;
  private String type;
  private Integer uploaded;
  private String url;
  private java.util.Date created;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public Media() {
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

  public String getType()
  {
    return type;
  }

  public void setType( String type )
  {
    this.type = type;
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

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public Media save()
  {
    return Backendless.Data.of( Media.class ).save( this );
  }

  public Future<Media> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Media> future = new Future<Media>();
      Backendless.Data.of( Media.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Media> callback )
  {
    Backendless.Data.of( Media.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Media.class ).remove( this );
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
      Backendless.Data.of( Media.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Media.class ).remove( this, callback );
  }

  public static Media findById( String id )
  {
    return Backendless.Data.of( Media.class ).findById( id );
  }

  public static Future<Media> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Media> future = new Future<Media>();
      Backendless.Data.of( Media.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Media> callback )
  {
    Backendless.Data.of( Media.class ).findById( id, callback );
  }

  public static Media findFirst()
  {
    return Backendless.Data.of( Media.class ).findFirst();
  }

  public static Future<Media> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Media> future = new Future<Media>();
      Backendless.Data.of( Media.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Media> callback )
  {
    Backendless.Data.of( Media.class ).findFirst( callback );
  }

  public static Media findLast()
  {
    return Backendless.Data.of( Media.class ).findLast();
  }

  public static Future<Media> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Media> future = new Future<Media>();
      Backendless.Data.of( Media.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Media> callback )
  {
    Backendless.Data.of( Media.class ).findLast( callback );
  }

  public static BackendlessCollection<Media> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Media.class ).find( query );
  }

  public static Future<BackendlessCollection<Media>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Media>> future = new Future<BackendlessCollection<Media>>();
      Backendless.Data.of( Media.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Media>> callback )
  {
    Backendless.Data.of( Media.class ).find( query, callback );
  }
}