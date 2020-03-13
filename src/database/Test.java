package database;

import com.vdurmont.emoji.EmojiParser;
import gui.HolderCont;
import instagramimpl.MainHandl;
import model.CometonAccount;
import model.InstagramUserRecord;
import model.LogEvent;

import java.util.*;
import java.util.regex.Pattern;

public class Test {

    public static int globalBegin = 165;

    public static void main(String args[]) {

        int choice = 2;
        switch (choice) {
            case 1:
                getMails(28);
                break;

            case 2:
                testDb();
                break;

            case 3:
                runeer();
                break;

        }


        //runeer();
    }

    private static String getWords(List<String> list, int nrOfWords) {
        Random r = new Random();
        String toReturn = "";
        for(int i=0; i<nrOfWords; i++) {
            int index = r.nextInt()%list.size();
            if(index < 0) index *= -1;
            toReturn = toReturn + " " +list.get(index);
        }
        toReturn = toReturn.replace("." ,"");
        toReturn = toReturn.replace("–" ,"");
        toReturn = toReturn.replace("\n" ,"");
        toReturn = toReturn.toUpperCase();
        toReturn = toReturn.replace("    " ," ");
        toReturn = toReturn.replace("  " ," ");
        toReturn = toReturn.replace("   " ," ");
        toReturn = toReturn.replace("   " ," ");
        return toReturn;
    }

    private static String scramble(String token) {
        String toReturn = "";
        String firstChar = String.valueOf(token.charAt(0));
        String lastChar = String.valueOf(token.charAt(token.length()-1));

        ArrayList<String> coreTokenList = new ArrayList<>();
        String coreToken = token.substring(1, token.length()-1);
        for(char c: coreToken.toCharArray()) {
            coreTokenList.add(String.valueOf(c));
        }

        Collections.shuffle(coreTokenList);

        String coreTokenStr = "";
        for(String s: coreTokenList) {
            coreTokenStr = coreTokenStr + s;
        }

        toReturn = firstChar + coreTokenStr + lastChar;
        return toReturn;
    }

    public static void testDb() {
        DatabaseHandler handler = new DatabaseHandler();

        handler.getAllLogs();


    }

    public static void getMails(int nr) {
        DatabaseHandler handler = new DatabaseHandler();
        ArrayList<InstagramUserRecord> records = handler.getAllRecords();

        ArrayList<String> allMails = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        int counter = 0;


        for(InstagramUserRecord rec: records) {
            String currMail = getMailFromBio(rec.getBio());
            if(currMail != null) {
                counter++;
                buffer.append(currMail + ",");
                if(counter >= nr) {
                    System.out.println(buffer.toString() + "\n");
                    buffer = new StringBuffer();
                    counter=0;
                }
            }
        }

    }

    private static String getMailFromBio(String bio) {
        Scanner scanner = new Scanner(bio);

        String currToken = "";
        while(scanner.hasNext()) {
            currToken = scanner.next();
            if( currToken.contains("gmail") || currToken.contains("yahoo") || currToken.contains("outlook")) {
                currToken = currToken.replace(String.valueOf('"'), "");
                currToken = currToken.replace(String.valueOf(']'), "");
                currToken = currToken.replace(String.valueOf('|'), "");
                currToken = currToken.replace(String.valueOf('/'), "");
                currToken = removeEmoticos(currToken);


                if(currToken.contains(":")) {
                    return currToken.split(":")[1];
                }
                if(currToken.length() > 55) return null;
                String splitted[] = currToken.split("\\.");
                String toReturn =  splitted[0] + ".com";

                if((toReturn.contains("gmail") || currToken.contains("yahoo") || currToken.contains("outlook")) && isValidEmail(currToken)) {
                    return toReturn;
                }
            }
        }
        return null;
    }

    private static boolean isValidEmail(String currToken) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);
        if (currToken == null)
            return false;
        return pat.matcher(currToken).matches();
    }

    private static String removeEmoticos(String currToken) {
        currToken = EmojiParser.removeAllEmojis(currToken);

        String characterFilter = "[^\\p{L}\\p{M}\\p{N}\\p{P}\\p{Z}\\p{Cf}\\p{Cs}\\s]";
        currToken = currToken.replaceAll(characterFilter,"");

        currToken = currToken.replace("ud83","");
        currToken = currToken.replace("dudc","");
        currToken = currToken.replace("uddf","");
        currToken = currToken.replace("u2709","");
        currToken = currToken.replace("u25","");
        currToken = currToken.replace("ufe0","");

        return currToken;
    }

    public static void runeer() {
        while(true) {
            MainHandl handl = new MainHandl();
            handl.start();
            sleepT(95000);
            handl.stop();
            globalBegin++;
        }
    }

    public static void databaseTesting() {
        DatabaseHandler handler = new DatabaseHandler();
        CometonAccount account = handler.getCometonAccount("jimbo", "123456");
    }

    public static void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}











































