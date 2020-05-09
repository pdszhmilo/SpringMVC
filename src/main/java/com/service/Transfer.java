
package com.service;

import com.dao.comm.Dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = {Exception.class})
public class Transfer {
    @Autowired
    private Dao dao;
    public static Logger logger = Logger.getLogger("debug");

    public Transfer() {
    }

    public void chaxunyue() {
        List<Map<String, Object>> user_list = this.dao.selectList("all_user");
        System.out.println(user_list.toString());
    }

    public void quqian(String name, int money) throws Exception {
        Map params = new HashMap();
        Map money_map = this.dao.selectOne("bank_money");
        if (money_map.get("money") != null) {
            int bank_money = Integer.parseInt(money_map.get("money").toString());
            if (bank_money < money) {
                throw new Exception("银行余额不足");
            }

            logger.debug("银行余额大于用户取钱金额，可以取钱");
            params.put("money", money);
            this.dao.update("bank_less", params);
            params.put("name", name);
            this.dao.update("user_add", params);
            logger.info("取钱成功！！！！");
        }

    }
}
