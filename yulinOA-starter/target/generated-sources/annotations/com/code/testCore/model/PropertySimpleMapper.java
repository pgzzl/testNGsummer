package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class PropertySimpleMapper {
  public String id;

  public String firmName;

  public String rentPlace;

  public String linkman;

  public String linkPhone;

  public Long enterTime;

  public String costType;

  public String costState;

  public Integer waitPayNum;

  public String enterpriseId;

  public Long gmtUpdate;

  public Long gmtCreate;

  public PropertySimpleMapper() {
  }

  public PropertySimpleMapper(String id, String firmName, String rentPlace, String linkman,
      String linkPhone, Long enterTime, String costType, String costState, Integer waitPayNum,
      String enterpriseId, Long gmtUpdate, Long gmtCreate) {
    this.id=id;
    this.firmName=firmName;
    this.rentPlace=rentPlace;
    this.linkman=linkman;
    this.linkPhone=linkPhone;
    this.enterTime=enterTime;
    this.costType=costType;
    this.costState=costState;
    this.waitPayNum=waitPayNum;
    this.enterpriseId=enterpriseId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static PropertySimpleMapper buildMapper(Property obj) {
    PropertySimpleMapper mapper = new PropertySimpleMapper();
    mapper.id=obj.getId();
    mapper.firmName=obj.getFirmName();
    mapper.rentPlace=obj.getRentPlace();
    mapper.linkman=obj.getLinkman();
    mapper.linkPhone=obj.getLinkPhone();
    mapper.enterTime=obj.modifyTime(obj.getEnterTime());
    mapper.costType=obj.getCostType();
    mapper.costState=obj.getCostState();
    mapper.waitPayNum=obj.getWaitPayNum();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("firmName",this.firmName);
    map.put("rentPlace",this.rentPlace);
    map.put("linkman",this.linkman);
    map.put("linkPhone",this.linkPhone);
    map.put("enterTime",this.enterTime);
    map.put("costType",this.costType);
    map.put("costState",this.costState);
    map.put("waitPayNum",this.waitPayNum);
    map.put("enterpriseId",this.enterpriseId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Property obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("firmName", obj.getFirmName());
    map.put("rentPlace", obj.getRentPlace());
    map.put("linkman", obj.getLinkman());
    map.put("linkPhone", obj.getLinkPhone());
    map.put("enterTime", obj.modifyTime(obj.getEnterTime()));
    map.put("costType", obj.getCostType());
    map.put("costState", obj.getCostState());
    map.put("waitPayNum", obj.getWaitPayNum());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Property obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("firmName", JSONObject.toJSONString(obj.getFirmName()));
    map.put("rentPlace", JSONObject.toJSONString(obj.getRentPlace()));
    map.put("linkman", JSONObject.toJSONString(obj.getLinkman()));
    map.put("linkPhone", JSONObject.toJSONString(obj.getLinkPhone()));
    map.put("enterTime", JSONObject.toJSONString(obj.modifyTime(obj.getEnterTime())));
    map.put("costType", JSONObject.toJSONString(obj.getCostType()));
    map.put("costState", JSONObject.toJSONString(obj.getCostState()));
    map.put("waitPayNum", JSONObject.toJSONString(obj.getWaitPayNum()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Property buildEntity() {
    Property obj = new Property();
    obj.setId(this.id);
    obj.setFirmName(this.firmName);
    obj.setRentPlace(this.rentPlace);
    obj.setLinkman(this.linkman);
    obj.setLinkPhone(this.linkPhone);
    obj.setEnterTime(obj.recoverTime(this.enterTime));
    obj.setCostType(this.costType);
    obj.setCostState(this.costState);
    obj.setWaitPayNum(this.waitPayNum);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Property parseEntity(Map<String, Object> map) {
    Property obj = new Property();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setFirmName((String) map.get("firmName"));
    obj.setRentPlace((String) map.get("rentPlace"));
    obj.setLinkman((String) map.get("linkman"));
    obj.setLinkPhone((String) map.get("linkPhone"));
    obj.setEnterTime(obj.recoverTime((Long) map.get("enterTime")));
    obj.setCostType((String) map.get("costType"));
    obj.setCostState((String) map.get("costState"));
    obj.setWaitPayNum((Integer) map.get("waitPayNum"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Property parseSerialEntity(Map<String, String> map) {
    Property obj = new Property();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setFirmName(JSONObject.parseObject(map.get("firmName"), String.class));
    obj.setRentPlace(JSONObject.parseObject(map.get("rentPlace"), String.class));
    obj.setLinkman(JSONObject.parseObject(map.get("linkman"), String.class));
    obj.setLinkPhone(JSONObject.parseObject(map.get("linkPhone"), String.class));
    obj.setEnterTime(obj.recoverTime(JSONObject.parseObject(map.get("enterTime"), Long.class)));
    obj.setCostType(JSONObject.parseObject(map.get("costType"), String.class));
    obj.setCostState(JSONObject.parseObject(map.get("costState"), String.class));
    obj.setWaitPayNum(JSONObject.parseObject(map.get("waitPayNum"), Integer.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}
