package com.cattsoft.wm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.wm.component.dao.IWfExpFlowRegionInstSDAO;import com.cattsoft.wm.vo.WfExpFlowRegionInstSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法WfExpFlowRegionInstSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class WfExpFlowRegionInstSDAOImpl implements IWfExpFlowRegionInstSDAO{    private static Logger log = Logger.getLogger(WfExpFlowRegionInstSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;    if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO WF_EXP_FLOW_REGION_INST(EXP_FLOW_REGION_ID,PROC_INST_ID,WF_EXP_FLOW_INST_ID)");sql.append(" VALUES (:expFlowRegionId,:procInstId,:wfExpFlowInstId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {      sql.setNullLong("expFlowRegionId");     } else {    sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());    }       if (StringUtil.isBlank(wfExpFlowRegionInst.getProcInstId())) {      sql.setNullLong("procInstId");     } else {    sql.setLong("procInstId", wfExpFlowRegionInst.getProcInstId());    }       if (StringUtil.isBlank(wfExpFlowRegionInst.getWfExpFlowInstId())) {      sql.setNullLong("wfExpFlowInstId");     } else {    sql.setLong("wfExpFlowInstId", wfExpFlowRegionInst.getWfExpFlowInstId());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;    if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT EXP_FLOW_REGION_ID,PROC_INST_ID,WF_EXP_FLOW_INST_ID FROM WF_EXP_FLOW_REGION_INST WHERE 1=1  ");sql.append(" and EXP_FLOW_REGION_ID=:expFlowRegionId");sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      wfExpFlowRegionInst =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           wfExpFlowRegionInst = new WfExpFlowRegionInstSVO();           wfExpFlowRegionInst.setExpFlowRegionId(rs.getString("EXP_FLOW_REGION_ID"));           wfExpFlowRegionInst.setProcInstId(rs.getString("PROC_INST_ID"));           wfExpFlowRegionInst.setWfExpFlowInstId(rs.getString("WF_EXP_FLOW_INST_ID"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return wfExpFlowRegionInst;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT EXP_FLOW_REGION_ID,PROC_INST_ID,WF_EXP_FLOW_INST_ID FROM WF_EXP_FLOW_REGION_INST WHERE 1=1 ");     try {if (wfExpFlowRegionInst.getFlagExpFlowRegionId() == 1) {      if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {             sql.append(" and EXP_FLOW_REGION_ID is null ");          }      else{             sql.append(" and EXP_FLOW_REGION_ID=:expFlowRegionId");             sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());          }   } if (wfExpFlowRegionInst.getFlagProcInstId() == 1) {      if (StringUtil.isBlank(wfExpFlowRegionInst.getProcInstId())) {             sql.append(" and PROC_INST_ID is null ");          }      else{             sql.append(" and PROC_INST_ID=:procInstId");             sql.setLong("procInstId", wfExpFlowRegionInst.getProcInstId());          }   } if (wfExpFlowRegionInst.getFlagWfExpFlowInstId() == 1) {      if (StringUtil.isBlank(wfExpFlowRegionInst.getWfExpFlowInstId())) {             sql.append(" and WF_EXP_FLOW_INST_ID is null ");          }      else{             sql.append(" and WF_EXP_FLOW_INST_ID=:wfExpFlowInstId");             sql.setLong("wfExpFlowInstId", wfExpFlowRegionInst.getWfExpFlowInstId());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           wfExpFlowRegionInst = new WfExpFlowRegionInstSVO();           wfExpFlowRegionInst.setExpFlowRegionId(rs.getString("EXP_FLOW_REGION_ID"));           wfExpFlowRegionInst.setProcInstId(rs.getString("PROC_INST_ID"));           wfExpFlowRegionInst.setWfExpFlowInstId(rs.getString("WF_EXP_FLOW_INST_ID"));               res.add(wfExpFlowRegionInst);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;    if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE WF_EXP_FLOW_REGION_INST SET ");     try {if (wfExpFlowRegionInst.getFlagProcInstId() == 1) {sql.append("PROC_INST_ID=:procInstId,");sql.setLong("procInstId", wfExpFlowRegionInst.getProcInstId()); } if (wfExpFlowRegionInst.getFlagWfExpFlowInstId() == 1) {sql.append("WF_EXP_FLOW_INST_ID=:wfExpFlowInstId,");sql.setLong("wfExpFlowInstId", wfExpFlowRegionInst.getWfExpFlowInstId()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and EXP_FLOW_REGION_ID=:expFlowRegionId");sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO WF_EXP_FLOW_REGION_INST(EXP_FLOW_REGION_ID,PROC_INST_ID,WF_EXP_FLOW_INST_ID)");sql.append(" VALUES (:expFlowRegionId,:procInstId,:wfExpFlowInstId)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) list.get(i);         if (wfExpFlowRegionInst== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {      sql.setNullLong("expFlowRegionId");     } else {    sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());    }       if (StringUtil.isBlank(wfExpFlowRegionInst.getProcInstId())) {      sql.setNullLong("procInstId");     } else {    sql.setLong("procInstId", wfExpFlowRegionInst.getProcInstId());    }       if (StringUtil.isBlank(wfExpFlowRegionInst.getWfExpFlowInstId())) {      sql.setNullLong("wfExpFlowInstId");     } else {    sql.setLong("wfExpFlowInstId", wfExpFlowRegionInst.getWfExpFlowInstId());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;    if (StringUtil.isBlank(wfExpFlowRegionInst.getExpFlowRegionId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM WF_EXP_FLOW_REGION_INST WHERE 1=1  ");sql.append(" and EXP_FLOW_REGION_ID=:expFlowRegionId");sql.setLong("expFlowRegionId", wfExpFlowRegionInst.getExpFlowRegionId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     WfExpFlowRegionInstSVO wfExpFlowRegionInst=(WfExpFlowRegionInstSVO) vo;       }}
