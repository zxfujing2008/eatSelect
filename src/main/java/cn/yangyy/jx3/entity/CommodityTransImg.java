package cn.yangyy.jx3.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 报价成交图片表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-29
 */
@TableName("jx3_commodity_trans_img")
public class CommodityTransImg extends Model<CommodityTransImg> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	private String id;
    /**
     * 报价主键
     */
	@TableField("commodity_trans_id")
	private String commodityTransId;
    /**
     * 图片
     */
	private String path;
    /**
     * 创建者
     */
	@TableField("create_by")
	private String createBy;
	@TableField("create_date")
	private Date createDate;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCommodityTransId() {
		return commodityTransId;
	}

	public void setCommodityTransId(String commodityTransId) {
		this.commodityTransId = commodityTransId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
