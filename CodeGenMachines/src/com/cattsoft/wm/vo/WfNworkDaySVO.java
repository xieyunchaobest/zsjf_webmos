package com.cattsoft.wm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * WfNworkDaySVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class WfNworkDaySVO extends GenericVO {/**	 * 	 */	private static final long serialVersionUID = 6695162455749441868L;private Date changeDate = null;private String changeStaffId = null;private Date createDate = null;private String createStaffId = null;private String datasetLevel = null;private String endValue = null;private String expressId = null;private String iscontain = null;private String nworkDayId = null;private String objStr = null;private String remark = null;private String startValue = null;private String state = null;private String type = null;private int flagChangeDate = 0;private int flagChangeStaffId = 0;private int flagCreateDate = 0;private int flagCreateStaffId = 0;private int flagDatasetLevel = 0;private int flagEndValue = 0;private int flagExpressId = 0;private int flagIscontain = 0;private int flagNworkDayId = 0;private int flagObjStr = 0;private int flagRemark = 0;private int flagStartValue = 0;private int flagState = 0;private int flagType = 0;public Date getChangeDate(){  return changeDate;}public void setChangeDate(Date newValue){   this.changeDate = newValue;  flagChangeDate = 1;}public int getFlagChangeDate(){  return flagChangeDate;}public String getChangeStaffId(){ return changeStaffId;}public void setChangeStaffId(String newValue){  this.changeStaffId = newValue;  flagChangeStaffId = 1;}public int getFlagChangeStaffId(){  return flagChangeStaffId;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getCreateStaffId(){ return createStaffId;}public void setCreateStaffId(String newValue){  this.createStaffId = newValue;  flagCreateStaffId = 1;}public int getFlagCreateStaffId(){  return flagCreateStaffId;}public String getDatasetLevel(){ return datasetLevel;}public void setDatasetLevel(String newValue){  this.datasetLevel = newValue;  flagDatasetLevel = 1;}public int getFlagDatasetLevel(){  return flagDatasetLevel;}public String getEndValue(){ return endValue;}public void setEndValue(String newValue){  this.endValue = newValue;  flagEndValue = 1;}public int getFlagEndValue(){  return flagEndValue;}public String getExpressId(){ return expressId;}public void setExpressId(String newValue){  this.expressId = newValue;  flagExpressId = 1;}public int getFlagExpressId(){  return flagExpressId;}public String getIscontain(){ return iscontain;}public void setIscontain(String newValue){  this.iscontain = newValue;  flagIscontain = 1;}public int getFlagIscontain(){  return flagIscontain;}public String getNworkDayId(){ return nworkDayId;}public void setNworkDayId(String newValue){  this.nworkDayId = newValue;  flagNworkDayId = 1;}public int getFlagNworkDayId(){  return flagNworkDayId;}public String getObjStr(){ return objStr;}public void setObjStr(String newValue){  this.objStr = newValue;  flagObjStr = 1;}public int getFlagObjStr(){  return flagObjStr;}public String getRemark(){ return remark;}public void setRemark(String newValue){  this.remark = newValue;  flagRemark = 1;}public int getFlagRemark(){  return flagRemark;}public String getStartValue(){ return startValue;}public void setStartValue(String newValue){  this.startValue = newValue;  flagStartValue = 1;}public int getFlagStartValue(){  return flagStartValue;}public String getState(){ return state;}public void setState(String newValue){  this.state = newValue;  flagState = 1;}public int getFlagState(){  return flagState;}public String getType(){ return type;}public void setType(String newValue){  this.type = newValue;  flagType = 1;}public int getFlagType(){  return flagType;}public void clearFlagChangeDate(){ flagChangeDate = 0 ;}public void clearFlagChangeStaffId(){ flagChangeStaffId = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagCreateStaffId(){ flagCreateStaffId = 0 ;}public void clearFlagDatasetLevel(){ flagDatasetLevel = 0 ;}public void clearFlagEndValue(){ flagEndValue = 0 ;}public void clearFlagExpressId(){ flagExpressId = 0 ;}public void clearFlagIscontain(){ flagIscontain = 0 ;}public void clearFlagNworkDayId(){ flagNworkDayId = 0 ;}public void clearFlagObjStr(){ flagObjStr = 0 ;}public void clearFlagRemark(){ flagRemark = 0 ;}public void clearFlagStartValue(){ flagStartValue = 0 ;}public void clearFlagState(){ flagState = 0 ;}public void clearFlagType(){ flagType = 0 ;}public void clearAll(){ flagChangeDate = 0; flagChangeStaffId = 0; flagCreateDate = 0; flagCreateStaffId = 0; flagDatasetLevel = 0; flagEndValue = 0; flagExpressId = 0; flagIscontain = 0; flagNworkDayId = 0; flagObjStr = 0; flagRemark = 0; flagStartValue = 0; flagState = 0; flagType = 0;}}
