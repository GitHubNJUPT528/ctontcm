package com.cton.utils.ga;

import java.sql.Timestamp;


public class Cargo {
    public Cargo(Integer id, Float mass, Float volume, Double price) {
        this.id = id;
        this.mass = mass;
        this.volume = volume;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    private Integer id;
    private Long cargoId;
    private Integer consignorId;
    private String consignorName;
    private String consignorPhone;
    private String origin;
    private String destination;

    public Float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;

    }

    public Float getVolume() {
        return volume;
    }

    public void setVolume(Float volume) {
        this.volume = volume;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private String detailedOrigin;// 出发地详细地址
    private Double detailedOriginLongitude;// 出发地详细地址的经度
    private Double detailedOriginLatitude;// 出发地详细地址的纬度
    private String detailedDestination;// 目的地详细地址
    private Double detailedDestinationLongitude;// 目的地详细地址的经度
    private Double detailedDestinationLatitude;// 目的地详细地址的纬度
    private Integer type; // 0拼车 1整车
    private boolean cargoTaking;
    private Float mass;
    private Float volume;
    private Double price;
    private String cargoDescription;// 货物描述信息
    private boolean completed; // 货物订单是否已被运输完成
    private Float grade; // 用户评分0-5分
    private boolean payed; // 货物订单是否已经支付
    private boolean big; // 是否为大货物, "大"指的是是否超过所有货车中最大的体积和负载
    private Integer transportationRecordId; // 该货物如果被接单了, 对应的运输记录id, 目前所有cargo无论是否接单该值都为-1
    private Double realPrice; // 实际价格, 如果cargo为个人司机拼单型, 实际价格<=理论价格price
    private String currentCity; // 当前货物已完成阶段运输后所在城市. 例如南京-厦门的货物, 现在已到达杭州集运中心, 所以当前城市为杭州, 杭州-厦门阶段还未完成
    private Integer currentState; // 当前状态, 0表示在集运中心等待运输, 1表示正在运输中, 2表示已到达终点, 其余状态码省略, 可扩展
    //    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Timestamp expectedArrivalTime; // 期望的货物送达时间
    private Integer expectedPrice; //期望的货物运输价格
    private Integer transportationCenterId;//对应所在转运中心id




}
