package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class EventSimpleMapper {
  public String id;

  public String type;

  public String status;

  public String name;

  public Long gmtUpdate;

  public Long gmtCreate;

  public EventSimpleMapper() {
  }

  public EventSimpleMapper(String id, String type, String status, String name, Long gmtUpdate,
      Long gmtCreate) {
    this.id=id;
    this.type=type;
    this.status=status;
    this.name=name;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static EventSimpleMapper buildMapper(Event obj) {
    EventSimpleMapper mapper = new EventSimpleMapper();
    mapper.id=obj.getId();
    mapper.type=obj.getType();
    mapper.status=obj.getStatus();
    mapper.name=obj.getName();
    mapper.gmtUpdate=obj.modifyTime(obj.getGmtUpdate());
    mapper.gmtCreate=obj.modifyTime(obj.getGmtCreate());
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("type",this.type);
    map.put("status",this.status);
    map.put("name",this.name);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Event obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("type", obj.getType());
    map.put("status", obj.getStatus());
    map.put("name", obj.getName());
    map.put("gmtUpdate", obj.modifyTime(obj.getGmtUpdate()));
    map.put("gmtCreate", obj.modifyTime(obj.getGmtCreate()));
    return map;
  }

  public static Map<String, String> buildSerialMap(Event obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("type", JSONObject.toJSONString(obj.getType()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("name", JSONObject.toJSONString(obj.getName()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtUpdate())));
    map.put("gmtCreate", JSONObject.toJSONString(obj.modifyTime(obj.getGmtCreate())));
    return map;
  }

  public Event buildEntity() {
    Event obj = new Event();
    obj.setId(this.id);
    obj.setType(this.type);
    obj.setStatus(this.status);
    obj.setName(this.name);
    obj.setGmtUpdate(obj.recoverTime(this.gmtUpdate));
    obj.setGmtCreate(obj.recoverTime(this.gmtCreate));
    return obj;
  }

  public static Event parseEntity(Map<String, Object> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setType((String) map.get("type"));
    obj.setStatus((String) map.get("status"));
    obj.setName((String) map.get("name"));
    obj.setGmtUpdate(obj.recoverTime((Long) map.get("gmtUpdate")));
    obj.setGmtCreate(obj.recoverTime((Long) map.get("gmtCreate")));
    return obj;
  }

  public static Event parseSerialEntity(Map<String, String> map) {
    Event obj = new Event();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setType(JSONObject.parseObject(map.get("type"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), String.class));
    obj.setName(JSONObject.parseObject(map.get("name"), String.class));
    obj.setGmtUpdate(obj.recoverTime(JSONObject.parseObject(map.get("gmtUpdate"), Long.class)));
    obj.setGmtCreate(obj.recoverTime(JSONObject.parseObject(map.get("gmtCreate"), Long.class)));
    return obj;
  }
}
