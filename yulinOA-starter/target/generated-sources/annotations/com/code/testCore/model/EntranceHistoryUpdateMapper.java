package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EntranceHistoryUpdateMapper {
  public String id;

  public String entranceGuardId;

  public String staffName;

  public String tellPhone;

  public Long useDate;

  public Integer inOrOut;

  public String entranceName;

  public String photo;

  public EntranceHistoryUpdateMapper() {
  }

  public EntranceHistoryUpdateMapper(String id, String entranceGuardId, String staffName,
      String tellPhone, Long useDate, Integer inOrOut, String entranceName, String photo) {
    this.id=id;
    this.entranceGuardId=entranceGuardId;
    this.staffName=staffName;
    this.tellPhone=tellPhone;
    this.useDate=useDate;
    this.inOrOut=inOrOut;
    this.entranceName=entranceName;
    this.photo=photo;
  }

  public static EntranceHistoryUpdateMapper buildMapper(EntranceHistory obj) {
    EntranceHistoryUpdateMapper mapper = new EntranceHistoryUpdateMapper();
    mapper.id=obj.getId();
    mapper.entranceGuardId=obj.getEntranceGuardId();
    mapper.staffName=obj.getStaffName();
    mapper.tellPhone=obj.getTellPhone();
    mapper.useDate=obj.modifyTime(obj.getUseDate());
    mapper.inOrOut=obj.getInOrOut();
    mapper.entranceName=obj.getEntranceName();
    mapper.photo=obj.getPhoto();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("entranceGuardId",this.entranceGuardId);
    map.put("staffName",this.staffName);
    map.put("tellPhone",this.tellPhone);
    map.put("useDate",this.useDate);
    map.put("inOrOut",this.inOrOut);
    map.put("entranceName",this.entranceName);
    map.put("photo",this.photo);
    return map;
  }

  public static Map<String, Object> buildMap(EntranceHistory obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("entranceGuardId", obj.getEntranceGuardId());
    map.put("staffName", obj.getStaffName());
    map.put("tellPhone", obj.getTellPhone());
    map.put("useDate", obj.modifyTime(obj.getUseDate()));
    map.put("inOrOut", obj.getInOrOut());
    map.put("entranceName", obj.getEntranceName());
    map.put("photo", obj.getPhoto());
    return map;
  }

  public static Map<String, String> buildSerialMap(EntranceHistory obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("entranceGuardId", JSONObject.toJSONString(obj.getEntranceGuardId()));
    map.put("staffName", JSONObject.toJSONString(obj.getStaffName()));
    map.put("tellPhone", JSONObject.toJSONString(obj.getTellPhone()));
    map.put("useDate", JSONObject.toJSONString(obj.modifyTime(obj.getUseDate())));
    map.put("inOrOut", JSONObject.toJSONString(obj.getInOrOut()));
    map.put("entranceName", JSONObject.toJSONString(obj.getEntranceName()));
    map.put("photo", JSONObject.toJSONString(obj.getPhoto()));
    return map;
  }

  public EntranceHistory buildEntity() {
    EntranceHistory obj = new EntranceHistory();
    obj.setId(this.id);
    obj.setEntranceGuardId(this.entranceGuardId);
    obj.setStaffName(this.staffName);
    obj.setTellPhone(this.tellPhone);
    obj.setUseDate(obj.recoverTime(this.useDate));
    obj.setInOrOut(this.inOrOut);
    obj.setEntranceName(this.entranceName);
    obj.setPhoto(this.photo);
    return obj;
  }

  public static EntranceHistory parseEntity(Map<String, Object> map) {
    EntranceHistory obj = new EntranceHistory();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setEntranceGuardId((String) map.get("entranceGuardId"));
    obj.setStaffName((String) map.get("staffName"));
    obj.setTellPhone((String) map.get("tellPhone"));
    obj.setUseDate(obj.recoverTime((Long) map.get("useDate")));
    obj.setInOrOut((Integer) map.get("inOrOut"));
    obj.setEntranceName((String) map.get("entranceName"));
    obj.setPhoto((String) map.get("photo"));
    return obj;
  }

  public static EntranceHistory parseSerialEntity(Map<String, String> map) {
    EntranceHistory obj = new EntranceHistory();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setEntranceGuardId(JSONObject.parseObject(map.get("entranceGuardId"), String.class));
    obj.setStaffName(JSONObject.parseObject(map.get("staffName"), String.class));
    obj.setTellPhone(JSONObject.parseObject(map.get("tellPhone"), String.class));
    obj.setUseDate(obj.recoverTime(JSONObject.parseObject(map.get("useDate"), Long.class)));
    obj.setInOrOut(JSONObject.parseObject(map.get("inOrOut"), Integer.class));
    obj.setEntranceName(JSONObject.parseObject(map.get("entranceName"), String.class));
    obj.setPhoto(JSONObject.parseObject(map.get("photo"), String.class));
    return obj;
  }
}
