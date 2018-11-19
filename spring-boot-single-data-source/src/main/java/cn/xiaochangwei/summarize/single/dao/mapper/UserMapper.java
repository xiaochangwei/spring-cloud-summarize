package cn.xiaochangwei.summarize.single.dao.mapper;

import cn.xiaochangwei.summarize.single.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by changw.xiao@qq.com at 2018/11/19 15:33
 **/
@Repository //这个注解不加也可以正常使用，但不加Autowired的地方有个找不到bean的错误
public interface UserMapper {

    List<User> findByCondition(User user);

    List<User> findByAccount(@Param("account") String account);

    int updatePassword(@Param("password") String password, @Param("id") Long id);
}
