package com.pinyougou.manager.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.pinyougou.pojo.TbBrand;
import com.pinyougou.pojo.TbBrandExample;
import com.pinyougou.sellergoods.service.BrandService;
import entity.PageResult;
import entity.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * 品牌的控制器
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有
     * @return
     */
    @RequestMapping("/findAll")
    public List<TbBrand> findAll() {
        return brandService.findAll();
    }

    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findPage")
    public PageResult findPage(int pageNum, int pageSize,@RequestBody TbBrand brand) {
        PageResult page = brandService.findPage(pageNum, pageSize,brand);
        return page;
    }

    /**
     * 根据id查询，做数据回显
     * @param id
     * @return
     */
    @RequestMapping("/findOne")
    public TbBrand findOne(Long id) {
        TbBrand brand = brandService.findOne(id);
        return brand;
    }

    /**
     * 新增
     * @param brand
     * @return
     */
    @RequestMapping("/insert")
    public Result insert(@RequestBody TbBrand brand) {
        try {
            brandService.insert(brand);
            return new Result(true, "新增成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "新增失败！");
        }
    }

    /**
     * 修改
     * @param brand
     * @return
     */
    @RequestMapping("/update")
    public Result update(@RequestBody TbBrand brand) {
        try {
            brandService.update(brand);
            return new Result(true, "修改成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "修改失败！");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result delete(Long[] ids) {
        try {
            brandService.delete(ids);
            return new Result(true, "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, "删除失败！");
        }
    }



   /* @RequestMapping("/findByLike1")
    public PageResult findByLike1(HttpServletRequest request) throws Exception {

        String name = request.getParameter("name");
        name = URLDecoder.decode(name, "utf-8");
        String firstChar = request.getParameter("firstChar");
        Integer pageNum = Integer.parseInt(request.getParameter("pageNum"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));

        System.out.println(name);
        System.out.println(firstChar);

        TbBrandExample example = new TbBrandExample();
        TbBrandExample.Criteria criteria = example.createCriteria();
        if (name != null && !"".equals(name)) {
            criteria.andNameLike("%"+name+"%");
            System.out.println("1111");
        }
        if (firstChar != null && !"".equals(firstChar)) {
            criteria.andFirstCharLike("%"+firstChar+"%");
            System.out.println("2222");
        }
        PageResult page = brandService.findPage1(example, pageNum, pageSize);

        System.out.println("集合数据："+page.getRows());

        return page;
    }*/

}
