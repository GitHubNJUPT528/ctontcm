package Util;



public class ExpressInfo {
    private String num;
    private String customer;
    private String express_class;
    private String postid;
    private String address;
    private String state;
    private String contact;

    private String time;    //签收时间
    private String middle;  //list中间内容整合


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    private LatLng latLng;

    public ExpressInfo(){
        super();
    }

    public ExpressInfo(String num,
                       String customer,
                       String express_class,
                       String postid,
                       String address,
                       String state,
                       String contact){
        this.num = num;
        this.customer = customer;
        this.express_class = express_class;
        this.postid = postid;
        this.address = address;
        this.state = state;
        this.contact = contact;
    }

    public ExpressInfo(String arg1,String arg2, String arg3){
        this.num = arg1;
        this.middle = arg2;
        this.state = arg3;
    }

    public String getNum(){
        return num;
    }

    public void setNum(String num){
        this.num = num;
    }

    public String getCustomer(){
        return customer;
    }

    public void setCustomer(String customer){
        this.customer = customer;
    }

    public String getExpress_class(){
        return express_class;
    }

    public void setExpress_class(String express_class){
        this.express_class = express_class;
    }

    public String getPostid(){
        return postid;
    }

    public void setPostid(String postid){
        this.postid = postid;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getState(){
        return state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getContact(){
        return contact;
    }

    public void setContact(String contact){
        this.contact = contact;
    }

    public String getMiddle(){
        return middle;
    }

    public void setMiddle(String middle){
        this.middle = middle;
    }
}
