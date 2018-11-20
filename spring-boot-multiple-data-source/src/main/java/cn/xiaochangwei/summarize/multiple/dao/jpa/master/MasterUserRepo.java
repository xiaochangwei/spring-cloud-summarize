package cn.xiaochangwei.summarize.multiple.dao.jpa.master;

import cn.xiaochangwei.summarize.multiple.entity.master.MasterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * create by changw.xiao@qq.com at 2018/11/20 10:49
 **/
@Repository
public interface MasterUserRepo extends JpaRepository<MasterUser,Long>{
}
