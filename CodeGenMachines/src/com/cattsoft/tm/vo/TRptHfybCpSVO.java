package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRptHfybCpSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRptHfybCpSVO extends GenericVO {private String clDysr = null;private String clHbsr = null;private String clSysr = null;private String clYhs = null;private String cp = null;private Date createDate = null;private String czSr = null;private String czYhs = null;private String jlSysr = null;private String jlYhs = null;private String khq = null;private Date openDate = null;private String zlDysr = null;private String zlYhs = null;private String zzDysr = null;private String zzDyyhs = null;private String zzHbsr = null;private String zzHbyhs = null;private String zzSysr = null;private String zzSyyhs = null;private int flagClDysr = 0;private int flagClHbsr = 0;private int flagClSysr = 0;private int flagClYhs = 0;private int flagCp = 0;private int flagCreateDate = 0;private int flagCzSr = 0;private int flagCzYhs = 0;private int flagJlSysr = 0;private int flagJlYhs = 0;private int flagKhq = 0;private int flagOpenDate = 0;private int flagZlDysr = 0;private int flagZlYhs = 0;private int flagZzDysr = 0;private int flagZzDyyhs = 0;private int flagZzHbsr = 0;private int flagZzHbyhs = 0;private int flagZzSysr = 0;private int flagZzSyyhs = 0;public String getClDysr(){ return clDysr;}public void setClDysr(String newValue){  this.clDysr = newValue;  flagClDysr = 1;}public int getFlagClDysr(){  return flagClDysr;}public String getClHbsr(){ return clHbsr;}public void setClHbsr(String newValue){  this.clHbsr = newValue;  flagClHbsr = 1;}public int getFlagClHbsr(){  return flagClHbsr;}public String getClSysr(){ return clSysr;}public void setClSysr(String newValue){  this.clSysr = newValue;  flagClSysr = 1;}public int getFlagClSysr(){  return flagClSysr;}public String getClYhs(){ return clYhs;}public void setClYhs(String newValue){  this.clYhs = newValue;  flagClYhs = 1;}public int getFlagClYhs(){  return flagClYhs;}public String getCp(){ return cp;}public void setCp(String newValue){  this.cp = newValue;  flagCp = 1;}public int getFlagCp(){  return flagCp;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getCzSr(){ return czSr;}public void setCzSr(String newValue){  this.czSr = newValue;  flagCzSr = 1;}public int getFlagCzSr(){  return flagCzSr;}public String getCzYhs(){ return czYhs;}public void setCzYhs(String newValue){  this.czYhs = newValue;  flagCzYhs = 1;}public int getFlagCzYhs(){  return flagCzYhs;}public String getJlSysr(){ return jlSysr;}public void setJlSysr(String newValue){  this.jlSysr = newValue;  flagJlSysr = 1;}public int getFlagJlSysr(){  return flagJlSysr;}public String getJlYhs(){ return jlYhs;}public void setJlYhs(String newValue){  this.jlYhs = newValue;  flagJlYhs = 1;}public int getFlagJlYhs(){  return flagJlYhs;}public String getKhq(){ return khq;}public void setKhq(String newValue){  this.khq = newValue;  flagKhq = 1;}public int getFlagKhq(){  return flagKhq;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getZlDysr(){ return zlDysr;}public void setZlDysr(String newValue){  this.zlDysr = newValue;  flagZlDysr = 1;}public int getFlagZlDysr(){  return flagZlDysr;}public String getZlYhs(){ return zlYhs;}public void setZlYhs(String newValue){  this.zlYhs = newValue;  flagZlYhs = 1;}public int getFlagZlYhs(){  return flagZlYhs;}public String getZzDysr(){ return zzDysr;}public void setZzDysr(String newValue){  this.zzDysr = newValue;  flagZzDysr = 1;}public int getFlagZzDysr(){  return flagZzDysr;}public String getZzDyyhs(){ return zzDyyhs;}public void setZzDyyhs(String newValue){  this.zzDyyhs = newValue;  flagZzDyyhs = 1;}public int getFlagZzDyyhs(){  return flagZzDyyhs;}public String getZzHbsr(){ return zzHbsr;}public void setZzHbsr(String newValue){  this.zzHbsr = newValue;  flagZzHbsr = 1;}public int getFlagZzHbsr(){  return flagZzHbsr;}public String getZzHbyhs(){ return zzHbyhs;}public void setZzHbyhs(String newValue){  this.zzHbyhs = newValue;  flagZzHbyhs = 1;}public int getFlagZzHbyhs(){  return flagZzHbyhs;}public String getZzSysr(){ return zzSysr;}public void setZzSysr(String newValue){  this.zzSysr = newValue;  flagZzSysr = 1;}public int getFlagZzSysr(){  return flagZzSysr;}public String getZzSyyhs(){ return zzSyyhs;}public void setZzSyyhs(String newValue){  this.zzSyyhs = newValue;  flagZzSyyhs = 1;}public int getFlagZzSyyhs(){  return flagZzSyyhs;}public void clearFlagClDysr(){ flagClDysr = 0 ;}public void clearFlagClHbsr(){ flagClHbsr = 0 ;}public void clearFlagClSysr(){ flagClSysr = 0 ;}public void clearFlagClYhs(){ flagClYhs = 0 ;}public void clearFlagCp(){ flagCp = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagCzSr(){ flagCzSr = 0 ;}public void clearFlagCzYhs(){ flagCzYhs = 0 ;}public void clearFlagJlSysr(){ flagJlSysr = 0 ;}public void clearFlagJlYhs(){ flagJlYhs = 0 ;}public void clearFlagKhq(){ flagKhq = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagZlDysr(){ flagZlDysr = 0 ;}public void clearFlagZlYhs(){ flagZlYhs = 0 ;}public void clearFlagZzDysr(){ flagZzDysr = 0 ;}public void clearFlagZzDyyhs(){ flagZzDyyhs = 0 ;}public void clearFlagZzHbsr(){ flagZzHbsr = 0 ;}public void clearFlagZzHbyhs(){ flagZzHbyhs = 0 ;}public void clearFlagZzSysr(){ flagZzSysr = 0 ;}public void clearFlagZzSyyhs(){ flagZzSyyhs = 0 ;}public void clearAll(){ flagClDysr = 0; flagClHbsr = 0; flagClSysr = 0; flagClYhs = 0; flagCp = 0; flagCreateDate = 0; flagCzSr = 0; flagCzYhs = 0; flagJlSysr = 0; flagJlYhs = 0; flagKhq = 0; flagOpenDate = 0; flagZlDysr = 0; flagZlYhs = 0; flagZzDysr = 0; flagZzDyyhs = 0; flagZzHbsr = 0; flagZzHbyhs = 0; flagZzSysr = 0; flagZzSyyhs = 0;}}
