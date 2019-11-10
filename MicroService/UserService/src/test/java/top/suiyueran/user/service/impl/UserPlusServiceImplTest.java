package top.suiyueran.user.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zouyaowen
 * @Description:
 * @Date: 22:26 2019/11/10
 * @Modifyed by:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserPlusServiceImplTest {

    @Autowired
    private UserPlusServiceImpl userService;

    @Test
    public void count() {
        int count = userService.count();
        System.out.println(count);
    }


}