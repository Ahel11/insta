package model;

public class SearchQuery {

    private String keywords;
    private Long minNrFollowing;
    private Long minNrFollowers;
    private Long minNrOfHighLights;
    private Boolean isVerifiedAccount;
    private Boolean isBusinessAccount;
    private Boolean isRecentlyJoinedAccount;
    private String businessCategory;
    private Boolean isHaveMailAddress;
    private Long followingFollowerRatio;

    @Override
    public String toString() {
        return "SearchQuery{" +
                "keywords='" + keywords + '\'' +
                ", minNrFollowing=" + minNrFollowing +
                ", minNrFollowers=" + minNrFollowers +
                ", minNrOfHighLights=" + minNrOfHighLights +
                ", isVerifiedAccount=" + isVerifiedAccount +
                ", isBusinessAccount=" + isBusinessAccount +
                ", isRecentlyJoinedAccount=" + isRecentlyJoinedAccount +
                ", businessCategory='" + businessCategory + '\'' +
                ", isHaveMailAddress=" + isHaveMailAddress +
                ", followingFollowerRatio=" + followingFollowerRatio +
                '}';
    }

    public String getKeywords() {
        return keywords;
    }

    public Long getMinNrFollowing() {
        return minNrFollowing;
    }

    public Long getMinNrFollowers() {
        return minNrFollowers;
    }

    public Long getMinNrOfHighLights() {
        return minNrOfHighLights;
    }

    public Boolean getVerifiedAccount() {
        return isVerifiedAccount;
    }

    public Boolean getBusinessAccount() {
        return isBusinessAccount;
    }

    public Boolean getRecentlyJoinedAccount() {
        return isRecentlyJoinedAccount;
    }

    public String getBusinessCategory() {
        return businessCategory;
    }

    public Boolean getHaveMailAddress() {
        return isHaveMailAddress;
    }

    public Long getFollowingFollowerRatio() {
        return followingFollowerRatio;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setMinNrFollowing(Long minNrFollowing) {
        this.minNrFollowing = minNrFollowing;
    }

    public void setMinNrFollowers(Long minNrFollowers) {
        this.minNrFollowers = minNrFollowers;
    }

    public void setMinNrOfHighLights(Long minNrOfHighLights) {
        this.minNrOfHighLights = minNrOfHighLights;
    }

    public void setVerifiedAccount(Boolean verifiedAccount) {
        isVerifiedAccount = verifiedAccount;
    }

    public void setBusinessAccount(Boolean businessAccount) {
        isBusinessAccount = businessAccount;
    }

    public void setRecentlyJoinedAccount(Boolean recentlyJoinedAccount) {
        isRecentlyJoinedAccount = recentlyJoinedAccount;
    }

    public void setBusinessCategory(String businessCategory) {
        this.businessCategory = businessCategory;
    }

    public void setHaveMailAddress(Boolean haveMailAddress) {
        isHaveMailAddress = haveMailAddress;
    }

    public void setFollowingFollowerRatio(Long followingFollowerRatio) {
        this.followingFollowerRatio = followingFollowerRatio;
    }
}
