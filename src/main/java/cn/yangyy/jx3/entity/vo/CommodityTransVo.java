package cn.yangyy.jx3.entity.vo;

import cn.yangyy.jx3.entity.CommodityTrans;

/**
 *
 */
public class CommodityTransVo extends CommodityTrans {


    private static final long serialVersionUID = 6472574742418741686L;
    /**
     * 商品名称
     */
    private String commodityName;

    /**
     * 服务器名称
     */
    private String serverName;
    private String network;
    private String serial;

    public String getCommodityName() {
        return commodityName;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }
}
