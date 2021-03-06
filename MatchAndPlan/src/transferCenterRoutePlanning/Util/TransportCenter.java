package transferCenterRoutePlanning.Util;

public class TransportCenter {
    private Integer id;
    private String name;
    private String city;
    private Integer max_cargo_count;
    private String address;
    private Double longitude;
    private Double latitude;

    @Override
    public String toString() {
        return "TransportCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", max_cargo_count=" + max_cargo_count +
                ", address='" + address + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getMax_cargo_count() {
        return max_cargo_count;
    }

    public void setMax_cargo_count(Integer max_cargo_count) {
        this.max_cargo_count = max_cargo_count;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public TransportCenter(Integer id, String name, String city, Integer max_cargo_count, String address, Double longitude, Double latitude) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.max_cargo_count = max_cargo_count;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public TransportCenter() {
    }
}
