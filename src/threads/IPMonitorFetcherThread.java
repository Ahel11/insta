package threads;

import helpers.HttpHelper;
import model.IPLocationInfo;
import selenium.IPController;

public class IPMonitorFetcherThread extends Thread {


    public void run() {
        while (true) {
            HttpHelper helper = new HttpHelper();
            String resp = helper.executeGetReq("https://www.expressvpn.com/what-is-my-ip");
            try {
                updateIpInfo(resp);
            } catch (Exception e) {

            }
            sleepT(5000);
        }

    }

    private void updateIpInfo(String ipSiteHtml) {
        IPLocationInfo updatedLocationInfo = new IPLocationInfo();
        String ipAddress = ipSiteHtml.split("<p class='ip-address'>")[1].split("\n")[1];
        String country = ipSiteHtml.split("></span>")[9].split("\n")[1];

        updatedLocationInfo.setCurrIpAddress(ipAddress);
        updatedLocationInfo.setIpLocation(country);

        IPController.updateIpInfo(updatedLocationInfo);
    }

    private void sleepT(long ms) {
        try {
            Thread.sleep(ms);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
