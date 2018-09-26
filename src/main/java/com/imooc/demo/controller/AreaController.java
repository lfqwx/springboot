package com.imooc.demo.controller;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    //为什么要用Map？
    private Map<String,Object> listarea(){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        List<Area> list=areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }
    @RequestMapping(value = "/queryById",method = RequestMethod.GET)
    private Map<String,Object> queryById(int areaId){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        Area area=areaService.queryById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }
    @RequestMapping(value = "/addArea",method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/updateArea",method = RequestMethod.POST)
    private Map<String,Object> updateArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.updateArea(area));
        return modelMap;
    }
    @RequestMapping(value = "/deleteArea",method = RequestMethod.GET)
    private Map<String,Object> deleteArea(int areaId){
        Map<String,Object> modelMap=new HashMap<String, Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }



}

