package model;

public class InstagramUserRecord {

    private String name;
    private long pk;
    private String bio;
    private long followingCount;
    private long followersCount;
    private long mediaCount;
    private String phoneNumber;
    private String mail;


    public InstagramUserRecord() {
        this.name = "";
        this.bio = "";
        this.followersCount = 0;
        this.followersCount = 0;
        this.mediaCount = 0;
        this.phoneNumber = "";
        this.mail = "";
        this.pk = 0;
    }

    @Override
    public String toString() {
        return "InstagramUserRecord{" +
                "name='" + name + '\'' +
                ", pk=" + pk +
                ", bio='" + bio + '\'' +
                ", followingCount=" + followingCount +
                ", followersCount=" + followersCount +
                ", mediaCount=" + mediaCount +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }

    public long getPk() {
        return pk;
    }

    public void setPk(long pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public long getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(long followingCount) {
        this.followingCount = followingCount;
    }

    public long getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(long followersCount) {
        this.followersCount = followersCount;
    }

    public long getMediaCount() {
        return mediaCount;
    }

    public void setMediaCount(long mediaCount) {
        this.mediaCount = mediaCount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }


}
