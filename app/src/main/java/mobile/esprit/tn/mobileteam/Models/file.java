package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

import java.io.Serializable;

public class file implements Serializable {
  private String objectId;
  private String filleUrl;
  private Double size;
  private java.util.Date updated;
  private String name;
  private String ownerId;
  private java.util.Date created;

  public static file findById(String id) {
    return Backendless.Data.of(file.class).findById(id);
  }

  public static Future<file> findByIdAsync(String id) {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<file> future = new Future<file>();
      Backendless.Data.of(file.class).findById(id, future);

      return future;
    }
  }

  public static void findByIdAsync(String id, AsyncCallback<file> callback) {
    Backendless.Data.of(file.class).findById(id, callback);
  }

  public static file findFirst() {
    return Backendless.Data.of(file.class).findFirst();
  }

  public static Future<file> findFirstAsync() {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<file> future = new Future<file>();
      Backendless.Data.of(file.class).findFirst(future);

      return future;
    }
  }

  public static void findFirstAsync(AsyncCallback<file> callback) {
    Backendless.Data.of(file.class).findFirst(callback);
  }

  public static file findLast() {
    return Backendless.Data.of(file.class).findLast();
  }

  public static Future<file> findLastAsync() {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<file> future = new Future<file>();
      Backendless.Data.of(file.class).findLast(future);

      return future;
    }
  }

  public static void findLastAsync(AsyncCallback<file> callback) {
    Backendless.Data.of(file.class).findLast(callback);
  }

  public static BackendlessCollection<file> find(BackendlessDataQuery query) {
    return Backendless.Data.of(file.class).find(query);
  }

  public static Future<BackendlessCollection<file>> findAsync(BackendlessDataQuery query) {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<BackendlessCollection<file>> future = new Future<BackendlessCollection<file>>();
      Backendless.Data.of(file.class).find(query, future);

      return future;
    }
  }

  public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<file>> callback) {
    Backendless.Data.of(file.class).find(query, callback);
  }

  public String getObjectId() {
    return objectId;
  }

  public String getFilleUrl() {
    return filleUrl;
  }

  public void setFilleUrl(String filleUrl) {
    this.filleUrl = filleUrl;
  }

  public Double getSize() {
    return size;
  }

  public void setSize(Double size) {
    this.size = size;
  }

  public java.util.Date getUpdated() {
    return updated;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getOwnerId() {
    return ownerId;
  }

  public java.util.Date getCreated() {
    return created;
  }

  public file save() {
    return Backendless.Data.of(file.class).save(this);
  }

  public Future<file> saveAsync() {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<file> future = new Future<file>();
      Backendless.Data.of(file.class).save(this, future);

      return future;
    }
  }

  public void saveAsync(AsyncCallback<file> callback) {
    Backendless.Data.of(file.class).save(this, callback);
  }

  public Long remove() {
    return Backendless.Data.of(file.class).remove(this);
  }

  public Future<Long> removeAsync() {
    if (Backendless.isAndroid()) {
      throw new UnsupportedOperationException("Using this method is restricted in Android");
    } else {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of(file.class).remove(this, future);

      return future;
    }
  }

  public void removeAsync(AsyncCallback<Long> callback) {
    Backendless.Data.of(file.class).remove(this, callback);
  }
}