package com.cattsoft.wm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.wm.component.dao.IWfExpFlowNodeRegionSDAO;import com.cattsoft.wm.vo.WfExpFlowNodeRegionSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法WfExpFlowNodeRegionSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class WfExpFlowNodeRegionSDAOImpl implements IWfExpFlowNodeRegionSDAO{    private static Logger log = Logger.getLogger(WfExpFlowNodeRegionSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;    if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO WF_EXP_FLOW_NODE_REGION(END_PROC_NODE_INST_ID,EXP_FLOW_NODE_REGION_ID,START_PROC_NODE_INST_ID,WF_EXP_FLOW_INST_ID)");sql.append(" VALUES (:endProcNodeInstId,:expFlowNodeRegionId,:startProcNodeInstId,:wfExpFlowInstId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(wfExpFlowNodeRegion.getEndProcNodeInstId())) {      sql.setNullLong("endProcNodeInstId");     } else {    sql.setLong("endProcNodeInstId", wfExpFlowNodeRegion.getEndProcNodeInstId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {      sql.setNullLong("expFlowNodeRegionId");     } else {    sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getStartProcNodeInstId())) {      sql.setNullLong("startProcNodeInstId");     } else {    sql.setLong("startProcNodeInstId", wfExpFlowNodeRegion.getStartProcNodeInstId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getWfExpFlowInstId())) {      sql.setNullLong("wfExpFlowInstId");     } else {    sql.setLong("wfExpFlowInstId", wfExpFlowNodeRegion.getWfExpFlowInstId());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;    if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT END_PROC_NODE_INST_ID,EXP_FLOW_NODE_REGION_ID,START_PROC_NODE_INST_ID,WF_EXP_FLOW_INST_ID FROM WF_EXP_FLOW_NODE_REGION WHERE 1=1  ");sql.append(" and EXP_FLOW_NODE_REGION_ID=:expFlowNodeRegionId");sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      wfExpFlowNodeRegion =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           wfExpFlowNodeRegion = new WfExpFlowNodeRegionSVO();           wfExpFlowNodeRegion.setEndProcNodeInstId(rs.getString("END_PROC_NODE_INST_ID"));           wfExpFlowNodeRegion.setExpFlowNodeRegionId(rs.getString("EXP_FLOW_NODE_REGION_ID"));           wfExpFlowNodeRegion.setStartProcNodeInstId(rs.getString("START_PROC_NODE_INST_ID"));           wfExpFlowNodeRegion.setWfExpFlowInstId(rs.getString("WF_EXP_FLOW_INST_ID"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return wfExpFlowNodeRegion;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT END_PROC_NODE_INST_ID,EXP_FLOW_NODE_REGION_ID,START_PROC_NODE_INST_ID,WF_EXP_FLOW_INST_ID FROM WF_EXP_FLOW_NODE_REGION WHERE 1=1 ");     try {if (wfExpFlowNodeRegion.getFlagEndProcNodeInstId() == 1) {      if (StringUtil.isBlank(wfExpFlowNodeRegion.getEndProcNodeInstId())) {             sql.append(" and END_PROC_NODE_INST_ID is null ");          }      else{             sql.append(" and END_PROC_NODE_INST_ID=:endProcNodeInstId");             sql.setLong("endProcNodeInstId", wfExpFlowNodeRegion.getEndProcNodeInstId());          }   } if (wfExpFlowNodeRegion.getFlagExpFlowNodeRegionId() == 1) {      if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {             sql.append(" and EXP_FLOW_NODE_REGION_ID is null ");          }      else{             sql.append(" and EXP_FLOW_NODE_REGION_ID=:expFlowNodeRegionId");             sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());          }   } if (wfExpFlowNodeRegion.getFlagStartProcNodeInstId() == 1) {      if (StringUtil.isBlank(wfExpFlowNodeRegion.getStartProcNodeInstId())) {             sql.append(" and START_PROC_NODE_INST_ID is null ");          }      else{             sql.append(" and START_PROC_NODE_INST_ID=:startProcNodeInstId");             sql.setLong("startProcNodeInstId", wfExpFlowNodeRegion.getStartProcNodeInstId());          }   } if (wfExpFlowNodeRegion.getFlagWfExpFlowInstId() == 1) {      if (StringUtil.isBlank(wfExpFlowNodeRegion.getWfExpFlowInstId())) {             sql.append(" and WF_EXP_FLOW_INST_ID is null ");          }      else{             sql.append(" and WF_EXP_FLOW_INST_ID=:wfExpFlowInstId");             sql.setLong("wfExpFlowInstId", wfExpFlowNodeRegion.getWfExpFlowInstId());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           wfExpFlowNodeRegion = new WfExpFlowNodeRegionSVO();           wfExpFlowNodeRegion.setEndProcNodeInstId(rs.getString("END_PROC_NODE_INST_ID"));           wfExpFlowNodeRegion.setExpFlowNodeRegionId(rs.getString("EXP_FLOW_NODE_REGION_ID"));           wfExpFlowNodeRegion.setStartProcNodeInstId(rs.getString("START_PROC_NODE_INST_ID"));           wfExpFlowNodeRegion.setWfExpFlowInstId(rs.getString("WF_EXP_FLOW_INST_ID"));               res.add(wfExpFlowNodeRegion);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;    if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE WF_EXP_FLOW_NODE_REGION SET ");     try {if (wfExpFlowNodeRegion.getFlagEndProcNodeInstId() == 1) {sql.append("END_PROC_NODE_INST_ID=:endProcNodeInstId,");sql.setLong("endProcNodeInstId", wfExpFlowNodeRegion.getEndProcNodeInstId()); } if (wfExpFlowNodeRegion.getFlagStartProcNodeInstId() == 1) {sql.append("START_PROC_NODE_INST_ID=:startProcNodeInstId,");sql.setLong("startProcNodeInstId", wfExpFlowNodeRegion.getStartProcNodeInstId()); } if (wfExpFlowNodeRegion.getFlagWfExpFlowInstId() == 1) {sql.append("WF_EXP_FLOW_INST_ID=:wfExpFlowInstId,");sql.setLong("wfExpFlowInstId", wfExpFlowNodeRegion.getWfExpFlowInstId()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and EXP_FLOW_NODE_REGION_ID=:expFlowNodeRegionId");sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO WF_EXP_FLOW_NODE_REGION(END_PROC_NODE_INST_ID,EXP_FLOW_NODE_REGION_ID,START_PROC_NODE_INST_ID,WF_EXP_FLOW_INST_ID)");sql.append(" VALUES (:endProcNodeInstId,:expFlowNodeRegionId,:startProcNodeInstId,:wfExpFlowInstId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) list.get(i);         if (wfExpFlowNodeRegion== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(wfExpFlowNodeRegion.getEndProcNodeInstId())) {      sql.setNullLong("endProcNodeInstId");     } else {    sql.setLong("endProcNodeInstId", wfExpFlowNodeRegion.getEndProcNodeInstId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {      sql.setNullLong("expFlowNodeRegionId");     } else {    sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getStartProcNodeInstId())) {      sql.setNullLong("startProcNodeInstId");     } else {    sql.setLong("startProcNodeInstId", wfExpFlowNodeRegion.getStartProcNodeInstId());    }       if (StringUtil.isBlank(wfExpFlowNodeRegion.getWfExpFlowInstId())) {      sql.setNullLong("wfExpFlowInstId");     } else {    sql.setLong("wfExpFlowInstId", wfExpFlowNodeRegion.getWfExpFlowInstId());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;    if (StringUtil.isBlank(wfExpFlowNodeRegion.getExpFlowNodeRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM WF_EXP_FLOW_NODE_REGION WHERE 1=1  ");sql.append(" and EXP_FLOW_NODE_REGION_ID=:expFlowNodeRegionId");sql.setLong("expFlowNodeRegionId", wfExpFlowNodeRegion.getExpFlowNodeRegionId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     WfExpFlowNodeRegionSVO wfExpFlowNodeRegion=(WfExpFlowNodeRegionSVO) vo;       }}
