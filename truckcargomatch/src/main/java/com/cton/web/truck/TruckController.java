package com.cton.web.truck;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.handler.BusinessException;
import com.cton.model.Truck;
import com.cton.service.truck.TruckService;
import com.cton.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/truck")
@Controller
@CrossOrigin
@Api(value = "货车模块",tags = "货车接口")
public class TruckController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TruckService truckService;

    @GetMapping("/listAll")
    @ResponseBody
    @ApiOperation("获取所有种类货车")
    public ResultDTO listAllTrucks(){
        List<Truck> truckList = truckService.listAllTrucks();
        if(null!=truckList){
            return ResultUtil.success("获取所有种类货车成功",truckList);
        }else
            throw new BusinessException(HttpCode.DATABASEISNULL.getCode(),"数据库货车查询为空");
    }

    @PostMapping("/create")
    @ResponseBody
    @ApiOperation("新增货车")
    public ResultDTO createTruck(@RequestBody Truck truck){
        Integer count = truckService.createTruck(truck);
        if(count>0){
            return ResultUtil.success("新增货车成功");
        }else
            throw new BusinessException(HttpCode.FAIL.getCode(),"新增货车失败");
    }
    @PostMapping("/delete/{id}")
    @ResponseBody
    @ApiOperation("根据货车ID删除货车")
    public ResultDTO deleteTruck(@ApiParam(value = "货车ID",required = true) @PathVariable Integer id){
        Integer count = truckService.deleteTruckById(id);
        if(count>0){
            return ResultUtil.success("根据货车ID删除货车成功");
        }else
            throw new BusinessException(HttpCode.FAIL.getCode(),"根据货车ID删除货车失败");
    }
    @PostMapping("/update/{id}")
    @ResponseBody
    @ApiOperation("根据货车ID更新货车")
    public ResultDTO updateTruck(@PathVariable Integer id, @ApiParam(value = "货车对象",required = true)Truck truck){
        Integer count = truckService.updateTruck(truck);
        if(count>0){
            return ResultUtil.success("根据货车ID更新货车成功");
        }else
            throw new BusinessException(HttpCode.FAIL.getCode(),"根据货车ID更新货车失败");
    }
    @GetMapping("/selete/{id}")
    @ResponseBody
    @ApiOperation("根据货车ID查询货车")
    public ResultDTO seleteTruck(@PathVariable Integer id){
        Truck truck = truckService.selectTruckById(id);
        if(null!=truck){
            return ResultUtil.success("根据货车ID查询货车成功",truck);
        }else
            throw new BusinessException(HttpCode.FAIL.getCode(),"根据货车ID查询货车失败");
    }
}
