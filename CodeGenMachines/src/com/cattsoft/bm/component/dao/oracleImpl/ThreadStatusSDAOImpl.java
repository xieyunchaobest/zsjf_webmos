package com.cattsoft.bm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.bm.component.dao.IThreadStatusSDAO;import com.cattsoft.bm.vo.ThreadStatusSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法ThreadStatusSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class ThreadStatusSDAOImpl implements IThreadStatusSDAO{    private static Logger log = Logger.getLogger(ThreadStatusSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;    if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO THREAD_STATUS(PROCESS_NO,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE,THREAD_NO,THREAD_STATUS_ID,THROUGHPUT_CYCLE,THROUGHPUT_TOTAL)");sql.append(" VALUES (:processNo,:remarks,:serverApplicationId,:sts,:stsDate,:threadNo,:threadStatusId,:throughputCycle,:throughputTotal)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(threadStatus.getProcessNo())) {      sql.setNullString("processNo");     } else {    sql.setString("processNo", threadStatus.getProcessNo());    }       if (StringUtil.isBlank(threadStatus.getRemarks())) {      sql.setNullString("remarks");     } else {    sql.setString("remarks", threadStatus.getRemarks());    }       if (StringUtil.isBlank(threadStatus.getServerApplicationId())) {      sql.setNullLong("serverApplicationId");     } else {    sql.setLong("serverApplicationId", threadStatus.getServerApplicationId());    }       if (StringUtil.isBlank(threadStatus.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", threadStatus.getSts());    }    if (threadStatus.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", threadStatus.getStsDate());    }       if (StringUtil.isBlank(threadStatus.getThreadNo())) {      sql.setNullLong("threadNo");     } else {    sql.setLong("threadNo", threadStatus.getThreadNo());    }       if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {      sql.setNullLong("threadStatusId");     } else {    sql.setLong("threadStatusId", threadStatus.getThreadStatusId());    }       if (StringUtil.isBlank(threadStatus.getThroughputCycle())) {      sql.setNullLong("throughputCycle");     } else {    sql.setLong("throughputCycle", threadStatus.getThroughputCycle());    }       if (StringUtil.isBlank(threadStatus.getThroughputTotal())) {      sql.setNullLong("throughputTotal");     } else {    sql.setLong("throughputTotal", threadStatus.getThroughputTotal());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;    if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT PROCESS_NO,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE,THREAD_NO,THREAD_STATUS_ID,THROUGHPUT_CYCLE,THROUGHPUT_TOTAL FROM THREAD_STATUS WHERE 1=1  ");sql.append(" and THREAD_STATUS_ID=:threadStatusId");sql.setLong("threadStatusId", threadStatus.getThreadStatusId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      threadStatus =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           threadStatus = new ThreadStatusSVO();           threadStatus.setProcessNo(rs.getString("PROCESS_NO"));           threadStatus.setRemarks(rs.getString("REMARKS"));           threadStatus.setServerApplicationId(rs.getString("SERVER_APPLICATION_ID"));           threadStatus.setSts(rs.getString("STS"));           threadStatus.setStsDate(rs.getTimestamp("STS_DATE"));           threadStatus.setThreadNo(rs.getString("THREAD_NO"));           threadStatus.setThreadStatusId(rs.getString("THREAD_STATUS_ID"));           threadStatus.setThroughputCycle(rs.getString("THROUGHPUT_CYCLE"));           threadStatus.setThroughputTotal(rs.getString("THROUGHPUT_TOTAL"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return threadStatus;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT PROCESS_NO,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE,THREAD_NO,THREAD_STATUS_ID,THROUGHPUT_CYCLE,THROUGHPUT_TOTAL FROM THREAD_STATUS WHERE 1=1 ");     try {if (threadStatus.getFlagProcessNo() == 1) {      if (StringUtil.isBlank(threadStatus.getProcessNo())) {             sql.append(" and PROCESS_NO is null ");          }      else{             sql.append(" and PROCESS_NO=:processNo");             sql.setString("processNo", threadStatus.getProcessNo());          }   } if (threadStatus.getFlagRemarks() == 1) {      if (StringUtil.isBlank(threadStatus.getRemarks())) {             sql.append(" and REMARKS is null ");          }      else{             sql.append(" and REMARKS=:remarks");             sql.setString("remarks", threadStatus.getRemarks());          }   } if (threadStatus.getFlagServerApplicationId() == 1) {      if (StringUtil.isBlank(threadStatus.getServerApplicationId())) {             sql.append(" and SERVER_APPLICATION_ID is null ");          }      else{             sql.append(" and SERVER_APPLICATION_ID=:serverApplicationId");             sql.setLong("serverApplicationId", threadStatus.getServerApplicationId());          }   } if (threadStatus.getFlagSts() == 1) {      if (StringUtil.isBlank(threadStatus.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", threadStatus.getSts());          }   } if (threadStatus.getFlagStsDate() == 1) {      if (threadStatus.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", threadStatus.getStsDate());          }   } if (threadStatus.getFlagThreadNo() == 1) {      if (StringUtil.isBlank(threadStatus.getThreadNo())) {             sql.append(" and THREAD_NO is null ");          }      else{             sql.append(" and THREAD_NO=:threadNo");             sql.setLong("threadNo", threadStatus.getThreadNo());          }   } if (threadStatus.getFlagThreadStatusId() == 1) {      if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {             sql.append(" and THREAD_STATUS_ID is null ");          }      else{             sql.append(" and THREAD_STATUS_ID=:threadStatusId");             sql.setLong("threadStatusId", threadStatus.getThreadStatusId());          }   } if (threadStatus.getFlagThroughputCycle() == 1) {      if (StringUtil.isBlank(threadStatus.getThroughputCycle())) {             sql.append(" and THROUGHPUT_CYCLE is null ");          }      else{             sql.append(" and THROUGHPUT_CYCLE=:throughputCycle");             sql.setLong("throughputCycle", threadStatus.getThroughputCycle());          }   } if (threadStatus.getFlagThroughputTotal() == 1) {      if (StringUtil.isBlank(threadStatus.getThroughputTotal())) {             sql.append(" and THROUGHPUT_TOTAL is null ");          }      else{             sql.append(" and THROUGHPUT_TOTAL=:throughputTotal");             sql.setLong("throughputTotal", threadStatus.getThroughputTotal());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           threadStatus = new ThreadStatusSVO();           threadStatus.setProcessNo(rs.getString("PROCESS_NO"));           threadStatus.setRemarks(rs.getString("REMARKS"));           threadStatus.setServerApplicationId(rs.getString("SERVER_APPLICATION_ID"));           threadStatus.setSts(rs.getString("STS"));           threadStatus.setStsDate(rs.getTimestamp("STS_DATE"));           threadStatus.setThreadNo(rs.getString("THREAD_NO"));           threadStatus.setThreadStatusId(rs.getString("THREAD_STATUS_ID"));           threadStatus.setThroughputCycle(rs.getString("THROUGHPUT_CYCLE"));           threadStatus.setThroughputTotal(rs.getString("THROUGHPUT_TOTAL"));               res.add(threadStatus);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;    if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE THREAD_STATUS SET ");     try {if (threadStatus.getFlagProcessNo() == 1) {sql.append("PROCESS_NO=:processNo,"); sql.setString("processNo", threadStatus.getProcessNo()); } if (threadStatus.getFlagRemarks() == 1) {sql.append("REMARKS=:remarks,"); sql.setString("remarks", threadStatus.getRemarks()); } if (threadStatus.getFlagServerApplicationId() == 1) {sql.append("SERVER_APPLICATION_ID=:serverApplicationId,");sql.setLong("serverApplicationId", threadStatus.getServerApplicationId()); } if (threadStatus.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", threadStatus.getSts()); } if (threadStatus.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", threadStatus.getStsDate()); } if (threadStatus.getFlagThreadNo() == 1) {sql.append("THREAD_NO=:threadNo,");sql.setLong("threadNo", threadStatus.getThreadNo()); } if (threadStatus.getFlagThroughputCycle() == 1) {sql.append("THROUGHPUT_CYCLE=:throughputCycle,");sql.setLong("throughputCycle", threadStatus.getThroughputCycle()); } if (threadStatus.getFlagThroughputTotal() == 1) {sql.append("THROUGHPUT_TOTAL=:throughputTotal,");sql.setLong("throughputTotal", threadStatus.getThroughputTotal()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and THREAD_STATUS_ID=:threadStatusId");sql.setLong("threadStatusId", threadStatus.getThreadStatusId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO THREAD_STATUS(PROCESS_NO,REMARKS,SERVER_APPLICATION_ID,STS,STS_DATE,THREAD_NO,THREAD_STATUS_ID,THROUGHPUT_CYCLE,THROUGHPUT_TOTAL)");sql.append(" VALUES (:processNo,:remarks,:serverApplicationId,:sts,:stsDate,:threadNo,:threadStatusId,:throughputCycle,:throughputTotal)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       ThreadStatusSVO threadStatus=(ThreadStatusSVO) list.get(i);         if (threadStatus== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(threadStatus.getProcessNo())) {      sql.setNullString("processNo");     } else {    sql.setString("processNo", threadStatus.getProcessNo());    }       if (StringUtil.isBlank(threadStatus.getRemarks())) {      sql.setNullString("remarks");     } else {    sql.setString("remarks", threadStatus.getRemarks());    }       if (StringUtil.isBlank(threadStatus.getServerApplicationId())) {      sql.setNullLong("serverApplicationId");     } else {    sql.setLong("serverApplicationId", threadStatus.getServerApplicationId());    }       if (StringUtil.isBlank(threadStatus.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", threadStatus.getSts());    }    if (threadStatus.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", threadStatus.getStsDate());    }       if (StringUtil.isBlank(threadStatus.getThreadNo())) {      sql.setNullLong("threadNo");     } else {    sql.setLong("threadNo", threadStatus.getThreadNo());    }       if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {      sql.setNullLong("threadStatusId");     } else {    sql.setLong("threadStatusId", threadStatus.getThreadStatusId());    }       if (StringUtil.isBlank(threadStatus.getThroughputCycle())) {      sql.setNullLong("throughputCycle");     } else {    sql.setLong("throughputCycle", threadStatus.getThroughputCycle());    }       if (StringUtil.isBlank(threadStatus.getThroughputTotal())) {      sql.setNullLong("throughputTotal");     } else {    sql.setLong("throughputTotal", threadStatus.getThroughputTotal());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;    if (StringUtil.isBlank(threadStatus.getThreadStatusId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM THREAD_STATUS WHERE 1=1  ");sql.append(" and THREAD_STATUS_ID=:threadStatusId");sql.setLong("threadStatusId", threadStatus.getThreadStatusId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     ThreadStatusSVO threadStatus=(ThreadStatusSVO) vo;       }}
