package com.cattsoft.sp.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.sp.component.dao.ISoChargeSDAO;import com.cattsoft.sp.vo.SoChargeSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法SoChargeSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class SoChargeSDAOImpl implements ISoChargeSDAO{    private static Logger log = Logger.getLogger(SoChargeSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoChargeSVO soCharge=(SoChargeSVO) vo;    if (StringUtil.isBlank(soCharge.getSoChargeId())) {       throw new AppException("100002", "缺少对象的主键！");      }    if (StringUtil.isBlank(soCharge.getSoNbr())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_CHARGE(BANK_NAME,CHARGE,CHARGE_CODE,CHARGE_NAME,EXT_SO_NBR,HOME_BILL_FLAG,INVOICE_ID,LOCAL_NET_ID,NO_FLAG,PAY_FLAG,PAY_NBR,PAY_TYPE,RECEIVE_ID,SO_CHARGE_ID,SO_NBR,STS,STS_DATE)");sql.append(" VALUES (:bankName,:charge,:chargeCode,:chargeName,:extSoNbr,:homeBillFlag,:invoiceId,:localNetId,:noFlag,:payFlag,:payNbr,:payType,:receiveId,:soChargeId,:soNbr,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(soCharge.getBankName())) {      sql.setNullString("bankName");     } else {    sql.setString("bankName", soCharge.getBankName());    }       if (StringUtil.isBlank(soCharge.getCharge())) {      sql.setNullLong("charge");     } else {    sql.setLong("charge", soCharge.getCharge());    }       if (StringUtil.isBlank(soCharge.getChargeCode())) {      sql.setNullString("chargeCode");     } else {    sql.setString("chargeCode", soCharge.getChargeCode());    }       if (StringUtil.isBlank(soCharge.getChargeName())) {      sql.setNullString("chargeName");     } else {    sql.setString("chargeName", soCharge.getChargeName());    }       if (StringUtil.isBlank(soCharge.getExtSoNbr())) {      sql.setNullString("extSoNbr");     } else {    sql.setString("extSoNbr", soCharge.getExtSoNbr());    }       if (StringUtil.isBlank(soCharge.getHomeBillFlag())) {      sql.setNullString("homeBillFlag");     } else {    sql.setString("homeBillFlag", soCharge.getHomeBillFlag());    }       if (StringUtil.isBlank(soCharge.getInvoiceId())) {      sql.setNullString("invoiceId");     } else {    sql.setString("invoiceId", soCharge.getInvoiceId());    }       if (StringUtil.isBlank(soCharge.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soCharge.getLocalNetId());    }       if (StringUtil.isBlank(soCharge.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soCharge.getNoFlag());    }       if (StringUtil.isBlank(soCharge.getPayFlag())) {      sql.setNullString("payFlag");     } else {    sql.setString("payFlag", soCharge.getPayFlag());    }       if (StringUtil.isBlank(soCharge.getPayNbr())) {      sql.setNullString("payNbr");     } else {    sql.setString("payNbr", soCharge.getPayNbr());    }       if (StringUtil.isBlank(soCharge.getPayType())) {      sql.setNullString("payType");     } else {    sql.setString("payType", soCharge.getPayType());    }       if (StringUtil.isBlank(soCharge.getReceiveId())) {      sql.setNullString("receiveId");     } else {    sql.setString("receiveId", soCharge.getReceiveId());    }       if (StringUtil.isBlank(soCharge.getSoChargeId())) {      sql.setNullLong("soChargeId");     } else {    sql.setLong("soChargeId", soCharge.getSoChargeId());    }       if (StringUtil.isBlank(soCharge.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", soCharge.getSoNbr());    }       if (StringUtil.isBlank(soCharge.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soCharge.getSts());    }    if (soCharge.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soCharge.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoChargeSVO soCharge=(SoChargeSVO) vo;    if (StringUtil.isBlank(soCharge.getSoChargeId())) {       throw new AppException("100002", "缺少对象的主键！");      }    if (StringUtil.isBlank(soCharge.getSoNbr())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT BANK_NAME,CHARGE,CHARGE_CODE,CHARGE_NAME,EXT_SO_NBR,HOME_BILL_FLAG,INVOICE_ID,LOCAL_NET_ID,NO_FLAG,PAY_FLAG,PAY_NBR,PAY_TYPE,RECEIVE_ID,SO_CHARGE_ID,SO_NBR,STS,STS_DATE FROM SO_CHARGE WHERE 1=1  ");sql.append(" and SO_CHARGE_ID=:soChargeId");sql.setLong("soChargeId", soCharge.getSoChargeId()); sql.append(" and SO_NBR=:soNbr");sql.setString("soNbr", soCharge.getSoNbr());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      soCharge =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           soCharge = new SoChargeSVO();           soCharge.setBankName(rs.getString("BANK_NAME"));           soCharge.setCharge(rs.getString("CHARGE"));           soCharge.setChargeCode(rs.getString("CHARGE_CODE"));           soCharge.setChargeName(rs.getString("CHARGE_NAME"));           soCharge.setExtSoNbr(rs.getString("EXT_SO_NBR"));           soCharge.setHomeBillFlag(rs.getString("HOME_BILL_FLAG"));           soCharge.setInvoiceId(rs.getString("INVOICE_ID"));           soCharge.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soCharge.setNoFlag(rs.getString("NO_FLAG"));           soCharge.setPayFlag(rs.getString("PAY_FLAG"));           soCharge.setPayNbr(rs.getString("PAY_NBR"));           soCharge.setPayType(rs.getString("PAY_TYPE"));           soCharge.setReceiveId(rs.getString("RECEIVE_ID"));           soCharge.setSoChargeId(rs.getString("SO_CHARGE_ID"));           soCharge.setSoNbr(rs.getString("SO_NBR"));           soCharge.setSts(rs.getString("STS"));           soCharge.setStsDate(rs.getTimestamp("STS_DATE"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return soCharge;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoChargeSVO soCharge=(SoChargeSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT BANK_NAME,CHARGE,CHARGE_CODE,CHARGE_NAME,EXT_SO_NBR,HOME_BILL_FLAG,INVOICE_ID,LOCAL_NET_ID,NO_FLAG,PAY_FLAG,PAY_NBR,PAY_TYPE,RECEIVE_ID,SO_CHARGE_ID,SO_NBR,STS,STS_DATE FROM SO_CHARGE WHERE 1=1 ");     try {if (soCharge.getFlagBankName() == 1) {      if (StringUtil.isBlank(soCharge.getBankName())) {             sql.append(" and BANK_NAME is null ");          }      else{             sql.append(" and BANK_NAME=:bankName");             sql.setString("bankName", soCharge.getBankName());          }   } if (soCharge.getFlagCharge() == 1) {      if (StringUtil.isBlank(soCharge.getCharge())) {             sql.append(" and CHARGE is null ");          }      else{             sql.append(" and CHARGE=:charge");             sql.setLong("charge", soCharge.getCharge());          }   } if (soCharge.getFlagChargeCode() == 1) {      if (StringUtil.isBlank(soCharge.getChargeCode())) {             sql.append(" and CHARGE_CODE is null ");          }      else{             sql.append(" and CHARGE_CODE=:chargeCode");             sql.setString("chargeCode", soCharge.getChargeCode());          }   } if (soCharge.getFlagChargeName() == 1) {      if (StringUtil.isBlank(soCharge.getChargeName())) {             sql.append(" and CHARGE_NAME is null ");          }      else{             sql.append(" and CHARGE_NAME=:chargeName");             sql.setString("chargeName", soCharge.getChargeName());          }   } if (soCharge.getFlagExtSoNbr() == 1) {      if (StringUtil.isBlank(soCharge.getExtSoNbr())) {             sql.append(" and EXT_SO_NBR is null ");          }      else{             sql.append(" and EXT_SO_NBR=:extSoNbr");             sql.setString("extSoNbr", soCharge.getExtSoNbr());          }   } if (soCharge.getFlagHomeBillFlag() == 1) {      if (StringUtil.isBlank(soCharge.getHomeBillFlag())) {             sql.append(" and HOME_BILL_FLAG is null ");          }      else{             sql.append(" and HOME_BILL_FLAG=:homeBillFlag");             sql.setString("homeBillFlag", soCharge.getHomeBillFlag());          }   } if (soCharge.getFlagInvoiceId() == 1) {      if (StringUtil.isBlank(soCharge.getInvoiceId())) {             sql.append(" and INVOICE_ID is null ");          }      else{             sql.append(" and INVOICE_ID=:invoiceId");             sql.setString("invoiceId", soCharge.getInvoiceId());          }   } if (soCharge.getFlagLocalNetId() == 1) {      if (StringUtil.isBlank(soCharge.getLocalNetId())) {             sql.append(" and LOCAL_NET_ID is null ");          }      else{             sql.append(" and LOCAL_NET_ID=:localNetId");             sql.setLong("localNetId", soCharge.getLocalNetId());          }   } if (soCharge.getFlagNoFlag() == 1) {      if (StringUtil.isBlank(soCharge.getNoFlag())) {             sql.append(" and NO_FLAG is null ");          }      else{             sql.append(" and NO_FLAG=:noFlag");             sql.setString("noFlag", soCharge.getNoFlag());          }   } if (soCharge.getFlagPayFlag() == 1) {      if (StringUtil.isBlank(soCharge.getPayFlag())) {             sql.append(" and PAY_FLAG is null ");          }      else{             sql.append(" and PAY_FLAG=:payFlag");             sql.setString("payFlag", soCharge.getPayFlag());          }   } if (soCharge.getFlagPayNbr() == 1) {      if (StringUtil.isBlank(soCharge.getPayNbr())) {             sql.append(" and PAY_NBR is null ");          }      else{             sql.append(" and PAY_NBR=:payNbr");             sql.setString("payNbr", soCharge.getPayNbr());          }   } if (soCharge.getFlagPayType() == 1) {      if (StringUtil.isBlank(soCharge.getPayType())) {             sql.append(" and PAY_TYPE is null ");          }      else{             sql.append(" and PAY_TYPE=:payType");             sql.setString("payType", soCharge.getPayType());          }   } if (soCharge.getFlagReceiveId() == 1) {      if (StringUtil.isBlank(soCharge.getReceiveId())) {             sql.append(" and RECEIVE_ID is null ");          }      else{             sql.append(" and RECEIVE_ID=:receiveId");             sql.setString("receiveId", soCharge.getReceiveId());          }   } if (soCharge.getFlagSoChargeId() == 1) {      if (StringUtil.isBlank(soCharge.getSoChargeId())) {             sql.append(" and SO_CHARGE_ID is null ");          }      else{             sql.append(" and SO_CHARGE_ID=:soChargeId");             sql.setLong("soChargeId", soCharge.getSoChargeId());          }   } if (soCharge.getFlagSoNbr() == 1) {      if (StringUtil.isBlank(soCharge.getSoNbr())) {             sql.append(" and SO_NBR is null ");          }      else{             sql.append(" and SO_NBR=:soNbr");             sql.setString("soNbr", soCharge.getSoNbr());          }   } if (soCharge.getFlagSts() == 1) {      if (StringUtil.isBlank(soCharge.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", soCharge.getSts());          }   } if (soCharge.getFlagStsDate() == 1) {      if (soCharge.getStsDate() == null) {             sql.append(" and STS_DATE is null ");          }      else{             sql.append(" and STS_DATE=:stsDate");             sql.setTimestamp("stsDate", soCharge.getStsDate());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           soCharge = new SoChargeSVO();           soCharge.setBankName(rs.getString("BANK_NAME"));           soCharge.setCharge(rs.getString("CHARGE"));           soCharge.setChargeCode(rs.getString("CHARGE_CODE"));           soCharge.setChargeName(rs.getString("CHARGE_NAME"));           soCharge.setExtSoNbr(rs.getString("EXT_SO_NBR"));           soCharge.setHomeBillFlag(rs.getString("HOME_BILL_FLAG"));           soCharge.setInvoiceId(rs.getString("INVOICE_ID"));           soCharge.setLocalNetId(rs.getString("LOCAL_NET_ID"));           soCharge.setNoFlag(rs.getString("NO_FLAG"));           soCharge.setPayFlag(rs.getString("PAY_FLAG"));           soCharge.setPayNbr(rs.getString("PAY_NBR"));           soCharge.setPayType(rs.getString("PAY_TYPE"));           soCharge.setReceiveId(rs.getString("RECEIVE_ID"));           soCharge.setSoChargeId(rs.getString("SO_CHARGE_ID"));           soCharge.setSoNbr(rs.getString("SO_NBR"));           soCharge.setSts(rs.getString("STS"));           soCharge.setStsDate(rs.getTimestamp("STS_DATE"));               res.add(soCharge);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       SoChargeSVO soCharge=(SoChargeSVO) vo;    if (StringUtil.isBlank(soCharge.getSoChargeId())) {       throw new AppException("100002", "缺少对象的主键！");      }    if (StringUtil.isBlank(soCharge.getSoNbr())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE SO_CHARGE SET ");     try {if (soCharge.getFlagBankName() == 1) {sql.append("BANK_NAME=:bankName,"); sql.setString("bankName", soCharge.getBankName()); } if (soCharge.getFlagCharge() == 1) {sql.append("CHARGE=:charge,");sql.setLong("charge", soCharge.getCharge()); } if (soCharge.getFlagChargeCode() == 1) {sql.append("CHARGE_CODE=:chargeCode,"); sql.setString("chargeCode", soCharge.getChargeCode()); } if (soCharge.getFlagChargeName() == 1) {sql.append("CHARGE_NAME=:chargeName,"); sql.setString("chargeName", soCharge.getChargeName()); } if (soCharge.getFlagExtSoNbr() == 1) {sql.append("EXT_SO_NBR=:extSoNbr,"); sql.setString("extSoNbr", soCharge.getExtSoNbr()); } if (soCharge.getFlagHomeBillFlag() == 1) {sql.append("HOME_BILL_FLAG=:homeBillFlag,"); sql.setString("homeBillFlag", soCharge.getHomeBillFlag()); } if (soCharge.getFlagInvoiceId() == 1) {sql.append("INVOICE_ID=:invoiceId,"); sql.setString("invoiceId", soCharge.getInvoiceId()); } if (soCharge.getFlagLocalNetId() == 1) {sql.append("LOCAL_NET_ID=:localNetId,");sql.setLong("localNetId", soCharge.getLocalNetId()); } if (soCharge.getFlagNoFlag() == 1) {sql.append("NO_FLAG=:noFlag,"); sql.setString("noFlag", soCharge.getNoFlag()); } if (soCharge.getFlagPayFlag() == 1) {sql.append("PAY_FLAG=:payFlag,"); sql.setString("payFlag", soCharge.getPayFlag()); } if (soCharge.getFlagPayNbr() == 1) {sql.append("PAY_NBR=:payNbr,"); sql.setString("payNbr", soCharge.getPayNbr()); } if (soCharge.getFlagPayType() == 1) {sql.append("PAY_TYPE=:payType,"); sql.setString("payType", soCharge.getPayType()); } if (soCharge.getFlagReceiveId() == 1) {sql.append("RECEIVE_ID=:receiveId,"); sql.setString("receiveId", soCharge.getReceiveId()); } if (soCharge.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", soCharge.getSts()); } if (soCharge.getFlagStsDate() == 1) {sql.append("STS_DATE=:stsDate,"); sql.setTimestamp("stsDate", soCharge.getStsDate()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and SO_CHARGE_ID=:soChargeId");sql.setLong("soChargeId", soCharge.getSoChargeId()); sql.append(" and SO_NBR=:soNbr");sql.setString("soNbr", soCharge.getSoNbr());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO SO_CHARGE(BANK_NAME,CHARGE,CHARGE_CODE,CHARGE_NAME,EXT_SO_NBR,HOME_BILL_FLAG,INVOICE_ID,LOCAL_NET_ID,NO_FLAG,PAY_FLAG,PAY_NBR,PAY_TYPE,RECEIVE_ID,SO_CHARGE_ID,SO_NBR,STS,STS_DATE)");sql.append(" VALUES (:bankName,:charge,:chargeCode,:chargeName,:extSoNbr,:homeBillFlag,:invoiceId,:localNetId,:noFlag,:payFlag,:payNbr,:payType,:receiveId,:soChargeId,:soNbr,:sts,:stsDate)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       SoChargeSVO soCharge=(SoChargeSVO) list.get(i);         if (soCharge== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(soCharge.getSoChargeId())) {       throw new AppException("100002", "缺少对象的主键！");      }    if (StringUtil.isBlank(soCharge.getSoNbr())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(soCharge.getBankName())) {      sql.setNullString("bankName");     } else {    sql.setString("bankName", soCharge.getBankName());    }       if (StringUtil.isBlank(soCharge.getCharge())) {      sql.setNullLong("charge");     } else {    sql.setLong("charge", soCharge.getCharge());    }       if (StringUtil.isBlank(soCharge.getChargeCode())) {      sql.setNullString("chargeCode");     } else {    sql.setString("chargeCode", soCharge.getChargeCode());    }       if (StringUtil.isBlank(soCharge.getChargeName())) {      sql.setNullString("chargeName");     } else {    sql.setString("chargeName", soCharge.getChargeName());    }       if (StringUtil.isBlank(soCharge.getExtSoNbr())) {      sql.setNullString("extSoNbr");     } else {    sql.setString("extSoNbr", soCharge.getExtSoNbr());    }       if (StringUtil.isBlank(soCharge.getHomeBillFlag())) {      sql.setNullString("homeBillFlag");     } else {    sql.setString("homeBillFlag", soCharge.getHomeBillFlag());    }       if (StringUtil.isBlank(soCharge.getInvoiceId())) {      sql.setNullString("invoiceId");     } else {    sql.setString("invoiceId", soCharge.getInvoiceId());    }       if (StringUtil.isBlank(soCharge.getLocalNetId())) {      sql.setNullLong("localNetId");     } else {    sql.setLong("localNetId", soCharge.getLocalNetId());    }       if (StringUtil.isBlank(soCharge.getNoFlag())) {      sql.setNullString("noFlag");     } else {    sql.setString("noFlag", soCharge.getNoFlag());    }       if (StringUtil.isBlank(soCharge.getPayFlag())) {      sql.setNullString("payFlag");     } else {    sql.setString("payFlag", soCharge.getPayFlag());    }       if (StringUtil.isBlank(soCharge.getPayNbr())) {      sql.setNullString("payNbr");     } else {    sql.setString("payNbr", soCharge.getPayNbr());    }       if (StringUtil.isBlank(soCharge.getPayType())) {      sql.setNullString("payType");     } else {    sql.setString("payType", soCharge.getPayType());    }       if (StringUtil.isBlank(soCharge.getReceiveId())) {      sql.setNullString("receiveId");     } else {    sql.setString("receiveId", soCharge.getReceiveId());    }       if (StringUtil.isBlank(soCharge.getSoChargeId())) {      sql.setNullLong("soChargeId");     } else {    sql.setLong("soChargeId", soCharge.getSoChargeId());    }       if (StringUtil.isBlank(soCharge.getSoNbr())) {      sql.setNullString("soNbr");     } else {    sql.setString("soNbr", soCharge.getSoNbr());    }       if (StringUtil.isBlank(soCharge.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", soCharge.getSts());    }    if (soCharge.getStsDate() == null) {      sql.setNullDate("stsDate");     } else {    sql.setTimestamp("stsDate", soCharge.getStsDate());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     SoChargeSVO soCharge=(SoChargeSVO) vo;    if (StringUtil.isBlank(soCharge.getSoChargeId())) {       throw new AppException("100002", "缺少对象的主键！");      }    if (StringUtil.isBlank(soCharge.getSoNbr())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM SO_CHARGE WHERE 1=1  ");sql.append(" and SO_CHARGE_ID=:soChargeId");sql.setLong("soChargeId", soCharge.getSoChargeId()); sql.append(" and SO_NBR=:soNbr");sql.setString("soNbr", soCharge.getSoNbr());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     SoChargeSVO soCharge=(SoChargeSVO) vo;       }}
