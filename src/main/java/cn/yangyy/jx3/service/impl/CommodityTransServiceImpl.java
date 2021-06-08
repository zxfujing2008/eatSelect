package cn.yangyy.jx3.service.impl;

import cn.yangyy.jx3.entity.CommodityTrans;
import cn.yangyy.jx3.entity.vo.CommodityTransVo;
import cn.yangyy.jx3.mapper.CommodityTransMapper;
import cn.yangyy.jx3.service.ICommodityTransService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 成交价格表 服务实现类
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@Service
public class CommodityTransServiceImpl extends ServiceImpl<CommodityTransMapper, CommodityTrans> implements ICommodityTransService {

    @Autowired
    private CommodityTransMapper commodityTransMapper;



    @Override
    public Page<CommodityTransVo> pageInfo(Page<CommodityTransVo> page, CommodityTrans commodity) {
        List<CommodityTransVo> commodityVos = commodityTransMapper.pageInfo(page, commodity);
        page.setRecords(commodityVos);
        return page;
    }
}
