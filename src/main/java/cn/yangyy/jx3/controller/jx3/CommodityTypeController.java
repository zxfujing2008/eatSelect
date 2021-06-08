package cn.yangyy.jx3.controller.jx3;

import cn.yangyy.jx3.common.anno.Log;
import cn.yangyy.jx3.common.bean.Rest;
import cn.yangyy.jx3.common.enums.DelFlagEnum;
import cn.yangyy.jx3.entity.CommodityType;
import cn.yangyy.jx3.service.ICommodityTypeService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * 商品类别表 前端控制器
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Controller
@RequestMapping("/jx3/commodityType")
public class CommodityTypeController {

    @Autowired
    private ICommodityTypeService commodityTypeService;

    @RequestMapping("list")
    @RequiresPermissions("listCommodityType")
    public ModelAndView page(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize, CommodityType commodityType) {
        Page<CommodityType> page = new Page<>(pageNumber, pageSize);
        Wrapper<CommodityType> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(commodityType.getName())) {
            wrapper.like("name", commodityType.getName());
        }
        if (StringUtils.isNotBlank(commodityType.getDelFlag())) {
            wrapper.eq("del_flag", commodityType.getDelFlag());
        }
        wrapper.orderBy("sort_num",false);
        page = commodityTypeService.selectPage(page, wrapper);
        mv.addObject("page", page);
        mv.addObject("query", commodityType);
        mv.addObject("delFlags",DelFlagEnum.values());
        mv.setViewName("jx3/commodityType/list");
        return mv;
    }

    @RequiresPermissions("addCommodityType")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView mv) {
        mv.setViewName("jx3/commodityType/add");
        return mv;
    }

    /**
     * 执行新增
     */
    @Log("创建商品类型")
    @RequiresPermissions("addCommodityType")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Rest doAdd(CommodityType commodityType) {
        commodityType.setDelFlag(DelFlagEnum.NORMAL.getCode());
        commodityTypeService.insert(commodityType);
        return Rest.ok();
    }

    @RequiresPermissions("updateCommodityType")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mv,@PathVariable String id) {
        mv.addObject("dto",commodityTypeService.selectById(id));
        mv.setViewName("jx3/commodityType/update");
        return mv;
    }

    /**
     * 执行修改
     */
    @Log("修改商品类型")
    @RequiresPermissions("updateCommodityType")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Rest update(CommodityType dto) {
        commodityTypeService.updateById(dto);
        return Rest.ok();
    }


    /**
     * 删除用户
     */
    @Log("删除商品类型")
    @RequiresPermissions("deleteCommodityType")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id) {
        CommodityType commodityType = new CommodityType();
        commodityType.setId(id);
        commodityType.setDelFlag(DelFlagEnum.DELETED.getCode());
        commodityTypeService.updateById(commodityType);
        return Rest.ok();
    }
}
