package model;

public class IPLocationInfo {

    String currIpAddress = "";
    String IpLocation = "";

    public String getCurrIpAddress() {
        return currIpAddress;
    }

    public void setCurrIpAddress(String currIpAddress) {
        this.currIpAddress = currIpAddress;
    }

    public String getIpLocation() {
        return IpLocation;
    }

    public void setIpLocation(String ipLocation) {
        IpLocation = ipLocation;
    }

    public boolean equals(IPLocationInfo locationInfo) {
        if(this.getCurrIpAddress().contains(locationInfo.getCurrIpAddress())
            && this.getIpLocation().contains(locationInfo.getIpLocation())) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "IPLocationInfo{" +
                "currIpAddress='" + currIpAddress + '\'' +
                ", IpLocation='" + IpLocation + '\'' +
                '}';
    }

    public boolean isEmpty() {
        return this.currIpAddress.isEmpty() && getIpLocation().isEmpty();
    }
}
