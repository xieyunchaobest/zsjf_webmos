package com.cattsoft.wm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * WfExpFlowInstanceSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class WfExpFlowInstanceSVO extends GenericVO {private Date changeDate = null;private String changeStaffId = null;private Date createDate = null;private String createStaffId = null;private String expCode = null;private String expFlowName = null;private String expType = null;private String failReasonName = null;private String state = null;private String wfExpFlowInstId = null;private int flagChangeDate = 0;private int flagChangeStaffId = 0;private int flagCreateDate = 0;private int flagCreateStaffId = 0;private int flagExpCode = 0;private int flagExpFlowName = 0;private int flagExpType = 0;private int flagFailReasonName = 0;private int flagState = 0;private int flagWfExpFlowInstId = 0;public Date getChangeDate(){  return changeDate;}public void setChangeDate(Date newValue){   this.changeDate = newValue;  flagChangeDate = 1;}public int getFlagChangeDate(){  return flagChangeDate;}public String getChangeStaffId(){ return changeStaffId;}public void setChangeStaffId(String newValue){  this.changeStaffId = newValue;  flagChangeStaffId = 1;}public int getFlagChangeStaffId(){  return flagChangeStaffId;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getCreateStaffId(){ return createStaffId;}public void setCreateStaffId(String newValue){  this.createStaffId = newValue;  flagCreateStaffId = 1;}public int getFlagCreateStaffId(){  return flagCreateStaffId;}public String getExpCode(){ return expCode;}public void setExpCode(String newValue){  this.expCode = newValue;  flagExpCode = 1;}public int getFlagExpCode(){  return flagExpCode;}public String getExpFlowName(){ return expFlowName;}public void setExpFlowName(String newValue){  this.expFlowName = newValue;  flagExpFlowName = 1;}public int getFlagExpFlowName(){  return flagExpFlowName;}public String getExpType(){ return expType;}public void setExpType(String newValue){  this.expType = newValue;  flagExpType = 1;}public int getFlagExpType(){  return flagExpType;}public String getFailReasonName(){ return failReasonName;}public void setFailReasonName(String newValue){  this.failReasonName = newValue;  flagFailReasonName = 1;}public int getFlagFailReasonName(){  return flagFailReasonName;}public String getState(){ return state;}public void setState(String newValue){  this.state = newValue;  flagState = 1;}public int getFlagState(){  return flagState;}public String getWfExpFlowInstId(){ return wfExpFlowInstId;}public void setWfExpFlowInstId(String newValue){  this.wfExpFlowInstId = newValue;  flagWfExpFlowInstId = 1;}public int getFlagWfExpFlowInstId(){  return flagWfExpFlowInstId;}public void clearFlagChangeDate(){ flagChangeDate = 0 ;}public void clearFlagChangeStaffId(){ flagChangeStaffId = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagCreateStaffId(){ flagCreateStaffId = 0 ;}public void clearFlagExpCode(){ flagExpCode = 0 ;}public void clearFlagExpFlowName(){ flagExpFlowName = 0 ;}public void clearFlagExpType(){ flagExpType = 0 ;}public void clearFlagFailReasonName(){ flagFailReasonName = 0 ;}public void clearFlagState(){ flagState = 0 ;}public void clearFlagWfExpFlowInstId(){ flagWfExpFlowInstId = 0 ;}public void clearAll(){ flagChangeDate = 0; flagChangeStaffId = 0; flagCreateDate = 0; flagCreateStaffId = 0; flagExpCode = 0; flagExpFlowName = 0; flagExpType = 0; flagFailReasonName = 0; flagState = 0; flagWfExpFlowInstId = 0;}}
