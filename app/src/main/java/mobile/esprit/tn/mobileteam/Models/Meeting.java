package mobile.esprit.tn.mobileteam.Models;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Meeting {
    private String objectId;
    private String name;
    private java.util.Date DateEnd;
    private String ownerId;
    private java.util.Date created;
    private java.util.Date updated;
    private java.util.Date dateStart;
    private Project Projets;
    private java.util.List<BackendlessUser> Users;

    public static Meeting findById(String id) {
        return Backendless.Data.of(Meeting.class).findById(id);
    }

    public static Future<Meeting> findByIdAsync(String id) {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<Meeting> future = new Future<Meeting>();
            Backendless.Data.of(Meeting.class).findById(id, future);

            return future;
        }
    }

    public static void findByIdAsync(String id, AsyncCallback<Meeting> callback) {
        Backendless.Data.of(Meeting.class).findById(id, callback);
    }

    public static Meeting findFirst() {
        return Backendless.Data.of(Meeting.class).findFirst();
    }

    public static Future<Meeting> findFirstAsync() {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<Meeting> future = new Future<Meeting>();
            Backendless.Data.of(Meeting.class).findFirst(future);

            return future;
        }
    }

    public static void findFirstAsync(AsyncCallback<Meeting> callback) {
        Backendless.Data.of(Meeting.class).findFirst(callback);
    }

    public static Meeting findLast() {
        return Backendless.Data.of(Meeting.class).findLast();
    }

    public static Future<Meeting> findLastAsync() {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<Meeting> future = new Future<Meeting>();
            Backendless.Data.of(Meeting.class).findLast(future);

            return future;
        }
    }

    public static void findLastAsync(AsyncCallback<Meeting> callback) {
        Backendless.Data.of(Meeting.class).findLast(callback);
    }

    public static BackendlessCollection<Meeting> find(BackendlessDataQuery query) {
        return Backendless.Data.of(Meeting.class).find(query);
    }

    public static Future<BackendlessCollection<Meeting>> findAsync(BackendlessDataQuery query) {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<BackendlessCollection<Meeting>> future = new Future<BackendlessCollection<Meeting>>();
            Backendless.Data.of(Meeting.class).find(query, future);

            return future;
        }
    }

    public static void findAsync(BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Meeting>> callback) {
        Backendless.Data.of(Meeting.class).find(query, callback);
    }

    public String getObjectId() {
        return objectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public java.util.Date getDateEnd() {
        return DateEnd;
    }

    public void setDateEnd(java.util.Date DateEnd) {
        this.DateEnd = DateEnd;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public java.util.Date getCreated() {
        return created;
    }

    public java.util.Date getUpdated() {
        return updated;
    }

    public java.util.Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(java.util.Date dateStart) {
        this.dateStart = dateStart;
    }

    public Project getProjets() {
        return Projets;
    }

    public void setProjets(Project Projets) {
        this.Projets = Projets;
    }

    public java.util.List<BackendlessUser> getUsers() {
        return Users;
    }

    public void setUsers(java.util.List<BackendlessUser> Users) {
        this.Users = Users;
    }

    public Meeting save() {
        return Backendless.Data.of(Meeting.class).save(this);
    }

    public Future<Meeting> saveAsync() {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<Meeting> future = new Future<Meeting>();
            Backendless.Data.of(Meeting.class).save(this, future);

            return future;
        }
    }

    public void saveAsync(AsyncCallback<Meeting> callback) {
        Backendless.Data.of(Meeting.class).save(this, callback);
    }

    public Long remove() {
        return Backendless.Data.of(Meeting.class).remove(this);
    }

    public Future<Long> removeAsync() {
        if (Backendless.isAndroid()) {
            throw new UnsupportedOperationException("Using this method is restricted in Android");
        } else {
            Future<Long> future = new Future<Long>();
            Backendless.Data.of(Meeting.class).remove(this, future);

            return future;
        }
    }

    public void removeAsync(AsyncCallback<Long> callback) {
        Backendless.Data.of(Meeting.class).remove(this, callback);
    }
}