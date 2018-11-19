package cn.xiaochangwei.summarize.single.dao.repo;

import cn.xiaochangwei.summarize.single.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * create by changw.xiao@qq.com at 2018/11/19 13:41
 **/
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByAgeGreaterThanAndProvinceCodeOrderByAccountAscProvinceCodeDesc(Integer age, String provinceCode);
}
