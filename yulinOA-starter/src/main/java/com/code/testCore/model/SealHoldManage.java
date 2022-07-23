package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.SealHoldManageDO;
import com.horsecoder.yulinOA.sys.domain.SealHoldManageTO;
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
    name = {"SealHoldManageData","SealHoldManageDomain","SealHoldManageFilterMapper","SealHoldManagePostMapper","SealHoldManageUpdateMapper","SealHoldManageSimpleMapper","SealHoldManageDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","detail","detail",},
    name = {"page","rows","orderBy","holderIdIn","archiveIdIn","limitEndTimeFrom","limitEndTimeTo","holdLimitIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo","sealManage","user",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,Long.class,Long.class,Integer.class,Long.class,Long.class,Long.class,Long.class,Map.class,Map.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","String, Object","String, Object",},
    list = {false,false,true,true,true,false,false,true,false,false,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {SealHoldManageDO.class,SealHoldManageTO.class,}
)
@TestModel
public class SealHoldManage {
  /**
   * 印章持有ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 持有人ID
   */
  private String holderId;

  /**
   * 印章Id
   */
  private String archiveId;

  /**
   * 截止日期
   */
  @MapperIgnore({"filter", })
  @MapperModify(
      value = {"post", "update", "simple", "detail", "filter",},
      modify = {"modifyTime", "modifyTime", "modifyTime", "modifyTime", "modifyTime",},
      recover = {"recoverTime", "recoverTime", "recoverTime", "recoverTime", "recoverTime",}
  )
  private Date limitEndTime;

  /**
   * 持有期限
   */
  private Integer holdLimit;

  /**
   * 状态
   */
  private Integer state;

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
