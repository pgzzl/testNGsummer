package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessTripPostMapper {
  public Long tripStartTime;

  public Long tripEndTime;

  public String tripStartPlace;

  public String tripEndPlace;

  public String trafficTool;

  public String tripBack;

  public String tripRemark;

  public String userId;

  public Integer status;

  public BusinessTripPostMapper() {
  }

  public BusinessTripPostMapper(Long tripStartTime, Long tripEndTime, String tripStartPlace,
      String tripEndPlace, String trafficTool, String tripBack, String tripRemark, String userId,
      Integer status) {
    this.tripStartTime=tripStartTime;
    this.tripEndTime=tripEndTime;
    this.tripStartPlace=tripStartPlace;
    this.tripEndPlace=tripEndPlace;
    this.trafficTool=trafficTool;
    this.tripBack=tripBack;
    this.tripRemark=tripRemark;
    this.userId=userId;
    this.status=status;
  }

  public static BusinessTripPostMapper buildMapper(BusinessTrip obj) {
    BusinessTripPostMapper mapper = new BusinessTripPostMapper();
    mapper.tripStartTime=obj.modifyTime(obj.getTripStartTime());
    mapper.tripEndTime=obj.modifyTime(obj.getTripEndTime());
    mapper.tripStartPlace=obj.getTripStartPlace();
    mapper.tripEndPlace=obj.getTripEndPlace();
    mapper.trafficTool=obj.getTrafficTool();
    mapper.tripBack=obj.getTripBack();
    mapper.tripRemark=obj.getTripRemark();
    mapper.userId=obj.getUserId();
    mapper.status=obj.getStatus();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("tripStartTime",this.tripStartTime);
    map.put("tripEndTime",this.tripEndTime);
    map.put("tripStartPlace",this.tripStartPlace);
    map.put("tripEndPlace",this.tripEndPlace);
    map.put("trafficTool",this.trafficTool);
    map.put("tripBack",this.tripBack);
    map.put("tripRemark",this.tripRemark);
    map.put("userId",this.userId);
    map.put("status",this.status);
    return map;
  }

  public static Map<String, Object> buildMap(BusinessTrip obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("tripStartTime", obj.modifyTime(obj.getTripStartTime()));
    map.put("tripEndTime", obj.modifyTime(obj.getTripEndTime()));
    map.put("tripStartPlace", obj.getTripStartPlace());
    map.put("tripEndPlace", obj.getTripEndPlace());
    map.put("trafficTool", obj.getTrafficTool());
    map.put("tripBack", obj.getTripBack());
    map.put("tripRemark", obj.getTripRemark());
    map.put("userId", obj.getUserId());
    map.put("status", obj.getStatus());
    return map;
  }

  public static Map<String, String> buildSerialMap(BusinessTrip obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("tripStartTime", JSONObject.toJSONString(obj.modifyTime(obj.getTripStartTime())));
    map.put("tripEndTime", JSONObject.toJSONString(obj.modifyTime(obj.getTripEndTime())));
    map.put("tripStartPlace", JSONObject.toJSONString(obj.getTripStartPlace()));
    map.put("tripEndPlace", JSONObject.toJSONString(obj.getTripEndPlace()));
    map.put("trafficTool", JSONObject.toJSONString(obj.getTrafficTool()));
    map.put("tripBack", JSONObject.toJSONString(obj.getTripBack()));
    map.put("tripRemark", JSONObject.toJSONString(obj.getTripRemark()));
    map.put("userId", JSONObject.toJSONString(obj.getUserId()));
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    return map;
  }

  public BusinessTrip buildEntity() {
    BusinessTrip obj = new BusinessTrip();
    obj.setTripStartTime(obj.recoverTime(this.tripStartTime));
    obj.setTripEndTime(obj.recoverTime(this.tripEndTime));
    obj.setTripStartPlace(this.tripStartPlace);
    obj.setTripEndPlace(this.tripEndPlace);
    obj.setTrafficTool(this.trafficTool);
    obj.setTripBack(this.tripBack);
    obj.setTripRemark(this.tripRemark);
    obj.setUserId(this.userId);
    obj.setStatus(this.status);
    return obj;
  }

  public static BusinessTrip parseEntity(Map<String, Object> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setTripStartTime(obj.recoverTime((Long) map.get("tripStartTime")));
    obj.setTripEndTime(obj.recoverTime((Long) map.get("tripEndTime")));
    obj.setTripStartPlace((String) map.get("tripStartPlace"));
    obj.setTripEndPlace((String) map.get("tripEndPlace"));
    obj.setTrafficTool((String) map.get("trafficTool"));
    obj.setTripBack((String) map.get("tripBack"));
    obj.setTripRemark((String) map.get("tripRemark"));
    obj.setUserId((String) map.get("userId"));
    obj.setStatus((Integer) map.get("status"));
    return obj;
  }

  public static BusinessTrip parseSerialEntity(Map<String, String> map) {
    BusinessTrip obj = new BusinessTrip();
    if (map == null) return obj;
    obj.setTripStartTime(obj.recoverTime(JSONObject.parseObject(map.get("tripStartTime"), Long.class)));
    obj.setTripEndTime(obj.recoverTime(JSONObject.parseObject(map.get("tripEndTime"), Long.class)));
    obj.setTripStartPlace(JSONObject.parseObject(map.get("tripStartPlace"), String.class));
    obj.setTripEndPlace(JSONObject.parseObject(map.get("tripEndPlace"), String.class));
    obj.setTrafficTool(JSONObject.parseObject(map.get("trafficTool"), String.class));
    obj.setTripBack(JSONObject.parseObject(map.get("tripBack"), String.class));
    obj.setTripRemark(JSONObject.parseObject(map.get("tripRemark"), String.class));
    obj.setUserId(JSONObject.parseObject(map.get("userId"), String.class));
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    return obj;
  }
}
