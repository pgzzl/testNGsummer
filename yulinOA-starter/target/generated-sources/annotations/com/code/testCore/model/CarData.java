package com.code.testCore.model;

import com.alibaba.fastjson.JSONObject;
import com.horsecoder.yulinOA.sys.dataobject.CarDO;
import java.lang.Object;
import java.lang.String;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class CarData {
  public String id;

  public String driverName;

  public String driverPhone;

  public String carID;

  public String parkType;

  public String carState;

  public Date stopTime;

  public String enterpriseId;

  public Date gmtUpdate;

  public Date gmtCreate;

  public CarData() {
  }

  public CarData(String id, String driverName, String driverPhone, String carID, String parkType,
      String carState, Date stopTime, String enterpriseId, Date gmtUpdate, Date gmtCreate) {
    this.id=id;
    this.driverName=driverName;
    this.driverPhone=driverPhone;
    this.carID=carID;
    this.parkType=parkType;
    this.carState=carState;
    this.stopTime=stopTime;
    this.enterpriseId=enterpriseId;
    this.gmtUpdate=gmtUpdate;
    this.gmtCreate=gmtCreate;
  }

  public static CarData buildMapper(Car obj) {
    CarData mapper = new CarData();
    mapper.id=obj.getId();
    mapper.driverName=obj.getDriverName();
    mapper.driverPhone=obj.getDriverPhone();
    mapper.carID=obj.getCarID();
    mapper.parkType=obj.getParkType();
    mapper.carState=obj.getCarState();
    mapper.stopTime=obj.getStopTime();
    mapper.enterpriseId=obj.getEnterpriseId();
    mapper.gmtUpdate=obj.getGmtUpdate();
    mapper.gmtCreate=obj.getGmtCreate();
    return mapper;
  }

  public Map<String, Object> buildMap() {
    Map<String, Object> map = new LinkedHashMap<>();
    map.put("id",this.id);
    map.put("driverName",this.driverName);
    map.put("driverPhone",this.driverPhone);
    map.put("carID",this.carID);
    map.put("parkType",this.parkType);
    map.put("carState",this.carState);
    map.put("stopTime",this.stopTime);
    map.put("enterpriseId",this.enterpriseId);
    map.put("gmtUpdate",this.gmtUpdate);
    map.put("gmtCreate",this.gmtCreate);
    return map;
  }

  public static Map<String, Object> buildMap(Car obj) {
    Map<String, Object> map = new LinkedHashMap<>();
    if (obj == null) return map;
    map.put("id", obj.getId());
    map.put("driverName", obj.getDriverName());
    map.put("driverPhone", obj.getDriverPhone());
    map.put("carID", obj.getCarID());
    map.put("parkType", obj.getParkType());
    map.put("carState", obj.getCarState());
    map.put("stopTime", obj.getStopTime());
    map.put("enterpriseId", obj.getEnterpriseId());
    map.put("gmtUpdate", obj.getGmtUpdate());
    map.put("gmtCreate", obj.getGmtCreate());
    return map;
  }

  public static Map<String, String> buildSerialMap(Car obj) {
    Map<String, String> map = new LinkedHashMap<>();
    map.put("id", JSONObject.toJSONString(obj.getId()));
    map.put("driverName", JSONObject.toJSONString(obj.getDriverName()));
    map.put("driverPhone", JSONObject.toJSONString(obj.getDriverPhone()));
    map.put("carID", JSONObject.toJSONString(obj.getCarID()));
    map.put("parkType", JSONObject.toJSONString(obj.getParkType()));
    map.put("carState", JSONObject.toJSONString(obj.getCarState()));
    map.put("stopTime", JSONObject.toJSONString(obj.getStopTime()));
    map.put("enterpriseId", JSONObject.toJSONString(obj.getEnterpriseId()));
    map.put("gmtUpdate", JSONObject.toJSONString(obj.getGmtUpdate()));
    map.put("gmtCreate", JSONObject.toJSONString(obj.getGmtCreate()));
    return map;
  }

  public Car buildEntity() {
    Car obj = new Car();
    obj.setId(this.id);
    obj.setDriverName(this.driverName);
    obj.setDriverPhone(this.driverPhone);
    obj.setCarID(this.carID);
    obj.setParkType(this.parkType);
    obj.setCarState(this.carState);
    obj.setStopTime(this.stopTime);
    obj.setEnterpriseId(this.enterpriseId);
    obj.setGmtUpdate(this.gmtUpdate);
    obj.setGmtCreate(this.gmtCreate);
    return obj;
  }

  public static Car parseEntity(Map<String, Object> map) {
    Car obj = new Car();
    if (map == null) return obj;
    obj.setId((String) map.get("id"));
    obj.setDriverName((String) map.get("driverName"));
    obj.setDriverPhone((String) map.get("driverPhone"));
    obj.setCarID((String) map.get("carID"));
    obj.setParkType((String) map.get("parkType"));
    obj.setCarState((String) map.get("carState"));
    obj.setStopTime((Date) map.get("stopTime"));
    obj.setEnterpriseId((String) map.get("enterpriseId"));
    obj.setGmtUpdate((Date) map.get("gmtUpdate"));
    obj.setGmtCreate((Date) map.get("gmtCreate"));
    return obj;
  }

  public static Car parseSerialEntity(Map<String, String> map) {
    Car obj = new Car();
    if (map == null) return obj;
    obj.setId(JSONObject.parseObject(map.get("id"), String.class));
    obj.setDriverName(JSONObject.parseObject(map.get("driverName"), String.class));
    obj.setDriverPhone(JSONObject.parseObject(map.get("driverPhone"), String.class));
    obj.setCarID(JSONObject.parseObject(map.get("carID"), String.class));
    obj.setParkType(JSONObject.parseObject(map.get("parkType"), String.class));
    obj.setCarState(JSONObject.parseObject(map.get("carState"), String.class));
    obj.setStopTime(JSONObject.parseObject(map.get("stopTime"), Date.class));
    obj.setEnterpriseId(JSONObject.parseObject(map.get("enterpriseId"), String.class));
    obj.setGmtUpdate(JSONObject.parseObject(map.get("gmtUpdate"), Date.class));
    obj.setGmtCreate(JSONObject.parseObject(map.get("gmtCreate"), Date.class));
    return obj;
  }

  public static CarDO convert(Car from, CarDO to) {
    if (from == null) return to;
    if (to == null) to = new CarDO();
    to.setId(from.getId());
    to.setDriverName(from.getDriverName());
    to.setDriverPhone(from.getDriverPhone());
    to.setCarID(from.getCarID());
    to.setParkType(from.getParkType());
    to.setCarState(from.getCarState());
    to.setStopTime(from.getStopTime());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }

  public static Car convert(CarDO from, Car to) {
    if (from == null) return to;
    if (to == null) to = new Car();
    to.setId(from.getId());
    to.setDriverName(from.getDriverName());
    to.setDriverPhone(from.getDriverPhone());
    to.setCarID(from.getCarID());
    to.setParkType(from.getParkType());
    to.setCarState(from.getCarState());
    to.setStopTime(from.getStopTime());
    to.setEnterpriseId(from.getEnterpriseId());
    to.setGmtUpdate(from.getGmtUpdate());
    to.setGmtCreate(from.getGmtCreate());
    return to;
  }
}
