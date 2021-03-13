package com.cton.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * t_cargo
 * @author 
 */
@Data
public class Cargo implements Serializable {
    private Integer id;

    private Long cargoId;

    private String senderId;

    private String senderName;

    private String senderPhone;

    private String origin;

    private String destination;

    private Integer networkId;

    private String detailedOrigin;

    private Double detailedOriginLongitude;

    private Double detailedOriginLatitude;

    private String detailedDestination;

    private Double detailedDestinationLongitude;

    private Double detailedDestinationLatitude;

    /**
     * 0：拼车\n1：整车
     */
    private Integer type;

    /**
     * 0：代表未接单\n1：代表已结单
     */
    private Boolean isCargoTaking;

    private Double mass;

    private Double length;

    private Double width;

    private Double hight;

    private Double volume;

    private Double price;

    private String cargoDescription;

    /**
     * 0未完成; 1已完成
     */
    private Boolean completed;

    private Double grade;

    private Boolean payed;

    private Boolean big;

    private Integer transportationRecordId;

    private Double realPrice;

    private String currentCity;

    private Integer currentState;

    private Date expectedArrivalTime;

    private Integer expectedPrice;

    /**
     * 与转运中心绑定
     */
    private Integer transportationCenterId;

    private static final long serialVersionUID = 1L;
}