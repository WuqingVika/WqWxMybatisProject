package com.wq.service.impl;

import com.mysql.jdbc.StringUtils;
import com.wq.dao.AreaDao;
import com.wq.entity.Area;
import com.wq.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by wuqingvika on 2018/3/6.
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        int i=1/0;//人为制造一个错误 看我们的自定义的异常是否能捕获到
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        if(!StringUtils.isNullOrEmpty(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectNum=areaDao.insertArea(area);
                if(effectNum>0){
                    return  true;
                }else {
                    throw new RuntimeException("插入区域信息失败!");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    @Override
    @Transactional
    public boolean modifyArea(Area area) {
        // 空值判断，主要是areaId不为空
        if (area.getAreaId() != null && area.getAreaId() > 0) {
            // 设置默认值
            area.setLastEditTime(new Date());
            try {
                // 更新区域信息
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    @Transactional
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                // 删除区域信息
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息失败:" + e.toString());
            }
        } else {
            throw new RuntimeException("区域Id不能为空！");
        }
    }
}
