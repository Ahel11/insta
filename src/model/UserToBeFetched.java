package model;

public class UserToBeFetched {

    String username;
    boolean hasBeenAddedToDb;
    boolean hasBeenFetched;

    public UserToBeFetched(String name) {
        username = name;
        hasBeenAddedToDb = false;
        hasBeenFetched = false;
    }

    @Override
    public boolean equals(Object o) {
        if(this.username == ((UserToBeFetched)o).username) {
            return true;
        } else {
            return false;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isHasBeenAddedToDb() {
        return hasBeenAddedToDb;
    }

    public void setHasBeenAddedToDb(boolean hasBeenAddedToDb) {
        this.hasBeenAddedToDb = hasBeenAddedToDb;
    }

    public boolean isHasBeenFetched() {
        return hasBeenFetched;
    }

    public void setHasBeenFetched(boolean hasBeenFetched) {
        this.hasBeenFetched = hasBeenFetched;
    }
}
