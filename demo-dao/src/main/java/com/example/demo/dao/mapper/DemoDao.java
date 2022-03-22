package com.example.demo.dao.mapper;

import com.example.demo.dao.entity.DemoEntity;

/**
 * @author : wangjun
 * @date : 2022/3/11  11:51
 */
public interface DemoDao {
    void saveDemo(DemoEntity demoEntity);

    void removeDemo(Long id);

    void updateDemo(DemoEntity demoEntity);

    DemoEntity findDemoById(Long id);

}
