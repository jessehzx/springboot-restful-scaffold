package com.jessehzx.springbootrestfulscaffold.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jessehzx.springbootrestfulscaffold.user.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author huangzx
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
