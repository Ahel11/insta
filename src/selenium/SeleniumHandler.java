package selenium;

import model.IPLocationInfo;
import model.MailAccount;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SeleniumHandler {

    private List<MailAccount> allAccounts;
    private IPLocationInfo currIpLocation;

    public SeleniumHandler() {
        initialize();
    }

    public void startSendingMails() {
        currIpLocation = IPController.ipLocationInfo;
        while(IPController.ipLocationInfo.isEmpty()) {
            sleepT(500);
        }

        while(true) {
            MailAccount currMaiL = getMailAccountFromCurrentLocation();

            SeleniumUserThread currSeleniumUserThread = new SeleniumUserThread();
            currSeleniumUserThread.setMailAccount(currMaiL);
            currSeleniumUserThread.start();

            sleepT(180 * 1000);
            currSeleniumUserThread.abort();

            checkIfIpHasChanged();
        }
    }

    private void checkIfIpHasChanged() {
        while(true) {
            if(currIpLocation.equals(IPController.ipLocationInfo)) {
                sleepT(2000);
            } else {
                break;
            }
        }
    }

    private MailAccount getMailAccountFromCurrentLocation() {
        String currLocation = IPController.ipLocationInfo.getIpLocation();

        ArrayList<MailAccount> accountsInCurrLocation = new ArrayList<>();

        //Fetch only accs that are in the current location
        for(MailAccount currAcc: allAccounts) {
            if (currAcc.getLocation().equalsIgnoreCase(currLocation)) {
                accountsInCurrLocation.add(currAcc);
            }
        }

        Random r = new Random();
        int index = r.nextInt()%accountsInCurrLocation.size();
        if(index < 0) {
            index *= -1;
        }

        return accountsInCurrLocation.get(index);

    }

    private void initialize() {
        IPController controller = new IPController();
        controller.startMonitoringIp();
        allAccounts = getAllAccounts();
    }

    private List<MailAccount> getAllAccounts() {
        ArrayList<MailAccount> allAccounts = new ArrayList<>();

        MailAccount mailAccount = new MailAccount();

        mailAccount.setMailAddress("timofeigromik1978@mail.ru");
        mailAccount.setPassword("sQ0PxtHO37A");
        mailAccount.setLocation("Romania");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("slujaevamariya1968638@mail.ru");
        mailAccount.setPassword("fHWhbx156Xu");
        mailAccount.setLocation("Ireland");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("albinakanushina1985377@mail.ru");
        mailAccount.setPassword("84b5Bgy95m");
        mailAccount.setLocation("Germany");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("vitalinasavkun92@mail.ru");
        mailAccount.setPassword("6R5lsO1zNRHP9");
        mailAccount.setLocation("Belgium");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("starostintrofim19992651@mail.ru");
        mailAccount.setPassword("gciVX1TbqWQBM5");
        mailAccount.setLocation("France");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("lavrentiiudyanskii9914@mail.ru");
        mailAccount.setPassword("rnA7uuzvyLF3h2");
        mailAccount.setLocation("France");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("repskiialeksei470@mail.ru");
        mailAccount.setPassword("4TqEPof55hhj");
        mailAccount.setLocation("France");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        mailAccount.setMailAddress("gnoevoialbert892741@mail.ru");
        mailAccount.setPassword("NGQJx5LnyG8");
        mailAccount.setLocation("France");
        allAccounts.add(mailAccount);
        mailAccount = new MailAccount();

        return allAccounts;
    }

    private void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {

        }
    }

}





















