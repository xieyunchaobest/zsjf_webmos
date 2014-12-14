package com.cattsoft.sg.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sg.component.dao.IFaultReasonToTypeSDAO;import com.cattsoft.sg.vo.FaultReasonToTypeSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法FaultReasonToTypeSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class FaultReasonToTypeSDAOImpl implements IFaultReasonToTypeSDAO{    private static Logger log = Logger.getLogger(FaultReasonToTypeSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;    if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO FAULT_REASON_TO_TYPE(FAULT_REASON_ID,FAULT_REASON_TO_TYPE_ID,FAULT_TYPE_ID)");sql.append(" VALUES (:faultReasonId,:faultReasonToTypeId,:faultTypeId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(faultReasonToType.getFaultReasonId())) {      sql.setNullLong("faultReasonId");     } else {    sql.setLong("faultReasonId", faultReasonToType.getFaultReasonId());    }       if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {      sql.setNullLong("faultReasonToTypeId");     } else {    sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());    }       if (StringUtil.isBlank(faultReasonToType.getFaultTypeId())) {      sql.setNullLong("faultTypeId");     } else {    sql.setLong("faultTypeId", faultReasonToType.getFaultTypeId());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;    if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT FAULT_REASON_ID,FAULT_REASON_TO_TYPE_ID,FAULT_TYPE_ID FROM FAULT_REASON_TO_TYPE WHERE 1=1  ");sql.append(" and FAULT_REASON_TO_TYPE_ID=:faultReasonToTypeId");sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      faultReasonToType =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           faultReasonToType = new FaultReasonToTypeSVO();           faultReasonToType.setFaultReasonId(rs.getString("FAULT_REASON_ID"));           faultReasonToType.setFaultReasonToTypeId(rs.getString("FAULT_REASON_TO_TYPE_ID"));           faultReasonToType.setFaultTypeId(rs.getString("FAULT_TYPE_ID"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return faultReasonToType;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT FAULT_REASON_ID,FAULT_REASON_TO_TYPE_ID,FAULT_TYPE_ID FROM FAULT_REASON_TO_TYPE WHERE 1=1 ");     try {if (faultReasonToType.getFlagFaultReasonId() == 1) {      if (StringUtil.isBlank(faultReasonToType.getFaultReasonId())) {             sql.append(" and FAULT_REASON_ID is null ");          }      else{             sql.append(" and FAULT_REASON_ID=:faultReasonId");             sql.setLong("faultReasonId", faultReasonToType.getFaultReasonId());          }   } if (faultReasonToType.getFlagFaultReasonToTypeId() == 1) {      if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {             sql.append(" and FAULT_REASON_TO_TYPE_ID is null ");          }      else{             sql.append(" and FAULT_REASON_TO_TYPE_ID=:faultReasonToTypeId");             sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());          }   } if (faultReasonToType.getFlagFaultTypeId() == 1) {      if (StringUtil.isBlank(faultReasonToType.getFaultTypeId())) {             sql.append(" and FAULT_TYPE_ID is null ");          }      else{             sql.append(" and FAULT_TYPE_ID=:faultTypeId");             sql.setLong("faultTypeId", faultReasonToType.getFaultTypeId());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           faultReasonToType = new FaultReasonToTypeSVO();           faultReasonToType.setFaultReasonId(rs.getString("FAULT_REASON_ID"));           faultReasonToType.setFaultReasonToTypeId(rs.getString("FAULT_REASON_TO_TYPE_ID"));           faultReasonToType.setFaultTypeId(rs.getString("FAULT_TYPE_ID"));               res.add(faultReasonToType);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;    if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE FAULT_REASON_TO_TYPE SET ");     try {if (faultReasonToType.getFlagFaultReasonId() == 1) {sql.append("FAULT_REASON_ID=:faultReasonId,");sql.setLong("faultReasonId", faultReasonToType.getFaultReasonId()); } if (faultReasonToType.getFlagFaultTypeId() == 1) {sql.append("FAULT_TYPE_ID=:faultTypeId,");sql.setLong("faultTypeId", faultReasonToType.getFaultTypeId()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and FAULT_REASON_TO_TYPE_ID=:faultReasonToTypeId");sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO FAULT_REASON_TO_TYPE(FAULT_REASON_ID,FAULT_REASON_TO_TYPE_ID,FAULT_TYPE_ID)");sql.append(" VALUES (:faultReasonId,:faultReasonToTypeId,:faultTypeId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) list.get(i);         if (faultReasonToType== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(faultReasonToType.getFaultReasonId())) {      sql.setNullLong("faultReasonId");     } else {    sql.setLong("faultReasonId", faultReasonToType.getFaultReasonId());    }       if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {      sql.setNullLong("faultReasonToTypeId");     } else {    sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());    }       if (StringUtil.isBlank(faultReasonToType.getFaultTypeId())) {      sql.setNullLong("faultTypeId");     } else {    sql.setLong("faultTypeId", faultReasonToType.getFaultTypeId());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;    if (StringUtil.isBlank(faultReasonToType.getFaultReasonToTypeId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM FAULT_REASON_TO_TYPE WHERE 1=1  ");sql.append(" and FAULT_REASON_TO_TYPE_ID=:faultReasonToTypeId");sql.setLong("faultReasonToTypeId", faultReasonToType.getFaultReasonToTypeId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     FaultReasonToTypeSVO faultReasonToType=(FaultReasonToTypeSVO) vo;       }}
