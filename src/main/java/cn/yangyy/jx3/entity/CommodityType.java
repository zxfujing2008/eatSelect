package cn.yangyy.jx3.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 商品类别表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@TableName("jx3_commodity_type")
public class CommodityType extends Model<CommodityType> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.UUID)
	private String id;
	private String name;
    /**
     * 排序（倒序排列）
     */
	@TableField("sort_num")
	private Integer sortNum;

	/**
	 * 删除标记
	 */
	@TableField("del_flag")
	private String delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
