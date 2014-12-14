package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.ISoSiGroupMemberSDAO;import com.cattsoft.sp.vo.SoSiGroupMemberSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法SoSiGroupMemberSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class SoSiGroupMemberSDAOImpl implements ISoSiGroupMemberSDAO{    private static Logger log = Logger.getLogger(SoSiGroupMemberSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;    if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_SI_GROUP_MEMBER(ACC_NBR,ACT_TYPE,AREA_ID,CHG_SERV_SPEC_ID,DIST_NBR,EXT_SO_NBR,LOCAL_NET_ID,MAIN_FLAG,MEMBER_TYPE,NO_FLAG,PHY_ACC_NBR,PHY_DIST_NBR,PROD_ID,SERV_INST_ID,SO_SI_GROUP_ID,SO_SI_GROUP_MEMBER_ID,STS,STS_DATE,WO_ACTION)");sql.append(" VALUES (:accNbr,:actType,:areaId,:chgServSpecId,:distNbr,:extSoNbr,:localNetId,:mainFlag,:memberType,:noFlag,:phyAccNbr,:phyDistNbr,:prodId,:servInstId,:soSiGroupId,:soSiGroupMemberId,:sts,:stsDate,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(soSiGroupMember.getAccNbr())) {      sql.setNullString("accNbr");     } else {    sql.setString("accNbr", soSiGroupMember.getAccNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", soSiGroupMember.getActType());    }       if (StringUtil.isBlank(soSiGroupMember.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", soSiGroupMember.getAreaId());    }       if (StringUtil.isBlank(soSiGroupMember.getChgServSpecId())) {      sql.setNullLong("chgServSpecId");     } else {    sql.setLong("chgServSpecId", soSiGroupMember.getChgServSpecId());    }       if (StringUtil.isBlank(soSiGroupMember.getDistNbr())) {      sql.setNullString("distNbr");     } else {    sql.setString("distNbr", soSiGroupMember.getDistNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getExtSoNbr())) {      sql.setNullString("extSoNbr");     } else {    sql.setString("extSoNbr", soSiGroupMember.getExtSoNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soSiGroupMember.getLocalNetId());    }       if (StringUtil.isBlank(soSiGroupMember.getMainFlag())) {      sql.setNullString("mainFlag");     } else {    sql.setString("mainFlag", soSiGroupMember.getMainFlag());    }       if (StringUtil.isBlank(soSiGroupMember.getMemberType())) {      sql.setNullString("memberType");     } else {    sql.setString("memberType", soSiGroupMember.getMemberType());    }       if (StringUtil.isBlank(soSiGroupMember.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soSiGroupMember.getNoFlag());    }       if (StringUtil.isBlank(soSiGroupMember.getPhyAccNbr())) {      sql.setNullString("phyAccNbr");     } else {    sql.setString("phyAccNbr", soSiGroupMember.getPhyAccNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getPhyDistNbr())) {      sql.setNullString("phyDistNbr");     } else {    sql.setString("phyDistNbr", soSiGroupMember.getPhyDistNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getProdId())) {      sql.setNullLong("prodId");     } else {    sql.setLong("prodId", soSiGroupMember.getProdId());    }       if (StringUtil.isBlank(soSiGroupMember.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", soSiGroupMember.getServInstId());    }       if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupId())) {      sql.setNullLong("soSiGroupId");     } else {    sql.setLong("soSiGroupId", soSiGroupMember.getSoSiGroupId());    }       if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {      sql.setNullLong("soSiGroupMemberId");     } else {    sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());    }       if (StringUtil.isBlank(soSiGroupMember.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soSiGroupMember.getSts());    }    if (soSiGroupMember.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soSiGroupMember.getStsDate());    }       if (StringUtil.isBlank(soSiGroupMember.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", soSiGroupMember.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;    if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT ACC_NBR,ACT_TYPE,AREA_ID,CHG_SERV_SPEC_ID,DIST_NBR,EXT_SO_NBR,LOCAL_NET_ID,MAIN_FLAG,MEMBER_TYPE,NO_FLAG,PHY_ACC_NBR,PHY_DIST_NBR,PROD_ID,SERV_INST_ID,SO_SI_GROUP_ID,SO_SI_GROUP_MEMBER_ID,STS,STS_DATE,WO_ACTION FROM SO_SI_GROUP_MEMBER WHERE 1=1  ");sql.append(" and SO_SI_GROUP_MEMBER_ID=:soSiGroupMemberId");sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      soSiGroupMember =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           soSiGroupMember = new SoSiGroupMemberSVO();           soSiGroupMember.setAccNbr(rs.getString("ACC_NBR"));           soSiGroupMember.setActType(rs.getString("ACT_TYPE"));           soSiGroupMember.setAreaId(rs.getString("AREA_ID"));           soSiGroupMember.setChgServSpecId(rs.getString("CHG_SERV_SPEC_ID"));           soSiGroupMember.setDistNbr(rs.getString("DIST_NBR"));           soSiGroupMember.setExtSoNbr(rs.getString("EXT_SO_NBR"));           soSiGroupMember.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soSiGroupMember.setMainFlag(rs.getString("MAIN_FLAG"));           soSiGroupMember.setMemberType(rs.getString("MEMBER_TYPE"));           soSiGroupMember.setNoFlag(rs.getString("NO_FLAG"));           soSiGroupMember.setPhyAccNbr(rs.getString("PHY_ACC_NBR"));           soSiGroupMember.setPhyDistNbr(rs.getString("PHY_DIST_NBR"));           soSiGroupMember.setProdId(rs.getString("PROD_ID"));           soSiGroupMember.setServInstId(rs.getString("SERV_INST_ID"));           soSiGroupMember.setSoSiGroupId(rs.getString("SO_SI_GROUP_ID"));           soSiGroupMember.setSoSiGroupMemberId(rs.getString("SO_SI_GROUP_MEMBER_ID"));           soSiGroupMember.setSts(rs.getString("STS"));           soSiGroupMember.setStsDate(rs.getTimestamp("STS_DATE"));           soSiGroupMember.setWoAction(rs.getString("WO_ACTION"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return soSiGroupMember;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT ACC_NBR,ACT_TYPE,AREA_ID,CHG_SERV_SPEC_ID,DIST_NBR,EXT_SO_NBR,LOCAL_NET_ID,MAIN_FLAG,MEMBER_TYPE,NO_FLAG,PHY_ACC_NBR,PHY_DIST_NBR,PROD_ID,SERV_INST_ID,SO_SI_GROUP_ID,SO_SI_GROUP_MEMBER_ID,STS,STS_DATE,WO_ACTION FROM SO_SI_GROUP_MEMBER WHERE 1=1 ");     try {if (soSiGroupMember.getFlagAccNbr() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getAccNbr())) {             sql.append(" and ACC_NBR is null ");          }      else{             sql.append(" and ACC_NBR=:accNbr");             sql.setString("accNbr", soSiGroupMember.getAccNbr());          }   } if (soSiGroupMember.getFlagActType() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getActType())) {             sql.append(" and ACT_TYPE is null ");          }      else{             sql.append(" and ACT_TYPE=:actType");             sql.setString("actType", soSiGroupMember.getActType());          }   } if (soSiGroupMember.getFlagAreaId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getAreaId())) {             sql.append(" and AREA_ID is null ");          }      else{             sql.append(" and AREA_ID=:areaId");             sql.setLong("areaId", soSiGroupMember.getAreaId());          }   } if (soSiGroupMember.getFlagChgServSpecId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getChgServSpecId())) {             sql.append(" and CHG_SERV_SPEC_ID is null ");          }      else{             sql.append(" and CHG_SERV_SPEC_ID=:chgServSpecId");             sql.setLong("chgServSpecId", soSiGroupMember.getChgServSpecId());          }   } if (soSiGroupMember.getFlagDistNbr() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getDistNbr())) {             sql.append(" and DIST_NBR is null ");          }      else{             sql.append(" and DIST_NBR=:distNbr");             sql.setString("distNbr", soSiGroupMember.getDistNbr());          }   } if (soSiGroupMember.getFlagExtSoNbr() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getExtSoNbr())) {             sql.append(" and EXT_SO_NBR is null ");          }      else{             sql.append(" and EXT_SO_NBR=:extSoNbr");             sql.setString("extSoNbr", soSiGroupMember.getExtSoNbr());          }   } if (soSiGroupMember.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", soSiGroupMember.getLocalNetId());          }   } if (soSiGroupMember.getFlagMainFlag() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getMainFlag())) {             sql.append(" and MAIN_FLAG is null ");          }      else{             sql.append(" and MAIN_FLAG=:mainFlag");             sql.setString("mainFlag", soSiGroupMember.getMainFlag());          }   } if (soSiGroupMember.getFlagMemberType() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getMemberType())) {             sql.append(" and MEMBER_TYPE is null ");          }      else{             sql.append(" and MEMBER_TYPE=:memberType");             sql.setString("memberType", soSiGroupMember.getMemberType());          }   } if (soSiGroupMember.getFlagNoFlag() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getNoFlag())) {             sql.append(" and NO_FLAG is null ");          }      else{             sql.append(" and NO_FLAG=:noFlag");             sql.setString("noFlag", soSiGroupMember.getNoFlag());          }   } if (soSiGroupMember.getFlagPhyAccNbr() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getPhyAccNbr())) {             sql.append(" and PHY_ACC_NBR is null ");          }      else{             sql.append(" and PHY_ACC_NBR=:phyAccNbr");             sql.setString("phyAccNbr", soSiGroupMember.getPhyAccNbr());          }   } if (soSiGroupMember.getFlagPhyDistNbr() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getPhyDistNbr())) {             sql.append(" and PHY_DIST_NBR is null ");          }      else{             sql.append(" and PHY_DIST_NBR=:phyDistNbr");             sql.setString("phyDistNbr", soSiGroupMember.getPhyDistNbr());          }   } if (soSiGroupMember.getFlagProdId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getProdId())) {             sql.append(" and PROD_ID is null ");          }      else{             sql.append(" and PROD_ID=:prodId");             sql.setLong("prodId", soSiGroupMember.getProdId());          }   } if (soSiGroupMember.getFlagServInstId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getServInstId())) {             sql.append(" and SERV_INST_ID is null ");          }      else{             sql.append(" and SERV_INST_ID=:servInstId");             sql.setLong("servInstId", soSiGroupMember.getServInstId());          }   } if (soSiGroupMember.getFlagSoSiGroupId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupId())) {             sql.append(" and SO_SI_GROUP_ID is null ");          }      else{             sql.append(" and SO_SI_GROUP_ID=:soSiGroupId");             sql.setLong("soSiGroupId", soSiGroupMember.getSoSiGroupId());          }   } if (soSiGroupMember.getFlagSoSiGroupMemberId() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {             sql.append(" and SO_SI_GROUP_MEMBER_ID is null ");          }      else{             sql.append(" and SO_SI_GROUP_MEMBER_ID=:soSiGroupMemberId");             sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());          }   } if (soSiGroupMember.getFlagSts() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", soSiGroupMember.getSts());          }   } if (soSiGroupMember.getFlagStsDate() == 1) {      if (soSiGroupMember.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", soSiGroupMember.getStsDate());          }   } if (soSiGroupMember.getFlagWoAction() == 1) {      if (StringUtil.isBlank(soSiGroupMember.getWoAction())) {             sql.append(" and WO_ACTION is null ");          }      else{             sql.append(" and WO_ACTION=:woAction");             sql.setString("woAction", soSiGroupMember.getWoAction());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           soSiGroupMember = new SoSiGroupMemberSVO();           soSiGroupMember.setAccNbr(rs.getString("ACC_NBR"));           soSiGroupMember.setActType(rs.getString("ACT_TYPE"));           soSiGroupMember.setAreaId(rs.getString("AREA_ID"));           soSiGroupMember.setChgServSpecId(rs.getString("CHG_SERV_SPEC_ID"));           soSiGroupMember.setDistNbr(rs.getString("DIST_NBR"));           soSiGroupMember.setExtSoNbr(rs.getString("EXT_SO_NBR"));           soSiGroupMember.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soSiGroupMember.setMainFlag(rs.getString("MAIN_FLAG"));           soSiGroupMember.setMemberType(rs.getString("MEMBER_TYPE"));           soSiGroupMember.setNoFlag(rs.getString("NO_FLAG"));           soSiGroupMember.setPhyAccNbr(rs.getString("PHY_ACC_NBR"));           soSiGroupMember.setPhyDistNbr(rs.getString("PHY_DIST_NBR"));           soSiGroupMember.setProdId(rs.getString("PROD_ID"));           soSiGroupMember.setServInstId(rs.getString("SERV_INST_ID"));           soSiGroupMember.setSoSiGroupId(rs.getString("SO_SI_GROUP_ID"));           soSiGroupMember.setSoSiGroupMemberId(rs.getString("SO_SI_GROUP_MEMBER_ID"));           soSiGroupMember.setSts(rs.getString("STS"));           soSiGroupMember.setStsDate(rs.getTimestamp("STS_DATE"));           soSiGroupMember.setWoAction(rs.getString("WO_ACTION"));               res.add(soSiGroupMember);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;    if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE SO_SI_GROUP_MEMBER SET ");     try {if (soSiGroupMember.getFlagAccNbr() == 1) {sql.append("ACC_NBR=:accNbr,"); sql.setString("accNbr", soSiGroupMember.getAccNbr()); } if (soSiGroupMember.getFlagActType() == 1) {sql.append("ACT_TYPE=:actType,"); sql.setString("actType", soSiGroupMember.getActType()); } if (soSiGroupMember.getFlagAreaId() == 1) {sql.append("AREA_ID=:areaId,");sql.setLong("areaId", soSiGroupMember.getAreaId()); } if (soSiGroupMember.getFlagChgServSpecId() == 1) {sql.append("CHG_SERV_SPEC_ID=:chgServSpecId,");sql.setLong("chgServSpecId", soSiGroupMember.getChgServSpecId()); } if (soSiGroupMember.getFlagDistNbr() == 1) {sql.append("DIST_NBR=:distNbr,"); sql.setString("distNbr", soSiGroupMember.getDistNbr()); } if (soSiGroupMember.getFlagExtSoNbr() == 1) {sql.append("EXT_SO_NBR=:extSoNbr,"); sql.setString("extSoNbr", soSiGroupMember.getExtSoNbr()); } if (soSiGroupMember.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", soSiGroupMember.getLocalNetId()); } if (soSiGroupMember.getFlagMainFlag() == 1) {sql.append("MAIN_FLAG=:mainFlag,"); sql.setString("mainFlag", soSiGroupMember.getMainFlag()); } if (soSiGroupMember.getFlagMemberType() == 1) {sql.append("MEMBER_TYPE=:memberType,"); sql.setString("memberType", soSiGroupMember.getMemberType()); } if (soSiGroupMember.getFlagNoFlag() == 1) {sql.append("NO_FLAG=:noFlag,"); sql.setString("noFlag", soSiGroupMember.getNoFlag()); } if (soSiGroupMember.getFlagPhyAccNbr() == 1) {sql.append("PHY_ACC_NBR=:phyAccNbr,"); sql.setString("phyAccNbr", soSiGroupMember.getPhyAccNbr()); } if (soSiGroupMember.getFlagPhyDistNbr() == 1) {sql.append("PHY_DIST_NBR=:phyDistNbr,"); sql.setString("phyDistNbr", soSiGroupMember.getPhyDistNbr()); } if (soSiGroupMember.getFlagProdId() == 1) {sql.append("PROD_ID=:prodId,");sql.setLong("prodId", soSiGroupMember.getProdId()); } if (soSiGroupMember.getFlagServInstId() == 1) {sql.append("SERV_INST_ID=:servInstId,");sql.setLong("servInstId", soSiGroupMember.getServInstId()); } if (soSiGroupMember.getFlagSoSiGroupId() == 1) {sql.append("SO_SI_GROUP_ID=:soSiGroupId,");sql.setLong("soSiGroupId", soSiGroupMember.getSoSiGroupId()); } if (soSiGroupMember.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", soSiGroupMember.getSts()); } if (soSiGroupMember.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", soSiGroupMember.getStsDate()); } if (soSiGroupMember.getFlagWoAction() == 1) {sql.append("WO_ACTION=:woAction,"); sql.setString("woAction", soSiGroupMember.getWoAction()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and SO_SI_GROUP_MEMBER_ID=:soSiGroupMemberId");sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_SI_GROUP_MEMBER(ACC_NBR,ACT_TYPE,AREA_ID,CHG_SERV_SPEC_ID,DIST_NBR,EXT_SO_NBR,LOCAL_NET_ID,MAIN_FLAG,MEMBER_TYPE,NO_FLAG,PHY_ACC_NBR,PHY_DIST_NBR,PROD_ID,SERV_INST_ID,SO_SI_GROUP_ID,SO_SI_GROUP_MEMBER_ID,STS,STS_DATE,WO_ACTION)");sql.append(" VALUES (:accNbr,:actType,:areaId,:chgServSpecId,:distNbr,:extSoNbr,:localNetId,:mainFlag,:memberType,:noFlag,:phyAccNbr,:phyDistNbr,:prodId,:servInstId,:soSiGroupId,:soSiGroupMemberId,:sts,:stsDate,:woAction)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) list.get(i);         if (soSiGroupMember== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(soSiGroupMember.getAccNbr())) {      sql.setNullString("accNbr");     } else {    sql.setString("accNbr", soSiGroupMember.getAccNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getActType())) {      sql.setNullString("actType");     } else {    sql.setString("actType", soSiGroupMember.getActType());    }       if (StringUtil.isBlank(soSiGroupMember.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", soSiGroupMember.getAreaId());    }       if (StringUtil.isBlank(soSiGroupMember.getChgServSpecId())) {      sql.setNullLong("chgServSpecId");     } else {    sql.setLong("chgServSpecId", soSiGroupMember.getChgServSpecId());    }       if (StringUtil.isBlank(soSiGroupMember.getDistNbr())) {      sql.setNullString("distNbr");     } else {    sql.setString("distNbr", soSiGroupMember.getDistNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getExtSoNbr())) {      sql.setNullString("extSoNbr");     } else {    sql.setString("extSoNbr", soSiGroupMember.getExtSoNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soSiGroupMember.getLocalNetId());    }       if (StringUtil.isBlank(soSiGroupMember.getMainFlag())) {      sql.setNullString("mainFlag");     } else {    sql.setString("mainFlag", soSiGroupMember.getMainFlag());    }       if (StringUtil.isBlank(soSiGroupMember.getMemberType())) {      sql.setNullString("memberType");     } else {    sql.setString("memberType", soSiGroupMember.getMemberType());    }       if (StringUtil.isBlank(soSiGroupMember.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soSiGroupMember.getNoFlag());    }       if (StringUtil.isBlank(soSiGroupMember.getPhyAccNbr())) {      sql.setNullString("phyAccNbr");     } else {    sql.setString("phyAccNbr", soSiGroupMember.getPhyAccNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getPhyDistNbr())) {      sql.setNullString("phyDistNbr");     } else {    sql.setString("phyDistNbr", soSiGroupMember.getPhyDistNbr());    }       if (StringUtil.isBlank(soSiGroupMember.getProdId())) {      sql.setNullLong("prodId");     } else {    sql.setLong("prodId", soSiGroupMember.getProdId());    }       if (StringUtil.isBlank(soSiGroupMember.getServInstId())) {      sql.setNullLong("servInstId");     } else {    sql.setLong("servInstId", soSiGroupMember.getServInstId());    }       if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupId())) {      sql.setNullLong("soSiGroupId");     } else {    sql.setLong("soSiGroupId", soSiGroupMember.getSoSiGroupId());    }       if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {      sql.setNullLong("soSiGroupMemberId");     } else {    sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());    }       if (StringUtil.isBlank(soSiGroupMember.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soSiGroupMember.getSts());    }    if (soSiGroupMember.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soSiGroupMember.getStsDate());    }       if (StringUtil.isBlank(soSiGroupMember.getWoAction())) {      sql.setNullString("woAction");     } else {    sql.setString("woAction", soSiGroupMember.getWoAction());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;    if (StringUtil.isBlank(soSiGroupMember.getSoSiGroupMemberId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM SO_SI_GROUP_MEMBER WHERE 1=1  ");sql.append(" and SO_SI_GROUP_MEMBER_ID=:soSiGroupMemberId");sql.setLong("soSiGroupMemberId", soSiGroupMember.getSoSiGroupMemberId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     SoSiGroupMemberSVO soSiGroupMember=(SoSiGroupMemberSVO) vo;       }}
