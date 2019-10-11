package model;

public class MediaIdContainer {

    private String username;
    private String mediaId;
    private String timeStamp;

    public MediaIdContainer(String username, String mediaid, String timeStamp) {
        this.username = username;
        this.mediaId = mediaid;
        this.timeStamp = timeStamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
