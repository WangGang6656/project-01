package com.changgou.service;

import changgou.goods.pojo.Brand;
import com.github.pagehelper.PageInfo;
import org.bouncycastle.jce.provider.BrokenJCEBlockCipher;

import java.util.List;

public interface BrandService {
    //查询所有商品
    public List<Brand> findAll();

    //根据id查询
    public Brand findById(Integer id);

    //增加品牌
    public void add(Brand brand);

    //根据id,修改品牌
    public void update(Brand brand);

    //根据id,删除品牌
    public void delete(Integer id);

    //条件查询，根据名字或者id查询(未实现）
    public List<Brand> findList(Brand brand);

    //分页查询 page,当前页，size,每页显示条数----
    public PageInfo<Brand> findPage(Integer page,Integer size);

    //分页+条件搜索
    public PageInfo<Brand> findPage(Brand brand,Integer page,Integer size);
 }
