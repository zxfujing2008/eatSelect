package cn.yangyy.jx3.mapper;

import java.util.List;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import cn.yangyy.jx3.entity.SysUserRole;

/**
 *
 * SysUserRole 表数据库控制层接口
 *
 */
public interface SysUserRoleMapper extends BaseMapper<SysUserRole> {

	List<String> selectPermissionByUid(String uid);

}