package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.constants.Constant;
import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.dao.repo.User2Repository;
import cn.xiaochangwei.summarize.single.dao.repo.UserPageRepository;
import cn.xiaochangwei.summarize.single.dao.repo.UserRepository;
import cn.xiaochangwei.summarize.single.entity.User;
import cn.xiaochangwei.summarize.single.entity.User2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * create by changw.xiao@qq.com at 2018/11/19 13:43
 **/
@RestController
@RequestMapping("/jpa")
public class JpaTestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserPageRepository userPageRepository;

    @GetMapping("/pageable")
    public Result pageable(@RequestParam(name = "pn", required = false, defaultValue = "0") Integer pn) {
        PageRequest pageRequest = PageRequest.of(pn, Constant.PAGE_SIZE, Sort.Direction.DESC, "account", "provinceCode");
        return new Result(userPageRepository.findAllByAgeGreaterThan(10, pageRequest).getContent());
    }

    @GetMapping("/normal")
    public Result getData(@RequestParam(name = "age", required = false, defaultValue = "0") Integer age, @RequestParam(name = "provinceCode", required = false, defaultValue = "51") String provinceCode) {
//        return new Result(userRepository.getOne(1L));
        //jpa2中使用getOne时，会报错，原因是getOne返回的是代理对象，在转为对象时，session已经关闭，而部分延迟加载的内容无法获取就报错，可以在entity上加@JsonIgnoreProperties({"hibernateLazyInitializer"})解决https://blog.csdn.net/xiewz1112/article/details/83338179
        //但是并不可取，应该用findById进行相关操作

        return new Result(userRepository.findAllByAgeGreaterThanAndProvinceCodeOrderByAccountAscProvinceCodeDesc(age, provinceCode));
    }


    @Autowired
    User2Repository user2Repository;

    @PostMapping("/trasactional")
    @Transactional //@Transactional(rollbackFor = RuntimeException.class) //默认是RuntimeException异常时才回滚
    //    @Transactional(rollbackFor = Exception.class) //非RuntimeException异常时指明对应异常类型
    public Result trasactional(@Valid User user) {
        userRepository.saveAndFlush(user);
        //TODO 连续两次调用userRepository.saveAndFlush(user)未报唯一索引存在错误，仅插入一条数据，待研究......

        User2 user2 = new User2();
        user2.setAccount(user.getAccount());
        user2Repository.saveAndFlush(user2);
        return new Result(null);
    }
}
