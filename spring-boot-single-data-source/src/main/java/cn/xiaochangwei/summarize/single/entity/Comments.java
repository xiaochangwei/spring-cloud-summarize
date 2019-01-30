package cn.xiaochangwei.summarize.single.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
public class Comments implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer orderId;

    private Integer productId;

    private Integer auditStatus;

    private String titile;

    public Comments(Integer orderId, Integer productId, Integer auditStatus, String titile) {
        this.orderId = orderId;
        this.productId = productId;
        this.auditStatus = auditStatus;
        this.titile = titile;
    }
}
