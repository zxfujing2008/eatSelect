package cn.yangyy.jx3.mapper;

import cn.yangyy.jx3.entity.CommodityTrans;
import cn.yangyy.jx3.entity.vo.CommodityTransVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 成交价格表 Mapper 接口
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
public interface CommodityTransMapper extends BaseMapper<CommodityTrans> {

    List<CommodityTransVo> pageInfo(Pagination page, @Param("query") CommodityTrans query);
}