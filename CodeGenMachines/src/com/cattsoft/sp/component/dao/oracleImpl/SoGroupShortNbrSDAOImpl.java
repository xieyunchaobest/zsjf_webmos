package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.ISoGroupShortNbrSDAO;import com.cattsoft.sp.vo.SoGroupShortNbrSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法SoGroupShortNbrSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class SoGroupShortNbrSDAOImpl implements ISoGroupShortNbrSDAO{    private static Logger log = Logger.getLogger(SoGroupShortNbrSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_GROUP_SHORT_NBR(ACT_TYPE,EFF_DATE,END_NBR,EXP_DATE,LOCAL_NET_ID,NO_FLAG,NUM,SERV_INST_ID,SHORT_NBR_ID,SO_NBR,START_NBR,STS,STS_DATE)");sql.append(" VALUES (:actType,:effDate,:endNbr,:expDate,:localNetId,:noFlag,:num,:servInstId,:shortNbrId,:soNbr,:startNbr,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(soGroupShortNbr.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", soGroupShortNbr.getActType());    }    if (soGroupShortNbr.getEffDate() == null) {      sql.setNullDate("effDate");     } else {    sql.setTimestamp("effDate", soGroupShortNbr.getEffDate());    }       if (StringUtil.isBlank(soGroupShortNbr.getEndNbr())) {      sql.setNullString("endNbr");     } else {    sql.setString("endNbr", soGroupShortNbr.getEndNbr());    }    if (soGroupShortNbr.getExpDate() == null) {      sql.setNullDate("expDate");     } else {    sql.setTimestamp("expDate", soGroupShortNbr.getExpDate());    }       if (StringUtil.isBlank(soGroupShortNbr.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soGroupShortNbr.getLocalNetId());    }       if (StringUtil.isBlank(soGroupShortNbr.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soGroupShortNbr.getNoFlag());    }       if (StringUtil.isBlank(soGroupShortNbr.getNum())) {      sql.setNullLong("num");     } else {    sql.setLong("num", soGroupShortNbr.getNum());    }       if (StringUtil.isBlank(soGroupShortNbr.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", soGroupShortNbr.getServInstId());    }       if (StringUtil.isBlank(soGroupShortNbr.getShortNbrId())) {      sql.setNullLong("shortNbrId");     } else {    sql.setLong("shortNbrId", soGroupShortNbr.getShortNbrId());    }       if (StringUtil.isBlank(soGroupShortNbr.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", soGroupShortNbr.getSoNbr());    }       if (StringUtil.isBlank(soGroupShortNbr.getStartNbr())) {      sql.setNullString("startNbr");     } else {    sql.setString("startNbr", soGroupShortNbr.getStartNbr());    }       if (StringUtil.isBlank(soGroupShortNbr.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soGroupShortNbr.getSts());    }    if (soGroupShortNbr.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soGroupShortNbr.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;       Sql sql = new Sql("SELECT ACT_TYPE,EFF_DATE,END_NBR,EXP_DATE,LOCAL_NET_ID,NO_FLAG,NUM,SERV_INST_ID,SHORT_NBR_ID,SO_NBR,START_NBR,STS,STS_DATE FROM SO_GROUP_SHORT_NBR WHERE 1=1  ");      Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      soGroupShortNbr =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           soGroupShortNbr = new SoGroupShortNbrSVO();           soGroupShortNbr.setActType(rs.getString("ACT_TYPE"));           soGroupShortNbr.setEffDate(rs.getTimestamp("EFF_DATE"));           soGroupShortNbr.setEndNbr(rs.getString("END_NBR"));           soGroupShortNbr.setExpDate(rs.getTimestamp("EXP_DATE"));           soGroupShortNbr.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soGroupShortNbr.setNoFlag(rs.getString("NO_FLAG"));           soGroupShortNbr.setNum(rs.getString("NUM"));           soGroupShortNbr.setServInstId(rs.getString("SERV_INST_ID"));           soGroupShortNbr.setShortNbrId(rs.getString("SHORT_NBR_ID"));           soGroupShortNbr.setSoNbr(rs.getString("SO_NBR"));           soGroupShortNbr.setStartNbr(rs.getString("START_NBR"));           soGroupShortNbr.setSts(rs.getString("STS"));           soGroupShortNbr.setStsDate(rs.getTimestamp("STS_DATE"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return soGroupShortNbr;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT ACT_TYPE,EFF_DATE,END_NBR,EXP_DATE,LOCAL_NET_ID,NO_FLAG,NUM,SERV_INST_ID,SHORT_NBR_ID,SO_NBR,START_NBR,STS,STS_DATE FROM SO_GROUP_SHORT_NBR WHERE 1=1 ");     try {if (soGroupShortNbr.getFlagActType() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getActType())) {             sql.append(" and ACT_TYPE is null ");          }      else{             sql.append(" and ACT_TYPE=:actType");             sql.setString("actType", soGroupShortNbr.getActType());          }   } if (soGroupShortNbr.getFlagEffDate() == 1) {      if (soGroupShortNbr.getEffDate() == null) {             sql.append(" and EFF_DATE is null ");          }      else{             sql.append(" and EFF_DATE=:effDate");             sql.setTimestamp("effDate", soGroupShortNbr.getEffDate());          }   } if (soGroupShortNbr.getFlagEndNbr() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getEndNbr())) {             sql.append(" and END_NBR is null ");          }      else{             sql.append(" and END_NBR=:endNbr");             sql.setString("endNbr", soGroupShortNbr.getEndNbr());          }   } if (soGroupShortNbr.getFlagExpDate() == 1) {      if (soGroupShortNbr.getExpDate() == null) {             sql.append(" and EXP_DATE is null ");          }      else{             sql.append(" and EXP_DATE=:expDate");             sql.setTimestamp("expDate", soGroupShortNbr.getExpDate());          }   } if (soGroupShortNbr.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", soGroupShortNbr.getLocalNetId());          }   } if (soGroupShortNbr.getFlagNoFlag() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getNoFlag())) {             sql.append(" and NO_FLAG is null ");          }      else{             sql.append(" and NO_FLAG=:noFlag");             sql.setString("noFlag", soGroupShortNbr.getNoFlag());          }   } if (soGroupShortNbr.getFlagNum() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getNum())) {             sql.append(" and NUM is null ");          }      else{             sql.append(" and NUM=:num");             sql.setLong("num", soGroupShortNbr.getNum());          }   } if (soGroupShortNbr.getFlagServInstId() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getServInstId())) {             sql.append(" and SERV_INST_ID is null ");          }      else{             sql.append(" and SERV_INST_ID=:servInstId");             sql.setLong("servInstId", soGroupShortNbr.getServInstId());          }   } if (soGroupShortNbr.getFlagShortNbrId() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getShortNbrId())) {             sql.append(" and SHORT_NBR_ID is null ");          }      else{             sql.append(" and SHORT_NBR_ID=:shortNbrId");             sql.setLong("shortNbrId", soGroupShortNbr.getShortNbrId());          }   } if (soGroupShortNbr.getFlagSoNbr() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getSoNbr())) {             sql.append(" and SO_NBR is null ");          }      else{             sql.append(" and SO_NBR=:soNbr");             sql.setString("soNbr", soGroupShortNbr.getSoNbr());          }   } if (soGroupShortNbr.getFlagStartNbr() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getStartNbr())) {             sql.append(" and START_NBR is null ");          }      else{             sql.append(" and START_NBR=:startNbr");             sql.setString("startNbr", soGroupShortNbr.getStartNbr());          }   } if (soGroupShortNbr.getFlagSts() == 1) {      if (StringUtil.isBlank(soGroupShortNbr.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", soGroupShortNbr.getSts());          }   } if (soGroupShortNbr.getFlagStsDate() == 1) {      if (soGroupShortNbr.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", soGroupShortNbr.getStsDate());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           soGroupShortNbr = new SoGroupShortNbrSVO();           soGroupShortNbr.setActType(rs.getString("ACT_TYPE"));           soGroupShortNbr.setEffDate(rs.getTimestamp("EFF_DATE"));           soGroupShortNbr.setEndNbr(rs.getString("END_NBR"));           soGroupShortNbr.setExpDate(rs.getTimestamp("EXP_DATE"));           soGroupShortNbr.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soGroupShortNbr.setNoFlag(rs.getString("NO_FLAG"));           soGroupShortNbr.setNum(rs.getString("NUM"));           soGroupShortNbr.setServInstId(rs.getString("SERV_INST_ID"));           soGroupShortNbr.setShortNbrId(rs.getString("SHORT_NBR_ID"));           soGroupShortNbr.setSoNbr(rs.getString("SO_NBR"));           soGroupShortNbr.setStartNbr(rs.getString("START_NBR"));           soGroupShortNbr.setSts(rs.getString("STS"));           soGroupShortNbr.setStsDate(rs.getTimestamp("STS_DATE"));               res.add(soGroupShortNbr);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE SO_GROUP_SHORT_NBR SET ");     try {if (soGroupShortNbr.getFlagActType() == 1) {sql.append("ACT_TYPE=:actType,"); sql.setString("actType", soGroupShortNbr.getActType()); } if (soGroupShortNbr.getFlagEffDate() == 1) {sql.append("EFF_DATE=:effDate,"); sql.setTimestamp("effDate", soGroupShortNbr.getEffDate()); } if (soGroupShortNbr.getFlagEndNbr() == 1) {sql.append("END_NBR=:endNbr,"); sql.setString("endNbr", soGroupShortNbr.getEndNbr()); } if (soGroupShortNbr.getFlagExpDate() == 1) {sql.append("EXP_DATE=:expDate,"); sql.setTimestamp("expDate", soGroupShortNbr.getExpDate()); } if (soGroupShortNbr.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", soGroupShortNbr.getLocalNetId()); } if (soGroupShortNbr.getFlagNoFlag() == 1) {sql.append("NO_FLAG=:noFlag,"); sql.setString("noFlag", soGroupShortNbr.getNoFlag()); } if (soGroupShortNbr.getFlagNum() == 1) {sql.append("NUM=:num,");sql.setLong("num", soGroupShortNbr.getNum()); } if (soGroupShortNbr.getFlagServInstId() == 1) {sql.append("SERV_INST_ID=:servInstId,");sql.setLong("servInstId", soGroupShortNbr.getServInstId()); } if (soGroupShortNbr.getFlagShortNbrId() == 1) {sql.append("SHORT_NBR_ID=:shortNbrId,");sql.setLong("shortNbrId", soGroupShortNbr.getShortNbrId()); } if (soGroupShortNbr.getFlagSoNbr() == 1) {sql.append("SO_NBR=:soNbr,"); sql.setString("soNbr", soGroupShortNbr.getSoNbr()); } if (soGroupShortNbr.getFlagStartNbr() == 1) {sql.append("START_NBR=:startNbr,"); sql.setString("startNbr", soGroupShortNbr.getStartNbr()); } if (soGroupShortNbr.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", soGroupShortNbr.getSts()); } if (soGroupShortNbr.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", soGroupShortNbr.getStsDate()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_GROUP_SHORT_NBR(ACT_TYPE,EFF_DATE,END_NBR,EXP_DATE,LOCAL_NET_ID,NO_FLAG,NUM,SERV_INST_ID,SHORT_NBR_ID,SO_NBR,START_NBR,STS,STS_DATE)");sql.append(" VALUES (:actType,:effDate,:endNbr,:expDate,:localNetId,:noFlag,:num,:servInstId,:shortNbrId,:soNbr,:startNbr,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) list.get(i);         if (soGroupShortNbr== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }      if (StringUtil.isBlank(soGroupShortNbr.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", soGroupShortNbr.getActType());    }    if (soGroupShortNbr.getEffDate() == null) {      sql.setNullDate("effDate");     } else {    sql.setTimestamp("effDate", soGroupShortNbr.getEffDate());    }       if (StringUtil.isBlank(soGroupShortNbr.getEndNbr())) {      sql.setNullString("endNbr");     } else {    sql.setString("endNbr", soGroupShortNbr.getEndNbr());    }    if (soGroupShortNbr.getExpDate() == null) {      sql.setNullDate("expDate");     } else {    sql.setTimestamp("expDate", soGroupShortNbr.getExpDate());    }       if (StringUtil.isBlank(soGroupShortNbr.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soGroupShortNbr.getLocalNetId());    }       if (StringUtil.isBlank(soGroupShortNbr.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soGroupShortNbr.getNoFlag());    }       if (StringUtil.isBlank(soGroupShortNbr.getNum())) {      sql.setNullLong("num");     } else {    sql.setLong("num", soGroupShortNbr.getNum());    }       if (StringUtil.isBlank(soGroupShortNbr.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", soGroupShortNbr.getServInstId());    }       if (StringUtil.isBlank(soGroupShortNbr.getShortNbrId())) {      sql.setNullLong("shortNbrId");     } else {    sql.setLong("shortNbrId", soGroupShortNbr.getShortNbrId());    }       if (StringUtil.isBlank(soGroupShortNbr.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", soGroupShortNbr.getSoNbr());    }       if (StringUtil.isBlank(soGroupShortNbr.getStartNbr())) {      sql.setNullString("startNbr");     } else {    sql.setString("startNbr", soGroupShortNbr.getStartNbr());    }       if (StringUtil.isBlank(soGroupShortNbr.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soGroupShortNbr.getSts());    }    if (soGroupShortNbr.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soGroupShortNbr.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM SO_GROUP_SHORT_NBR WHERE 1=1  ");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     SoGroupShortNbrSVO soGroupShortNbr=(SoGroupShortNbrSVO) vo;       }}
