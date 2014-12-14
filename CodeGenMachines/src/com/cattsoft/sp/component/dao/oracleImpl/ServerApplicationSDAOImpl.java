package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.IServerApplicationSDAO;import com.cattsoft.sp.vo.ServerApplicationSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法ServerApplicationSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class ServerApplicationSDAOImpl implements IServerApplicationSDAO{    private static Logger log = Logger.getLogger(ServerApplicationSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;    if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SERVER_APPLICATION(APPLICATION_CODE,EXEC_IN_FACT,NAME,PLAN_TO_EXEC,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE)");sql.append(" VALUES (:applicationCode,:execInFact,:name,:planToExec,:remarks,:serverApplicationId,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(serverApplication.getApplicationCode())) {      sql.setNullString("applicationCode");     } else {    sql.setString("applicationCode", serverApplication.getApplicationCode());    }       if (StringUtil.isBlank(serverApplication.getExecInFact())) {      sql.setNullLong("execInFact");     } else {    sql.setLong("execInFact", serverApplication.getExecInFact());    }       if (StringUtil.isBlank(serverApplication.getName())) {      sql.setNullString("name");     } else {    sql.setString("name", serverApplication.getName());    }       if (StringUtil.isBlank(serverApplication.getPlanToExec())) {      sql.setNullLong("planToExec");     } else {    sql.setLong("planToExec", serverApplication.getPlanToExec());    }       if (StringUtil.isBlank(serverApplication.getRemarks())) {      sql.setNullString("remarks");     } else {    sql.setString("remarks", serverApplication.getRemarks());    }       if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {      sql.setNullLong("serverApplicationId");     } else {    sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());    }       if (StringUtil.isBlank(serverApplication.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", serverApplication.getSts());    }    if (serverApplication.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", serverApplication.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;    if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT APPLICATION_CODE,EXEC_IN_FACT,NAME,PLAN_TO_EXEC,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE FROM SERVER_APPLICATION WHERE 1=1  ");sql.append(" and SERVER_APPLICATION_ID=:serverApplicationId");sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      serverApplication =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           serverApplication = new ServerApplicationSVO();           serverApplication.setApplicationCode(rs.getString("APPLICATION_CODE"));           serverApplication.setExecInFact(rs.getString("EXEC_IN_FACT"));           serverApplication.setName(rs.getString("NAME"));           serverApplication.setPlanToExec(rs.getString("PLAN_TO_EXEC"));           serverApplication.setRemarks(rs.getString("REMARKS"));           serverApplication.setServerApplicationId(rs.getString("SERVER_APPLICATION_ID"));           serverApplication.setSts(rs.getString("STS"));           serverApplication.setStsDate(rs.getTimestamp("STS_DATE"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return serverApplication;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT APPLICATION_CODE,EXEC_IN_FACT,NAME,PLAN_TO_EXEC,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE FROM SERVER_APPLICATION WHERE 1=1 ");     try {if (serverApplication.getFlagApplicationCode() == 1) {      if (StringUtil.isBlank(serverApplication.getApplicationCode())) {             sql.append(" and APPLICATION_CODE is null ");          }      else{             sql.append(" and APPLICATION_CODE=:applicationCode");             sql.setString("applicationCode", serverApplication.getApplicationCode());          }   } if (serverApplication.getFlagExecInFact() == 1) {      if (StringUtil.isBlank(serverApplication.getExecInFact())) {             sql.append(" and EXEC_IN_FACT is null ");          }      else{             sql.append(" and EXEC_IN_FACT=:execInFact");             sql.setLong("execInFact", serverApplication.getExecInFact());          }   } if (serverApplication.getFlagName() == 1) {      if (StringUtil.isBlank(serverApplication.getName())) {             sql.append(" and NAME is null ");          }      else{             sql.append(" and NAME=:name");             sql.setString("name", serverApplication.getName());          }   } if (serverApplication.getFlagPlanToExec() == 1) {      if (StringUtil.isBlank(serverApplication.getPlanToExec())) {             sql.append(" and PLAN_TO_EXEC is null ");          }      else{             sql.append(" and PLAN_TO_EXEC=:planToExec");             sql.setLong("planToExec", serverApplication.getPlanToExec());          }   } if (serverApplication.getFlagRemarks() == 1) {      if (StringUtil.isBlank(serverApplication.getRemarks())) {             sql.append(" and REMARKS is null ");          }      else{             sql.append(" and REMARKS=:remarks");             sql.setString("remarks", serverApplication.getRemarks());          }   } if (serverApplication.getFlagServerApplicationId() == 1) {      if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {             sql.append(" and SERVER_APPLICATION_ID is null ");          }      else{             sql.append(" and SERVER_APPLICATION_ID=:serverApplicationId");             sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());          }   } if (serverApplication.getFlagSts() == 1) {      if (StringUtil.isBlank(serverApplication.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", serverApplication.getSts());          }   } if (serverApplication.getFlagStsDate() == 1) {      if (serverApplication.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", serverApplication.getStsDate());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           serverApplication = new ServerApplicationSVO();           serverApplication.setApplicationCode(rs.getString("APPLICATION_CODE"));           serverApplication.setExecInFact(rs.getString("EXEC_IN_FACT"));           serverApplication.setName(rs.getString("NAME"));           serverApplication.setPlanToExec(rs.getString("PLAN_TO_EXEC"));           serverApplication.setRemarks(rs.getString("REMARKS"));           serverApplication.setServerApplicationId(rs.getString("SERVER_APPLICATION_ID"));           serverApplication.setSts(rs.getString("STS"));           serverApplication.setStsDate(rs.getTimestamp("STS_DATE"));               res.add(serverApplication);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;    if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE SERVER_APPLICATION SET ");     try {if (serverApplication.getFlagApplicationCode() == 1) {sql.append("APPLICATION_CODE=:applicationCode,"); sql.setString("applicationCode", serverApplication.getApplicationCode()); } if (serverApplication.getFlagExecInFact() == 1) {sql.append("EXEC_IN_FACT=:execInFact,");sql.setLong("execInFact", serverApplication.getExecInFact()); } if (serverApplication.getFlagName() == 1) {sql.append("NAME=:name,"); sql.setString("name", serverApplication.getName()); } if (serverApplication.getFlagPlanToExec() == 1) {sql.append("PLAN_TO_EXEC=:planToExec,");sql.setLong("planToExec", serverApplication.getPlanToExec()); } if (serverApplication.getFlagRemarks() == 1) {sql.append("REMARKS=:remarks,"); sql.setString("remarks", serverApplication.getRemarks()); } if (serverApplication.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", serverApplication.getSts()); } if (serverApplication.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", serverApplication.getStsDate()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and SERVER_APPLICATION_ID=:serverApplicationId");sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SERVER_APPLICATION(APPLICATION_CODE,EXEC_IN_FACT,NAME,PLAN_TO_EXEC,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE)");sql.append(" VALUES (:applicationCode,:execInFact,:name,:planToExec,:remarks,:serverApplicationId,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       ServerApplicationSVO serverApplication=(ServerApplicationSVO) list.get(i);         if (serverApplication== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(serverApplication.getApplicationCode())) {      sql.setNullString("applicationCode");     } else {    sql.setString("applicationCode", serverApplication.getApplicationCode());    }       if (StringUtil.isBlank(serverApplication.getExecInFact())) {      sql.setNullLong("execInFact");     } else {    sql.setLong("execInFact", serverApplication.getExecInFact());    }       if (StringUtil.isBlank(serverApplication.getName())) {      sql.setNullString("name");     } else {    sql.setString("name", serverApplication.getName());    }       if (StringUtil.isBlank(serverApplication.getPlanToExec())) {      sql.setNullLong("planToExec");     } else {    sql.setLong("planToExec", serverApplication.getPlanToExec());    }       if (StringUtil.isBlank(serverApplication.getRemarks())) {      sql.setNullString("remarks");     } else {    sql.setString("remarks", serverApplication.getRemarks());    }       if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {      sql.setNullLong("serverApplicationId");     } else {    sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());    }       if (StringUtil.isBlank(serverApplication.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", serverApplication.getSts());    }    if (serverApplication.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", serverApplication.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;    if (StringUtil.isBlank(serverApplication.getServerApplicationId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM SERVER_APPLICATION WHERE 1=1  ");sql.append(" and SERVER_APPLICATION_ID=:serverApplicationId");sql.setLong("serverApplicationId", serverApplication.getServerApplicationId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     ServerApplicationSVO serverApplication=(ServerApplicationSVO) vo;       }}
