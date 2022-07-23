package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.CarDO;
import com.horsecoder.yulinOA.sys.domain.CarTO;
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
    name = {"CarData","CarDomain","CarFilterMapper","CarPostMapper","CarUpdateMapper","CarSimpleMapper","CarDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","driverNameLike","driverPhoneLike","carIDLike","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","carParkList","enterprise",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,false,false,false,false,false,false,false,true,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {CarDO.class,CarTO.class,}
)
@TestModel
public class Car {
  /**
   * 车辆ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 车主姓名
   */
  private String driverName;

  /**
   * 联系电话
   */
  private String driverPhone;

  /**
   * 车牌号
   */
  private String carID;

  /**
   * 停车类型
   */
  private String parkType;

  /**
   * 车辆状态
   */
  private String carState;

  /**
   * 停车时长
   */
  @MapperIgnore({"post", "update","filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date stopTime;

  /**
   * 企业ID
   */
  private String enterpriseId;

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
