package cn.xiaochangwei.summarize.multiple.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.multiple.dao.jpa.master.MasterUserRepo;
import cn.xiaochangwei.summarize.multiple.dao.jpa.slave.SlaveUserRepo;
import cn.xiaochangwei.summarize.multiple.entity.master.MasterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/11/20 11:03
 **/
@RestController
@RequestMapping("/jpa")
public class MultipleDataSourceJpaTestController {

    @Autowired
    MasterUserRepo masterUserRepo;

    @Autowired
    SlaveUserRepo slaveUserRepo;

    @GetMapping("/master")
    public Result masterJpa() {
        return new Result(masterUserRepo.findAll());
    }

    @GetMapping("/master/t")
    @Transactional(transactionManager = "masterJpaTransactionManager",rollbackFor = Exception.class)
    public Result masterJpaTransactional() {
        MasterUser masterUser = new MasterUser();
        masterUser.setAccount(UUID.randomUUID().toString());
        masterUser.setIDCard(UUID.randomUUID().toString());
        masterUserRepo.saveAndFlush(masterUser);
        int i = 100 / 0;
        return new Result();
    }

    @GetMapping("/slave")
    public Result slaveJpa() {
        return new Result(slaveUserRepo.findAll());
    }
}
