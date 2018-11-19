package cn.xiaochangwei.summarize.single.dao.repo;

import cn.xiaochangwei.summarize.single.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * create by changw.xiao@qq.com at 2018/11/19 13:41
 **/
@Repository
public interface UserPageRepository extends PagingAndSortingRepository<User, Long> {
    Page<User> findAllByAgeGreaterThan(Integer age, Pageable pageable);
}
