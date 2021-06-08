package cn.yangyy.jx3.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 商品图片表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@TableName("jx3_commodity_img")
public class CommodityImg extends Model<CommodityImg> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.UUID)
	private String id;

	/**
	 * 商品主键
	 */
	@TableField("commodity_id")
	private String commodityId;
    /**
     * 名称
     */
	private String name;
    /**
     * 描述
     */
	private String remarks;
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

	public String getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(String commodityId) {
		this.commodityId = commodityId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
