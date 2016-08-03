package mobile.esprit.tn.mobileteam.Models;

import android.graphics.drawable.Drawable;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

import java.util.List;

public class Project
{
  private String ownerId;
  private java.util.Date updated;
  private String description;
  private String name;



  public String getImage() {
    return image;
  }

  public Project(String ownerId) {
    this.ownerId = ownerId;
  }

  public void setImage(String image) {
    this.image = image;
  }

  //test variable that should be converted to string when i use backendless
  private String image;
  private String objectId;
  private String AndroidStoreUrl;
  private String MicrosoftStoreUrl;
  private String iosStoreUrl;
  private java.util.Date created;
  private java.util.List<BackendlessUser> Members;
  private Calendar Calendar;
  private java.util.List<Technology> Technologies;
  private java.util.List<Diplomat> Diplomats;
  private java.util.List<Award> Awards;
  private java.util.List<Media> Medias;
  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription( String description )
  {
    this.description = description;
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

  public String getAndroidStoreUrl()
  {
    return AndroidStoreUrl;
  }

  public void setAndroidStoreUrl( String AndroidStoreUrl )
  {
    this.AndroidStoreUrl = AndroidStoreUrl;
  }

  public String getMicrosoftStoreUrl()
  {
    return MicrosoftStoreUrl;
  }

  public void setMicrosoftStoreUrl( String MicrosoftStoreUrl )
  {
    this.MicrosoftStoreUrl = MicrosoftStoreUrl;
  }



  public String getIosStoreUrl()
  {
    return iosStoreUrl;
  }

  public void setIosStoreUrl( String iosStoreUrl )
  {
    this.iosStoreUrl = iosStoreUrl;
  }

  public Project() {
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public java.util.List<BackendlessUser> getMembers()
  {
    return Members;
  }

  public void setMembers( java.util.List<BackendlessUser> Members )
  {
    this.Members = Members;
  }

  public Calendar getCalendar()
  {
    return Calendar;
  }

  public void setCalendar( Calendar Calendar )
  {
    this.Calendar = Calendar;
  }

  public java.util.List<Technology> getTechnologies()
  {
    return Technologies;
  }

  public void setTechnologies( java.util.List<Technology> Technologies )
  {
    this.Technologies = Technologies;
  }

  public java.util.List<Diplomat> getDiplomats()
  {
    return Diplomats;
  }

  public void setDiplomats( java.util.List<Diplomat> Diplomats )
  {
    this.Diplomats = Diplomats;
  }

  public java.util.List<Award> getAwards()
  {
    return Awards;
  }

  public void setAwards( java.util.List<Award> Awards )
  {
    this.Awards = Awards;
  }

  public java.util.List<Media> getMedias()
  {
    return Medias;
  }

  public void setMedias( java.util.List<Media> Medias )
  {
    this.Medias = Medias;
  }

                                                    
  public Project save()
  {
    return Backendless.Data.of( Project.class ).save( this );
  }

  public Future<Project> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Project> future = new Future<Project>();
      Backendless.Data.of( Project.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Project> callback )
  {
    Backendless.Data.of( Project.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Project.class ).remove( this );
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
      Backendless.Data.of( Project.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Project.class ).remove( this, callback );
  }

  public static Project findById( String id )
  {
    return Backendless.Data.of( Project.class ).findById( id );
  }

  public static Future<Project> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Project> future = new Future<Project>();
      Backendless.Data.of( Project.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Project> callback )
  {
    Backendless.Data.of( Project.class ).findById( id, callback );
  }

  public static Project findFirst()
  {
    return Backendless.Data.of( Project.class ).findFirst();
  }

  public static Future<Project> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Project> future = new Future<Project>();
      Backendless.Data.of( Project.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Project> callback )
  {
    Backendless.Data.of( Project.class ).findFirst( callback );
  }

  public static Project findLast()
  {
    return Backendless.Data.of( Project.class ).findLast();
  }

  public static Future<Project> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Project> future = new Future<Project>();
      Backendless.Data.of( Project.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Project> callback )
  {
    Backendless.Data.of( Project.class ).findLast( callback );
  }

  public static BackendlessCollection<Project> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Project.class ).find( query );
  }

  public static Future<BackendlessCollection<Project>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Project>> future = new Future<BackendlessCollection<Project>>();
      Backendless.Data.of( Project.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Project>> callback )
  {
    Backendless.Data.of( Project.class ).find( query, callback );
  }
}