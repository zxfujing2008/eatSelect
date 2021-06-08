package cn.yangyy.jx3.service.impl;

import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.vo.CommodityVo;
import cn.yangyy.jx3.mapper.CommodityMapper;
import cn.yangyy.jx3.service.ICommodityService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 商品表 服务实现类
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Service
public class CommodityServiceImpl extends ServiceImpl<CommodityMapper, Commodity> implements ICommodityService {

    @Autowired
    private CommodityMapper commodityMapper;


    @Override
    public Page<CommodityVo> pageInfo(Page page, Commodity commodity) {
        List<CommodityVo> commodityVos = commodityMapper.selectPage(page, commodity);
        page.setRecords(commodityVos);
        return page;
    }
}
