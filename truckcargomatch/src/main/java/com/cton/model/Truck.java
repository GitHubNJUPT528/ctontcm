package com.cton.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * t_truck
 * @author
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Truck对象",description = "货车对象")
public class Truck implements Serializable {
    @ApiModelProperty("货车ID")
    private Integer id;

    @ApiModelProperty("货车类型")
    private String truckType;

    @ApiModelProperty("货车容量")
    private Double truckVolume;

    @ApiModelProperty("货车载重")
    private Double truckLoad;

    @ApiModelProperty("百公里油耗")
    private Double fuelLitersperhundredmiles;

    @ApiModelProperty("序列ID")
    private static final long serialVersionUID = 11L;
}
