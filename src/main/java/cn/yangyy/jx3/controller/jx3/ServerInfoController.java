package cn.yangyy.jx3.controller.jx3;

import cn.yangyy.jx3.common.anno.Log;
import cn.yangyy.jx3.common.bean.Rest;
import cn.yangyy.jx3.common.controller.SuperController;
import cn.yangyy.jx3.common.enums.DelFlagEnum;
import cn.yangyy.jx3.common.enums.NetworkTypesEnum;
import cn.yangyy.jx3.entity.ServerInfo;
import cn.yangyy.jx3.service.IServerInfoService;
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
 * 区服表 前端控制器
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Controller
@RequestMapping("jx3/serverInfo")
public class ServerInfoController extends SuperController {

    @Autowired
    private IServerInfoService serverInfoService;

    private void initData(ModelAndView mv) {
        mv.addObject("networkTypes", NetworkTypesEnum.values());
        mv.addObject("delFlags",DelFlagEnum.values());
    }

    @RequestMapping("list")
    @RequiresPermissions("listServer")
    public ModelAndView page(ModelAndView mv, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "15") Integer pageSize, ServerInfo serverInfo) {
        Page<ServerInfo> page = new Page<>(pageNumber, pageSize);
        Wrapper<ServerInfo> wrapper = new EntityWrapper<>();
        if (StringUtils.isNotBlank(serverInfo.getNetwork())) {
            wrapper.eq("network", serverInfo.getNetwork());
        }
        if (StringUtils.isNotBlank(serverInfo.getName())) {
            wrapper.like("name", serverInfo.getName());
        }
        if(StringUtils.isNotBlank(serverInfo.getDelFlag())){
            wrapper.eq("del_flag",serverInfo.getDelFlag());
        }
        wrapper.orderBy("sort_num",false);
        page = serverInfoService.selectPage(page, wrapper);
        mv.addObject("page", page);
        mv.addObject("query", serverInfo);
        initData(mv);
        mv.setViewName("jx3/serverInfo/list");
        return mv;
    }

    @RequiresPermissions("addServer")
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView add(ModelAndView mv) {
        initData(mv);
        mv.setViewName("jx3/serverInfo/add");
        return mv;
    }

    /**
     * 执行新增
     */
    @Log("创建区服")
    @RequiresPermissions("addServer")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ResponseBody
    public Rest add(ServerInfo serverInfo) {
        serverInfo.setDelFlag(DelFlagEnum.NORMAL.getCode());
        serverInfoService.insert(serverInfo);
        return Rest.ok();
    }

    @RequiresPermissions("updateServer")
    @RequestMapping(value = "update/{id}", method = RequestMethod.GET)
    public ModelAndView update(ModelAndView mv,@PathVariable String id) {
        initData(mv);
        mv.addObject("dto",serverInfoService.selectById(id));
        mv.setViewName("jx3/serverInfo/update");
        return mv;
    }

    /**
     * 执行新增
     */
    @Log("修改区服")
    @RequiresPermissions("updateServer")
    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Rest update(ServerInfo serverInfo) {
        serverInfoService.updateById(serverInfo);
        return Rest.ok();
    }


    /**
     * 删除用户
     */
    @Log("删除区服")
    @RequiresPermissions("deleteServer")
    @RequestMapping("/delete")
    @ResponseBody
    public Rest delete(String id) {
        ServerInfo serverInfo = new ServerInfo();
        serverInfo.setId(id);
        serverInfo.setDelFlag(DelFlagEnum.DELETED.getCode());
        serverInfoService.updateById(serverInfo);
        return Rest.ok();
    }
}
