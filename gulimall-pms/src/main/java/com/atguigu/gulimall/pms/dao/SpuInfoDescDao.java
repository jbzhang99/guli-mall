package com.atguigu.gulimall.pms.dao;

import com.atguigu.gulimall.pms.entity.SpuInfoDescEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * spu信息介绍
 * 
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 15:52:32
 */
@Mapper
@Repository
public interface SpuInfoDescDao extends BaseMapper<SpuInfoDescEntity> {
	
}
