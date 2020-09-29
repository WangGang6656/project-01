package com.changgou.controller;

import changgou.goods.pojo.Brand;
import com.changgou.service.BrandService;
import com.github.pagehelper.PageInfo;
import entity.Result;
import entity.StatusCode;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/brand")
@CrossOrigin
public class BrandController {
    @Autowired
    private BrandService brandService;

    //查询所有商品
    @GetMapping
    public Result<List<Brand>> findAll(){
        List<Brand> brands = brandService.findAll();
        return new Result<List<Brand>>(true, StatusCode.OK,"查询所有商品成功",brands);

    }

    //根据id查询
    @GetMapping(value="/{id}")
    public Result<Brand> findById(@PathVariable(value="id") Integer id){
        Brand brand = brandService.findById(id);
        return new Result<Brand>(true,StatusCode.OK,"根据id查询成功",brand);
    }

    //增加品牌
    @PostMapping
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功");
    }

    //根据id,修改品牌
    @PutMapping(value = "/{id}")
    public Result update(@PathVariable(value="id")Integer id,@RequestBody Brand brand){
        brand.setId(id);
        brandService.update(brand);
        return new Result(true,StatusCode.OK,"增加品牌成功");
    }

    //根据id,删除品牌
    @DeleteMapping(value="/{id}")
    public Result delete(@PathVariable(value="id") Integer id){
        brandService.delete(id);
        return new Result(true,StatusCode.OK,"根据id,删除成功");
    }

    //条件查询
    @PostMapping(value="/search")
    public Result<List<Brand>> findList(@RequestBody Brand brand){
        return null;
    }

    //分页查询
    @GetMapping(value="/seach/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@PathVariable(value="page") Integer page,@PathVariable (value="size") Integer size){
        PageInfo<Brand> pageInfo = brandService.findPage(page, size);
        return new Result<PageInfo<Brand>>(true,StatusCode.OK,"分页查询成功",pageInfo);
    }

    //分页+条件搜素(未实现）
    @PostMapping(value="/search/{page}/{size}")
    public Result<PageInfo<Brand>> findPage(@RequestBody Brand brand,
                                            @PathVariable(value="page")Integer page,@PathVariable(value="size") Integer size){
        return null;
    }
}
