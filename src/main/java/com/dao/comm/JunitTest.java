package com.dao.comm;

import com.service.Transfer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/spring-mybatis.xml"})
public class JunitTest {
    @Autowired
    public Transfer transfer;

    public JunitTest() {
    }

    @Test
    public void test() {
        this.transfer.chaxunyue();
    }

    @Test
    public void add() {
        try {
            this.transfer.quqian("张三", 1000);
            this.transfer.chaxunyue();
        } catch (Exception var2) {
            System.out.println("出现异常===========================");
            var2.printStackTrace();
        }

    }
}
