package com.cattsoft.pm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.pm.component.dao.IProdPackageSDAO;import com.cattsoft.pm.vo.ProdPackageSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法ProdPackageSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class ProdPackageSDAOImpl implements IProdPackageSDAO{    private static Logger log = Logger.getLogger(ProdPackageSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ProdPackageSVO prodPackage=(ProdPackageSVO) vo;    if (StringUtil.isBlank(prodPackage.getProdPackageId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO PROD_PACKAGE(AREA_ID,CREATE_DATE,LOCAL_NET_ID,NAME,PROD_PACKAGE_ID,STANDARD_ID,STS,STS_DATE)");sql.append(" VALUES (:areaId,:createDate,:localNetId,:name,:prodPackageId,:standardId,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(prodPackage.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", prodPackage.getAreaId());    }    if (prodPackage.getCreateDate() == null) {      sql.setNullDate("createDate");     } else {    sql.setTimestamp("createDate", prodPackage.getCreateDate());    }       if (StringUtil.isBlank(prodPackage.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", prodPackage.getLocalNetId());    }       if (StringUtil.isBlank(prodPackage.getName())) {      sql.setNullString("name");     } else {    sql.setString("name", prodPackage.getName());    }       if (StringUtil.isBlank(prodPackage.getProdPackageId())) {      sql.setNullLong("prodPackageId");     } else {    sql.setLong("prodPackageId", prodPackage.getProdPackageId());    }       if (StringUtil.isBlank(prodPackage.getStandardId())) {      sql.setNullString("standardId");     } else {    sql.setString("standardId", prodPackage.getStandardId());    }       if (StringUtil.isBlank(prodPackage.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", prodPackage.getSts());    }    if (prodPackage.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", prodPackage.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ProdPackageSVO prodPackage=(ProdPackageSVO) vo;    if (StringUtil.isBlank(prodPackage.getProdPackageId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT AREA_ID,CREATE_DATE,LOCAL_NET_ID,NAME,PROD_PACKAGE_ID,STANDARD_ID,STS,STS_DATE FROM PROD_PACKAGE WHERE 1=1  ");sql.append(" and PROD_PACKAGE_ID=:prodPackageId");sql.setLong("prodPackageId", prodPackage.getProdPackageId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      prodPackage =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           prodPackage = new ProdPackageSVO();           prodPackage.setAreaId(rs.getString("AREA_ID"));           prodPackage.setCreateDate(rs.getTimestamp("CREATE_DATE"));           prodPackage.setLocalNetId(rs.getString("LOCAL_NET_ID"));           prodPackage.setName(rs.getString("NAME"));           prodPackage.setProdPackageId(rs.getString("PROD_PACKAGE_ID"));           prodPackage.setStandardId(rs.getString("STANDARD_ID"));           prodPackage.setSts(rs.getString("STS"));           prodPackage.setStsDate(rs.getTimestamp("STS_DATE"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return prodPackage;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ProdPackageSVO prodPackage=(ProdPackageSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT AREA_ID,CREATE_DATE,LOCAL_NET_ID,NAME,PROD_PACKAGE_ID,STANDARD_ID,STS,STS_DATE FROM PROD_PACKAGE WHERE 1=1 ");     try {if (prodPackage.getFlagAreaId() == 1) {      if (StringUtil.isBlank(prodPackage.getAreaId())) {             sql.append(" and AREA_ID is null ");          }      else{             sql.append(" and AREA_ID=:areaId");             sql.setLong("areaId", prodPackage.getAreaId());          }   } if (prodPackage.getFlagCreateDate() == 1) {      if (prodPackage.getCreateDate() == null) {             sql.append(" and CREATE_DATE is null ");          }      else{             sql.append(" and CREATE_DATE=:createDate");             sql.setTimestamp("createDate", prodPackage.getCreateDate());          }   } if (prodPackage.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(prodPackage.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", prodPackage.getLocalNetId());          }   } if (prodPackage.getFlagName() == 1) {      if (StringUtil.isBlank(prodPackage.getName())) {             sql.append(" and NAME is null ");          }      else{             sql.append(" and NAME=:name");             sql.setString("name", prodPackage.getName());          }   } if (prodPackage.getFlagProdPackageId() == 1) {      if (StringUtil.isBlank(prodPackage.getProdPackageId())) {             sql.append(" and PROD_PACKAGE_ID is null ");          }      else{             sql.append(" and PROD_PACKAGE_ID=:prodPackageId");             sql.setLong("prodPackageId", prodPackage.getProdPackageId());          }   } if (prodPackage.getFlagStandardId() == 1) {      if (StringUtil.isBlank(prodPackage.getStandardId())) {             sql.append(" and STANDARD_ID is null ");          }      else{             sql.append(" and STANDARD_ID=:standardId");             sql.setString("standardId", prodPackage.getStandardId());          }   } if (prodPackage.getFlagSts() == 1) {      if (StringUtil.isBlank(prodPackage.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", prodPackage.getSts());          }   } if (prodPackage.getFlagStsDate() == 1) {      if (prodPackage.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", prodPackage.getStsDate());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           prodPackage = new ProdPackageSVO();           prodPackage.setAreaId(rs.getString("AREA_ID"));           prodPackage.setCreateDate(rs.getTimestamp("CREATE_DATE"));           prodPackage.setLocalNetId(rs.getString("LOCAL_NET_ID"));           prodPackage.setName(rs.getString("NAME"));           prodPackage.setProdPackageId(rs.getString("PROD_PACKAGE_ID"));           prodPackage.setStandardId(rs.getString("STANDARD_ID"));           prodPackage.setSts(rs.getString("STS"));           prodPackage.setStsDate(rs.getTimestamp("STS_DATE"));               res.add(prodPackage);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       ProdPackageSVO prodPackage=(ProdPackageSVO) vo;    if (StringUtil.isBlank(prodPackage.getProdPackageId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE PROD_PACKAGE SET ");     try {if (prodPackage.getFlagAreaId() == 1) {sql.append("AREA_ID=:areaId,");sql.setLong("areaId", prodPackage.getAreaId()); } if (prodPackage.getFlagCreateDate() == 1) {sql.append("CREATE_DATE=:createDate,"); sql.setTimestamp("createDate", prodPackage.getCreateDate()); } if (prodPackage.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", prodPackage.getLocalNetId()); } if (prodPackage.getFlagName() == 1) {sql.append("NAME=:name,"); sql.setString("name", prodPackage.getName()); } if (prodPackage.getFlagStandardId() == 1) {sql.append("STANDARD_ID=:standardId,"); sql.setString("standardId", prodPackage.getStandardId()); } if (prodPackage.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", prodPackage.getSts()); } if (prodPackage.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", prodPackage.getStsDate()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and PROD_PACKAGE_ID=:prodPackageId");sql.setLong("prodPackageId", prodPackage.getProdPackageId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO PROD_PACKAGE(AREA_ID,CREATE_DATE,LOCAL_NET_ID,NAME,PROD_PACKAGE_ID,STANDARD_ID,STS,STS_DATE)");sql.append(" VALUES (:areaId,:createDate,:localNetId,:name,:prodPackageId,:standardId,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       ProdPackageSVO prodPackage=(ProdPackageSVO) list.get(i);         if (prodPackage== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(prodPackage.getProdPackageId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(prodPackage.getAreaId())) {      sql.setNullLong("areaId");     } else {    sql.setLong("areaId", prodPackage.getAreaId());    }    if (prodPackage.getCreateDate() == null) {      sql.setNullDate("createDate");     } else {    sql.setTimestamp("createDate", prodPackage.getCreateDate());    }       if (StringUtil.isBlank(prodPackage.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", prodPackage.getLocalNetId());    }       if (StringUtil.isBlank(prodPackage.getName())) {      sql.setNullString("name");     } else {    sql.setString("name", prodPackage.getName());    }       if (StringUtil.isBlank(prodPackage.getProdPackageId())) {      sql.setNullLong("prodPackageId");     } else {    sql.setLong("prodPackageId", prodPackage.getProdPackageId());    }       if (StringUtil.isBlank(prodPackage.getStandardId())) {      sql.setNullString("standardId");     } else {    sql.setString("standardId", prodPackage.getStandardId());    }       if (StringUtil.isBlank(prodPackage.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", prodPackage.getSts());    }    if (prodPackage.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", prodPackage.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     ProdPackageSVO prodPackage=(ProdPackageSVO) vo;    if (StringUtil.isBlank(prodPackage.getProdPackageId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM PROD_PACKAGE WHERE 1=1  ");sql.append(" and PROD_PACKAGE_ID=:prodPackageId");sql.setLong("prodPackageId", prodPackage.getProdPackageId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     ProdPackageSVO prodPackage=(ProdPackageSVO) vo;       }}
