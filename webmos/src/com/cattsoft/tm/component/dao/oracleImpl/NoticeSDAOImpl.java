package com.cattsoft.tm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.List;import java.util.ArrayList;import org.apache.log4j.Logger;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.tm.component.dao.INoticeSDAO;import com.cattsoft.tm.vo.NoticeSVO;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.vo.GenericVO;import com.cattsoft.pub.util.StringUtil; /**   * 方法NoticeSDAOImpl   * <p>Company: 大唐软件</p>   * @author ：白小亮。   * @version 1.1  2007-9-23  */public class NoticeSDAOImpl implements INoticeSDAO{    private static Logger log = Logger.getLogger(NoticeSDAOImpl.class);    private static final String UNABLE_STS = "P";  /**   * 增加。   * @return String  */ public void add(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     NoticeSVO notice=(NoticeSVO) vo;    if (StringUtil.isBlank(notice.getNoticeId())) {       throw new AppException("100002", "缺少对象的主键！");      }      Connection conn = null;      PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO NOTICE(CONTENT,CREATE_TIME,NOTICE_ID,RELEASE_PERSON,STS,TITLE)");sql.append(" VALUES (:content,:createTime,:noticeId,:releasePerson,:sts,:title)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());      if (StringUtil.isBlank(notice.getContent())) {      sql.setNullString("content");     } else {    sql.setString("content", notice.getContent());    }    if (notice.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", notice.getCreateTime());    }       if (StringUtil.isBlank(notice.getNoticeId())) {      sql.setNullLong("noticeId");     } else {    sql.setLong("noticeId", notice.getNoticeId());    }       if (StringUtil.isBlank(notice.getReleasePerson())) {      sql.setNullString("releasePerson");     } else {    sql.setString("releasePerson", notice.getReleasePerson());    }       if (StringUtil.isBlank(notice.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", notice.getSts());    }       if (StringUtil.isBlank(notice.getTitle())) {      sql.setNullString("title");     } else {    sql.setString("title", notice.getTitle());    }            sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 主键查询的SQL。   * @return String ： 主键查询的SQL。  */ public GenericVO findByPK(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     NoticeSVO notice=(NoticeSVO) vo;    if (StringUtil.isBlank(notice.getNoticeId())) {       throw new AppException("100002", "缺少对象的主键！");      }       Sql sql = new Sql("SELECT CONTENT,CREATE_TIME,NOTICE_ID,RELEASE_PERSON,STS,TITLE FROM NOTICE WHERE 1=1  ");sql.append(" and NOTICE_ID=:noticeId");sql.setLong("noticeId", notice.getNoticeId());       Connection conn = null;      PreparedStatement ps = null;      ResultSet rs = null;      notice =null;      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();            while (rs.next()) {           notice = new NoticeSVO();           notice.setContent(rs.getString("CONTENT"));           notice.setCreateTime(rs.getTimestamp("CREATE_TIME"));           notice.setNoticeId(rs.getString("NOTICE_ID"));           notice.setReleasePerson(rs.getString("RELEASE_PERSON"));           notice.setSts(rs.getString("STS"));           notice.setTitle(rs.getString("TITLE"));                 }           } catch (SQLException se) {             throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(rs,ps);           }           return notice;         } /**   * 批量查询的SQL。   * @return String ： 批量查询的SQL。  */ public List findByVO(GenericVO vo) throws AppException, SysException{         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       NoticeSVO notice=(NoticeSVO) vo;          List res = new ArrayList();          Connection conn = null;          PreparedStatement ps = null;          ResultSet rs = null;          Sql sql = new Sql("SELECT CONTENT,CREATE_TIME,NOTICE_ID,RELEASE_PERSON,STS,TITLE FROM NOTICE WHERE 1=1 ");     try {if (notice.getFlagContent() == 1) {      if (StringUtil.isBlank(notice.getContent())) {             sql.append(" and CONTENT is null ");          }      else{             sql.append(" and CONTENT=:content");             sql.setString("content", notice.getContent());          }   } if (notice.getFlagCreateTime() == 1) {      if (notice.getCreateTime() == null) {             sql.append(" and CREATE_TIME is null ");          }      else{             sql.append(" and CREATE_TIME=:createTime");             sql.setTimestamp("createTime", notice.getCreateTime());          }   } if (notice.getFlagNoticeId() == 1) {      if (StringUtil.isBlank(notice.getNoticeId())) {             sql.append(" and NOTICE_ID is null ");          }      else{             sql.append(" and NOTICE_ID=:noticeId");             sql.setLong("noticeId", notice.getNoticeId());          }   } if (notice.getFlagReleasePerson() == 1) {      if (StringUtil.isBlank(notice.getReleasePerson())) {             sql.append(" and RELEASE_PERSON is null ");          }      else{             sql.append(" and RELEASE_PERSON=:releasePerson");             sql.setString("releasePerson", notice.getReleasePerson());          }   } if (notice.getFlagSts() == 1) {      if (StringUtil.isBlank(notice.getSts())) {             sql.append(" and STS is null ");          }      else{             sql.append(" and STS=:sts");             sql.setString("sts", notice.getSts());          }   } if (notice.getFlagTitle() == 1) {      if (StringUtil.isBlank(notice.getTitle())) {             sql.append(" and TITLE is null ");          }      else{             sql.append(" and TITLE=:title");             sql.setString("title", notice.getTitle());          }   }            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           rs = ps.executeQuery();                    while (rs.next()) {           notice = new NoticeSVO();           notice.setContent(rs.getString("CONTENT"));           notice.setCreateTime(rs.getTimestamp("CREATE_TIME"));           notice.setNoticeId(rs.getString("NOTICE_ID"));           notice.setReleasePerson(rs.getString("RELEASE_PERSON"));           notice.setSts(rs.getString("STS"));           notice.setTitle(rs.getString("TITLE"));               res.add(notice);                            }          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(rs,ps);               }                         if(0 == res.size()) res = null;          return res;   } /**   * 更新的SQL。   * @return String ： 更新的SQL。  */ public void update(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }       NoticeSVO notice=(NoticeSVO) vo;    if (StringUtil.isBlank(notice.getNoticeId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;          Sql sql = new Sql("UPDATE NOTICE SET ");     try {if (notice.getFlagContent() == 1) {sql.append("CONTENT=:content,"); sql.setString("content", notice.getContent()); } if (notice.getFlagCreateTime() == 1) {sql.append("CREATE_TIME=:createTime,"); sql.setTimestamp("createTime", notice.getCreateTime()); } if (notice.getFlagReleasePerson() == 1) {sql.append("RELEASE_PERSON=:releasePerson,"); sql.setString("releasePerson", notice.getReleasePerson()); } if (notice.getFlagSts() == 1) {sql.append("STS=:sts,"); sql.setString("sts", notice.getSts()); } if (notice.getFlagTitle() == 1) {sql.append("TITLE=:title,"); sql.setString("title", notice.getTitle()); }            	sql.removeSuffix(1); sql.append(" WHERE 1=1 ");sql.append(" and NOTICE_ID=:noticeId");sql.setLong("noticeId", notice.getNoticeId());            conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           ps = sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();                    } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);            } finally {                JdbcUtil.close(ps);               }                  } /**   * 批量增加记录。   * @return String ： 批量增加的SQL。  */ public void addBat(List list)throws AppException, SysException {     if (list == null) {     throw new AppException("100001", "缺少DAO操作对象！");           }          Connection conn = null;          PreparedStatement ps = null;Sql sql = new Sql("INSERT INTO NOTICE(CONTENT,CREATE_TIME,NOTICE_ID,RELEASE_PERSON,STS,TITLE)");sql.append(" VALUES (:content,:createTime,:noticeId,:releasePerson,:sts,:title)");      try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());    for(int i=0;i<list.size();i++){       NoticeSVO notice=(NoticeSVO) list.get(i);         if (notice== null) {         throw new AppException("100001", "缺少DAO操作对象！");       }    if (StringUtil.isBlank(notice.getNoticeId())) {       throw new AppException("100002", "缺少对象的主键！");      }      if (StringUtil.isBlank(notice.getContent())) {      sql.setNullString("content");     } else {    sql.setString("content", notice.getContent());    }    if (notice.getCreateTime() == null) {      sql.setNullDate("createTime");     } else {    sql.setTimestamp("createTime", notice.getCreateTime());    }       if (StringUtil.isBlank(notice.getNoticeId())) {      sql.setNullLong("noticeId");     } else {    sql.setLong("noticeId", notice.getNoticeId());    }       if (StringUtil.isBlank(notice.getReleasePerson())) {      sql.setNullString("releasePerson");     } else {    sql.setString("releasePerson", notice.getReleasePerson());    }       if (StringUtil.isBlank(notice.getSts())) {      sql.setNullString("sts");     } else {    sql.setString("sts", notice.getSts());    }       if (StringUtil.isBlank(notice.getTitle())) {      sql.setNullString("title");     } else {    sql.setString("title", notice.getTitle());    }            sql.fillParams(ps);           sql.log(this.getClass());           sql.clearParameters();           ps.addBatch();           }                  ps.executeBatch();          } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);           } finally {                    JdbcUtil.close(ps);           }  } /**   * 根据传入参数删除一条或者一批记录。   * @return String ： 删除的SQL。  */ public void delete(GenericVO vo)throws AppException, SysException {         if (vo== null) {         throw new AppException("100001", "缺少DAO操作对象！");        }     NoticeSVO notice=(NoticeSVO) vo;    if (StringUtil.isBlank(notice.getNoticeId())) {       throw new AppException("100002", "缺少对象的主键！");      }          Connection conn = null;          PreparedStatement ps = null;       Sql sql = new Sql("DELETE FROM NOTICE WHERE 1=1  ");sql.append(" and NOTICE_ID=:noticeId");sql.setLong("noticeId", notice.getNoticeId());       try {           conn = ConnectionFactory.getConnection();           ps = conn.prepareStatement(sql.getSql());           sql.fillParams(ps);           sql.log(this.getClass());           ps.executeUpdate();            } catch (SQLException se) {           throw new SysException("100003", "JDBC操作异常！", se);                      } finally {                    JdbcUtil.close(ps);           }         } /**   * 注销一条或者一批   * @return String ： 注销一条或者一批的SQL。  */ public void unable(GenericVO vo)throws AppException, SysException {     NoticeSVO notice=(NoticeSVO) vo;       }}
