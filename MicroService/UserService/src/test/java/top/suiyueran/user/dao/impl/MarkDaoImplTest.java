package top.suiyueran.user.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.suiyueran.user.dao.IMarkDao;
import top.suiyueran.user.entity.MarkDO;

import java.util.List;
import java.util.Optional;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:37 2019/11/11
 * @Modifyed by:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MarkDaoImplTest {

    @Autowired
    private IMarkDao markDao;

    @Test
    public void insertDO(){
        MarkDO markDO = new MarkDO();
        markDO.setMarkCode("AAA");
        markDO.setMarkName("慕课网");
        markDO.setMarkUrl("www.mooc.com");
        markDO.setUserId(2L);
        markDao.insertDO(markDO);
    }

    @Test
    public void deleteDO() {
        markDao.deleteDO(1L);
    }

    @Test
    public void selectDO() {
        MarkDO markDO = markDao.selectDO(1L);
        System.out.println(markDO);
        MarkDO query = new MarkDO();
        query.setMarkName("慕课网");
        query.setMarkCode("AAA");
        Optional<List<MarkDO>> markDOS = markDao.get(query);
        if(markDOS.isPresent()){
            List<MarkDO> markDOS1 = markDOS.get();
            System.out.println(markDOS1);
        }
    }

    @Test
    public void selectAll() {
        List<MarkDO> markDOS = markDao.selectAll();
        System.out.println(markDOS);

    }

    @Test
    public void updateDO() {
        MarkDO markDO = new MarkDO();
        markDO.setUserId(1L);
        markDO.setMarkUrl("www.baidu.com");
        markDao.edit(markDO);
    }
}