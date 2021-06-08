package cn.yangyy.jx3.entity;

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
 * 商品表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@TableName("jx3_commodity")
public class Commodity extends Model<Commodity> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.UUID)
	private String id;
    /**
     * 类型
     */
	@TableField("type_id")
	private String typeId;
    /**
     * 名称
     */
	private String name;
    /**
     * 别名
     */
	private String alias;
    /**
     * 发行日期
     */
	@TableField("publish_date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishDate;
    /**
     * 描述
     */
	private String remarks;
    /**
     * 创建者
     */
	@TableField("create_by")
	private String createBy;
    /**
     * 创建时间
     */
	@TableField("create_date")
//	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createDate;
    /**
     * 删除标记
     */
	@TableField("del_flag")
	private String delFlag;

	/**
	 * 排序（倒序排列）
	 */
	@TableField("sort_num")
	private Integer sortNum;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}
}
