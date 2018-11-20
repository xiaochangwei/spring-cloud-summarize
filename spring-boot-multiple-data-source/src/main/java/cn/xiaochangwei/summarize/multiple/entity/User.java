package cn.xiaochangwei.summarize.multiple.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

/**
 * create by changw.xiao@qq.com at 2018/11/19 9:52
 **/
//@Entity
//@Table(name = "t_user", uniqueConstraints = {
//        @UniqueConstraint(columnNames = {"account"}),
//        @UniqueConstraint(columnNames = {"IDCard"})
//})
@Data
public class User implements Serializable{
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{user.account.empty}")
//    @Email(message = "邮箱格式错误")
    private String account;

    private String password;

    //    @Range(min = 0, max = 150)
    private int age;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bornDate = new Date();

    //        @NotEmpty
//    @Size(min = 18, max = 18, message = "字符串长度要求18到18之间。")
//    @Pattern(regexp = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
//            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)")
    private String IDCard;

    private String provinceCode;
}
