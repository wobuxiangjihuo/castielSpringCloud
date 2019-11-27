package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@AllArgsConstructor //全参构造子
@NoArgsConstructor  //无参构造子
/*@Accessors(chain = true)*/
public class Dept implements Serializable
{
    private Long deptNo;   //主键
    private String dName;  //部门名称
    private String db_source; //来之哪个数据库,因为微服务架构可以对应一个数据库,同一个信息被存到不同数据库
}
