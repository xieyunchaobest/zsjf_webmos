package com.cattsoft.sp.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TempFeeSoMainProdPrptySVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TempFeeSoMainProdPrptySVO extends GenericVO {private String actType = null;private String changedFlag = null;private String localNetId = null;private String parentPrptyId = null;private String parentPrptyInstId = null;private String sortPosition = null;private String specPrptyId = null;private String specPrptyName = null;private String specPrptyValue = null;private String specPrptyValueId = null;private String spvSeq = null;private String sts = null;private Date stsDate = null;private String tempFeeSoMainProdId = null;private String tempFeeSoMainProdPrptyId = null;private int flagActType = 0;private int flagChangedFlag = 0;private int flagLocalNetId = 0;private int flagParentPrptyId = 0;private int flagParentPrptyInstId = 0;private int flagSortPosition = 0;private int flagSpecPrptyId = 0;private int flagSpecPrptyName = 0;private int flagSpecPrptyValue = 0;private int flagSpecPrptyValueId = 0;private int flagSpvSeq = 0;private int flagSts = 0;private int flagStsDate = 0;private int flagTempFeeSoMainProdId = 0;private int flagTempFeeSoMainProdPrptyId = 0;public String getActType(){ return actType;}public void setActType(String newValue){  this.actType = newValue;  flagActType = 1;}public int getFlagActType(){  return flagActType;}public String getChangedFlag(){ return changedFlag;}public void setChangedFlag(String newValue){  this.changedFlag = newValue;  flagChangedFlag = 1;}public int getFlagChangedFlag(){  return flagChangedFlag;}public String getLocalNetId(){ return localNetId;}public void setLocalNetId(String newValue){  this.localNetId = newValue;  flagLocalNetId = 1;}public int getFlagLocalNetId(){  return flagLocalNetId;}public String getParentPrptyId(){ return parentPrptyId;}public void setParentPrptyId(String newValue){  this.parentPrptyId = newValue;  flagParentPrptyId = 1;}public int getFlagParentPrptyId(){  return flagParentPrptyId;}public String getParentPrptyInstId(){ return parentPrptyInstId;}public void setParentPrptyInstId(String newValue){  this.parentPrptyInstId = newValue;  flagParentPrptyInstId = 1;}public int getFlagParentPrptyInstId(){  return flagParentPrptyInstId;}public String getSortPosition(){ return sortPosition;}public void setSortPosition(String newValue){  this.sortPosition = newValue;  flagSortPosition = 1;}public int getFlagSortPosition(){  return flagSortPosition;}public String getSpecPrptyId(){ return specPrptyId;}public void setSpecPrptyId(String newValue){  this.specPrptyId = newValue;  flagSpecPrptyId = 1;}public int getFlagSpecPrptyId(){  return flagSpecPrptyId;}public String getSpecPrptyName(){ return specPrptyName;}public void setSpecPrptyName(String newValue){  this.specPrptyName = newValue;  flagSpecPrptyName = 1;}public int getFlagSpecPrptyName(){  return flagSpecPrptyName;}public String getSpecPrptyValue(){ return specPrptyValue;}public void setSpecPrptyValue(String newValue){  this.specPrptyValue = newValue;  flagSpecPrptyValue = 1;}public int getFlagSpecPrptyValue(){  return flagSpecPrptyValue;}public String getSpecPrptyValueId(){ return specPrptyValueId;}public void setSpecPrptyValueId(String newValue){  this.specPrptyValueId = newValue;  flagSpecPrptyValueId = 1;}public int getFlagSpecPrptyValueId(){  return flagSpecPrptyValueId;}public String getSpvSeq(){ return spvSeq;}public void setSpvSeq(String newValue){  this.spvSeq = newValue;  flagSpvSeq = 1;}public int getFlagSpvSeq(){  return flagSpvSeq;}public String getSts(){ return sts;}public void setSts(String newValue){  this.sts = newValue;  flagSts = 1;}public int getFlagSts(){  return flagSts;}public Date getStsDate(){  return stsDate;}public void setStsDate(Date newValue){   this.stsDate = newValue;  flagStsDate = 1;}public int getFlagStsDate(){  return flagStsDate;}public String getTempFeeSoMainProdId(){ return tempFeeSoMainProdId;}public void setTempFeeSoMainProdId(String newValue){  this.tempFeeSoMainProdId = newValue;  flagTempFeeSoMainProdId = 1;}public int getFlagTempFeeSoMainProdId(){  return flagTempFeeSoMainProdId;}public String getTempFeeSoMainProdPrptyId(){ return tempFeeSoMainProdPrptyId;}public void setTempFeeSoMainProdPrptyId(String newValue){  this.tempFeeSoMainProdPrptyId = newValue;  flagTempFeeSoMainProdPrptyId = 1;}public int getFlagTempFeeSoMainProdPrptyId(){  return flagTempFeeSoMainProdPrptyId;}public void clearFlagActType(){ flagActType = 0 ;}public void clearFlagChangedFlag(){ flagChangedFlag = 0 ;}public void clearFlagLocalNetId(){ flagLocalNetId = 0 ;}public void clearFlagParentPrptyId(){ flagParentPrptyId = 0 ;}public void clearFlagParentPrptyInstId(){ flagParentPrptyInstId = 0 ;}public void clearFlagSortPosition(){ flagSortPosition = 0 ;}public void clearFlagSpecPrptyId(){ flagSpecPrptyId = 0 ;}public void clearFlagSpecPrptyName(){ flagSpecPrptyName = 0 ;}public void clearFlagSpecPrptyValue(){ flagSpecPrptyValue = 0 ;}public void clearFlagSpecPrptyValueId(){ flagSpecPrptyValueId = 0 ;}public void clearFlagSpvSeq(){ flagSpvSeq = 0 ;}public void clearFlagSts(){ flagSts = 0 ;}public void clearFlagStsDate(){ flagStsDate = 0 ;}public void clearFlagTempFeeSoMainProdId(){ flagTempFeeSoMainProdId = 0 ;}public void clearFlagTempFeeSoMainProdPrptyId(){ flagTempFeeSoMainProdPrptyId = 0 ;}public void clearAll(){ flagActType = 0; flagChangedFlag = 0; flagLocalNetId = 0; flagParentPrptyId = 0; flagParentPrptyInstId = 0; flagSortPosition = 0; flagSpecPrptyId = 0; flagSpecPrptyName = 0; flagSpecPrptyValue = 0; flagSpecPrptyValueId = 0; flagSpvSeq = 0; flagSts = 0; flagStsDate = 0; flagTempFeeSoMainProdId = 0; flagTempFeeSoMainProdPrptyId = 0;}}
