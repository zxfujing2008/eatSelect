package cn.yangyy.jx3.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 区服表
 * </p>
 *
 * @author zhaox
 * @since 2018-10-26
 */
@TableName("jx3_server_info")
public class ServerInfo extends Model<ServerInfo> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(type= IdType.UUID)
	private String id;
    /**
     * 网络类型
     */
	private String network;
    /**
     * 区服序号
     */
	private String serial;
    /**
     * 服务器名
     */
	private String name;
    /**
     * 描述
     */
	private String remarks;

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

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}
}
