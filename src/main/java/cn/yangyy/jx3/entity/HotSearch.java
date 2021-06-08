package cn.yangyy.jx3.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 热搜关键字管理
 * </p>
 *
 * @author zhaox
 * @since 2018-10-31
 */
@TableName("jx3_hot_search")
public class HotSearch extends Model<HotSearch> {

    private static final long serialVersionUID = 1L;

	@TableId(type= IdType.UUID)
	private String id;
	@TableField("search_text")
	private String searchText;
	@TableField("search_count")
	private Long searchCount;
    /**
     * 0指定，1系统
     */
	private String status;
    /**
     * 0显示，1隐藏
     */
	@TableField("view_flag")
	private String viewFlag;
	@TableField("last_search_time")
	private Date lastSearchTime;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSearchText() {
		return searchText;
	}

	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}

	public Long getSearchCount() {
		return searchCount;
	}

	public void setSearchCount(Long searchCount) {
		this.searchCount = searchCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getViewFlag() {
		return viewFlag;
	}

	public void setViewFlag(String viewFlag) {
		this.viewFlag = viewFlag;
	}

	public Date getLastSearchTime() {
		return lastSearchTime;
	}

	public void setLastSearchTime(Date lastSearchTime) {
		this.lastSearchTime = lastSearchTime;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
