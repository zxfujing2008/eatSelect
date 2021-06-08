package cn.yangyy.jx3.controller.jx3;

import cn.yangyy.jx3.common.anno.Log;
import cn.yangyy.jx3.common.bean.Rest;
import cn.yangyy.jx3.common.controller.SuperController;
import cn.yangyy.jx3.common.enums.DelFlagEnum;
import cn.yangyy.jx3.entity.HotSearch;
import cn.yangyy.jx3.service.IHotSearchService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * <p>
 * 热搜关键字管理 前端控制器
 * </p>
 *
 * @author zhaox
 * @since 2018-10-31
 */
@Controller
@RequestMapping("/jx3/hotSearch")
public class HotSearchController extends SuperController {

    @Autowired
    private IHotSearchService hotSearchService;

    @RequestMapping("list")
    @RequiresPermissions("listHotSearch")
    public ModelAndView list(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize,
                             HotSearch query){
        Wrapper<HotSearch> wrapper = new EntityWrapper<>();
        if(StringUtils.isNotBlank(query.getSearchText())){
            wrapper.like("search_text",query.getSearchText());
        }
        if(StringUtils.isNotBlank(query.getStatus())){
            wrapper.eq("status",query.getStatus());
        }
        if(StringUtils.isNotBlank(query.getViewFlag())){
            wrapper.eq("view_flag",query.getViewFlag());
        }
        Page<HotSearch> page = new Page<>(pageNumber,pageSize);
        page = hotSearchService.selectPage(page, wrapper);
        mv.addObject("page",page);
        mv.addObject("query",query);
        mv.setViewName("jx3/hotSearch/list");
        return mv;
    }


    @RequiresPermissions("addHotSearch")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView mv) {
        mv.setViewName("jx3/hotSearch/add");
        return mv;
    }


    @Log("创建热搜词")
    @RequiresPermissions("addHotSearch")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Rest add(HotSearch hotSearch) {
        hotSearch.setStatus(DelFlagEnum.NORMAL.getCode());
        hotSearch.setViewFlag(DelFlagEnum.NORMAL.getCode());
        hotSearch.setLastSearchTime(new Date());
        hotSearchService.insert(hotSearch);
        return Rest.ok();
    }

    @RequiresPermissions("updateHotSearch")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mv,@PathVariable String id) {
        mv.addObject("dto",hotSearchService.selectById(id));
        mv.setViewName("jx3/hotSearch/update");
        return mv;
    }


    @Log("修改热搜词")
    @RequiresPermissions("updateHotSearch")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Rest update(HotSearch hotSearch) {
        hotSearch.setLastSearchTime(new Date());
        hotSearchService.updateById(hotSearch);
        return Rest.ok();
    }


    @Log("删除热搜词")
    @RequiresPermissions("deleteHotSearch")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id) {
        HotSearch hotSearch = new HotSearch();
        hotSearch.setId(id);
        hotSearch.setStatus(DelFlagEnum.DELETED.getCode());
        hotSearchService.updateById(hotSearch);
        return Rest.ok();
    }

}
