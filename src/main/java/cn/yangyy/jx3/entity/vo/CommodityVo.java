package cn.yangyy.jx3.entity.vo;

import cn.yangyy.jx3.entity.Commodity;
import cn.yangyy.jx3.entity.CommodityImg;

import java.util.List;

/**
 * 商品
 */
public class CommodityVo extends Commodity {

    private static final long serialVersionUID = -1458152085200651351L;
    private List<CommodityImg> imgs;

    public List<CommodityImg> getImgs() {
        return imgs;
    }

    public void setImgs(List<CommodityImg> imgs) {
        this.imgs = imgs;
    }
}
