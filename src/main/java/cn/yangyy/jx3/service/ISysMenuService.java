package cn.yangyy.jx3.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import cn.yangyy.jx3.entity.SysMenu;
import cn.yangyy.jx3.entity.vo.TreeMenu;
import cn.yangyy.jx3.entity.vo.TreeMenuAllowAccess;

/**
 *
 * SysMenu 表数据服务层接口
 *
 */
public interface ISysMenuService extends IService<SysMenu> {

	/**
	 * 获取指定用户拥有的菜单
	 */
	List<String> selectMenuIdsByuserId(String uid);
	/**
	 * 获取指定用户的菜单
	 * @param  menuIds 当前用户所在角色拥有的权限ID集合
	 * @param  pid 菜单父ID
	 */
	List<TreeMenu> selectTreeMenuByMenuIdsAndPid(List<String> menuIds,String pid);
	/**
	 * 获取当前用户的菜单
	 */
	List<TreeMenu> selectTreeMenuByUserId(String uid);
	/**
	 * 获取指定用户拥有权限
	 * @param  menuIds 该角色拥有的权限ID集合
	 * @param  pid 菜单父ID
	 */
	List<TreeMenuAllowAccess> selectTreeMenuAllowAccessByMenuIdsAndPid(List<String> menuIds,String pid);

}