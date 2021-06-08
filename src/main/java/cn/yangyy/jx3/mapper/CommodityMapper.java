package cn.yangyy.jx3.mapper;

import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.vo.CommodityVo;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
  * 商品表 Mapper 接口
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
public interface CommodityMapper extends BaseMapper<Commodity> {

    List<CommodityVo> selectPage(Pagination page, @Param("commodity") Commodity commodity);

}