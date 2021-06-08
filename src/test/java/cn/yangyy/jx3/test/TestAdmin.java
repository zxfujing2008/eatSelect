package cn.yangyy.jx3.test;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.yangyy.jx3.service.ISysMenuService;
import cn.yangyy.jx3.service.ISysRoleMenuService;
import cn.yangyy.jx3.service.ISysRoleService;
import cn.yangyy.jx3.service.ISysUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring/applicationContext-dao.xml",
		"classpath:spring/applicationContext-service.xml"
})
public class TestAdmin {
	
	@Autowired private ISysRoleService sysRoleService;
	@Autowired private ISysRoleMenuService sysRoleMenuService;
	@Autowired private ISysMenuService sysMenuService;
	@Autowired private ISysUserService sysUserService;
	
//	/**
//	 * 创建一个Admin用户
//	 */
//	@Test
//	public void addAdmin() {
//
//		//创建角色
//		SysRole sysRole = new SysRole();
//		sysRole.setRoleName("超级管理员");
//		sysRole.setRoleState(1);
//		sysRole.setCreateTime(new Date());
//		sysRoleService.insert(sysRole);
//		//查询权限
//		List<Object> list = sysMenuService.selectObjs(new EntityWrapper<SysMenu>().setSqlSelect("id"));
//		//分配权限
//		sysRoleMenuService.addAuth(sysRole.getId(),list.toArray(new String[list.size()]));
//		//添加用户
//		SysUser user = new SysUser();
//		user.setUserState(1);
//		user.setUserName("admin");
//		user.setPassword("123456");
//		user.setCreateTime(new Date());
//		sysUserService.insertUser(user, new String[]{sysRole.getId()});
//
//	}
	
	/**
	 * 修改Admin的密码位123456
	 */
	@Test
	public void changeAdminPwd() {
		// MD5,"密码","盐",加密次数

		String pwd = new SimpleHash("MD5", "123456", "admin", 1024).toString();
		pwd = new SimpleHash("MD5", "cll310", "cll", 1024).toString();
		System.out.println(pwd);
	}

}
