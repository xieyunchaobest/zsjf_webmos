package com.cattsoft.wm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.wm.component.dao.ITMsEventPoolHisSDAO;import com.cattsoft.wm.vo.TMsEventPoolHisSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法TMsEventPoolHisSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class TMsEventPoolHisSDAOImpl implements ITMsEventPoolHisSDAO{    private static Logger log = Logger.getLogger(TMsEventPoolHisSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;    if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO T_MS_EVENT_POOL_HIS(EVENT_PARAM,EVENT_STR,EVENT_TIME,EXCEPT_REASON,EXCEPT_TIMES,EXECUTABLE_TIME,EXECUTED_TIME,EXECUTE_STATE,MS_EVENT_ID,OBJ_ID,OBJ_STATUS,OBJ_TYPE,PROC_INST_ID,REALTIME_FLAG,SUBAREA_NO)");sql.append(" VALUES (:eventParam,:eventStr,:eventTime,:exceptReason,:exceptTimes,:executableTime,:executedTime,:executeState,:msEventId,:objId,:objStatus,:objType,:procInstId,:realtimeFlag,:subareaNo)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(tMsEventPoolHis.getEventParam())) {      sql.setNullString("eventParam");     } else {    sql.setString("eventParam", tMsEventPoolHis.getEventParam());    }       if (StringUtil.isBlank(tMsEventPoolHis.getEventStr())) {      sql.setNullString("eventStr");     } else {    sql.setString("eventStr", tMsEventPoolHis.getEventStr());    }    if (tMsEventPoolHis.getEventTime() == null) {      sql.setNullDate("eventTime");     } else {    sql.setTimestamp("eventTime", tMsEventPoolHis.getEventTime());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExceptReason())) {      sql.setNullString("exceptReason");     } else {    sql.setString("exceptReason", tMsEventPoolHis.getExceptReason());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExceptTimes())) {      sql.setNullLong("exceptTimes");     } else {    sql.setLong("exceptTimes", tMsEventPoolHis.getExceptTimes());    }    if (tMsEventPoolHis.getExecutableTime() == null) {      sql.setNullDate("executableTime");     } else {    sql.setTimestamp("executableTime", tMsEventPoolHis.getExecutableTime());    }    if (tMsEventPoolHis.getExecutedTime() == null) {      sql.setNullDate("executedTime");     } else {    sql.setTimestamp("executedTime", tMsEventPoolHis.getExecutedTime());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExecuteState())) {      sql.setNullLong("executeState");     } else {    sql.setLong("executeState", tMsEventPoolHis.getExecuteState());    }       if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {      sql.setNullLong("msEventId");     } else {    sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjId())) {      sql.setNullLong("objId");     } else {    sql.setLong("objId", tMsEventPoolHis.getObjId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjStatus())) {      sql.setNullString("objStatus");     } else {    sql.setString("objStatus", tMsEventPoolHis.getObjStatus());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjType())) {      sql.setNullString("objType");     } else {    sql.setString("objType", tMsEventPoolHis.getObjType());    }       if (StringUtil.isBlank(tMsEventPoolHis.getProcInstId())) {      sql.setNullLong("procInstId");     } else {    sql.setLong("procInstId", tMsEventPoolHis.getProcInstId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getRealtimeFlag())) {      sql.setNullString("realtimeFlag");     } else {    sql.setString("realtimeFlag", tMsEventPoolHis.getRealtimeFlag());    }       if (StringUtil.isBlank(tMsEventPoolHis.getSubareaNo())) {      sql.setNullLong("subareaNo");     } else {    sql.setLong("subareaNo", tMsEventPoolHis.getSubareaNo());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;    if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT EVENT_PARAM,EVENT_STR,EVENT_TIME,EXCEPT_REASON,EXCEPT_TIMES,EXECUTABLE_TIME,EXECUTED_TIME,EXECUTE_STATE,MS_EVENT_ID,OBJ_ID,OBJ_STATUS,OBJ_TYPE,PROC_INST_ID,REALTIME_FLAG,SUBAREA_NO FROM T_MS_EVENT_POOL_HIS WHERE 1=1  ");sql.append(" and MS_EVENT_ID=:msEventId");sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      tMsEventPoolHis =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           tMsEventPoolHis = new TMsEventPoolHisSVO();           tMsEventPoolHis.setEventParam(rs.getString("EVENT_PARAM"));           tMsEventPoolHis.setEventStr(rs.getString("EVENT_STR"));           tMsEventPoolHis.setEventTime(rs.getTimestamp("EVENT_TIME"));           tMsEventPoolHis.setExceptReason(rs.getString("EXCEPT_REASON"));           tMsEventPoolHis.setExceptTimes(rs.getString("EXCEPT_TIMES"));           tMsEventPoolHis.setExecutableTime(rs.getTimestamp("EXECUTABLE_TIME"));           tMsEventPoolHis.setExecutedTime(rs.getTimestamp("EXECUTED_TIME"));           tMsEventPoolHis.setExecuteState(rs.getString("EXECUTE_STATE"));           tMsEventPoolHis.setMsEventId(rs.getString("MS_EVENT_ID"));           tMsEventPoolHis.setObjId(rs.getString("OBJ_ID"));           tMsEventPoolHis.setObjStatus(rs.getString("OBJ_STATUS"));           tMsEventPoolHis.setObjType(rs.getString("OBJ_TYPE"));           tMsEventPoolHis.setProcInstId(rs.getString("PROC_INST_ID"));           tMsEventPoolHis.setRealtimeFlag(rs.getString("REALTIME_FLAG"));           tMsEventPoolHis.setSubareaNo(rs.getString("SUBAREA_NO"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return tMsEventPoolHis;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT EVENT_PARAM,EVENT_STR,EVENT_TIME,EXCEPT_REASON,EXCEPT_TIMES,EXECUTABLE_TIME,EXECUTED_TIME,EXECUTE_STATE,MS_EVENT_ID,OBJ_ID,OBJ_STATUS,OBJ_TYPE,PROC_INST_ID,REALTIME_FLAG,SUBAREA_NO FROM T_MS_EVENT_POOL_HIS WHERE 1=1 ");     try {if (tMsEventPoolHis.getFlagEventParam() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getEventParam())) {             sql.append(" and EVENT_PARAM is null ");          }      else{             sql.append(" and EVENT_PARAM=:eventParam");             sql.setString("eventParam", tMsEventPoolHis.getEventParam());          }   } if (tMsEventPoolHis.getFlagEventStr() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getEventStr())) {             sql.append(" and EVENT_STR is null ");          }      else{             sql.append(" and EVENT_STR=:eventStr");             sql.setString("eventStr", tMsEventPoolHis.getEventStr());          }   } if (tMsEventPoolHis.getFlagEventTime() == 1) {      if (tMsEventPoolHis.getEventTime() == null) {             sql.append(" and EVENT_TIME is null ");          }      else{             sql.append(" and EVENT_TIME=:eventTime");             sql.setTimestamp("eventTime", tMsEventPoolHis.getEventTime());          }   } if (tMsEventPoolHis.getFlagExceptReason() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getExceptReason())) {             sql.append(" and EXCEPT_REASON is null ");          }      else{             sql.append(" and EXCEPT_REASON=:exceptReason");             sql.setString("exceptReason", tMsEventPoolHis.getExceptReason());          }   } if (tMsEventPoolHis.getFlagExceptTimes() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getExceptTimes())) {             sql.append(" and EXCEPT_TIMES is null ");          }      else{             sql.append(" and EXCEPT_TIMES=:exceptTimes");             sql.setLong("exceptTimes", tMsEventPoolHis.getExceptTimes());          }   } if (tMsEventPoolHis.getFlagExecutableTime() == 1) {      if (tMsEventPoolHis.getExecutableTime() == null) {             sql.append(" and EXECUTABLE_TIME is null ");          }      else{             sql.append(" and EXECUTABLE_TIME=:executableTime");             sql.setTimestamp("executableTime", tMsEventPoolHis.getExecutableTime());          }   } if (tMsEventPoolHis.getFlagExecutedTime() == 1) {      if (tMsEventPoolHis.getExecutedTime() == null) {             sql.append(" and EXECUTED_TIME is null ");          }      else{             sql.append(" and EXECUTED_TIME=:executedTime");             sql.setTimestamp("executedTime", tMsEventPoolHis.getExecutedTime());          }   } if (tMsEventPoolHis.getFlagExecuteState() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getExecuteState())) {             sql.append(" and EXECUTE_STATE is null ");          }      else{             sql.append(" and EXECUTE_STATE=:executeState");             sql.setLong("executeState", tMsEventPoolHis.getExecuteState());          }   } if (tMsEventPoolHis.getFlagMsEventId() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {             sql.append(" and MS_EVENT_ID is null ");          }      else{             sql.append(" and MS_EVENT_ID=:msEventId");             sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());          }   } if (tMsEventPoolHis.getFlagObjId() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getObjId())) {             sql.append(" and OBJ_ID is null ");          }      else{             sql.append(" and OBJ_ID=:objId");             sql.setLong("objId", tMsEventPoolHis.getObjId());          }   } if (tMsEventPoolHis.getFlagObjStatus() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getObjStatus())) {             sql.append(" and OBJ_STATUS is null ");          }      else{             sql.append(" and OBJ_STATUS=:objStatus");             sql.setString("objStatus", tMsEventPoolHis.getObjStatus());          }   } if (tMsEventPoolHis.getFlagObjType() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getObjType())) {             sql.append(" and OBJ_TYPE is null ");          }      else{             sql.append(" and OBJ_TYPE=:objType");             sql.setString("objType", tMsEventPoolHis.getObjType());          }   } if (tMsEventPoolHis.getFlagProcInstId() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getProcInstId())) {             sql.append(" and PROC_INST_ID is null ");          }      else{             sql.append(" and PROC_INST_ID=:procInstId");             sql.setLong("procInstId", tMsEventPoolHis.getProcInstId());          }   } if (tMsEventPoolHis.getFlagRealtimeFlag() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getRealtimeFlag())) {             sql.append(" and REALTIME_FLAG is null ");          }      else{             sql.append(" and REALTIME_FLAG=:realtimeFlag");             sql.setString("realtimeFlag", tMsEventPoolHis.getRealtimeFlag());          }   } if (tMsEventPoolHis.getFlagSubareaNo() == 1) {      if (StringUtil.isBlank(tMsEventPoolHis.getSubareaNo())) {             sql.append(" and SUBAREA_NO is null ");          }      else{             sql.append(" and SUBAREA_NO=:subareaNo");             sql.setLong("subareaNo", tMsEventPoolHis.getSubareaNo());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           tMsEventPoolHis = new TMsEventPoolHisSVO();           tMsEventPoolHis.setEventParam(rs.getString("EVENT_PARAM"));           tMsEventPoolHis.setEventStr(rs.getString("EVENT_STR"));           tMsEventPoolHis.setEventTime(rs.getTimestamp("EVENT_TIME"));           tMsEventPoolHis.setExceptReason(rs.getString("EXCEPT_REASON"));           tMsEventPoolHis.setExceptTimes(rs.getString("EXCEPT_TIMES"));           tMsEventPoolHis.setExecutableTime(rs.getTimestamp("EXECUTABLE_TIME"));           tMsEventPoolHis.setExecutedTime(rs.getTimestamp("EXECUTED_TIME"));           tMsEventPoolHis.setExecuteState(rs.getString("EXECUTE_STATE"));           tMsEventPoolHis.setMsEventId(rs.getString("MS_EVENT_ID"));           tMsEventPoolHis.setObjId(rs.getString("OBJ_ID"));           tMsEventPoolHis.setObjStatus(rs.getString("OBJ_STATUS"));           tMsEventPoolHis.setObjType(rs.getString("OBJ_TYPE"));           tMsEventPoolHis.setProcInstId(rs.getString("PROC_INST_ID"));           tMsEventPoolHis.setRealtimeFlag(rs.getString("REALTIME_FLAG"));           tMsEventPoolHis.setSubareaNo(rs.getString("SUBAREA_NO"));               res.add(tMsEventPoolHis);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;    if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE T_MS_EVENT_POOL_HIS SET ");     try {if (tMsEventPoolHis.getFlagEventParam() == 1) {sql.append("EVENT_PARAM=:eventParam,"); sql.setString("eventParam", tMsEventPoolHis.getEventParam()); } if (tMsEventPoolHis.getFlagEventStr() == 1) {sql.append("EVENT_STR=:eventStr,"); sql.setString("eventStr", tMsEventPoolHis.getEventStr()); } if (tMsEventPoolHis.getFlagEventTime() == 1) {sql.append("EVENT_TIME=:eventTime,"); sql.setTimestamp("eventTime", tMsEventPoolHis.getEventTime()); } if (tMsEventPoolHis.getFlagExceptReason() == 1) {sql.append("EXCEPT_REASON=:exceptReason,"); sql.setString("exceptReason", tMsEventPoolHis.getExceptReason()); } if (tMsEventPoolHis.getFlagExceptTimes() == 1) {sql.append("EXCEPT_TIMES=:exceptTimes,");sql.setLong("exceptTimes", tMsEventPoolHis.getExceptTimes()); } if (tMsEventPoolHis.getFlagExecutableTime() == 1) {sql.append("EXECUTABLE_TIME=:executableTime,"); sql.setTimestamp("executableTime", tMsEventPoolHis.getExecutableTime()); } if (tMsEventPoolHis.getFlagExecutedTime() == 1) {sql.append("EXECUTED_TIME=:executedTime,"); sql.setTimestamp("executedTime", tMsEventPoolHis.getExecutedTime()); } if (tMsEventPoolHis.getFlagExecuteState() == 1) {sql.append("EXECUTE_STATE=:executeState,");sql.setLong("executeState", tMsEventPoolHis.getExecuteState()); } if (tMsEventPoolHis.getFlagObjId() == 1) {sql.append("OBJ_ID=:objId,");sql.setLong("objId", tMsEventPoolHis.getObjId()); } if (tMsEventPoolHis.getFlagObjStatus() == 1) {sql.append("OBJ_STATUS=:objStatus,"); sql.setString("objStatus", tMsEventPoolHis.getObjStatus()); } if (tMsEventPoolHis.getFlagObjType() == 1) {sql.append("OBJ_TYPE=:objType,"); sql.setString("objType", tMsEventPoolHis.getObjType()); } if (tMsEventPoolHis.getFlagProcInstId() == 1) {sql.append("PROC_INST_ID=:procInstId,");sql.setLong("procInstId", tMsEventPoolHis.getProcInstId()); } if (tMsEventPoolHis.getFlagRealtimeFlag() == 1) {sql.append("REALTIME_FLAG=:realtimeFlag,"); sql.setString("realtimeFlag", tMsEventPoolHis.getRealtimeFlag()); } if (tMsEventPoolHis.getFlagSubareaNo() == 1) {sql.append("SUBAREA_NO=:subareaNo,");sql.setLong("subareaNo", tMsEventPoolHis.getSubareaNo()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and MS_EVENT_ID=:msEventId");sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO T_MS_EVENT_POOL_HIS(EVENT_PARAM,EVENT_STR,EVENT_TIME,EXCEPT_REASON,EXCEPT_TIMES,EXECUTABLE_TIME,EXECUTED_TIME,EXECUTE_STATE,MS_EVENT_ID,OBJ_ID,OBJ_STATUS,OBJ_TYPE,PROC_INST_ID,REALTIME_FLAG,SUBAREA_NO)");sql.append(" VALUES (:eventParam,:eventStr,:eventTime,:exceptReason,:exceptTimes,:executableTime,:executedTime,:executeState,:msEventId,:objId,:objStatus,:objType,:procInstId,:realtimeFlag,:subareaNo)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) list.get(i);         if (tMsEventPoolHis== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(tMsEventPoolHis.getEventParam())) {      sql.setNullString("eventParam");     } else {    sql.setString("eventParam", tMsEventPoolHis.getEventParam());    }       if (StringUtil.isBlank(tMsEventPoolHis.getEventStr())) {      sql.setNullString("eventStr");     } else {    sql.setString("eventStr", tMsEventPoolHis.getEventStr());    }    if (tMsEventPoolHis.getEventTime() == null) {      sql.setNullDate("eventTime");     } else {    sql.setTimestamp("eventTime", tMsEventPoolHis.getEventTime());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExceptReason())) {      sql.setNullString("exceptReason");     } else {    sql.setString("exceptReason", tMsEventPoolHis.getExceptReason());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExceptTimes())) {      sql.setNullLong("exceptTimes");     } else {    sql.setLong("exceptTimes", tMsEventPoolHis.getExceptTimes());    }    if (tMsEventPoolHis.getExecutableTime() == null) {      sql.setNullDate("executableTime");     } else {    sql.setTimestamp("executableTime", tMsEventPoolHis.getExecutableTime());    }    if (tMsEventPoolHis.getExecutedTime() == null) {      sql.setNullDate("executedTime");     } else {    sql.setTimestamp("executedTime", tMsEventPoolHis.getExecutedTime());    }       if (StringUtil.isBlank(tMsEventPoolHis.getExecuteState())) {      sql.setNullLong("executeState");     } else {    sql.setLong("executeState", tMsEventPoolHis.getExecuteState());    }       if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {      sql.setNullLong("msEventId");     } else {    sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjId())) {      sql.setNullLong("objId");     } else {    sql.setLong("objId", tMsEventPoolHis.getObjId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjStatus())) {      sql.setNullString("objStatus");     } else {    sql.setString("objStatus", tMsEventPoolHis.getObjStatus());    }       if (StringUtil.isBlank(tMsEventPoolHis.getObjType())) {      sql.setNullString("objType");     } else {    sql.setString("objType", tMsEventPoolHis.getObjType());    }       if (StringUtil.isBlank(tMsEventPoolHis.getProcInstId())) {      sql.setNullLong("procInstId");     } else {    sql.setLong("procInstId", tMsEventPoolHis.getProcInstId());    }       if (StringUtil.isBlank(tMsEventPoolHis.getRealtimeFlag())) {      sql.setNullString("realtimeFlag");     } else {    sql.setString("realtimeFlag", tMsEventPoolHis.getRealtimeFlag());    }       if (StringUtil.isBlank(tMsEventPoolHis.getSubareaNo())) {      sql.setNullLong("subareaNo");     } else {    sql.setLong("subareaNo", tMsEventPoolHis.getSubareaNo());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;    if (StringUtil.isBlank(tMsEventPoolHis.getMsEventId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM T_MS_EVENT_POOL_HIS WHERE 1=1  ");sql.append(" and MS_EVENT_ID=:msEventId");sql.setLong("msEventId", tMsEventPoolHis.getMsEventId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     TMsEventPoolHisSVO tMsEventPoolHis=(TMsEventPoolHisSVO) vo;       }}
