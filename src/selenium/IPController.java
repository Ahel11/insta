package selenium;

import model.IPLocationInfo;
import threads.IPMonitorFetcherThread;

public class IPController {

    public static IPLocationInfo ipLocationInfo = new IPLocationInfo();

    public static synchronized void updateIpInfo(IPLocationInfo locationInfo) {
        ipLocationInfo =  locationInfo;
        System.out.println(ipLocationInfo.toString() + "\n");
    }

    public IPController() {

    }

    public void startMonitoringIp() {
        IPMonitorFetcherThread fetcherThread = new IPMonitorFetcherThread();
        fetcherThread.start();
    }

}
