package transferCenterRoutePlanning.Util;



public class ExpressInfo {
    private String postid;
    private String customer;
    private String address;
    private String lat;
    private String lng;

    @Override
    public String toString() {
        return "ExpressInfo{" +
                "postid='" + postid + '\'' +
                ", customer='" + customer + '\'' +
                ", address='" + address + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                '}';
    }

    public String getPostid() {
        return postid;
    }

    public void setPostid(String postid) {
        this.postid = postid;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public ExpressInfo(String postid, String customer, String address, String lat, String lng) {
        this.postid = postid;
        this.customer = customer;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
    }

    public ExpressInfo() {
    }
}

