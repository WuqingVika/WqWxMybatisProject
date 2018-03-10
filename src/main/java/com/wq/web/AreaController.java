package com.wq.web;

import com.wq.entity.Area;
import com.wq.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wuqingvika on 2018/3/6.
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    public Map<String,Object> listArea(){
        List<Area> areaList = areaService.getAreaList();
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("list",areaList);
        return result;
    }

    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    public Map<String,Object> getAreaById(@RequestParam("areaId") Integer areaId){
        Area area = areaService.getAreaById(areaId);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("area",area);
        return result;
    }

    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    public Map<String,Object> addArea(@RequestBody Area area){
        boolean b = areaService.addArea(area);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",b);
        return result;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    public Map<String,Object> modifyArea(@RequestBody Area area){
        boolean b = areaService.modifyArea(area);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",b);
        return result;
    }

    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    public Map<String,Object> deleteArea(Integer areaId){
        boolean b = areaService.deleteArea(areaId);
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("success",b);
        return result;
    }
}
