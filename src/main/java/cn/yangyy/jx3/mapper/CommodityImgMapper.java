package cn.yangyy.jx3.mapper;

import cn.yangyy.jx3.entity.CommodityImg;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
  * 商品图片表 Mapper 接口
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
public interface CommodityImgMapper extends BaseMapper<CommodityImg> {


    List<CommodityImg> findById(String id);
}