package com.cattsoft.sm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * PartyIdentitySVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class PartyIdentitySVO extends GenericVO {private String certAddr = null;private String certCode = null;private Date certExpDate = null;private String certTypeId = null;private String checkInfo = null;private Date createDate = null;private String detailInfo = null;private String localNetId = null;private String partyId = null;private String partyIdentityId = null;private String sts = null;private Date stsDate = null;private int flagCertAddr = 0;private int flagCertCode = 0;private int flagCertExpDate = 0;private int flagCertTypeId = 0;private int flagCheckInfo = 0;private int flagCreateDate = 0;private int flagDetailInfo = 0;private int flagLocalNetId = 0;private int flagPartyId = 0;private int flagPartyIdentityId = 0;private int flagSts = 0;private int flagStsDate = 0;public String getCertAddr(){ return certAddr;}public void setCertAddr(String newValue){  this.certAddr = newValue;  flagCertAddr = 1;}public int getFlagCertAddr(){  return flagCertAddr;}public String getCertCode(){ return certCode;}public void setCertCode(String newValue){  this.certCode = newValue;  flagCertCode = 1;}public int getFlagCertCode(){  return flagCertCode;}public Date getCertExpDate(){  return certExpDate;}public void setCertExpDate(Date newValue){   this.certExpDate = newValue;  flagCertExpDate = 1;}public int getFlagCertExpDate(){  return flagCertExpDate;}public String getCertTypeId(){ return certTypeId;}public void setCertTypeId(String newValue){  this.certTypeId = newValue;  flagCertTypeId = 1;}public int getFlagCertTypeId(){  return flagCertTypeId;}public String getCheckInfo(){ return checkInfo;}public void setCheckInfo(String newValue){  this.checkInfo = newValue;  flagCheckInfo = 1;}public int getFlagCheckInfo(){  return flagCheckInfo;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getDetailInfo(){ return detailInfo;}public void setDetailInfo(String newValue){  this.detailInfo = newValue;  flagDetailInfo = 1;}public int getFlagDetailInfo(){  return flagDetailInfo;}public String getLocalNetId(){ return localNetId;}public void setLocalNetId(String newValue){  this.localNetId = newValue;  flagLocalNetId = 1;}public int getFlagLocalNetId(){  return flagLocalNetId;}public String getPartyId(){ return partyId;}public void setPartyId(String newValue){  this.partyId = newValue;  flagPartyId = 1;}public int getFlagPartyId(){  return flagPartyId;}public String getPartyIdentityId(){ return partyIdentityId;}public void setPartyIdentityId(String newValue){  this.partyIdentityId = newValue;  flagPartyIdentityId = 1;}public int getFlagPartyIdentityId(){  return flagPartyIdentityId;}public String getSts(){ return sts;}public void setSts(String newValue){  this.sts = newValue;  flagSts = 1;}public int getFlagSts(){  return flagSts;}public Date getStsDate(){  return stsDate;}public void setStsDate(Date newValue){   this.stsDate = newValue;  flagStsDate = 1;}public int getFlagStsDate(){  return flagStsDate;}public void clearFlagCertAddr(){ flagCertAddr = 0 ;}public void clearFlagCertCode(){ flagCertCode = 0 ;}public void clearFlagCertExpDate(){ flagCertExpDate = 0 ;}public void clearFlagCertTypeId(){ flagCertTypeId = 0 ;}public void clearFlagCheckInfo(){ flagCheckInfo = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagDetailInfo(){ flagDetailInfo = 0 ;}public void clearFlagLocalNetId(){ flagLocalNetId = 0 ;}public void clearFlagPartyId(){ flagPartyId = 0 ;}public void clearFlagPartyIdentityId(){ flagPartyIdentityId = 0 ;}public void clearFlagSts(){ flagSts = 0 ;}public void clearFlagStsDate(){ flagStsDate = 0 ;}public void clearAll(){ flagCertAddr = 0; flagCertCode = 0; flagCertExpDate = 0; flagCertTypeId = 0; flagCheckInfo = 0; flagCreateDate = 0; flagDetailInfo = 0; flagLocalNetId = 0; flagPartyId = 0; flagPartyIdentityId = 0; flagSts = 0; flagStsDate = 0;}}
