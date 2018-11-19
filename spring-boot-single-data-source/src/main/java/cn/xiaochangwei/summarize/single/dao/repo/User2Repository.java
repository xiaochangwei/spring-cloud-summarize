package cn.xiaochangwei.summarize.single.dao.repo;

import cn.xiaochangwei.summarize.single.entity.User2;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create by changw.xiao@qq.com at 2018/11/19 13:41
 **/
@Repository
public interface User2Repository extends JpaRepository<User2, Long> {
}
