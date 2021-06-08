package cn.yangyy.jx3.controller.jx3;

import cn.yangyy.jx3.common.anno.Log;
import cn.yangyy.jx3.common.bean.Rest;
import cn.yangyy.jx3.common.controller.SuperController;
import cn.yangyy.jx3.common.enums.DelFlagEnum;
import cn.yangyy.jx3.common.enums.NetworkTypesEnum;
import cn.yangyy.jx3.common.enums.TrdPlatform;
import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.CommodityTrans;
import cn.yangyy.jx3.entity.CommodityTransImg;
import cn.yangyy.jx3.entity.ServerInfo;
import cn.yangyy.jx3.entity.vo.CommodityTransVo;
import cn.yangyy.jx3.service.ICommodityService;
import cn.yangyy.jx3.service.ICommodityTransImgService;
import cn.yangyy.jx3.service.ICommodityTransService;
import cn.yangyy.jx3.service.IServerInfoService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 成交价格表 前端控制器
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Controller
@RequestMapping("/jx3/commodityTrans")
public class CommodityTransController extends SuperController {


    @Autowired
    private IServerInfoService serverInfoService;
    @Autowired
    private ICommodityService commodityService;
    @Autowired
    private ICommodityTransService commodityTransService;
    @Autowired
    private ICommodityTransImgService commodityTransImgService;

    private void initData(ModelAndView mv) {
        Wrapper<Commodity> commodityWrapper = new EntityWrapper<>();
        commodityWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());
        commodityWrapper.orderBy("sort_num", false);
        List<Commodity> commodities = commodityService.selectList(commodityWrapper);
        Wrapper<ServerInfo> serverInfoWrapper = new EntityWrapper<>();
        serverInfoWrapper.eq("del_flag", DelFlagEnum.NORMAL.getCode());
        serverInfoWrapper.orderBy("sort_num", false);
        List<ServerInfo> serverInfos = serverInfoService.selectList(serverInfoWrapper);
        mv.addObject("commodities", commodities);
        mv.addObject("serverInfos", serverInfos);
        mv.addObject("delFlags",DelFlagEnum.values());
        mv.addObject("networks", NetworkTypesEnum.values());
        mv.addObject("trdPlatforms", TrdPlatform.values());
    }

    @RequestMapping("list")
    @RequiresPermissions("listCommodityTrans")
    public ModelAndView page(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize, CommodityTrans query) {
        Page<CommodityTransVo> page = new Page<>(pageNumber, pageSize);
        page = commodityTransService.pageInfo(page, query);
        mv.addObject("page", page);
        mv.addObject("query", query);
        initData(mv);
        mv.setViewName("jx3/commodityTrans/list");
        return mv;
    }

    @RequiresPermissions("addCommodityTrans")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView mv) {
        initData(mv);
        mv.setViewName("jx3/commodityTrans/add");
        return mv;
    }

    @Log("添加报价")
    @RequiresPermissions("addCommodityTrans")
    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public Rest add(CommodityTrans dto, String imgPath) {
        dto.setId(UUID.randomUUID().toString().replace("-",""));
        dto.setDelFlag(DelFlagEnum.NORMAL.getCode());
        dto.setCreateDate(new Date());
        dto.setCreateBy(getUser().getUserName());
        boolean flag = commodityTransService.insert(dto);
        if(flag){
            setCommodityTransImg(dto.getId(),imgPath);
        }
        return Rest.ok();
    }

    @RequiresPermissions("updateCommodityTrans")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mv, @PathVariable String id) {
        initData(mv);
        mv.addObject("dto", commodityTransService.selectById(id));
        mv.setViewName("jx3/commodityTrans/update");
        return mv;
    }

    @Log("修改报价")
    @RequiresPermissions("updateCommodityTrans")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Rest update(CommodityTrans dto,String imgPath) {
        boolean flag = commodityTransService.updateById(dto);
        if(flag){
            setCommodityTransImg(dto.getId(),imgPath);
        }
        return Rest.ok();
    }


    @Log("删除报价")
    @RequiresPermissions("deleteCommodityTrans")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id) {
        CommodityTrans dto = new CommodityTrans();
        dto.setId(id);
        dto.setDelFlag(DelFlagEnum.DELETED.getCode());
        commodityTransService.updateById(dto);
        return Rest.ok();
    }

    @Log("删除报价图片")
    @RequiresPermissions("updateCommodityTrans")
    @RequestMapping("/deleteImg")
    @ResponseBody
    public Rest deleteImg(String imgId) {
        commodityTransImgService.deleteById(imgId);
        return Rest.ok();
    }

    private void setCommodityTransImg(String id, String imgPath) {
        if (StringUtils.isNotBlank(imgPath)) {
            String[] split = imgPath.split("@");
            if (split.length > 1) {
                List<CommodityTransImg> list = new ArrayList<>();
                for (String s : split) {
                    if (StringUtils.isNotBlank(s)) {
                        CommodityTransImg img = new CommodityTransImg();
                        img.setCommodityTransId(id);
                        img.setPath(s);
                        img.setCreateDate(new Date());
                        img.setCreateBy(getUser().getUserName());
                        list.add(img);
                    }
                }
                if (list.size() > 0) {
                    commodityTransImgService.insertBatch(list);
                }
            }

        }
    }
}
