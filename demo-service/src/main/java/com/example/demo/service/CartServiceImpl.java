package com.example.demo.service;

import com.example.demo.dao.service.ITShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : wangjun
 * @date : 2022/4/1  17:15
 */
@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private ITShoppingCartService iTShoppingCartService;




}
