package helpers;

import org.brunocvcunha.instagram4j.requests.payload.InstagramPostCommentResult;

public class LogHandler {

    public static String generateCommentLogEvent(InstagramPostCommentResult commentResult, String name) {
        String logEvent = "";
        if(commentResult == null) {
            return "FAILURE";
        }
        if(commentResult.getStatus().equalsIgnoreCase("ok")) {
            logEvent = name + "\tSuccessfully commented on:\t" + commentResult.getComment().getMedia_id() + "\n";
        } else {
            logEvent = name + "\tCould not comment on:\t" + commentResult.getComment().getMedia_id() + "\n";
        }

        return logEvent;
    }

}
