package cn.yangyy.jx3.service;

import cn.yangyy.jx3.entity.CommodityTrans;
import cn.yangyy.jx3.entity.vo.CommodityTransVo;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 成交价格表 服务类
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
public interface ICommodityTransService extends IService<CommodityTrans> {

    Page<CommodityTransVo> pageInfo(Page<CommodityTransVo> page, CommodityTrans commodity);
}
