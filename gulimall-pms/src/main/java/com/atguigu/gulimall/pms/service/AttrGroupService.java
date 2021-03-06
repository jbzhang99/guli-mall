package com.atguigu.gulimall.pms.service;

import com.atguigu.gulimall.commons.bean.ServerResponse;
import com.atguigu.gulimall.pms.vo.resp.AttrgroupWithAttrsVo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.atguigu.gulimall.pms.entity.AttrGroupEntity;
import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;


/**
 * 属性分组
 *
 * @author leifengyang
 * @email lfy@atguigu.com
 * @date 2019-08-01 15:52:32
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageVo queryPage(QueryCondition params);

    ServerResponse<PageVo> listAttrGroupWithAttrsByCatId(QueryCondition queryCondition, Long catId,Integer attrType);

    /**
     * 查询某个分组以及分组下面的所有属性信息
     * @param attrGroupId
     * @return
     */
    ServerResponse<AttrgroupWithAttrsVo> selectAttrGroupWithattrs(Long attrGroupId,Integer attrType);
}

