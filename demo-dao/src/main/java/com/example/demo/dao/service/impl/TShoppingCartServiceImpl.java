package com.example.demo.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.entity.TShoppingCart;
import com.example.demo.dao.mapper.TShoppingCartMapper;
import com.example.demo.dao.service.ITShoppingCartService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * saas进货单 服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2022-04-01
 */
@Service
public class TShoppingCartServiceImpl extends ServiceImpl<TShoppingCartMapper, TShoppingCart> implements ITShoppingCartService {

}
