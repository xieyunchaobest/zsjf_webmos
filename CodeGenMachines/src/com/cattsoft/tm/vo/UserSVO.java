package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * UserSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class UserSVO extends GenericVO {private Date createDate = null;private String currentCity = null;private String currentProvince = null;private String educational = null;private String eMail = null;private String graduateInstitutions = null;private String interest = null;private String major = null;private String nation = null;private String otherSpeciality = null;private String passWord = null;private String personalWebsite = null;private String pwSecretLevel = null;private String qqNumber = null;private String qqSecretLevel = null;private String realName = null;private String sex = null;private String speciality = null;private String summary = null;private String telNbr = null;private String telSecretLevel = null;private Date updateDate = null;private String userId = null;private String userName = null;private String userType = null;private int flagCreateDate = 0;private int flagCurrentCity = 0;private int flagCurrentProvince = 0;private int flagEducational = 0;private int flagEMail = 0;private int flagGraduateInstitutions = 0;private int flagInterest = 0;private int flagMajor = 0;private int flagNation = 0;private int flagOtherSpeciality = 0;private int flagPassWord = 0;private int flagPersonalWebsite = 0;private int flagPwSecretLevel = 0;private int flagQqNumber = 0;private int flagQqSecretLevel = 0;private int flagRealName = 0;private int flagSex = 0;private int flagSpeciality = 0;private int flagSummary = 0;private int flagTelNbr = 0;private int flagTelSecretLevel = 0;private int flagUpdateDate = 0;private int flagUserId = 0;private int flagUserName = 0;private int flagUserType = 0;public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getCurrentCity(){ return currentCity;}public void setCurrentCity(String newValue){  this.currentCity = newValue;  flagCurrentCity = 1;}public int getFlagCurrentCity(){  return flagCurrentCity;}public String getCurrentProvince(){ return currentProvince;}public void setCurrentProvince(String newValue){  this.currentProvince = newValue;  flagCurrentProvince = 1;}public int getFlagCurrentProvince(){  return flagCurrentProvince;}public String getEducational(){ return educational;}public void setEducational(String newValue){  this.educational = newValue;  flagEducational = 1;}public int getFlagEducational(){  return flagEducational;}public String getEMail(){ return eMail;}public void setEMail(String newValue){  this.eMail = newValue;  flagEMail = 1;}public int getFlagEMail(){  return flagEMail;}public String getGraduateInstitutions(){ return graduateInstitutions;}public void setGraduateInstitutions(String newValue){  this.graduateInstitutions = newValue;  flagGraduateInstitutions = 1;}public int getFlagGraduateInstitutions(){  return flagGraduateInstitutions;}public String getInterest(){ return interest;}public void setInterest(String newValue){  this.interest = newValue;  flagInterest = 1;}public int getFlagInterest(){  return flagInterest;}public String getMajor(){ return major;}public void setMajor(String newValue){  this.major = newValue;  flagMajor = 1;}public int getFlagMajor(){  return flagMajor;}public String getNation(){ return nation;}public void setNation(String newValue){  this.nation = newValue;  flagNation = 1;}public int getFlagNation(){  return flagNation;}public String getOtherSpeciality(){ return otherSpeciality;}public void setOtherSpeciality(String newValue){  this.otherSpeciality = newValue;  flagOtherSpeciality = 1;}public int getFlagOtherSpeciality(){  return flagOtherSpeciality;}public String getPassWord(){ return passWord;}public void setPassWord(String newValue){  this.passWord = newValue;  flagPassWord = 1;}public int getFlagPassWord(){  return flagPassWord;}public String getPersonalWebsite(){ return personalWebsite;}public void setPersonalWebsite(String newValue){  this.personalWebsite = newValue;  flagPersonalWebsite = 1;}public int getFlagPersonalWebsite(){  return flagPersonalWebsite;}public String getPwSecretLevel(){ return pwSecretLevel;}public void setPwSecretLevel(String newValue){  this.pwSecretLevel = newValue;  flagPwSecretLevel = 1;}public int getFlagPwSecretLevel(){  return flagPwSecretLevel;}public String getQqNumber(){ return qqNumber;}public void setQqNumber(String newValue){  this.qqNumber = newValue;  flagQqNumber = 1;}public int getFlagQqNumber(){  return flagQqNumber;}public String getQqSecretLevel(){ return qqSecretLevel;}public void setQqSecretLevel(String newValue){  this.qqSecretLevel = newValue;  flagQqSecretLevel = 1;}public int getFlagQqSecretLevel(){  return flagQqSecretLevel;}public String getRealName(){ return realName;}public void setRealName(String newValue){  this.realName = newValue;  flagRealName = 1;}public int getFlagRealName(){  return flagRealName;}public String getSex(){ return sex;}public void setSex(String newValue){  this.sex = newValue;  flagSex = 1;}public int getFlagSex(){  return flagSex;}public String getSpeciality(){ return speciality;}public void setSpeciality(String newValue){  this.speciality = newValue;  flagSpeciality = 1;}public int getFlagSpeciality(){  return flagSpeciality;}public String getSummary(){ return summary;}public void setSummary(String newValue){  this.summary = newValue;  flagSummary = 1;}public int getFlagSummary(){  return flagSummary;}public String getTelNbr(){ return telNbr;}public void setTelNbr(String newValue){  this.telNbr = newValue;  flagTelNbr = 1;}public int getFlagTelNbr(){  return flagTelNbr;}public String getTelSecretLevel(){ return telSecretLevel;}public void setTelSecretLevel(String newValue){  this.telSecretLevel = newValue;  flagTelSecretLevel = 1;}public int getFlagTelSecretLevel(){  return flagTelSecretLevel;}public Date getUpdateDate(){  return updateDate;}public void setUpdateDate(Date newValue){   this.updateDate = newValue;  flagUpdateDate = 1;}public int getFlagUpdateDate(){  return flagUpdateDate;}public String getUserId(){ return userId;}public void setUserId(String newValue){  this.userId = newValue;  flagUserId = 1;}public int getFlagUserId(){  return flagUserId;}public String getUserName(){ return userName;}public void setUserName(String newValue){  this.userName = newValue;  flagUserName = 1;}public int getFlagUserName(){  return flagUserName;}public String getUserType(){ return userType;}public void setUserType(String newValue){  this.userType = newValue;  flagUserType = 1;}public int getFlagUserType(){  return flagUserType;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagCurrentCity(){ flagCurrentCity = 0 ;}public void clearFlagCurrentProvince(){ flagCurrentProvince = 0 ;}public void clearFlagEducational(){ flagEducational = 0 ;}public void clearFlagEMail(){ flagEMail = 0 ;}public void clearFlagGraduateInstitutions(){ flagGraduateInstitutions = 0 ;}public void clearFlagInterest(){ flagInterest = 0 ;}public void clearFlagMajor(){ flagMajor = 0 ;}public void clearFlagNation(){ flagNation = 0 ;}public void clearFlagOtherSpeciality(){ flagOtherSpeciality = 0 ;}public void clearFlagPassWord(){ flagPassWord = 0 ;}public void clearFlagPersonalWebsite(){ flagPersonalWebsite = 0 ;}public void clearFlagPwSecretLevel(){ flagPwSecretLevel = 0 ;}public void clearFlagQqNumber(){ flagQqNumber = 0 ;}public void clearFlagQqSecretLevel(){ flagQqSecretLevel = 0 ;}public void clearFlagRealName(){ flagRealName = 0 ;}public void clearFlagSex(){ flagSex = 0 ;}public void clearFlagSpeciality(){ flagSpeciality = 0 ;}public void clearFlagSummary(){ flagSummary = 0 ;}public void clearFlagTelNbr(){ flagTelNbr = 0 ;}public void clearFlagTelSecretLevel(){ flagTelSecretLevel = 0 ;}public void clearFlagUpdateDate(){ flagUpdateDate = 0 ;}public void clearFlagUserId(){ flagUserId = 0 ;}public void clearFlagUserName(){ flagUserName = 0 ;}public void clearFlagUserType(){ flagUserType = 0 ;}public void clearAll(){ flagCreateDate = 0; flagCurrentCity = 0; flagCurrentProvince = 0; flagEducational = 0; flagEMail = 0; flagGraduateInstitutions = 0; flagInterest = 0; flagMajor = 0; flagNation = 0; flagOtherSpeciality = 0; flagPassWord = 0; flagPersonalWebsite = 0; flagPwSecretLevel = 0; flagQqNumber = 0; flagQqSecretLevel = 0; flagRealName = 0; flagSex = 0; flagSpeciality = 0; flagSummary = 0; flagTelNbr = 0; flagTelSecretLevel = 0; flagUpdateDate = 0; flagUserId = 0; flagUserName = 0; flagUserType = 0;}}
