package model;

import org.junit.Test;

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
    private Double followingFollowerRatio;

    @Test
    public void testSearchQuery() {
        SearchQuery query = new SearchQuery();
        query.setFollowingFollowerRatio(new Double(1.3));
        query.setMinNrFollowing(55L);
        query.setMinNrFollowers(95L);
        query.setVerifiedAccount(true);
        query.setBusinessAccount(false);
        query.setRecentlyJoinedAccount(false);
        query.setBusinessCategory("Tempus");
        query.setKeywords("tempus,inerga,mastuberga,hitlerierga");
        query.setHaveMailAddress(true);

        String sqlCommand = query.generateSql();
        System.out.println(sqlCommand + "\n");

    }

    public String generateSql() {

        String SQLCommand = "SELECT * FROM FROM instagramuser\nWHERE " +
                "instagramuser.FollowingCount >= " + this.getMinNrFollowing() +
                "\nAND instagramuser.FollowerCount >= " + this.getMinNrFollowers() +
                "\nAND instagramuser.IsVerified = " + this.getVerifiedAccount() +
                "\nAND instagramuser.IsBusinessAccount = " + this.getBusinessAccount() +
                "\nAND instagramuser.IsRecentlyJoined = " + this.getRecentlyJoinedAccount() +
                //Add mail also
                generateKeywordStringSearch() ;

        return SQLCommand;
    }

    private String generateKeywordStringSearch() {
        String toReturn="";
        String splittedKeyWords[] = this.getKeywords().split(",");
        for(String currKey: splittedKeyWords) {
            toReturn = toReturn + "\nAND instagramuser.BioAndDesc like '%" + currKey + "%'";
        }
        return toReturn;
    }


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

    public Double getFollowingFollowerRatio() {
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

    public void setFollowingFollowerRatio(Double followingFollowerRatio) {
        this.followingFollowerRatio = followingFollowerRatio;
    }
}
