package com.example.demo.dao.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.entity.TOrderDetail;
import com.example.demo.dao.mapper.TOrderDetailMapper;
import com.example.demo.dao.service.ITOrderDetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单详情表 服务实现类
 * </p>
 *
 * @author wangjun
 * @since 2022-04-01
 */
@Service
public class TOrderDetailServiceImpl extends ServiceImpl<TOrderDetailMapper, TOrderDetail> implements ITOrderDetailService {

}
