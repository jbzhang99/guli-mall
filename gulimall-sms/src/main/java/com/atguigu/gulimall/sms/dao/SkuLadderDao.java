package com.atguigu.gulimall.sms.dao;

import com.atguigu.gulimall.sms.entity.SkuLadderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 商品阶梯价格
 * 
 * @author heyijie
 * @email hyj78586421@outlook.com
 * @date 2019-08-05 17:09:58
 */
@Mapper
@Repository
public interface SkuLadderDao extends BaseMapper<SkuLadderEntity> {
	
}
