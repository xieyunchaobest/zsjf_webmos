package com.cattsoft.wm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * WfProcNodeSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class WfProcNodeSVO extends GenericVO {private String caseValue = null;private String connectType = null;private String expressParam = null;private String isNeed = null;private String nextProcNodeId = null;private String nodeDesc = null;private String nodeType = null;private String objId = null;private String paramType = null;private String parentProcNodeId = null;private String procId = null;private String procNodeId = null;private String remark = null;private String upProcNodeId = null;private String wfProcNodeId = null;private String xmlNodeId = null;private int flagCaseValue = 0;private int flagConnectType = 0;private int flagExpressParam = 0;private int flagIsNeed = 0;private int flagNextProcNodeId = 0;private int flagNodeDesc = 0;private int flagNodeType = 0;private int flagObjId = 0;private int flagParamType = 0;private int flagParentProcNodeId = 0;private int flagProcId = 0;private int flagProcNodeId = 0;private int flagRemark = 0;private int flagUpProcNodeId = 0;private int flagWfProcNodeId = 0;private int flagXmlNodeId = 0;public String getCaseValue(){ return caseValue;}public void setCaseValue(String newValue){  this.caseValue = newValue;  flagCaseValue = 1;}public int getFlagCaseValue(){  return flagCaseValue;}public String getConnectType(){ return connectType;}public void setConnectType(String newValue){  this.connectType = newValue;  flagConnectType = 1;}public int getFlagConnectType(){  return flagConnectType;}public String getExpressParam(){ return expressParam;}public void setExpressParam(String newValue){  this.expressParam = newValue;  flagExpressParam = 1;}public int getFlagExpressParam(){  return flagExpressParam;}public String getIsNeed(){ return isNeed;}public void setIsNeed(String newValue){  this.isNeed = newValue;  flagIsNeed = 1;}public int getFlagIsNeed(){  return flagIsNeed;}public String getNextProcNodeId(){ return nextProcNodeId;}public void setNextProcNodeId(String newValue){  this.nextProcNodeId = newValue;  flagNextProcNodeId = 1;}public int getFlagNextProcNodeId(){  return flagNextProcNodeId;}public String getNodeDesc(){ return nodeDesc;}public void setNodeDesc(String newValue){  this.nodeDesc = newValue;  flagNodeDesc = 1;}public int getFlagNodeDesc(){  return flagNodeDesc;}public String getNodeType(){ return nodeType;}public void setNodeType(String newValue){  this.nodeType = newValue;  flagNodeType = 1;}public int getFlagNodeType(){  return flagNodeType;}public String getObjId(){ return objId;}public void setObjId(String newValue){  this.objId = newValue;  flagObjId = 1;}public int getFlagObjId(){  return flagObjId;}public String getParamType(){ return paramType;}public void setParamType(String newValue){  this.paramType = newValue;  flagParamType = 1;}public int getFlagParamType(){  return flagParamType;}public String getParentProcNodeId(){ return parentProcNodeId;}public void setParentProcNodeId(String newValue){  this.parentProcNodeId = newValue;  flagParentProcNodeId = 1;}public int getFlagParentProcNodeId(){  return flagParentProcNodeId;}public String getProcId(){ return procId;}public void setProcId(String newValue){  this.procId = newValue;  flagProcId = 1;}public int getFlagProcId(){  return flagProcId;}public String getProcNodeId(){ return procNodeId;}public void setProcNodeId(String newValue){  this.procNodeId = newValue;  flagProcNodeId = 1;}public int getFlagProcNodeId(){  return flagProcNodeId;}public String getRemark(){ return remark;}public void setRemark(String newValue){  this.remark = newValue;  flagRemark = 1;}public int getFlagRemark(){  return flagRemark;}public String getUpProcNodeId(){ return upProcNodeId;}public void setUpProcNodeId(String newValue){  this.upProcNodeId = newValue;  flagUpProcNodeId = 1;}public int getFlagUpProcNodeId(){  return flagUpProcNodeId;}public String getWfProcNodeId(){ return wfProcNodeId;}public void setWfProcNodeId(String newValue){  this.wfProcNodeId = newValue;  flagWfProcNodeId = 1;}public int getFlagWfProcNodeId(){  return flagWfProcNodeId;}public String getXmlNodeId(){ return xmlNodeId;}public void setXmlNodeId(String newValue){  this.xmlNodeId = newValue;  flagXmlNodeId = 1;}public int getFlagXmlNodeId(){  return flagXmlNodeId;}public void clearFlagCaseValue(){ flagCaseValue = 0 ;}public void clearFlagConnectType(){ flagConnectType = 0 ;}public void clearFlagExpressParam(){ flagExpressParam = 0 ;}public void clearFlagIsNeed(){ flagIsNeed = 0 ;}public void clearFlagNextProcNodeId(){ flagNextProcNodeId = 0 ;}public void clearFlagNodeDesc(){ flagNodeDesc = 0 ;}public void clearFlagNodeType(){ flagNodeType = 0 ;}public void clearFlagObjId(){ flagObjId = 0 ;}public void clearFlagParamType(){ flagParamType = 0 ;}public void clearFlagParentProcNodeId(){ flagParentProcNodeId = 0 ;}public void clearFlagProcId(){ flagProcId = 0 ;}public void clearFlagProcNodeId(){ flagProcNodeId = 0 ;}public void clearFlagRemark(){ flagRemark = 0 ;}public void clearFlagUpProcNodeId(){ flagUpProcNodeId = 0 ;}public void clearFlagWfProcNodeId(){ flagWfProcNodeId = 0 ;}public void clearFlagXmlNodeId(){ flagXmlNodeId = 0 ;}public void clearAll(){ flagCaseValue = 0; flagConnectType = 0; flagExpressParam = 0; flagIsNeed = 0; flagNextProcNodeId = 0; flagNodeDesc = 0; flagNodeType = 0; flagObjId = 0; flagParamType = 0; flagParentProcNodeId = 0; flagProcId = 0; flagProcNodeId = 0; flagRemark = 0; flagUpProcNodeId = 0; flagWfProcNodeId = 0; flagXmlNodeId = 0;}}
