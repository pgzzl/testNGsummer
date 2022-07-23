package com.code.testCore.model;

import cc.eamon.open.mapping.mapper.*;
import com.code.testCore.config.annotations.TestModel;
import com.horsecoder.yulinOA.sys.dataobject.GroupDO;
import com.horsecoder.yulinOA.sys.domain.GroupTO;
import lombok.*;

import java.util.Date;

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
    name = {"GroupData","GroupDomain","GroupFilterMapper","GroupPostMapper","GroupUpdateMapper","GroupSimpleMapper","GroupDetailMapper",}
)
@MapperExtra(
    value = {"filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter","filter",},
    name = {"page","rows","orderBy","headImgLike","headImgIn","groupNameLike","groupNameIn","groupPeopleLike","groupPeopleIn","gmtUpdateFrom","gmtUpdateTo","gmtCreateFrom","gmtCreateTo",},
    type = {Long.class,Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,Long.class,Long.class,Long.class,Long.class,},
    typeArgs = {"null","null","null","null","null","null","null","null","null","null","null","null","null",},
    list = {false,false,true,false,true,false,true,false,true,false,false,false,false,}
)
@MapperConvert(
    value = {"data","domain",},
    type = {GroupDO.class,GroupTO.class,}
)
@TestModel
public class Group {
  /**
   * 群聊ID
   */
  @MapperIgnore({"post",})
  private String id;

  /**
   * 群头像
   */
  private String headImg;

  /**
   * 群名称
   */
  private String groupName;

  /**
   * 群成员
   */
  private String groupPeople;

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
