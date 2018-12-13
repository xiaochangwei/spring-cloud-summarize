package cn.xiaochangwei.summarize.single.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * create by changw.xiao@qq.com at 2018/12/5 16:50
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "mongo_index")
@CompoundIndexes(@CompoundIndex(def = "{'key2':1,'key3':-1,'key1':1}"))
public class MongoVo implements Serializable {
    @Indexed
    @Id
    private String id;

    private String key1;

    private Integer key2;

    private Integer key3;

    private Integer key4;
}
