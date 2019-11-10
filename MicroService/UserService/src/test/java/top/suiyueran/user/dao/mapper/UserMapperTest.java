package top.suiyueran.user.dao.mapper;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.suiyueran.user.entity.UserDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 21:12 2019/11/10
 * @Modifyed by:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {

    @Autowired(required = false)
    private UserMapper userMapper;

    /**
     * 主键查询
     */
    @Test
    public void selectById() {
        userMapper.selectById(1);
    }

    /**
     * 批量主键查询
     */
    @Test
    public void selectBatchIds() {
        ArrayList<Long> longs = new ArrayList<>();
        longs.add(1L);
        longs.add(2L);
        userMapper.selectBatchIds(longs);
    }

    /**
     * 键值对Map:条件是Map
     */
    @Test
    public void selectByMap() {
        Map<String, Object> queryMap = new HashMap<>();
        queryMap.put("id", 3L);
        userMapper.selectByMap(queryMap);
    }

    /**
     * 查询结果是Map
     */
    @Test
    public void selectMaps() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("id", 1L);
        List<Map<String, Object>> maps = userMapper.selectMaps(query);
        System.out.println(maps);
    }

    @Test
    public void selectCount() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        Integer integer = userMapper.selectCount(query);
        System.out.println(integer);
    }

    @Test
    public void selectOne() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("id", 2L);
        UserDO userDO = userMapper.selectOne(query);
        System.out.println(userDO);
    }

    @Test
    public void selectList() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        List<UserDO> userDOS = userMapper.selectList(query);
        System.out.println(userDOS);
    }

    @Test
    public void selectObjs() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        //查询的是主键列表
        List<Object> objects = userMapper.selectObjs(query);
        System.out.println(objects);
    }

    @Test
    public void selectPage() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        Page<UserDO> userDOPage = new Page<>();
        userDOPage.setCurrent(1);
        userDOPage.setSize(5);
        // 要点!! 分页返回的对象与传入的对象是同一个
        IPage<UserDO> userDOIPage = userMapper.selectPage(userDOPage, query);
        System.out.println(JSON.toJSONString(userDOIPage));
    }

    @Test
    public void selectMapsPage() {
        Page<UserDO> userDOPage = new Page<>();
        userDOPage.setCurrent(1);
        userDOPage.setSize(2);
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        //返回的对象数据为Map
        IPage<Map<String, Object>> mapIPage = userMapper.selectMapsPage(userDOPage, query);
        System.out.println(JSON.toJSONString(mapIPage));
    }

    //--------------------------------------3.2.0版本中select一共十个方法测试完毕-----------------------------------------------

    @Test
    public void deleteById() {
        int i = userMapper.deleteById(5L);
        System.out.println(i);
    }

    @Test
    public void delete() {
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("age", 22);
        userMapper.delete(query);
    }

    @Test
    public void deleteBatchIds() {
        ArrayList<Long> idList = new ArrayList<>();
        idList.add(2L);
        idList.add(3L);
        userMapper.deleteBatchIds(idList);
    }

    @Test
    public void deleteByMap() {
        HashMap<String, Object> deleteMap = new HashMap<>();
        deleteMap.put("id", 2L);
        userMapper.deleteByMap(deleteMap);
    }

    //----------------------------------delete 4个方法测试完毕------------------------------------------------

    @Test
    public void insert() {
        UserDO userDO = new UserDO();
        userDO.setUserName("ASD");
        userDO.setUserCode("CVB");
        userDO.setAge(11);
        userDO.setGender(0);
        userMapper.insert(userDO);
    }

    @Test
    public void updateById() {
        UserDO userDO = new UserDO();
        userDO.setUserName("ASD");
        userDO.setUserCode("CVB");
        userDO.setAge(11);
        userDO.setGender(0);
        userDO.setId(6L);
        userMapper.updateById(userDO);
    }

    @Test
    public void update() {
        UserDO userDO = new UserDO();
        userDO.setGender(0);
        QueryWrapper<UserDO> query = new QueryWrapper<>();
        query.eq("gender", 1);
        userMapper.update(userDO, query);
    }

    //------------添加1个，删除4个，修改2个，查询10个方法，共十七个-----------------------------------------------------

}