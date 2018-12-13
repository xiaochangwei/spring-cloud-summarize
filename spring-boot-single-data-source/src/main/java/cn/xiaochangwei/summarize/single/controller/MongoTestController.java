package cn.xiaochangwei.summarize.single.controller;

import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.single.entity.MongoVo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/12/5 16:47
 **/
@RestController
@RequestMapping("/mongo")
@Slf4j
public class MongoTestController {
    @Autowired
    MongoTemplate mongoTemplate;

    @GetMapping("/insert")
    public Result insertTest() {
        for (int j = 0; j < 2; j++) {
            List<MongoVo> mongoVoList = new ArrayList<>();
            for (int i = 0; i < 2; i++) {
                mongoVoList.add(new MongoVo(UUID.randomUUID().toString(), UUID.randomUUID().toString(), new Random().nextInt(1000), new Random().nextInt(100), new Random().nextInt(100)));
            }
            mongoTemplate.insert(mongoVoList, MongoVo.class);
            log.info("inserted {}", mongoVoList.size());
        }
        return Result.success();
    }

    @GetMapping("/get")
    public Result getTest() {
        Query query = new Query();
        Criteria cacheCriteria = new Criteria();
        cacheCriteria.and("key1").regex(".*?d440.*");
        cacheCriteria.and("key3").lte(10);
        cacheCriteria.and("key2").gte(900);
        query.addCriteria(cacheCriteria);
        long start = System.currentTimeMillis();
        long result = mongoTemplate.count(query, MongoVo.class);
        System.out.println("spent " + (System.currentTimeMillis() - start));
        return Result.success(result);
    }

    @GetMapping("/query")
    public Result queryTest() {
        Query query = new Query();
        Criteria cacheCriteria = new Criteria();
        cacheCriteria.and("key1").regex(".*?d440.*");
        cacheCriteria.and("key3").lte(10);
        cacheCriteria.and("key2").gte(900);
        query.addCriteria(cacheCriteria);
        long start = System.currentTimeMillis();
        List<MongoVo> result = mongoTemplate.find(query.with(new Sort(Sort.Direction.DESC, "key2")).skip(10).limit(1000), MongoVo.class);
        System.out.println("spent " + (System.currentTimeMillis() - start));
        return Result.success(result);
    }
}
