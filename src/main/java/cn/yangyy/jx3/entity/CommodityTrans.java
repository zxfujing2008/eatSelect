package cn.yangyy.jx3.entity;

import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 成交价格表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@TableName("jx3_commodity_trans")
public class CommodityTrans extends Model<CommodityTrans> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.INPUT)
	private String id;
    /**
     * 商品
     */
	@TableField("commodity_id")
	private String commodityId;
    /**
     * 区服
     */
	@TableField("server_id")
	private String serverId;
    /**
     * 成交价格
     */
	@TableField("deal_price")
	private BigDecimal dealPrice;
    /**
     * 报价人
     */
	private String quotation;
    /**
     * 成交日期
     */
	@TableField("transaction_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date transactionDate;
    /**
     * 三方平台
     */
	@TableField("trd_platform")
	private String trdPlatform;
    /**
     * 成交截图
     */
	private String img;
    /**
     * 创建者
     */
	@TableField("create_by")
	private String createBy;
    /**
     * 创建时间
     */
	@TableField("create_date")
	private Date createDate;
	/**
	 * 删除标记
	 */
	@TableField("del_flag")
	private String delFlag;

	/**
	 * 描述
	 */
	private String remarks;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getServerId() {
		return serverId;
	}

	public void setServerId(String serverId) {
		this.serverId = serverId;
	}

	public BigDecimal getDealPrice() {
		return dealPrice;
	}

	public void setDealPrice(BigDecimal dealPrice) {
		this.dealPrice = dealPrice;
	}

	public String getQuotation() {
		return quotation;
	}

	public void setQuotation(String quotation) {
		this.quotation = quotation;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTrdPlatform() {
		return trdPlatform;
	}

	public void setTrdPlatform(String trdPlatform) {
		this.trdPlatform = trdPlatform;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
