package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.ITempFeeSoAddrSDAO;import com.cattsoft.sp.vo.TempFeeSoAddrSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法TempFeeSoAddrSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class TempFeeSoAddrSDAOImpl implements ITempFeeSoAddrSDAO{    private static Logger log = Logger.getLogger(TempFeeSoAddrSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO TEMP_FEE_SO_ADDR(ACT_TYPE,ADDR_ID,ADDR_INFO,AREA_ID,AZ_FLAG,BRANCH_ID,CHANGED_FLAG,DEVICE_ID,DISTRICT_ID,DISTRICT_NAME,EXCH_ID,LOCAL_NET_ID,MAINT_AREA_ID,MS_AREA_ID,MS_AREA_NAME,MS_STAFF_ID,MS_STAFF_NAME,MT_AREA_NAME,MT_STAFF_ID,MT_STAFF_NAME,NO_FLAG,REF_ACC_NBR,SERV_DEPT_ID,SITUATED,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_ADDR_ID,TWO_EXCH_FLAG,WO_ACTION)");sql.append(" VALUES (:actType,:addrId,:addrInfo,:areaId,:azFlag,:branchId,:changedFlag,:deviceId,:districtId,:districtName,:exchId,:localNetId,:maintAreaId,:msAreaId,:msAreaName,:msStaffId,:msStaffName,:mtAreaName,:mtStaffId,:mtStaffName,:noFlag,:refAccNbr,:servDeptId,:situated,:soNbr,:sts,:stsDate,:tempFeeSoAddrId,:twoExchFlag,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(tempFeeSoAddr.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", tempFeeSoAddr.getActType());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAddrId())) {      sql.setNullLong("addrId");     } else {    sql.setLong("addrId", tempFeeSoAddr.getAddrId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAddrInfo())) {      sql.setNullString("addrInfo");     } else {    sql.setString("addrInfo", tempFeeSoAddr.getAddrInfo());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", tempFeeSoAddr.getAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAzFlag())) {      sql.setNullString("azFlag");     } else {    sql.setString("azFlag", tempFeeSoAddr.getAzFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getBranchId())) {      sql.setNullLong("branchId");     } else {    sql.setLong("branchId", tempFeeSoAddr.getBranchId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getChangedFlag())) {      sql.setNullString("changedFlag");     } else {    sql.setString("changedFlag", tempFeeSoAddr.getChangedFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDeviceId())) {      sql.setNullLong("deviceId");     } else {    sql.setLong("deviceId", tempFeeSoAddr.getDeviceId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDistrictId())) {      sql.setNullLong("districtId");     } else {    sql.setLong("districtId", tempFeeSoAddr.getDistrictId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDistrictName())) {      sql.setNullString("districtName");     } else {    sql.setString("districtName", tempFeeSoAddr.getDistrictName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getExchId())) {      sql.setNullLong("exchId");     } else {    sql.setLong("exchId", tempFeeSoAddr.getExchId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", tempFeeSoAddr.getLocalNetId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMaintAreaId())) {      sql.setNullLong("maintAreaId");     } else {    sql.setLong("maintAreaId", tempFeeSoAddr.getMaintAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaId())) {      sql.setNullLong("msAreaId");     } else {    sql.setLong("msAreaId", tempFeeSoAddr.getMsAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaName())) {      sql.setNullString("msAreaName");     } else {    sql.setString("msAreaName", tempFeeSoAddr.getMsAreaName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffId())) {      sql.setNullLong("msStaffId");     } else {    sql.setLong("msStaffId", tempFeeSoAddr.getMsStaffId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffName())) {      sql.setNullString("msStaffName");     } else {    sql.setString("msStaffName", tempFeeSoAddr.getMsStaffName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtAreaName())) {      sql.setNullString("mtAreaName");     } else {    sql.setString("mtAreaName", tempFeeSoAddr.getMtAreaName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffId())) {      sql.setNullLong("mtStaffId");     } else {    sql.setLong("mtStaffId", tempFeeSoAddr.getMtStaffId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffName())) {      sql.setNullString("mtStaffName");     } else {    sql.setString("mtStaffName", tempFeeSoAddr.getMtStaffName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", tempFeeSoAddr.getNoFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getRefAccNbr())) {      sql.setNullString("refAccNbr");     } else {    sql.setString("refAccNbr", tempFeeSoAddr.getRefAccNbr());    }       if (StringUtil.isBlank(tempFeeSoAddr.getServDeptId())) {      sql.setNullLong("servDeptId");     } else {    sql.setLong("servDeptId", tempFeeSoAddr.getServDeptId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSituated())) {      sql.setNullString("situated");     } else {    sql.setString("situated", tempFeeSoAddr.getSituated());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", tempFeeSoAddr.getSoNbr());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", tempFeeSoAddr.getSts());    }    if (tempFeeSoAddr.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", tempFeeSoAddr.getStsDate());    }       if (StringUtil.isBlank(tempFeeSoAddr.getTempFeeSoAddrId())) {      sql.setNullLong("tempFeeSoAddrId");     } else {    sql.setLong("tempFeeSoAddrId", tempFeeSoAddr.getTempFeeSoAddrId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getTwoExchFlag())) {      sql.setNullString("twoExchFlag");     } else {    sql.setString("twoExchFlag", tempFeeSoAddr.getTwoExchFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", tempFeeSoAddr.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;       Sql sql = new Sql("SELECT ACT_TYPE,ADDR_ID,ADDR_INFO,AREA_ID,AZ_FLAG,BRANCH_ID,CHANGED_FLAG,DEVICE_ID,DISTRICT_ID,DISTRICT_NAME,EXCH_ID,LOCAL_NET_ID,MAINT_AREA_ID,MS_AREA_ID,MS_AREA_NAME,MS_STAFF_ID,MS_STAFF_NAME,MT_AREA_NAME,MT_STAFF_ID,MT_STAFF_NAME,NO_FLAG,REF_ACC_NBR,SERV_DEPT_ID,SITUATED,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_ADDR_ID,TWO_EXCH_FLAG,WO_ACTION FROM TEMP_FEE_SO_ADDR WHERE 1=1  ");      Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      tempFeeSoAddr =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           tempFeeSoAddr = new TempFeeSoAddrSVO();           tempFeeSoAddr.setActType(rs.getString("ACT_TYPE"));           tempFeeSoAddr.setAddrId(rs.getString("ADDR_ID"));           tempFeeSoAddr.setAddrInfo(rs.getString("ADDR_INFO"));           tempFeeSoAddr.setAreaId(rs.getString("AREA_ID"));           tempFeeSoAddr.setAzFlag(rs.getString("AZ_FLAG"));           tempFeeSoAddr.setBranchId(rs.getString("BRANCH_ID"));           tempFeeSoAddr.setChangedFlag(rs.getString("CHANGED_FLAG"));           tempFeeSoAddr.setDeviceId(rs.getString("DEVICE_ID"));           tempFeeSoAddr.setDistrictId(rs.getString("DISTRICT_ID"));           tempFeeSoAddr.setDistrictName(rs.getString("DISTRICT_NAME"));           tempFeeSoAddr.setExchId(rs.getString("EXCH_ID"));           tempFeeSoAddr.setLocalNetId(rs.getString("LOCAL_NET_ID"));           tempFeeSoAddr.setMaintAreaId(rs.getString("MAINT_AREA_ID"));           tempFeeSoAddr.setMsAreaId(rs.getString("MS_AREA_ID"));           tempFeeSoAddr.setMsAreaName(rs.getString("MS_AREA_NAME"));           tempFeeSoAddr.setMsStaffId(rs.getString("MS_STAFF_ID"));           tempFeeSoAddr.setMsStaffName(rs.getString("MS_STAFF_NAME"));           tempFeeSoAddr.setMtAreaName(rs.getString("MT_AREA_NAME"));           tempFeeSoAddr.setMtStaffId(rs.getString("MT_STAFF_ID"));           tempFeeSoAddr.setMtStaffName(rs.getString("MT_STAFF_NAME"));           tempFeeSoAddr.setNoFlag(rs.getString("NO_FLAG"));           tempFeeSoAddr.setRefAccNbr(rs.getString("REF_ACC_NBR"));           tempFeeSoAddr.setServDeptId(rs.getString("SERV_DEPT_ID"));           tempFeeSoAddr.setSituated(rs.getString("SITUATED"));           tempFeeSoAddr.setSoNbr(rs.getString("SO_NBR"));           tempFeeSoAddr.setSts(rs.getString("STS"));           tempFeeSoAddr.setStsDate(rs.getTimestamp("STS_DATE"));           tempFeeSoAddr.setTempFeeSoAddrId(rs.getString("TEMP_FEE_SO_ADDR_ID"));           tempFeeSoAddr.setTwoExchFlag(rs.getString("TWO_EXCH_FLAG"));           tempFeeSoAddr.setWoAction(rs.getString("WO_ACTION"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return tempFeeSoAddr;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT ACT_TYPE,ADDR_ID,ADDR_INFO,AREA_ID,AZ_FLAG,BRANCH_ID,CHANGED_FLAG,DEVICE_ID,DISTRICT_ID,DISTRICT_NAME,EXCH_ID,LOCAL_NET_ID,MAINT_AREA_ID,MS_AREA_ID,MS_AREA_NAME,MS_STAFF_ID,MS_STAFF_NAME,MT_AREA_NAME,MT_STAFF_ID,MT_STAFF_NAME,NO_FLAG,REF_ACC_NBR,SERV_DEPT_ID,SITUATED,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_ADDR_ID,TWO_EXCH_FLAG,WO_ACTION FROM TEMP_FEE_SO_ADDR WHERE 1=1 ");     try {if (tempFeeSoAddr.getFlagActType() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getActType())) {             sql.append(" and ACT_TYPE is null ");          }      else{             sql.append(" and ACT_TYPE=:actType");             sql.setString("actType", tempFeeSoAddr.getActType());          }   } if (tempFeeSoAddr.getFlagAddrId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getAddrId())) {             sql.append(" and ADDR_ID is null ");          }      else{             sql.append(" and ADDR_ID=:addrId");             sql.setLong("addrId", tempFeeSoAddr.getAddrId());          }   } if (tempFeeSoAddr.getFlagAddrInfo() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getAddrInfo())) {             sql.append(" and ADDR_INFO is null ");          }      else{             sql.append(" and ADDR_INFO=:addrInfo");             sql.setString("addrInfo", tempFeeSoAddr.getAddrInfo());          }   } if (tempFeeSoAddr.getFlagAreaId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getAreaId())) {             sql.append(" and AREA_ID is null ");          }      else{             sql.append(" and AREA_ID=:areaId");             sql.setLong("areaId", tempFeeSoAddr.getAreaId());          }   } if (tempFeeSoAddr.getFlagAzFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getAzFlag())) {             sql.append(" and AZ_FLAG is null ");          }      else{             sql.append(" and AZ_FLAG=:azFlag");             sql.setString("azFlag", tempFeeSoAddr.getAzFlag());          }   } if (tempFeeSoAddr.getFlagBranchId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getBranchId())) {             sql.append(" and BRANCH_ID is null ");          }      else{             sql.append(" and BRANCH_ID=:branchId");             sql.setLong("branchId", tempFeeSoAddr.getBranchId());          }   } if (tempFeeSoAddr.getFlagChangedFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getChangedFlag())) {             sql.append(" and CHANGED_FLAG is null ");          }      else{             sql.append(" and CHANGED_FLAG=:changedFlag");             sql.setString("changedFlag", tempFeeSoAddr.getChangedFlag());          }   } if (tempFeeSoAddr.getFlagDeviceId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getDeviceId())) {             sql.append(" and DEVICE_ID is null ");          }      else{             sql.append(" and DEVICE_ID=:deviceId");             sql.setLong("deviceId", tempFeeSoAddr.getDeviceId());          }   } if (tempFeeSoAddr.getFlagDistrictId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getDistrictId())) {             sql.append(" and DISTRICT_ID is null ");          }      else{             sql.append(" and DISTRICT_ID=:districtId");             sql.setLong("districtId", tempFeeSoAddr.getDistrictId());          }   } if (tempFeeSoAddr.getFlagDistrictName() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getDistrictName())) {             sql.append(" and DISTRICT_NAME is null ");          }      else{             sql.append(" and DISTRICT_NAME=:districtName");             sql.setString("districtName", tempFeeSoAddr.getDistrictName());          }   } if (tempFeeSoAddr.getFlagExchId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getExchId())) {             sql.append(" and EXCH_ID is null ");          }      else{             sql.append(" and EXCH_ID=:exchId");             sql.setLong("exchId", tempFeeSoAddr.getExchId());          }   } if (tempFeeSoAddr.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", tempFeeSoAddr.getLocalNetId());          }   } if (tempFeeSoAddr.getFlagMaintAreaId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMaintAreaId())) {             sql.append(" and MAINT_AREA_ID is null ");          }      else{             sql.append(" and MAINT_AREA_ID=:maintAreaId");             sql.setLong("maintAreaId", tempFeeSoAddr.getMaintAreaId());          }   } if (tempFeeSoAddr.getFlagMsAreaId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaId())) {             sql.append(" and MS_AREA_ID is null ");          }      else{             sql.append(" and MS_AREA_ID=:msAreaId");             sql.setLong("msAreaId", tempFeeSoAddr.getMsAreaId());          }   } if (tempFeeSoAddr.getFlagMsAreaName() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaName())) {             sql.append(" and MS_AREA_NAME is null ");          }      else{             sql.append(" and MS_AREA_NAME=:msAreaName");             sql.setString("msAreaName", tempFeeSoAddr.getMsAreaName());          }   } if (tempFeeSoAddr.getFlagMsStaffId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffId())) {             sql.append(" and MS_STAFF_ID is null ");          }      else{             sql.append(" and MS_STAFF_ID=:msStaffId");             sql.setLong("msStaffId", tempFeeSoAddr.getMsStaffId());          }   } if (tempFeeSoAddr.getFlagMsStaffName() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffName())) {             sql.append(" and MS_STAFF_NAME is null ");          }      else{             sql.append(" and MS_STAFF_NAME=:msStaffName");             sql.setString("msStaffName", tempFeeSoAddr.getMsStaffName());          }   } if (tempFeeSoAddr.getFlagMtAreaName() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMtAreaName())) {             sql.append(" and MT_AREA_NAME is null ");          }      else{             sql.append(" and MT_AREA_NAME=:mtAreaName");             sql.setString("mtAreaName", tempFeeSoAddr.getMtAreaName());          }   } if (tempFeeSoAddr.getFlagMtStaffId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffId())) {             sql.append(" and MT_STAFF_ID is null ");          }      else{             sql.append(" and MT_STAFF_ID=:mtStaffId");             sql.setLong("mtStaffId", tempFeeSoAddr.getMtStaffId());          }   } if (tempFeeSoAddr.getFlagMtStaffName() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffName())) {             sql.append(" and MT_STAFF_NAME is null ");          }      else{             sql.append(" and MT_STAFF_NAME=:mtStaffName");             sql.setString("mtStaffName", tempFeeSoAddr.getMtStaffName());          }   } if (tempFeeSoAddr.getFlagNoFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getNoFlag())) {             sql.append(" and NO_FLAG is null ");          }      else{             sql.append(" and NO_FLAG=:noFlag");             sql.setString("noFlag", tempFeeSoAddr.getNoFlag());          }   } if (tempFeeSoAddr.getFlagRefAccNbr() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getRefAccNbr())) {             sql.append(" and REF_ACC_NBR is null ");          }      else{             sql.append(" and REF_ACC_NBR=:refAccNbr");             sql.setString("refAccNbr", tempFeeSoAddr.getRefAccNbr());          }   } if (tempFeeSoAddr.getFlagServDeptId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getServDeptId())) {             sql.append(" and SERV_DEPT_ID is null ");          }      else{             sql.append(" and SERV_DEPT_ID=:servDeptId");             sql.setLong("servDeptId", tempFeeSoAddr.getServDeptId());          }   } if (tempFeeSoAddr.getFlagSituated() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getSituated())) {             sql.append(" and SITUATED is null ");          }      else{             sql.append(" and SITUATED=:situated");             sql.setString("situated", tempFeeSoAddr.getSituated());          }   } if (tempFeeSoAddr.getFlagSoNbr() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getSoNbr())) {             sql.append(" and SO_NBR is null ");          }      else{             sql.append(" and SO_NBR=:soNbr");             sql.setString("soNbr", tempFeeSoAddr.getSoNbr());          }   } if (tempFeeSoAddr.getFlagSts() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", tempFeeSoAddr.getSts());          }   } if (tempFeeSoAddr.getFlagStsDate() == 1) {      if (tempFeeSoAddr.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", tempFeeSoAddr.getStsDate());          }   } if (tempFeeSoAddr.getFlagTempFeeSoAddrId() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getTempFeeSoAddrId())) {             sql.append(" and TEMP_FEE_SO_ADDR_ID is null ");          }      else{             sql.append(" and TEMP_FEE_SO_ADDR_ID=:tempFeeSoAddrId");             sql.setLong("tempFeeSoAddrId", tempFeeSoAddr.getTempFeeSoAddrId());          }   } if (tempFeeSoAddr.getFlagTwoExchFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getTwoExchFlag())) {             sql.append(" and TWO_EXCH_FLAG is null ");          }      else{             sql.append(" and TWO_EXCH_FLAG=:twoExchFlag");             sql.setString("twoExchFlag", tempFeeSoAddr.getTwoExchFlag());          }   } if (tempFeeSoAddr.getFlagWoAction() == 1) {      if (StringUtil.isBlank(tempFeeSoAddr.getWoAction())) {             sql.append(" and WO_ACTION is null ");          }      else{             sql.append(" and WO_ACTION=:woAction");             sql.setString("woAction", tempFeeSoAddr.getWoAction());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           tempFeeSoAddr = new TempFeeSoAddrSVO();           tempFeeSoAddr.setActType(rs.getString("ACT_TYPE"));           tempFeeSoAddr.setAddrId(rs.getString("ADDR_ID"));           tempFeeSoAddr.setAddrInfo(rs.getString("ADDR_INFO"));           tempFeeSoAddr.setAreaId(rs.getString("AREA_ID"));           tempFeeSoAddr.setAzFlag(rs.getString("AZ_FLAG"));           tempFeeSoAddr.setBranchId(rs.getString("BRANCH_ID"));           tempFeeSoAddr.setChangedFlag(rs.getString("CHANGED_FLAG"));           tempFeeSoAddr.setDeviceId(rs.getString("DEVICE_ID"));           tempFeeSoAddr.setDistrictId(rs.getString("DISTRICT_ID"));           tempFeeSoAddr.setDistrictName(rs.getString("DISTRICT_NAME"));           tempFeeSoAddr.setExchId(rs.getString("EXCH_ID"));           tempFeeSoAddr.setLocalNetId(rs.getString("LOCAL_NET_ID"));           tempFeeSoAddr.setMaintAreaId(rs.getString("MAINT_AREA_ID"));           tempFeeSoAddr.setMsAreaId(rs.getString("MS_AREA_ID"));           tempFeeSoAddr.setMsAreaName(rs.getString("MS_AREA_NAME"));           tempFeeSoAddr.setMsStaffId(rs.getString("MS_STAFF_ID"));           tempFeeSoAddr.setMsStaffName(rs.getString("MS_STAFF_NAME"));           tempFeeSoAddr.setMtAreaName(rs.getString("MT_AREA_NAME"));           tempFeeSoAddr.setMtStaffId(rs.getString("MT_STAFF_ID"));           tempFeeSoAddr.setMtStaffName(rs.getString("MT_STAFF_NAME"));           tempFeeSoAddr.setNoFlag(rs.getString("NO_FLAG"));           tempFeeSoAddr.setRefAccNbr(rs.getString("REF_ACC_NBR"));           tempFeeSoAddr.setServDeptId(rs.getString("SERV_DEPT_ID"));           tempFeeSoAddr.setSituated(rs.getString("SITUATED"));           tempFeeSoAddr.setSoNbr(rs.getString("SO_NBR"));           tempFeeSoAddr.setSts(rs.getString("STS"));           tempFeeSoAddr.setStsDate(rs.getTimestamp("STS_DATE"));           tempFeeSoAddr.setTempFeeSoAddrId(rs.getString("TEMP_FEE_SO_ADDR_ID"));           tempFeeSoAddr.setTwoExchFlag(rs.getString("TWO_EXCH_FLAG"));           tempFeeSoAddr.setWoAction(rs.getString("WO_ACTION"));               res.add(tempFeeSoAddr);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE TEMP_FEE_SO_ADDR SET ");     try {if (tempFeeSoAddr.getFlagActType() == 1) {sql.append("ACT_TYPE=:actType,"); sql.setString("actType", tempFeeSoAddr.getActType()); } if (tempFeeSoAddr.getFlagAddrId() == 1) {sql.append("ADDR_ID=:addrId,");sql.setLong("addrId", tempFeeSoAddr.getAddrId()); } if (tempFeeSoAddr.getFlagAddrInfo() == 1) {sql.append("ADDR_INFO=:addrInfo,"); sql.setString("addrInfo", tempFeeSoAddr.getAddrInfo()); } if (tempFeeSoAddr.getFlagAreaId() == 1) {sql.append("AREA_ID=:areaId,");sql.setLong("areaId", tempFeeSoAddr.getAreaId()); } if (tempFeeSoAddr.getFlagAzFlag() == 1) {sql.append("AZ_FLAG=:azFlag,"); sql.setString("azFlag", tempFeeSoAddr.getAzFlag()); } if (tempFeeSoAddr.getFlagBranchId() == 1) {sql.append("BRANCH_ID=:branchId,");sql.setLong("branchId", tempFeeSoAddr.getBranchId()); } if (tempFeeSoAddr.getFlagChangedFlag() == 1) {sql.append("CHANGED_FLAG=:changedFlag,"); sql.setString("changedFlag", tempFeeSoAddr.getChangedFlag()); } if (tempFeeSoAddr.getFlagDeviceId() == 1) {sql.append("DEVICE_ID=:deviceId,");sql.setLong("deviceId", tempFeeSoAddr.getDeviceId()); } if (tempFeeSoAddr.getFlagDistrictId() == 1) {sql.append("DISTRICT_ID=:districtId,");sql.setLong("districtId", tempFeeSoAddr.getDistrictId()); } if (tempFeeSoAddr.getFlagDistrictName() == 1) {sql.append("DISTRICT_NAME=:districtName,"); sql.setString("districtName", tempFeeSoAddr.getDistrictName()); } if (tempFeeSoAddr.getFlagExchId() == 1) {sql.append("EXCH_ID=:exchId,");sql.setLong("exchId", tempFeeSoAddr.getExchId()); } if (tempFeeSoAddr.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", tempFeeSoAddr.getLocalNetId()); } if (tempFeeSoAddr.getFlagMaintAreaId() == 1) {sql.append("MAINT_AREA_ID=:maintAreaId,");sql.setLong("maintAreaId", tempFeeSoAddr.getMaintAreaId()); } if (tempFeeSoAddr.getFlagMsAreaId() == 1) {sql.append("MS_AREA_ID=:msAreaId,");sql.setLong("msAreaId", tempFeeSoAddr.getMsAreaId()); } if (tempFeeSoAddr.getFlagMsAreaName() == 1) {sql.append("MS_AREA_NAME=:msAreaName,"); sql.setString("msAreaName", tempFeeSoAddr.getMsAreaName()); } if (tempFeeSoAddr.getFlagMsStaffId() == 1) {sql.append("MS_STAFF_ID=:msStaffId,");sql.setLong("msStaffId", tempFeeSoAddr.getMsStaffId()); } if (tempFeeSoAddr.getFlagMsStaffName() == 1) {sql.append("MS_STAFF_NAME=:msStaffName,"); sql.setString("msStaffName", tempFeeSoAddr.getMsStaffName()); } if (tempFeeSoAddr.getFlagMtAreaName() == 1) {sql.append("MT_AREA_NAME=:mtAreaName,"); sql.setString("mtAreaName", tempFeeSoAddr.getMtAreaName()); } if (tempFeeSoAddr.getFlagMtStaffId() == 1) {sql.append("MT_STAFF_ID=:mtStaffId,");sql.setLong("mtStaffId", tempFeeSoAddr.getMtStaffId()); } if (tempFeeSoAddr.getFlagMtStaffName() == 1) {sql.append("MT_STAFF_NAME=:mtStaffName,"); sql.setString("mtStaffName", tempFeeSoAddr.getMtStaffName()); } if (tempFeeSoAddr.getFlagNoFlag() == 1) {sql.append("NO_FLAG=:noFlag,"); sql.setString("noFlag", tempFeeSoAddr.getNoFlag()); } if (tempFeeSoAddr.getFlagRefAccNbr() == 1) {sql.append("REF_ACC_NBR=:refAccNbr,"); sql.setString("refAccNbr", tempFeeSoAddr.getRefAccNbr()); } if (tempFeeSoAddr.getFlagServDeptId() == 1) {sql.append("SERV_DEPT_ID=:servDeptId,");sql.setLong("servDeptId", tempFeeSoAddr.getServDeptId()); } if (tempFeeSoAddr.getFlagSituated() == 1) {sql.append("SITUATED=:situated,"); sql.setString("situated", tempFeeSoAddr.getSituated()); } if (tempFeeSoAddr.getFlagSoNbr() == 1) {sql.append("SO_NBR=:soNbr,"); sql.setString("soNbr", tempFeeSoAddr.getSoNbr()); } if (tempFeeSoAddr.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", tempFeeSoAddr.getSts()); } if (tempFeeSoAddr.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", tempFeeSoAddr.getStsDate()); } if (tempFeeSoAddr.getFlagTempFeeSoAddrId() == 1) {sql.append("TEMP_FEE_SO_ADDR_ID=:tempFeeSoAddrId,");sql.setLong("tempFeeSoAddrId", tempFeeSoAddr.getTempFeeSoAddrId()); } if (tempFeeSoAddr.getFlagTwoExchFlag() == 1) {sql.append("TWO_EXCH_FLAG=:twoExchFlag,"); sql.setString("twoExchFlag", tempFeeSoAddr.getTwoExchFlag()); } if (tempFeeSoAddr.getFlagWoAction() == 1) {sql.append("WO_ACTION=:woAction,"); sql.setString("woAction", tempFeeSoAddr.getWoAction()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO TEMP_FEE_SO_ADDR(ACT_TYPE,ADDR_ID,ADDR_INFO,AREA_ID,AZ_FLAG,BRANCH_ID,CHANGED_FLAG,DEVICE_ID,DISTRICT_ID,DISTRICT_NAME,EXCH_ID,LOCAL_NET_ID,MAINT_AREA_ID,MS_AREA_ID,MS_AREA_NAME,MS_STAFF_ID,MS_STAFF_NAME,MT_AREA_NAME,MT_STAFF_ID,MT_STAFF_NAME,NO_FLAG,REF_ACC_NBR,SERV_DEPT_ID,SITUATED,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_ADDR_ID,TWO_EXCH_FLAG,WO_ACTION)");sql.append(" VALUES (:actType,:addrId,:addrInfo,:areaId,:azFlag,:branchId,:changedFlag,:deviceId,:districtId,:districtName,:exchId,:localNetId,:maintAreaId,:msAreaId,:msAreaName,:msStaffId,:msStaffName,:mtAreaName,:mtStaffId,:mtStaffName,:noFlag,:refAccNbr,:servDeptId,:situated,:soNbr,:sts,:stsDate,:tempFeeSoAddrId,:twoExchFlag,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) list.get(i);         if (tempFeeSoAddr== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }      if (StringUtil.isBlank(tempFeeSoAddr.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", tempFeeSoAddr.getActType());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAddrId())) {      sql.setNullLong("addrId");     } else {    sql.setLong("addrId", tempFeeSoAddr.getAddrId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAddrInfo())) {      sql.setNullString("addrInfo");     } else {    sql.setString("addrInfo", tempFeeSoAddr.getAddrInfo());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", tempFeeSoAddr.getAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getAzFlag())) {      sql.setNullString("azFlag");     } else {    sql.setString("azFlag", tempFeeSoAddr.getAzFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getBranchId())) {      sql.setNullLong("branchId");     } else {    sql.setLong("branchId", tempFeeSoAddr.getBranchId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getChangedFlag())) {      sql.setNullString("changedFlag");     } else {    sql.setString("changedFlag", tempFeeSoAddr.getChangedFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDeviceId())) {      sql.setNullLong("deviceId");     } else {    sql.setLong("deviceId", tempFeeSoAddr.getDeviceId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDistrictId())) {      sql.setNullLong("districtId");     } else {    sql.setLong("districtId", tempFeeSoAddr.getDistrictId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getDistrictName())) {      sql.setNullString("districtName");     } else {    sql.setString("districtName", tempFeeSoAddr.getDistrictName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getExchId())) {      sql.setNullLong("exchId");     } else {    sql.setLong("exchId", tempFeeSoAddr.getExchId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", tempFeeSoAddr.getLocalNetId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMaintAreaId())) {      sql.setNullLong("maintAreaId");     } else {    sql.setLong("maintAreaId", tempFeeSoAddr.getMaintAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaId())) {      sql.setNullLong("msAreaId");     } else {    sql.setLong("msAreaId", tempFeeSoAddr.getMsAreaId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsAreaName())) {      sql.setNullString("msAreaName");     } else {    sql.setString("msAreaName", tempFeeSoAddr.getMsAreaName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffId())) {      sql.setNullLong("msStaffId");     } else {    sql.setLong("msStaffId", tempFeeSoAddr.getMsStaffId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMsStaffName())) {      sql.setNullString("msStaffName");     } else {    sql.setString("msStaffName", tempFeeSoAddr.getMsStaffName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtAreaName())) {      sql.setNullString("mtAreaName");     } else {    sql.setString("mtAreaName", tempFeeSoAddr.getMtAreaName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffId())) {      sql.setNullLong("mtStaffId");     } else {    sql.setLong("mtStaffId", tempFeeSoAddr.getMtStaffId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getMtStaffName())) {      sql.setNullString("mtStaffName");     } else {    sql.setString("mtStaffName", tempFeeSoAddr.getMtStaffName());    }       if (StringUtil.isBlank(tempFeeSoAddr.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", tempFeeSoAddr.getNoFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getRefAccNbr())) {      sql.setNullString("refAccNbr");     } else {    sql.setString("refAccNbr", tempFeeSoAddr.getRefAccNbr());    }       if (StringUtil.isBlank(tempFeeSoAddr.getServDeptId())) {      sql.setNullLong("servDeptId");     } else {    sql.setLong("servDeptId", tempFeeSoAddr.getServDeptId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSituated())) {      sql.setNullString("situated");     } else {    sql.setString("situated", tempFeeSoAddr.getSituated());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", tempFeeSoAddr.getSoNbr());    }       if (StringUtil.isBlank(tempFeeSoAddr.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", tempFeeSoAddr.getSts());    }    if (tempFeeSoAddr.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", tempFeeSoAddr.getStsDate());    }       if (StringUtil.isBlank(tempFeeSoAddr.getTempFeeSoAddrId())) {      sql.setNullLong("tempFeeSoAddrId");     } else {    sql.setLong("tempFeeSoAddrId", tempFeeSoAddr.getTempFeeSoAddrId());    }       if (StringUtil.isBlank(tempFeeSoAddr.getTwoExchFlag())) {      sql.setNullString("twoExchFlag");     } else {    sql.setString("twoExchFlag", tempFeeSoAddr.getTwoExchFlag());    }       if (StringUtil.isBlank(tempFeeSoAddr.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", tempFeeSoAddr.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM TEMP_FEE_SO_ADDR WHERE 1=1  ");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     TempFeeSoAddrSVO tempFeeSoAddr=(TempFeeSoAddrSVO) vo;       }}
