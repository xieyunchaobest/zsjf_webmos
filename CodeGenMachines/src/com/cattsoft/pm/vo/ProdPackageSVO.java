package com.cattsoft.pm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * ProdPackageSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class ProdPackageSVO extends GenericVO {private String areaId = null;private Date createDate = null;private String localNetId = null;private String name = null;private String prodPackageId = null;private String standardId = null;private String sts = null;private Date stsDate = null;private int flagAreaId = 0;private int flagCreateDate = 0;private int flagLocalNetId = 0;private int flagName = 0;private int flagProdPackageId = 0;private int flagStandardId = 0;private int flagSts = 0;private int flagStsDate = 0;public String getAreaId(){ return areaId;}public void setAreaId(String newValue){  this.areaId = newValue;  flagAreaId = 1;}public int getFlagAreaId(){  return flagAreaId;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getLocalNetId(){ return localNetId;}public void setLocalNetId(String newValue){  this.localNetId = newValue;  flagLocalNetId = 1;}public int getFlagLocalNetId(){  return flagLocalNetId;}public String getName(){ return name;}public void setName(String newValue){  this.name = newValue;  flagName = 1;}public int getFlagName(){  return flagName;}public String getProdPackageId(){ return prodPackageId;}public void setProdPackageId(String newValue){  this.prodPackageId = newValue;  flagProdPackageId = 1;}public int getFlagProdPackageId(){  return flagProdPackageId;}public String getStandardId(){ return standardId;}public void setStandardId(String newValue){  this.standardId = newValue;  flagStandardId = 1;}public int getFlagStandardId(){  return flagStandardId;}public String getSts(){ return sts;}public void setSts(String newValue){  this.sts = newValue;  flagSts = 1;}public int getFlagSts(){  return flagSts;}public Date getStsDate(){  return stsDate;}public void setStsDate(Date newValue){   this.stsDate = newValue;  flagStsDate = 1;}public int getFlagStsDate(){  return flagStsDate;}public void clearFlagAreaId(){ flagAreaId = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagLocalNetId(){ flagLocalNetId = 0 ;}public void clearFlagName(){ flagName = 0 ;}public void clearFlagProdPackageId(){ flagProdPackageId = 0 ;}public void clearFlagStandardId(){ flagStandardId = 0 ;}public void clearFlagSts(){ flagSts = 0 ;}public void clearFlagStsDate(){ flagStsDate = 0 ;}public void clearAll(){ flagAreaId = 0; flagCreateDate = 0; flagLocalNetId = 0; flagName = 0; flagProdPackageId = 0; flagStandardId = 0; flagSts = 0; flagStsDate = 0;}}
