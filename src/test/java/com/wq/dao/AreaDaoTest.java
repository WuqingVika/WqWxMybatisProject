package com.wq.dao;

import com.wq.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuqingvika on 2018/3/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;
    @Test
    public void queryArea() throws Exception {
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() throws Exception {
        Area area=areaDao.queryAreaById(1);
        assertEquals("浦东新区",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() throws Exception {
        Area area=new Area();
        area.setAreaName("虹口区");
        area.setPriority(3);
        area.setCreateTime(new Date());
        area.setLastEditTime(new Date());
        int i=areaDao.insertArea(area);
        assertEquals(1,i);
    }

    @Test
    public void updateArea() throws Exception {
        Area area=new Area();
        area.setAreaId(3);
        area.setAreaName("虹口区2");
        area.setPriority(5);
        area.setLastEditTime(new Date());
        int i=areaDao.updateArea(area);
        assertEquals(1,i);
    }

    @Test
    public void deleteArea() throws Exception {
        int i=areaDao.deleteArea(3);
        assertEquals(1,i);
    }

}