package cn.yangyy.jx3.controller.jx3;

import cn.yangyy.jx3.common.anno.Log;
import cn.yangyy.jx3.common.bean.Rest;
import cn.yangyy.jx3.common.controller.SuperController;
import cn.yangyy.jx3.common.enums.DelFlagEnum;
import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.CommodityImg;
import cn.yangyy.jx3.entity.CommodityType;
import cn.yangyy.jx3.entity.ServerInfo;
import cn.yangyy.jx3.entity.vo.CommodityVo;
import cn.yangyy.jx3.service.ICommodityImgService;
import cn.yangyy.jx3.service.ICommodityService;
import cn.yangyy.jx3.service.ICommodityTypeService;
import cn.yangyy.jx3.service.IServerInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 商品表 前端控制器
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Controller
@RequestMapping("/jx3/commodity")
public class CommodityController extends SuperController {

    @Autowired
    private ICommodityTypeService commodityTypeService;
    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ICommodityImgService commodityImgService;

    private void initData(ModelAndView mv) {
        Wrapper<CommodityType> commodityTypeWrapper = new EntityWrapper<>();
        commodityTypeWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());
        commodityTypeWrapper.orderBy("sort_num", false);
        List<CommodityType> commodityTypes = commodityTypeService.selectList(commodityTypeWrapper);
        mv.addObject("typeList", commodityTypes);
        mv.addObject("delFlags",DelFlagEnum.values());
    }

    @RequestMapping("list")
    @RequiresPermissions("listCommodity")
    public ModelAndView page(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize, Commodity query) {
        Page<CommodityVo> page = new Page<>(pageNumber, pageSize);
        page = commodityService.pageInfo(page, query);
        mv.addObject("page", page);
        mv.addObject("query", query);
        initData(mv);
        mv.setViewName("jx3/commodity/list");
        return mv;
    }

    @RequiresPermissions("addCommodity")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView mv) {
        initData(mv);
        mv.setViewName("jx3/commodity/add");
        return mv;
    }

    @Log("添加商品")
    @RequiresPermissions("addCommodity")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Rest add(Commodity dto, String imgPath) {
        dto.setDelFlag(DelFlagEnum.NORMAL.getCode());
        dto.setCreateDate(new Date());
        dto.setCreateBy(getUser().getUserName());
        boolean flag = commodityService.insert(dto);
        if(flag) {
            Wrapper<Commodity> wrapper = new EntityWrapper<>();
            wrapper.eq("name", dto.getName());
            wrapper.eq("type_id", dto.getTypeId());
            Commodity commodity = commodityService.selectOne(wrapper);
            if ( StringUtils.isNotBlank(commodity.getId())) {
                setCommodityImg(commodity, imgPath);
            }
            return Rest.ok();
        }
        return Rest.failure("添加商品失败");
    }

    @RequiresPermissions("updateCommodity")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mv, @PathVariable String id) {
        initData(mv);
        mv.addObject("dto", commodityService.selectById(id));
        Wrapper<CommodityImg> wrapper=new EntityWrapper<>();
        wrapper.eq("commodity_id",id);
        List<CommodityImg> imgs = commodityImgService.selectList(wrapper);
        mv.addObject("imgs",imgs);
        mv.setViewName("jx3/commodity/update");
        return mv;
    }

    @Log("修改商品")
    @RequiresPermissions("updateCommodity")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Rest update(Commodity dto,String imgPath) {
        boolean b = commodityService.updateById(dto);
        if(b) {
            setCommodityImg(dto, imgPath);
            return Rest.ok();
        }
        return Rest.failure("修改商品失败");
    }

    private void setCommodityImg(Commodity dto, String imgPath) {
        if (StringUtils.isNotBlank(imgPath)) {
            String[] split = imgPath.split("@");
            if (split.length > 1) {
                List<CommodityImg> list = new ArrayList<>();
                for (String s : split) {
                    if (StringUtils.isNotBlank(s)) {
                        CommodityImg img = new CommodityImg();
                        img.setCommodityId(dto.getId());
                        img.setPath(s);
                        img.setCreateDate(new Date());
                        img.setCreateBy(getUser().getUserName());
                        list.add(img);
                    }
                }
                if (list.size() > 0) {
                    commodityImgService.insertBatch(list);
                }
            }

        }
    }


    @Log("删除商品")
    @RequiresPermissions("deleteCommodity")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id) {
        Commodity dto = new Commodity();
        dto.setId(id);
        dto.setDelFlag(DelFlagEnum.DELETED.getCode());
        commodityService.updateById(dto);
        return Rest.ok();
    }

    @Log("删除商品图片")
    @RequiresPermissions("updateCommodity")
    @RequestMapping("/deleteImg")
    @ResponseBody
    public Rest deleteImg(String imgId) {
        commodityImgService.deleteById(imgId);
        return Rest.ok();
    }
}
