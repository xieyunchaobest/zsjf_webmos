package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRptQdrbQdkhjlrbSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRptQdrbQdkhjlrbSVO extends GenericVO {private Date createDate = null;private String khjlMc = null;private String ocs2gDyljsx = null;private String ocs2gRjh = null;private String ocs2gRxs = null;private String ocs2gSyljjh = null;private String ocs3gDylj = null;private String ocs3gRfz = null;private String ocs3gSytq = null;private String ocs3gZzs = null;private Date openDate = null;private String pt2gDylj = null;private String pt2gRfz = null;private String pt2gSytq = null;private String pt2gZzs = null;private String pt3gDylj = null;private String pt3gRfz = null;private String pt3gSytq = null;private String pt3gZzs = null;private String pt4gDgyl = null;private String pt4gRfz = null;private String pt4gSytq = null;private String pt4gZzs = null;private String rh2g3gDylj = null;private String rh2g3gRfz = null;private String rh2g3gSytq = null;private String rh2g3gZzs = null;private String wdMc = null;private String wgCode = null;private String wgMc = null;private int flagCreateDate = 0;private int flagKhjlMc = 0;private int flagOcs2gDyljsx = 0;private int flagOcs2gRjh = 0;private int flagOcs2gRxs = 0;private int flagOcs2gSyljjh = 0;private int flagOcs3gDylj = 0;private int flagOcs3gRfz = 0;private int flagOcs3gSytq = 0;private int flagOcs3gZzs = 0;private int flagOpenDate = 0;private int flagPt2gDylj = 0;private int flagPt2gRfz = 0;private int flagPt2gSytq = 0;private int flagPt2gZzs = 0;private int flagPt3gDylj = 0;private int flagPt3gRfz = 0;private int flagPt3gSytq = 0;private int flagPt3gZzs = 0;private int flagPt4gDgyl = 0;private int flagPt4gRfz = 0;private int flagPt4gSytq = 0;private int flagPt4gZzs = 0;private int flagRh2g3gDylj = 0;private int flagRh2g3gRfz = 0;private int flagRh2g3gSytq = 0;private int flagRh2g3gZzs = 0;private int flagWdMc = 0;private int flagWgCode = 0;private int flagWgMc = 0;public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getKhjlMc(){ return khjlMc;}public void setKhjlMc(String newValue){  this.khjlMc = newValue;  flagKhjlMc = 1;}public int getFlagKhjlMc(){  return flagKhjlMc;}public String getOcs2gDyljsx(){ return ocs2gDyljsx;}public void setOcs2gDyljsx(String newValue){  this.ocs2gDyljsx = newValue;  flagOcs2gDyljsx = 1;}public int getFlagOcs2gDyljsx(){  return flagOcs2gDyljsx;}public String getOcs2gRjh(){ return ocs2gRjh;}public void setOcs2gRjh(String newValue){  this.ocs2gRjh = newValue;  flagOcs2gRjh = 1;}public int getFlagOcs2gRjh(){  return flagOcs2gRjh;}public String getOcs2gRxs(){ return ocs2gRxs;}public void setOcs2gRxs(String newValue){  this.ocs2gRxs = newValue;  flagOcs2gRxs = 1;}public int getFlagOcs2gRxs(){  return flagOcs2gRxs;}public String getOcs2gSyljjh(){ return ocs2gSyljjh;}public void setOcs2gSyljjh(String newValue){  this.ocs2gSyljjh = newValue;  flagOcs2gSyljjh = 1;}public int getFlagOcs2gSyljjh(){  return flagOcs2gSyljjh;}public String getOcs3gDylj(){ return ocs3gDylj;}public void setOcs3gDylj(String newValue){  this.ocs3gDylj = newValue;  flagOcs3gDylj = 1;}public int getFlagOcs3gDylj(){  return flagOcs3gDylj;}public String getOcs3gRfz(){ return ocs3gRfz;}public void setOcs3gRfz(String newValue){  this.ocs3gRfz = newValue;  flagOcs3gRfz = 1;}public int getFlagOcs3gRfz(){  return flagOcs3gRfz;}public String getOcs3gSytq(){ return ocs3gSytq;}public void setOcs3gSytq(String newValue){  this.ocs3gSytq = newValue;  flagOcs3gSytq = 1;}public int getFlagOcs3gSytq(){  return flagOcs3gSytq;}public String getOcs3gZzs(){ return ocs3gZzs;}public void setOcs3gZzs(String newValue){  this.ocs3gZzs = newValue;  flagOcs3gZzs = 1;}public int getFlagOcs3gZzs(){  return flagOcs3gZzs;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getPt2gDylj(){ return pt2gDylj;}public void setPt2gDylj(String newValue){  this.pt2gDylj = newValue;  flagPt2gDylj = 1;}public int getFlagPt2gDylj(){  return flagPt2gDylj;}public String getPt2gRfz(){ return pt2gRfz;}public void setPt2gRfz(String newValue){  this.pt2gRfz = newValue;  flagPt2gRfz = 1;}public int getFlagPt2gRfz(){  return flagPt2gRfz;}public String getPt2gSytq(){ return pt2gSytq;}public void setPt2gSytq(String newValue){  this.pt2gSytq = newValue;  flagPt2gSytq = 1;}public int getFlagPt2gSytq(){  return flagPt2gSytq;}public String getPt2gZzs(){ return pt2gZzs;}public void setPt2gZzs(String newValue){  this.pt2gZzs = newValue;  flagPt2gZzs = 1;}public int getFlagPt2gZzs(){  return flagPt2gZzs;}public String getPt3gDylj(){ return pt3gDylj;}public void setPt3gDylj(String newValue){  this.pt3gDylj = newValue;  flagPt3gDylj = 1;}public int getFlagPt3gDylj(){  return flagPt3gDylj;}public String getPt3gRfz(){ return pt3gRfz;}public void setPt3gRfz(String newValue){  this.pt3gRfz = newValue;  flagPt3gRfz = 1;}public int getFlagPt3gRfz(){  return flagPt3gRfz;}public String getPt3gSytq(){ return pt3gSytq;}public void setPt3gSytq(String newValue){  this.pt3gSytq = newValue;  flagPt3gSytq = 1;}public int getFlagPt3gSytq(){  return flagPt3gSytq;}public String getPt3gZzs(){ return pt3gZzs;}public void setPt3gZzs(String newValue){  this.pt3gZzs = newValue;  flagPt3gZzs = 1;}public int getFlagPt3gZzs(){  return flagPt3gZzs;}public String getPt4gDgyl(){ return pt4gDgyl;}public void setPt4gDgyl(String newValue){  this.pt4gDgyl = newValue;  flagPt4gDgyl = 1;}public int getFlagPt4gDgyl(){  return flagPt4gDgyl;}public String getPt4gRfz(){ return pt4gRfz;}public void setPt4gRfz(String newValue){  this.pt4gRfz = newValue;  flagPt4gRfz = 1;}public int getFlagPt4gRfz(){  return flagPt4gRfz;}public String getPt4gSytq(){ return pt4gSytq;}public void setPt4gSytq(String newValue){  this.pt4gSytq = newValue;  flagPt4gSytq = 1;}public int getFlagPt4gSytq(){  return flagPt4gSytq;}public String getPt4gZzs(){ return pt4gZzs;}public void setPt4gZzs(String newValue){  this.pt4gZzs = newValue;  flagPt4gZzs = 1;}public int getFlagPt4gZzs(){  return flagPt4gZzs;}public String getRh2g3gDylj(){ return rh2g3gDylj;}public void setRh2g3gDylj(String newValue){  this.rh2g3gDylj = newValue;  flagRh2g3gDylj = 1;}public int getFlagRh2g3gDylj(){  return flagRh2g3gDylj;}public String getRh2g3gRfz(){ return rh2g3gRfz;}public void setRh2g3gRfz(String newValue){  this.rh2g3gRfz = newValue;  flagRh2g3gRfz = 1;}public int getFlagRh2g3gRfz(){  return flagRh2g3gRfz;}public String getRh2g3gSytq(){ return rh2g3gSytq;}public void setRh2g3gSytq(String newValue){  this.rh2g3gSytq = newValue;  flagRh2g3gSytq = 1;}public int getFlagRh2g3gSytq(){  return flagRh2g3gSytq;}public String getRh2g3gZzs(){ return rh2g3gZzs;}public void setRh2g3gZzs(String newValue){  this.rh2g3gZzs = newValue;  flagRh2g3gZzs = 1;}public int getFlagRh2g3gZzs(){  return flagRh2g3gZzs;}public String getWdMc(){ return wdMc;}public void setWdMc(String newValue){  this.wdMc = newValue;  flagWdMc = 1;}public int getFlagWdMc(){  return flagWdMc;}public String getWgCode(){ return wgCode;}public void setWgCode(String newValue){  this.wgCode = newValue;  flagWgCode = 1;}public int getFlagWgCode(){  return flagWgCode;}public String getWgMc(){ return wgMc;}public void setWgMc(String newValue){  this.wgMc = newValue;  flagWgMc = 1;}public int getFlagWgMc(){  return flagWgMc;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagKhjlMc(){ flagKhjlMc = 0 ;}public void clearFlagOcs2gDyljsx(){ flagOcs2gDyljsx = 0 ;}public void clearFlagOcs2gRjh(){ flagOcs2gRjh = 0 ;}public void clearFlagOcs2gRxs(){ flagOcs2gRxs = 0 ;}public void clearFlagOcs2gSyljjh(){ flagOcs2gSyljjh = 0 ;}public void clearFlagOcs3gDylj(){ flagOcs3gDylj = 0 ;}public void clearFlagOcs3gRfz(){ flagOcs3gRfz = 0 ;}public void clearFlagOcs3gSytq(){ flagOcs3gSytq = 0 ;}public void clearFlagOcs3gZzs(){ flagOcs3gZzs = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagPt2gDylj(){ flagPt2gDylj = 0 ;}public void clearFlagPt2gRfz(){ flagPt2gRfz = 0 ;}public void clearFlagPt2gSytq(){ flagPt2gSytq = 0 ;}public void clearFlagPt2gZzs(){ flagPt2gZzs = 0 ;}public void clearFlagPt3gDylj(){ flagPt3gDylj = 0 ;}public void clearFlagPt3gRfz(){ flagPt3gRfz = 0 ;}public void clearFlagPt3gSytq(){ flagPt3gSytq = 0 ;}public void clearFlagPt3gZzs(){ flagPt3gZzs = 0 ;}public void clearFlagPt4gDgyl(){ flagPt4gDgyl = 0 ;}public void clearFlagPt4gRfz(){ flagPt4gRfz = 0 ;}public void clearFlagPt4gSytq(){ flagPt4gSytq = 0 ;}public void clearFlagPt4gZzs(){ flagPt4gZzs = 0 ;}public void clearFlagRh2g3gDylj(){ flagRh2g3gDylj = 0 ;}public void clearFlagRh2g3gRfz(){ flagRh2g3gRfz = 0 ;}public void clearFlagRh2g3gSytq(){ flagRh2g3gSytq = 0 ;}public void clearFlagRh2g3gZzs(){ flagRh2g3gZzs = 0 ;}public void clearFlagWdMc(){ flagWdMc = 0 ;}public void clearFlagWgCode(){ flagWgCode = 0 ;}public void clearFlagWgMc(){ flagWgMc = 0 ;}public void clearAll(){ flagCreateDate = 0; flagKhjlMc = 0; flagOcs2gDyljsx = 0; flagOcs2gRjh = 0; flagOcs2gRxs = 0; flagOcs2gSyljjh = 0; flagOcs3gDylj = 0; flagOcs3gRfz = 0; flagOcs3gSytq = 0; flagOcs3gZzs = 0; flagOpenDate = 0; flagPt2gDylj = 0; flagPt2gRfz = 0; flagPt2gSytq = 0; flagPt2gZzs = 0; flagPt3gDylj = 0; flagPt3gRfz = 0; flagPt3gSytq = 0; flagPt3gZzs = 0; flagPt4gDgyl = 0; flagPt4gRfz = 0; flagPt4gSytq = 0; flagPt4gZzs = 0; flagRh2g3gDylj = 0; flagRh2g3gRfz = 0; flagRh2g3gSytq = 0; flagRh2g3gZzs = 0; flagWdMc = 0; flagWgCode = 0; flagWgMc = 0;}}
