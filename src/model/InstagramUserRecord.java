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

    private Boolean isVerfied;
    private String externalUrl;
    private Long nrOfHighlights;
    private Boolean isBusinessAccount;
    private Boolean isRecentlyJoined;
    private String businessCategoryName;

    public InstagramUserRecord() {
        this.name = "";
        this.pk = 0;
        this.mail = "";
        this.nrOfHighlights = new Long(0);
        this.isVerfied = false;
        this.externalUrl = "";
        this.isBusinessAccount = false;
        this.isRecentlyJoined = false;
        this.businessCategoryName = "";
        this.bio = "";
        this.followersCount = 0;
        this.followingCount = 0;
        this.mediaCount = 0;
        this.phoneNumber ="";
    }

    public Boolean getVerfied() {
        return isVerfied;
    }

    public void setVerfied(Boolean verfied) {
        isVerfied = verfied;
    }

    public String getExternalUrl() {
        return externalUrl;
    }

    public void setExternalUrl(String externalUrl) {
        this.externalUrl = externalUrl;
    }

    public Long getNrOfHighlights() {
        return nrOfHighlights;
    }

    public void setNrOfHighlights(Long nrOfHighlights) {
        this.nrOfHighlights = nrOfHighlights;
    }

    public Boolean getBusinessAccount() {
        return isBusinessAccount;
    }

    public void setBusinessAccount(Boolean businessAccount) {
        isBusinessAccount = businessAccount;
    }

    public Boolean getRecentlyJoined() {
        return isRecentlyJoined;
    }

    public void setRecentlyJoined(Boolean recentlyJoined) {
        isRecentlyJoined = recentlyJoined;
    }

    public String getBusinessCategoryName() {
        return businessCategoryName;
    }

    public void setBusinessCategoryName(String businessCategoryName) {
        this.businessCategoryName = businessCategoryName;
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
