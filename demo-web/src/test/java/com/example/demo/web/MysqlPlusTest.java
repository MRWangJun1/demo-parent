package com.example.demo.web;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.dao.entity.TShoppingCart;
import com.example.demo.dao.service.ITShoppingCartService;
import com.example.demo.web.bootstrap.DemoWebApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author : wangjun
 * @date : 2022/4/1  18:19
 */
@SpringBootTest(classes = DemoWebApplication.class)
@RunWith(SpringRunner.class)
public class MysqlPlusTest {

    @Autowired
    private ITShoppingCartService iTShoppingCartService;

    @Test
    public void getCartList() {

        List<TShoppingCart> list = iTShoppingCartService.list();
        System.out.println("get");
        LambdaQueryWrapper<TShoppingCart> queryWrapper = Wrappers.lambdaQuery(TShoppingCart.class);
//        queryWrapper.eq(TShoppingCart::getShoppingCartId, 41);

//        queryWrapper.like(TShoppingCart::getProductName, "心诚");
        queryWrapper.last("limit 12");
        queryWrapper.in(TShoppingCart::getShoppingCartId,81,83);

        List<TShoppingCart> list1 =iTShoppingCartService.list(queryWrapper);


        System.out.println("www");
    }


}
