package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.BlacklistDO;
import com.horsecoder.yulinOA.sys.domain.BlacklistTO;
import lombok.*;

import java.util.Date;
import java.util.Map;

/**
 * Author: horsecoder
 * Email: eamon@horsecoder.com
 */
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Mapper(
    value = {"data","domain","filter","post","update","simple","detail",},
    name = {"BlacklistData","BlacklistDomain","BlacklistFilterMapper","BlacklistPostMapper","BlacklistUpdateMapper","BlacklistSimpleMapper","BlacklistDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","detail",},
    name = {"page","rows","orderBy","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","car",},
    type = {Long.class,Integer.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","String, Object",},
    list = {false,false,true,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {BlacklistDO.class,BlacklistTO.class,}
)
@TestModel
public class Blacklist {
  /**
   * 黑名单ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 操作人
   */
  private String operator;

  /**
   * 操作时间
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date operateTime;

  /**
   * 车辆ID
   */
  @MapperIgnore({"post", "update",})
  private String carId;

  /**
   * 设置原因
   */
  private String reason;

  /**
   * 更新时间
   */
  @MapperIgnore({"post", "update","filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date gmtUpdate;

  /**
   * 创建时间
   */
  @MapperIgnore({"post", "update","filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date gmtCreate;

  Long modifyTime(Date date) {
    if (date == null) return null;
    return date.getTime();
  }

  Date recoverTime(Long time) {
    if (time == null) return null;
    return new Date(time);
  }
}
