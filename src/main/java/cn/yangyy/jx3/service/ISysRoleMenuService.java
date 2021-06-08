package cn.yangyy.jx3.service;

import java.util.List;
import java.util.Set;

import com.baomidou.mybatisplus.service.IService;
import cn.yangyy.jx3.entity.SysRoleMenu;

/**
 *
 * SysRoleMenu 表数据服务层接口
 *
 */
public interface ISysRoleMenuService extends IService<SysRoleMenu> {
	
	/**
	 * 角色授权
	 */
	void addAuth(String roleId, String[] menuIds);
	
	/**
	 * 获取指定角色的权限
	 */
	List<SysRoleMenu> selectByRole(String roleId);

	Set<String> findMenusByUid(String id);


}