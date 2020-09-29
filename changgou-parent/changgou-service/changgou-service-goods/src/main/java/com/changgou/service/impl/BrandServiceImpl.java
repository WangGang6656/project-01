package com.changgou.service.impl;

import changgou.goods.pojo.Brand;
import com.changgou.dao.BrandMapper;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;

    //查询所有商品
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    //根据id查询
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    //增加品牌
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    //根据id，修改品牌
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    //根据id,删除品牌
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    //多条件搜索（未实现）
    public List<Brand> findList(Brand brand) {
      return null;
    }

    //条件构建，公共方法（未实现）
    public Example createExample(Brand brand){
        return null;
    }

    //分页查询
    public PageInfo<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> brands = brandMapper.selectAll();
        //封装PageInfo--list
        return new PageInfo<Brand>(brands);
    }

    //分页+条件搜索（未实现）
    public PageInfo<Brand> findPage(Brand brand, Integer page, Integer size) {
        PageHelper.startPage(page,size);  //分页
        return null;
    }
}
