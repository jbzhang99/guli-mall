package com.atguigu.gulimall.pms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


import com.atguigu.gulimall.commons.bean.PageVo;
import com.atguigu.gulimall.commons.bean.QueryCondition;
import com.atguigu.gulimall.commons.bean.Resp;
import com.atguigu.gulimall.commons.bean.ServerResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.atguigu.gulimall.pms.entity.CategoryEntity;
import com.atguigu.gulimall.pms.service.CategoryService;




/**
 * 商品三级分类
 *
 * @author heyijie
 * @email lfy@atguigu.com
 * @date 2019-08-01 15:52:32
 */
@Api(tags = "商品三级分类 管理")
@RestController
@RequestMapping("pms/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 列表
     */
    @ApiOperation("分页查询(排序)")
    @GetMapping("/list")
    @PreAuthorize("hasAuthority('pms:category:list')")
    public Resp<PageVo> list(QueryCondition queryCondition) {
        PageVo page = categoryService.queryPage(queryCondition);

        return Resp.ok(page);
    }

    /**
     * 获取某个等级所有分类数据
     * @param level 0-3；0代表获取所有等级，其他对应各自等级
     * @return
     */
    @ApiOperation("商品三级分类列表，用于树形展示")
    @GetMapping("/list/tree")
    public ServerResponse<List<CategoryEntity>> listCategoryTree(@RequestParam("level") Integer level){

        return categoryService.listCategoryTree(level);
    }

    @ApiOperation("获取某个分类的所有子分类")
    @GetMapping("/list/children/tree/{catId}")
    public ServerResponse<List<CategoryEntity>> getChildCategory(@PathVariable("catId") Integer catId){

        return categoryService.getChildCategory(catId);
    }


    /**
     * 信息
     */
    @ApiOperation("详情查询")
    @GetMapping("/info/{catId}")
    @PreAuthorize("hasAuthority('pms:category:info')")
    public Resp<CategoryEntity> info(@PathVariable("catId") Long catId){
		CategoryEntity category = categoryService.getById(catId);

        return Resp.ok(category);
    }

    /**
     * 保存
     */
    @ApiOperation("保存")
    @PostMapping("/save")
    @PreAuthorize("hasAuthority('pms:category:save')")
    public Resp<Object> save(@RequestBody CategoryEntity category){
		categoryService.save(category);

        return Resp.ok(null);
    }

    /**
     * 修改
     */
    @ApiOperation("修改")
    @PostMapping("/update")
    @PreAuthorize("hasAuthority('pms:category:update')")
    public Resp<Object> update(@RequestBody CategoryEntity category){
		categoryService.updateById(category);

        return Resp.ok(null);
    }

    /**
     * 删除
     */
    @ApiOperation("删除")
    @PostMapping("/delete")
    @PreAuthorize("hasAuthority('pms:category:delete')")
    public Resp<Object> delete(@RequestBody Long[] catIds){
		categoryService.removeByIds(Arrays.asList(catIds));

        return Resp.ok(null);
    }

}
