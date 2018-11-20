package cn.xiaochangwei.summarize.multiple.dao.jpa.slave;

import cn.xiaochangwei.summarize.multiple.entity.slave.SlaveUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create by changw.xiao@qq.com at 2018/11/20 10:49
 **/
@Repository
public interface SlaveUserRepo extends JpaRepository<SlaveUser, Long> {
}
