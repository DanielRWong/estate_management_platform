package com.benjaminbutton.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.benjaminbutton.bean.*;
import com.benjaminbutton.json.Common;
import com.benjaminbutton.service.EstateService;
import com.benjaminbutton.vo.CellMessage;
import com.benjaminbutton.vo.UnitMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WWX
 * @description
 * @date 2020-06-27 20:19
 * @modified By
 */
@RestController
public class EstateController {
    @Autowired
    private EstateService estateService;

    @RequestMapping("/estate/selectCompany")
    public JSONObject selectCompany(){
        List<TblCompany> tblcompanies = estateService.selectCompany();
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(tblcompanies)));
    }

    @RequestMapping("/estate/insertEstate")
    public JSONObject insertEstate(FcEstate fcEstate){
        Integer result = estateService.insertEstate(fcEstate);
        String message = "";
        Integer code = 0;
        if (result == 0){
            message = "房产编码已经存在";
        } else {
            message = "插入房产信息成功";
            code = 1;
        }
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(message, code)));
    }

    @RequestMapping("estate/selectBuilding")
    public JSONObject selectBuilding(Integer buildingNumber, String estateCode){
        List<FcBuilding> fcBuildings = estateService.selectBuilding(buildingNumber, estateCode);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(fcBuildings)));
    }

    @RequestMapping("estate/updateBuilding")
    public JSONObject updateBuilding(FcBuilding fcBuilding){
        Integer update = estateService.updateBuilding(fcBuilding);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common("插入楼宇信息成功")));
    }

    @RequestMapping("/estate/selectUnit")
    public JSONObject selectUnit(@RequestBody UnitMessage[] unitMessages){
        ArrayList<FcUnit> allUnit = new ArrayList<>();
        for (UnitMessage unitMessage : unitMessages) {
            allUnit.addAll(estateService.selectUnit(unitMessage));
        }
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(allUnit)));
    }

    @RequestMapping("/estate/updateUnit")
    public JSONObject updateUnit(FcUnit fcUnit){
        Integer result = estateService.updateUnit(fcUnit);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common("插入单元信息成功")));
    }

    @RequestMapping("/estate/insertCell")
    public JSONObject insertCell(@RequestBody CellMessage[] cellMessages){
        List<FcCell> fcCells = estateService.insertCell(cellMessages);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(fcCells)));
    }

    @RequestMapping("/estate/selectBuildingName")
    public JSONObject selectBuildingName(String estateCode){
        List<FcBuilding> fcBuildings = estateService.selectBuildingByEstate(estateCode);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(fcBuildings)));
    }

    @RequestMapping("/estate/selectUnitName")
    public JSONObject selectUnitName(String buildingCode){
        List<FcUnit> fcUnites = estateService.selectUnitByBuilding(buildingCode);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(fcUnites)));
    }

    @RequestMapping("/estate/selectCell")
    public JSONObject selectCell(String unitCode){
        List<FcCell> fcCells = estateService.selectCellByUnit(unitCode);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common(fcCells)));
    }

    @RequestMapping("/estate/updateCell")
    public JSONObject updateCell(FcCell fcCell){
        Integer result = estateService.updateCell(fcCell);
        return JSONObject.parseObject(JSONObject.toJSONString(new Common("编辑房间信息成功")));
    }

}
