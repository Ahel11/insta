package handlers;

import model.InstagramUserRecord;
import org.json.JSONObject;

public class AccountConverterHandler {


    public AccountConverterHandler() {

    }

    public InstagramUserRecord convertHtmlToInstagramUserRecord(String html) {
        InstagramUserRecord recToReturn = new InstagramUserRecord();

        Long followedBy = extractFollowedBy(html);
        Long following = extractFollowing(html);
        String bio = extractBiography(html);
        String externalUrl = extractExternalUrl(html);
        Long nrOfHighlights = extractHighLightNumber(html);
        Boolean isBusinessAccount = extractIsBusinessAccount(html);
        Boolean isRecentlyJoined = extractIsRecentlyJoined(html);
        String businessCategoryName = extractBusinessCategoryName(html);
        Boolean isVerified = extractIsVerified(html);

        recToReturn.setFollowersCount(followedBy);
        recToReturn.setFollowingCount(following);
        recToReturn.setBio(bio);
        recToReturn.setExternalUrl(externalUrl);
        recToReturn.setNrOfHighlights(nrOfHighlights);
        recToReturn.setBusinessAccount(isBusinessAccount);
        recToReturn.setRecentlyJoined(isRecentlyJoined);
        recToReturn.setBusinessCategoryName(businessCategoryName);
        recToReturn.setVerfied(isVerified);


        return recToReturn;
    }

    private Boolean extractIsVerified(String html) {

        Boolean isRecentlyJoinedBoolean = new Boolean(true);
        try {
            String isRecentlyJoinedArr[] = html.split("is_verified\":");
            String isRecentlyJoinedStr = isRecentlyJoinedArr[1];
            isRecentlyJoinedStr = isRecentlyJoinedStr.split(",")[0];
            isRecentlyJoinedBoolean = new Boolean(isRecentlyJoinedStr);
            return isRecentlyJoinedBoolean;
        }catch (Exception e) {
            return false;
        }
    }

    private String extractBusinessCategoryName(String html) {
        try {
            String tokens[] = html.split("business_category_name\":");
            String tokenItem = tokens[1];
            String tokenText = tokenItem.split(",")[0];
            tokenText = tokenText.replace(String.valueOf('"'), "");
            return tokenText;
        }catch (Exception e) {
            return "";
        }
    }

    private Boolean extractIsRecentlyJoined(String html) {
        Boolean isRecentlyJoinedBoolean = new Boolean(true);
        try {
            String isRecentlyJoinedArr[] = html.split("is_joined_recently\":");
            String isRecentlyJoinedStr = isRecentlyJoinedArr[1];
            isRecentlyJoinedStr = isRecentlyJoinedStr.split(",")[0];
            isRecentlyJoinedBoolean = new Boolean(isRecentlyJoinedStr);
            return isRecentlyJoinedBoolean;
        }catch (Exception e) {
            return false;
        }
    }

    private Boolean extractIsBusinessAccount(String html) {
        Boolean isBusinessAccountBool = new Boolean(true);
        try {
            String isBuisnessAccount[] = html.split("is_business_account\":");
            String isBusiness = isBuisnessAccount[1];
            String isBusinessStr = isBusiness.split(",")[0];
            isBusinessAccountBool = new Boolean(isBusinessStr);
            return isBusinessAccountBool;
        }catch (Exception e) {
            return false;
        }

    }


    //TODO
    /*private long extractId(String html) {
        Long idNr = new Long(0);
        try {
            String idTokens[] = html.split("id\":");
            String idToken = idTokens[1];

            return idNr;
        }catch (Exception e) {
            return new Long(-1);
        }
    }*/

    private Long extractHighLightNumber(String html) {
        try{
            String highLightSplitted[] = html.split("highlight_reel_count\":");
            String highLightToken = highLightSplitted[1];
            Long highLightNr = Long.parseLong(highLightToken.split(",")[0]);
            return highLightNr;
        }catch (Exception e) {
            e.printStackTrace();
            return new Long(-1);
        }

    }

    private String extractExternalUrl(String html) {
        try {
            String tokens[] = html.split("external_url\":");
            String tokenItem = tokens[1];
            String tokenText = tokenItem.split(",")[0];
            tokenText = tokenText.replace(String.valueOf('"'), "");
            return tokenText;
        }catch (Exception e) {
            return "";
        }

    }

    private String extractBiography(String html) {
        try {
            String biography[] = html.split("biography\":\"");
            String bio = biography[1];
            String bioText = bio.split(",")[0];
            return bioText;
        }catch (Exception e) {
            return "";
        }

    }

    private Long extractFollowedBy(String html) {
        try {
            String followedByTokens[] = html.split("edge_followed_by\":");
            String followedByToken = followedByTokens[1];
            JSONObject obj = new JSONObject(followedByToken.split(",")[0]);
            Long followerCount = obj.getLong("count");

            return followerCount;
        }catch (Exception e) {
            return new Long(-1);
        }

    }

    private Long extractFollowing(String html) {
        try {
            String followedByTokens[] = html.split("edge_follow\":");
            String followedByToken = followedByTokens[1];
            JSONObject obj = new JSONObject(followedByToken.split(",")[0]);
            Long followerCount = obj.getLong("count");

            return followerCount;
        }catch (Exception e) {
            e.printStackTrace();
            return new Long(-1);
        }
    }


}



































