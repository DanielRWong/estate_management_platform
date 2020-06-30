package com.benjaminbutton.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.benjaminbutton.bean.*;
import com.benjaminbutton.mapper.*;
import com.benjaminbutton.vo.CellMessage;
import com.benjaminbutton.vo.UnitMessage;
import jdk.nashorn.internal.ir.CallNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WWX
 * @description
 * @date 2020-06-27 20:20
 * @modified By
 */
@Service
public class EstateService {

    @Autowired
    private TblCompanyMapper tblCompanyMapper;

    @Autowired
    private FcEstateMapper fcEstateMapper;

    @Autowired
    private FcBuildingMapper fcBuildingMapper;

    @Autowired
    private FcUnitMapper fcUnitMapper;

    @Autowired
    private FcCellMapper fcCellMapper;


    public List<TblCompany> selectCompany(){
        List<TblCompany> tblcompanies = tblCompanyMapper.selectCompany();
        return tblcompanies;
    }

    public Integer insertEstate(FcEstate fcEstate){
        int result = 0;
        QueryWrapper<FcEstate> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("estate_code", fcEstate.getEstateCode());
        FcEstate fe = fcEstateMapper.selectOne(queryWrapper);
        if (fe == null){
            result = fcEstateMapper.insert(fcEstate);
        }
        return result;
    }

    public List<FcBuilding> selectBuilding(Integer buildingNumber, String estateCode){
        List<FcBuilding> fcBuildings = new ArrayList<>();
        for(int i = 0;i<buildingNumber;i++){
            FcBuilding fcBuilding = new FcBuilding();
            fcBuilding.setEstateCode(estateCode);
            fcBuilding.setBuildingCode("B" + (i+1));
            fcBuilding.setBuildingName("第" + (i+1) + "号楼");
            fcBuildingMapper.insert(fcBuilding);
            fcBuildings.add(fcBuilding);
        }
        return fcBuildings;
    }

    public Integer updateBuilding(FcBuilding fcBuilding){
        int update = fcBuildingMapper.updateById(fcBuilding);
        return update;
    }

    public List<FcUnit> selectUnit(UnitMessage unitMessage){
        ArrayList<FcUnit> fcUnits = new ArrayList<>();
        for (int i = 0;i<unitMessage.getUnitCount();i++){
            FcUnit fcUnit = new FcUnit();
            fcUnit.setBuildingCode(unitMessage.getBuildingCode());
            fcUnit.setUnitCode(unitMessage.getBuildingCode() + "U" + (i + 1));
            fcUnit.setUnitName("第" + (i + 1) + "单元");
            fcUnitMapper.insert(fcUnit);
            fcUnits.add(fcUnit);
        }
        return fcUnits;
    }

    public Integer updateUnit(FcUnit fcUnit){
        int result = fcUnitMapper.updateById(fcUnit);
        return result;
    }

    public List<FcCell> insertCell(CellMessage[] cellMessages){
        ArrayList<FcCell> fcCells = new ArrayList<>();
        for (CellMessage cellMessage : cellMessages) {
            for (int i = 1;i<=cellMessage.getStopFloor();i++){
                for (int j = 1; j<= cellMessage.getStopCellId();j++){
                    FcCell fcCell = new FcCell();
                    fcCell.setUnitCode(cellMessage.getUnitCode());
                    fcCell.setCellName(i + "0" + j);
                    fcCell.setCellCode(cellMessage.getUnitCode() + cellMessage.getUnitCode()+"C"+i+"0"+j);
                    fcCell.setFloorNumber(i);
                    fcCellMapper.insert(fcCell);
                    fcCells.add(fcCell);
                }
            }
        }
        return fcCells;
    }

    public List<FcBuilding> selectBuildingByEstate(String estateCode){
        QueryWrapper<FcBuilding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("estate_code",estateCode);
        queryWrapper.select("building_name","building_code");
        List<FcBuilding> fcBuildings = fcBuildingMapper.selectList(queryWrapper);
        return fcBuildings;
    }

    public List<FcUnit> selectUnitByBuilding(String buildingCode){
        QueryWrapper<FcUnit> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("building_code", buildingCode);
        queryWrapper.select("unit_code", "unit_name");
        List<FcUnit> fcUnits = fcUnitMapper.selectList(queryWrapper);
        return fcUnits;
    }

    public List<FcCell> selectCellByUnit(String unitCode){
        QueryWrapper<FcCell> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("unit_code", unitCode);
        List<FcCell> fcCells = fcCellMapper.selectList(queryWrapper);
        return fcCells;
    }

    public Integer updateCell(FcCell fcCell){
        int result = fcCellMapper.updateById(fcCell);
        return result;
    }
}
