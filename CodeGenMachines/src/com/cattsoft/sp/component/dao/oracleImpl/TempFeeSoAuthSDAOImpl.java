package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.ITempFeeSoAuthSDAO;import com.cattsoft.sp.vo.TempFeeSoAuthSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法TempFeeSoAuthSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class TempFeeSoAuthSDAOImpl implements ITempFeeSoAuthSDAO{    private static Logger log = Logger.getLogger(TempFeeSoAuthSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO TEMP_FEE_SO_AUTH(ACT_TYPE,AUTH_LEVEL,AUTH_TYPE,LOCAL_NET_ID,MAIN_FLAG,NO_FLAG,PASSWORD,SERV_INST_ID,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_AUTH_ID,USER_NAME,WO_ACTION)");sql.append(" VALUES (:actType,:authLevel,:authType,:localNetId,:mainFlag,:noFlag,:password,:servInstId,:soNbr,:sts,:stsDate,:tempFeeSoAuthId,:userName,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(tempFeeSoAuth.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", tempFeeSoAuth.getActType());    }       if (StringUtil.isBlank(tempFeeSoAuth.getAuthLevel())) {      sql.setNullString("authLevel");     } else {    sql.setString("authLevel", tempFeeSoAuth.getAuthLevel());    }       if (StringUtil.isBlank(tempFeeSoAuth.getAuthType())) {      sql.setNullString("authType");     } else {    sql.setString("authType", tempFeeSoAuth.getAuthType());    }       if (StringUtil.isBlank(tempFeeSoAuth.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", tempFeeSoAuth.getLocalNetId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getMainFlag())) {      sql.setNullString("mainFlag");     } else {    sql.setString("mainFlag", tempFeeSoAuth.getMainFlag());    }       if (StringUtil.isBlank(tempFeeSoAuth.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", tempFeeSoAuth.getNoFlag());    }       if (StringUtil.isBlank(tempFeeSoAuth.getPassword())) {      sql.setNullString("password");     } else {    sql.setString("password", tempFeeSoAuth.getPassword());    }       if (StringUtil.isBlank(tempFeeSoAuth.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", tempFeeSoAuth.getServInstId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getSoNbr())) {      sql.setNullLong("soNbr");     } else {    sql.setLong("soNbr", tempFeeSoAuth.getSoNbr());    }       if (StringUtil.isBlank(tempFeeSoAuth.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", tempFeeSoAuth.getSts());    }    if (tempFeeSoAuth.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", tempFeeSoAuth.getStsDate());    }       if (StringUtil.isBlank(tempFeeSoAuth.getTempFeeSoAuthId())) {      sql.setNullLong("tempFeeSoAuthId");     } else {    sql.setLong("tempFeeSoAuthId", tempFeeSoAuth.getTempFeeSoAuthId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getUserName())) {      sql.setNullString("userName");     } else {    sql.setString("userName", tempFeeSoAuth.getUserName());    }       if (StringUtil.isBlank(tempFeeSoAuth.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", tempFeeSoAuth.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;       Sql sql = new Sql("SELECT ACT_TYPE,AUTH_LEVEL,AUTH_TYPE,LOCAL_NET_ID,MAIN_FLAG,NO_FLAG,PASSWORD,SERV_INST_ID,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_AUTH_ID,USER_NAME,WO_ACTION FROM TEMP_FEE_SO_AUTH WHERE 1=1  ");      Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      tempFeeSoAuth =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           tempFeeSoAuth = new TempFeeSoAuthSVO();           tempFeeSoAuth.setActType(rs.getString("ACT_TYPE"));           tempFeeSoAuth.setAuthLevel(rs.getString("AUTH_LEVEL"));           tempFeeSoAuth.setAuthType(rs.getString("AUTH_TYPE"));           tempFeeSoAuth.setLocalNetId(rs.getString("LOCAL_NET_ID"));           tempFeeSoAuth.setMainFlag(rs.getString("MAIN_FLAG"));           tempFeeSoAuth.setNoFlag(rs.getString("NO_FLAG"));           tempFeeSoAuth.setPassword(rs.getString("PASSWORD"));           tempFeeSoAuth.setServInstId(rs.getString("SERV_INST_ID"));           tempFeeSoAuth.setSoNbr(rs.getString("SO_NBR"));           tempFeeSoAuth.setSts(rs.getString("STS"));           tempFeeSoAuth.setStsDate(rs.getTimestamp("STS_DATE"));           tempFeeSoAuth.setTempFeeSoAuthId(rs.getString("TEMP_FEE_SO_AUTH_ID"));           tempFeeSoAuth.setUserName(rs.getString("USER_NAME"));           tempFeeSoAuth.setWoAction(rs.getString("WO_ACTION"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return tempFeeSoAuth;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT ACT_TYPE,AUTH_LEVEL,AUTH_TYPE,LOCAL_NET_ID,MAIN_FLAG,NO_FLAG,PASSWORD,SERV_INST_ID,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_AUTH_ID,USER_NAME,WO_ACTION FROM TEMP_FEE_SO_AUTH WHERE 1=1 ");     try {if (tempFeeSoAuth.getFlagActType() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getActType())) {             sql.append(" and ACT_TYPE is null ");          }      else{             sql.append(" and ACT_TYPE=:actType");             sql.setString("actType", tempFeeSoAuth.getActType());          }   } if (tempFeeSoAuth.getFlagAuthLevel() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getAuthLevel())) {             sql.append(" and AUTH_LEVEL is null ");          }      else{             sql.append(" and AUTH_LEVEL=:authLevel");             sql.setString("authLevel", tempFeeSoAuth.getAuthLevel());          }   } if (tempFeeSoAuth.getFlagAuthType() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getAuthType())) {             sql.append(" and AUTH_TYPE is null ");          }      else{             sql.append(" and AUTH_TYPE=:authType");             sql.setString("authType", tempFeeSoAuth.getAuthType());          }   } if (tempFeeSoAuth.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", tempFeeSoAuth.getLocalNetId());          }   } if (tempFeeSoAuth.getFlagMainFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getMainFlag())) {             sql.append(" and MAIN_FLAG is null ");          }      else{             sql.append(" and MAIN_FLAG=:mainFlag");             sql.setString("mainFlag", tempFeeSoAuth.getMainFlag());          }   } if (tempFeeSoAuth.getFlagNoFlag() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getNoFlag())) {             sql.append(" and NO_FLAG is null ");          }      else{             sql.append(" and NO_FLAG=:noFlag");             sql.setString("noFlag", tempFeeSoAuth.getNoFlag());          }   } if (tempFeeSoAuth.getFlagPassword() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getPassword())) {             sql.append(" and PASSWORD is null ");          }      else{             sql.append(" and PASSWORD=:password");             sql.setString("password", tempFeeSoAuth.getPassword());          }   } if (tempFeeSoAuth.getFlagServInstId() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getServInstId())) {             sql.append(" and SERV_INST_ID is null ");          }      else{             sql.append(" and SERV_INST_ID=:servInstId");             sql.setLong("servInstId", tempFeeSoAuth.getServInstId());          }   } if (tempFeeSoAuth.getFlagSoNbr() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getSoNbr())) {             sql.append(" and SO_NBR is null ");          }      else{             sql.append(" and SO_NBR=:soNbr");             sql.setLong("soNbr", tempFeeSoAuth.getSoNbr());          }   } if (tempFeeSoAuth.getFlagSts() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", tempFeeSoAuth.getSts());          }   } if (tempFeeSoAuth.getFlagStsDate() == 1) {      if (tempFeeSoAuth.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", tempFeeSoAuth.getStsDate());          }   } if (tempFeeSoAuth.getFlagTempFeeSoAuthId() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getTempFeeSoAuthId())) {             sql.append(" and TEMP_FEE_SO_AUTH_ID is null ");          }      else{             sql.append(" and TEMP_FEE_SO_AUTH_ID=:tempFeeSoAuthId");             sql.setLong("tempFeeSoAuthId", tempFeeSoAuth.getTempFeeSoAuthId());          }   } if (tempFeeSoAuth.getFlagUserName() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getUserName())) {             sql.append(" and USER_NAME is null ");          }      else{             sql.append(" and USER_NAME=:userName");             sql.setString("userName", tempFeeSoAuth.getUserName());          }   } if (tempFeeSoAuth.getFlagWoAction() == 1) {      if (StringUtil.isBlank(tempFeeSoAuth.getWoAction())) {             sql.append(" and WO_ACTION is null ");          }      else{             sql.append(" and WO_ACTION=:woAction");             sql.setString("woAction", tempFeeSoAuth.getWoAction());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           tempFeeSoAuth = new TempFeeSoAuthSVO();           tempFeeSoAuth.setActType(rs.getString("ACT_TYPE"));           tempFeeSoAuth.setAuthLevel(rs.getString("AUTH_LEVEL"));           tempFeeSoAuth.setAuthType(rs.getString("AUTH_TYPE"));           tempFeeSoAuth.setLocalNetId(rs.getString("LOCAL_NET_ID"));           tempFeeSoAuth.setMainFlag(rs.getString("MAIN_FLAG"));           tempFeeSoAuth.setNoFlag(rs.getString("NO_FLAG"));           tempFeeSoAuth.setPassword(rs.getString("PASSWORD"));           tempFeeSoAuth.setServInstId(rs.getString("SERV_INST_ID"));           tempFeeSoAuth.setSoNbr(rs.getString("SO_NBR"));           tempFeeSoAuth.setSts(rs.getString("STS"));           tempFeeSoAuth.setStsDate(rs.getTimestamp("STS_DATE"));           tempFeeSoAuth.setTempFeeSoAuthId(rs.getString("TEMP_FEE_SO_AUTH_ID"));           tempFeeSoAuth.setUserName(rs.getString("USER_NAME"));           tempFeeSoAuth.setWoAction(rs.getString("WO_ACTION"));               res.add(tempFeeSoAuth);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE TEMP_FEE_SO_AUTH SET ");     try {if (tempFeeSoAuth.getFlagActType() == 1) {sql.append("ACT_TYPE=:actType,"); sql.setString("actType", tempFeeSoAuth.getActType()); } if (tempFeeSoAuth.getFlagAuthLevel() == 1) {sql.append("AUTH_LEVEL=:authLevel,"); sql.setString("authLevel", tempFeeSoAuth.getAuthLevel()); } if (tempFeeSoAuth.getFlagAuthType() == 1) {sql.append("AUTH_TYPE=:authType,"); sql.setString("authType", tempFeeSoAuth.getAuthType()); } if (tempFeeSoAuth.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", tempFeeSoAuth.getLocalNetId()); } if (tempFeeSoAuth.getFlagMainFlag() == 1) {sql.append("MAIN_FLAG=:mainFlag,"); sql.setString("mainFlag", tempFeeSoAuth.getMainFlag()); } if (tempFeeSoAuth.getFlagNoFlag() == 1) {sql.append("NO_FLAG=:noFlag,"); sql.setString("noFlag", tempFeeSoAuth.getNoFlag()); } if (tempFeeSoAuth.getFlagPassword() == 1) {sql.append("PASSWORD=:password,"); sql.setString("password", tempFeeSoAuth.getPassword()); } if (tempFeeSoAuth.getFlagServInstId() == 1) {sql.append("SERV_INST_ID=:servInstId,");sql.setLong("servInstId", tempFeeSoAuth.getServInstId()); } if (tempFeeSoAuth.getFlagSoNbr() == 1) {sql.append("SO_NBR=:soNbr,");sql.setLong("soNbr", tempFeeSoAuth.getSoNbr()); } if (tempFeeSoAuth.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", tempFeeSoAuth.getSts()); } if (tempFeeSoAuth.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", tempFeeSoAuth.getStsDate()); } if (tempFeeSoAuth.getFlagTempFeeSoAuthId() == 1) {sql.append("TEMP_FEE_SO_AUTH_ID=:tempFeeSoAuthId,");sql.setLong("tempFeeSoAuthId", tempFeeSoAuth.getTempFeeSoAuthId()); } if (tempFeeSoAuth.getFlagUserName() == 1) {sql.append("USER_NAME=:userName,"); sql.setString("userName", tempFeeSoAuth.getUserName()); } if (tempFeeSoAuth.getFlagWoAction() == 1) {sql.append("WO_ACTION=:woAction,"); sql.setString("woAction", tempFeeSoAuth.getWoAction()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO TEMP_FEE_SO_AUTH(ACT_TYPE,AUTH_LEVEL,AUTH_TYPE,LOCAL_NET_ID,MAIN_FLAG,NO_FLAG,PASSWORD,SERV_INST_ID,SO_NBR,STS,STS_DATE,TEMP_FEE_SO_AUTH_ID,USER_NAME,WO_ACTION)");sql.append(" VALUES (:actType,:authLevel,:authType,:localNetId,:mainFlag,:noFlag,:password,:servInstId,:soNbr,:sts,:stsDate,:tempFeeSoAuthId,:userName,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) list.get(i);         if (tempFeeSoAuth== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }      if (StringUtil.isBlank(tempFeeSoAuth.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", tempFeeSoAuth.getActType());    }       if (StringUtil.isBlank(tempFeeSoAuth.getAuthLevel())) {      sql.setNullString("authLevel");     } else {    sql.setString("authLevel", tempFeeSoAuth.getAuthLevel());    }       if (StringUtil.isBlank(tempFeeSoAuth.getAuthType())) {      sql.setNullString("authType");     } else {    sql.setString("authType", tempFeeSoAuth.getAuthType());    }       if (StringUtil.isBlank(tempFeeSoAuth.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", tempFeeSoAuth.getLocalNetId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getMainFlag())) {      sql.setNullString("mainFlag");     } else {    sql.setString("mainFlag", tempFeeSoAuth.getMainFlag());    }       if (StringUtil.isBlank(tempFeeSoAuth.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", tempFeeSoAuth.getNoFlag());    }       if (StringUtil.isBlank(tempFeeSoAuth.getPassword())) {      sql.setNullString("password");     } else {    sql.setString("password", tempFeeSoAuth.getPassword());    }       if (StringUtil.isBlank(tempFeeSoAuth.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", tempFeeSoAuth.getServInstId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getSoNbr())) {      sql.setNullLong("soNbr");     } else {    sql.setLong("soNbr", tempFeeSoAuth.getSoNbr());    }       if (StringUtil.isBlank(tempFeeSoAuth.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", tempFeeSoAuth.getSts());    }    if (tempFeeSoAuth.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", tempFeeSoAuth.getStsDate());    }       if (StringUtil.isBlank(tempFeeSoAuth.getTempFeeSoAuthId())) {      sql.setNullLong("tempFeeSoAuthId");     } else {    sql.setLong("tempFeeSoAuthId", tempFeeSoAuth.getTempFeeSoAuthId());    }       if (StringUtil.isBlank(tempFeeSoAuth.getUserName())) {      sql.setNullString("userName");     } else {    sql.setString("userName", tempFeeSoAuth.getUserName());    }       if (StringUtil.isBlank(tempFeeSoAuth.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", tempFeeSoAuth.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM TEMP_FEE_SO_AUTH WHERE 1=1  ");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     TempFeeSoAuthSVO tempFeeSoAuth=(TempFeeSoAuthSVO) vo;       }}
