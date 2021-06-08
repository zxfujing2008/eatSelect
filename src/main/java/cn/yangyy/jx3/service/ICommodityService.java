package cn.yangyy.jx3.service;

import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.vo.CommodityVo;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * 商品表 服务类
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
public interface ICommodityService extends IService<Commodity> {

     Page<CommodityVo> pageInfo(Page<CommodityVo> page, Commodity commodity);
}
