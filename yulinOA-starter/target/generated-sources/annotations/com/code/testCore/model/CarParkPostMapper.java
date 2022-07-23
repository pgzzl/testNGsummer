package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarParkPostMapper {
  public Integer status;

  public String time;

  public String carId;

  public String parkPlaceId;

  public CarParkPostMapper() {
  }

  public CarParkPostMapper(Integer status, String time, String carId, String parkPlaceId) {
    this.status=status;
    this.time=time;
    this.carId=carId;
    this.parkPlaceId=parkPlaceId;
  }

  public static CarParkPostMapper buildMapper(CarPark obj) {
    CarParkPostMapper mapper = new CarParkPostMapper();
    mapper.status=obj.getStatus();
    mapper.time=obj.getTime();
    mapper.carId=obj.getCarId();
    mapper.parkPlaceId=obj.getParkPlaceId();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("status",this.status);
    map.put("time",this.time);
    map.put("carId",this.carId);
    map.put("parkPlaceId",this.parkPlaceId);
    return map;
  }

  public static Map<String, Object> buildMap(CarPark obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("status", obj.getStatus());
    map.put("time", obj.getTime());
    map.put("carId", obj.getCarId());
    map.put("parkPlaceId", obj.getParkPlaceId());
    return map;
  }

  public static Map<String, String> buildSerialMap(CarPark obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("status", JSONObject.toJSONString(obj.getStatus()));
    map.put("time", JSONObject.toJSONString(obj.getTime()));
    map.put("carId", JSONObject.toJSONString(obj.getCarId()));
    map.put("parkPlaceId", JSONObject.toJSONString(obj.getParkPlaceId()));
    return map;
  }

  public CarPark buildEntity() {
    CarPark obj = new CarPark();
    obj.setStatus(this.status);
    obj.setTime(this.time);
    obj.setCarId(this.carId);
    obj.setParkPlaceId(this.parkPlaceId);
    return obj;
  }

  public static CarPark parseEntity(Map<String, Object> map) {
    CarPark obj = new CarPark();
    if (map == null) return obj;
    obj.setStatus((Integer) map.get("status"));
    obj.setTime((String) map.get("time"));
    obj.setCarId((String) map.get("carId"));
    obj.setParkPlaceId((String) map.get("parkPlaceId"));
    return obj;
  }

  public static CarPark parseSerialEntity(Map<String, String> map) {
    CarPark obj = new CarPark();
    if (map == null) return obj;
    obj.setStatus(JSONObject.parseObject(map.get("status"), Integer.class));
    obj.setTime(JSONObject.parseObject(map.get("time"), String.class));
    obj.setCarId(JSONObject.parseObject(map.get("carId"), String.class));
    obj.setParkPlaceId(JSONObject.parseObject(map.get("parkPlaceId"), String.class));
    return obj;
  }
}
