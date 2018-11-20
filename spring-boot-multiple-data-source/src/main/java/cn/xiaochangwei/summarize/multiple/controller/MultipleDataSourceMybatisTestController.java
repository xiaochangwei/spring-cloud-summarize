package cn.xiaochangwei.summarize.multiple.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.multiple.dao.mybatis.master.MasterUserMapper;
import cn.xiaochangwei.summarize.multiple.dao.mybatis.slave.SlaveUserMapper;
import cn.xiaochangwei.summarize.multiple.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/11/19 18:59
 **/
@RestController
@RequestMapping("/mybatis")
public class MultipleDataSourceMybatisTestController {

    @Autowired
    MasterUserMapper masterUserMapper;

    @Autowired
    @Qualifier("masterJdbcTemplate")
    JdbcTemplate masterJdbcTemplate;

    @Autowired
    SlaveUserMapper slaveUserMapper;

    @Autowired
    @Qualifier("slaveJdbcTemplate")
    JdbcTemplate slaveJdbcTemplate;

    @GetMapping("/master")
    public Result master() {
        return new Result(masterUserMapper.findByAccount("master"));
    }

    @GetMapping("/master/t")
    @Transactional(transactionManager = "masterTransactionManager") //需显示指定一个事务管理器，因为没有配置默认的，可以在一个事务管理器上增加@Primary设为默认的
    //同样，事务默认是对RunTimeException进行回滚，如果不是，则需要指定rollbackFor
    public Result masterTrasactional() {
        masterUserMapper.updatePassword(UUID.randomUUID().toString(), 1L);
        int i = 8 / 0;
        return new Result();
    }

    @GetMapping("/master/jdbc")
    public Result masterJdbc() {
        String sql = "SELECT id, idcard AS IDCard, account, age, born_date AS bornDate, `password`, province_code AS provinceCode FROM `t_user`";
        return new Result(masterJdbcTemplate.queryForList(sql));
    }


    @GetMapping("/slave")
    public Result slave() {
        return new Result(slaveUserMapper.findByAccount("slave"));
    }

    @GetMapping("/slave/jdbc")
    public Result slaveJdbc() {
        String sql = "SELECT id, idcard AS IDCard, account, age, born_date AS bornDate, `password`, province_code AS provinceCode FROM `t_user`";
        return new Result(slaveJdbcTemplate.queryForList(sql));
    }
}
