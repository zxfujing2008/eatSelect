package cn.yangyy.jx3.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import cn.yangyy.jx3.entity.SysSetting;

/**
 *
 * SysSetting 表数据服务层接口
 *
 */
public interface ISysSettingService extends IService<SysSetting> {

	List<SysSetting> findAll();


}