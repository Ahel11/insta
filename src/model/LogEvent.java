package model;

public class LogEvent {

    private long id;
    private String actionEvent;
    private String actionStatus;
    private String ipAddress;
    private String actionTime;
    private String origUser;
    private String targetLink;


    @Override
    public String toString() {
        return "LogEvent{" +
                "id=" + id +
                ", actionEvent='" + actionEvent + '\'' +
                ", actionStatus='" + actionStatus + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", actionTime='" + actionTime + '\'' +
                ", origUser='" + origUser + '\'' +
                ", targetLink='" + targetLink + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActionEvent() {
        return actionEvent;
    }

    public void setActionEvent(String actionEvent) {
        this.actionEvent = actionEvent;
    }

    public String getActionStatus() {
        return actionStatus;
    }

    public void setActionStatus(String actionStatus) {
        this.actionStatus = actionStatus;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getActionTime() {
        return actionTime;
    }

    public void setActionTime(String actionTime) {
        this.actionTime = actionTime;
    }

    public String getOrigUser() {
        return origUser;
    }

    public void setOrigUser(String origUser) {
        this.origUser = origUser;
    }

    public String getTargetLink() {
        return targetLink;
    }

    public void setTargetLink(String targetLink) {
        this.targetLink = targetLink;
    }
}
