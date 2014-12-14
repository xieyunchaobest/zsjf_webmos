package com.cattsoft.bm.component.dao.oracleImpl;import java.sql.Connection;import java.sql.PreparedStatement;import java.sql.ResultSet;import java.sql.SQLException;import java.util.ArrayList;import java.util.List;import org.apache.log4j.Logger;import com.cattsoft.bm.component.dao.INotifyTypeSDAO;import com.cattsoft.bm.vo.NotifyTypeSVO;import com.cattsoft.pub.SysConstants;import com.cattsoft.pub.connection.ConnectionFactory;import com.cattsoft.pub.dao.Sql;import com.cattsoft.pub.exception.AppException;import com.cattsoft.pub.exception.SysException;import com.cattsoft.pub.util.JdbcUtil;import com.cattsoft.pub.util.StringUtil;import com.cattsoft.pub.vo.GenericVO;/** * 方法NotifyTypeSDAOImpl * <p> * Company: 大唐软件 * </p> *  * @author ：白小亮。 * @version 1.1 2007-9-23 */public class NotifyTypeSDAOImpl implements INotifyTypeSDAO {	// private static Logger log = Logger.getLogger(NotifyTypeSDAOImpl.class);	// private static final String UNABLE_STS = "P";	/**	 * 增加。	 * 	 * @return String	 */	public void add(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;		if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql(				"INSERT INTO NOTIFY_TYPE(CALL_TYPE,CLASS_NAME,METHOD_NAME,NAME,NOTIFY_MODE,NOTIFY_TYPE_ID,REMARKS,STS,STS_DATE)");		sql				.append(" VALUES (:callType,:className,:methodName,:name,:notifyMode,:notifyTypeId,:remarks,:sts,:stsDate)");		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			if (StringUtil.isBlank(notifyType.getCallType())) {				sql.setNullString("callType");			} else {				sql.setString("callType", notifyType.getCallType());			}			if (StringUtil.isBlank(notifyType.getClassName())) {				sql.setNullString("className");			} else {				sql.setString("className", notifyType.getClassName());			}			if (StringUtil.isBlank(notifyType.getMethodName())) {				sql.setNullString("methodName");			} else {				sql.setString("methodName", notifyType.getMethodName());			}			if (StringUtil.isBlank(notifyType.getName())) {				sql.setNullString("name");			} else {				sql.setString("name", notifyType.getName());			}			if (StringUtil.isBlank(notifyType.getNotifyMode())) {				sql.setNullString("notifyMode");			} else {				sql.setString("notifyMode", notifyType.getNotifyMode());			}			if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {				sql.setNullLong("notifyTypeId");			} else {				sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());			}			if (StringUtil.isBlank(notifyType.getRemarks())) {				sql.setNullString("remarks");			} else {				sql.setString("remarks", notifyType.getRemarks());			}			if (StringUtil.isBlank(notifyType.getSts())) {				sql.setNullString("sts");			} else {				sql.setString("sts", notifyType.getSts());			}			if (notifyType.getStsDate() == null) {				sql.setNullDate("stsDate");			} else {				sql.setTimestamp("stsDate", notifyType.getStsDate());			}			sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 主键查询的SQL。	 * 	 * @return String ： 主键查询的SQL。	 */	public GenericVO findByPK(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;		if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Sql sql = new Sql(				"SELECT CALL_TYPE,CLASS_NAME,METHOD_NAME,NAME,NOTIFY_MODE,NOTIFY_TYPE_ID,REMARKS,STS,STS_DATE FROM NOTIFY_TYPE WHERE 1=1  ");		sql.append(" and NOTIFY_TYPE_ID=:notifyTypeId");		sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());		Connection conn = null;		PreparedStatement ps = null;		ResultSet rs = null;		notifyType = null;		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			sql.fillParams(ps);			sql.log(this.getClass());			rs = ps.executeQuery();			while (rs.next()) {				notifyType = new NotifyTypeSVO();				notifyType.setCallType(rs.getString("CALL_TYPE"));				notifyType.setClassName(rs.getString("CLASS_NAME"));				notifyType.setMethodName(rs.getString("METHOD_NAME"));				notifyType.setName(rs.getString("NAME"));				notifyType.setNotifyMode(rs.getString("NOTIFY_MODE"));				notifyType.setNotifyTypeId(rs.getString("NOTIFY_TYPE_ID"));				notifyType.setRemarks(rs.getString("REMARKS"));				notifyType.setSts(rs.getString("STS"));				notifyType.setStsDate(rs.getTimestamp("STS_DATE"));			}		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(rs, ps);		}		return notifyType;	}	/**	 * 批量查询的SQL。	 * 	 * @return String ： 批量查询的SQL。	 */	public List findByVO(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;		List res = new ArrayList();		Connection conn = null;		PreparedStatement ps = null;		ResultSet rs = null;		Sql sql = new Sql(				"SELECT CALL_TYPE,CLASS_NAME,METHOD_NAME,NAME,NOTIFY_MODE,NOTIFY_TYPE_ID,REMARKS,STS,STS_DATE FROM NOTIFY_TYPE WHERE 1=1 ");		try {			if (notifyType.getFlagCallType() == 1) {				if (StringUtil.isBlank(notifyType.getCallType())) {					sql.append(" and CALL_TYPE is null ");				} else {					sql.append(" and CALL_TYPE=:callType");					sql.setString("callType", notifyType.getCallType());				}			}			if (notifyType.getFlagClassName() == 1) {				if (StringUtil.isBlank(notifyType.getClassName())) {					sql.append(" and CLASS_NAME is null ");				} else {					sql.append(" and CLASS_NAME=:className");					sql.setString("className", notifyType.getClassName());				}			}			if (notifyType.getFlagMethodName() == 1) {				if (StringUtil.isBlank(notifyType.getMethodName())) {					sql.append(" and METHOD_NAME is null ");				} else {					sql.append(" and METHOD_NAME=:methodName");					sql.setString("methodName", notifyType.getMethodName());				}			}			if (notifyType.getFlagName() == 1) {				if (StringUtil.isBlank(notifyType.getName())) {					sql.append(" and NAME is null ");				} else {					sql.append(" and NAME=:name");					sql.setString("name", notifyType.getName());				}			}			if (notifyType.getFlagNotifyMode() == 1) {				if (StringUtil.isBlank(notifyType.getNotifyMode())) {					sql.append(" and NOTIFY_MODE is null ");				} else {					sql.append(" and NOTIFY_MODE=:notifyMode");					sql.setString("notifyMode", notifyType.getNotifyMode());				}			}			if (notifyType.getFlagNotifyTypeId() == 1) {				if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {					sql.append(" and NOTIFY_TYPE_ID is null ");				} else {					sql.append(" and NOTIFY_TYPE_ID=:notifyTypeId");					sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());				}			}			if (notifyType.getFlagRemarks() == 1) {				if (StringUtil.isBlank(notifyType.getRemarks())) {					sql.append(" and REMARKS is null ");				} else {					sql.append(" and REMARKS=:remarks");					sql.setString("remarks", notifyType.getRemarks());				}			}			if (notifyType.getFlagSts() == 1) {				if (StringUtil.isBlank(notifyType.getSts())) {					sql.append(" and STS is null ");				} else {					sql.append(" and STS=:sts");					sql.setString("sts", notifyType.getSts());				}			}			if (notifyType.getFlagStsDate() == 1) {				if (notifyType.getStsDate() == null) {					sql.append(" and STS_DATE is null ");				} else {					sql.append(" and STS_DATE=:stsDate");					sql.setTimestamp("stsDate", notifyType.getStsDate());				}			}			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			ps = sql.fillParams(ps);			sql.log(this.getClass());			rs = ps.executeQuery();			while (rs.next()) {				notifyType = new NotifyTypeSVO();				notifyType.setCallType(rs.getString("CALL_TYPE"));				notifyType.setClassName(rs.getString("CLASS_NAME"));				notifyType.setMethodName(rs.getString("METHOD_NAME"));				notifyType.setName(rs.getString("NAME"));				notifyType.setNotifyMode(rs.getString("NOTIFY_MODE"));				notifyType.setNotifyTypeId(rs.getString("NOTIFY_TYPE_ID"));				notifyType.setRemarks(rs.getString("REMARKS"));				notifyType.setSts(rs.getString("STS"));				notifyType.setStsDate(rs.getTimestamp("STS_DATE"));				res.add(notifyType);			}		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(rs, ps);		}		if (0 == res.size())			res = null;		return res;	}	/**	 * 更新的SQL。	 * 	 * @return String ： 更新的SQL。	 */	public void update(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;		if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql("UPDATE NOTIFY_TYPE SET ");		try {			if (notifyType.getFlagCallType() == 1) {				sql.append("CALL_TYPE=:callType,");				sql.setString("callType", notifyType.getCallType());			}			if (notifyType.getFlagClassName() == 1) {				sql.append("CLASS_NAME=:className,");				sql.setString("className", notifyType.getClassName());			}			if (notifyType.getFlagMethodName() == 1) {				sql.append("METHOD_NAME=:methodName,");				sql.setString("methodName", notifyType.getMethodName());			}			if (notifyType.getFlagName() == 1) {				sql.append("NAME=:name,");				sql.setString("name", notifyType.getName());			}			if (notifyType.getFlagNotifyMode() == 1) {				sql.append("NOTIFY_MODE=:notifyMode,");				sql.setString("notifyMode", notifyType.getNotifyMode());			}			if (notifyType.getFlagRemarks() == 1) {				sql.append("REMARKS=:remarks,");				sql.setString("remarks", notifyType.getRemarks());			}			if (notifyType.getFlagSts() == 1) {				sql.append("STS=:sts,");				sql.setString("sts", notifyType.getSts());			}			if (notifyType.getFlagStsDate() == 1) {				sql.append("STS_DATE=:stsDate,");				sql.setTimestamp("stsDate", notifyType.getStsDate());			}			sql.removeSuffix(1);			sql.append(" WHERE 1=1 ");			sql.append(" and NOTIFY_TYPE_ID=:notifyTypeId");			sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			ps = sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 批量增加记录。	 * 	 * @return String ： 批量增加的SQL。	 */	public void addBat(List list) throws AppException, SysException {		if (list == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql(				"INSERT INTO NOTIFY_TYPE(CALL_TYPE,CLASS_NAME,METHOD_NAME,NAME,NOTIFY_MODE,NOTIFY_TYPE_ID,REMARKS,STS,STS_DATE)");		sql				.append(" VALUES (:callType,:className,:methodName,:name,:notifyMode,:notifyTypeId,:remarks,:sts,:stsDate)");		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			for (int i = 0; i < list.size(); i++) {				NotifyTypeSVO notifyType = (NotifyTypeSVO) list.get(i);				if (notifyType == null) {					throw new AppException("100001", "缺少DAO操作对象！");				}				if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {					throw new AppException("100002", "缺少对象的主键！");				}				if (StringUtil.isBlank(notifyType.getCallType())) {					sql.setNullString("callType");				} else {					sql.setString("callType", notifyType.getCallType());				}				if (StringUtil.isBlank(notifyType.getClassName())) {					sql.setNullString("className");				} else {					sql.setString("className", notifyType.getClassName());				}				if (StringUtil.isBlank(notifyType.getMethodName())) {					sql.setNullString("methodName");				} else {					sql.setString("methodName", notifyType.getMethodName());				}				if (StringUtil.isBlank(notifyType.getName())) {					sql.setNullString("name");				} else {					sql.setString("name", notifyType.getName());				}				if (StringUtil.isBlank(notifyType.getNotifyMode())) {					sql.setNullString("notifyMode");				} else {					sql.setString("notifyMode", notifyType.getNotifyMode());				}				if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {					sql.setNullLong("notifyTypeId");				} else {					sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());				}				if (StringUtil.isBlank(notifyType.getRemarks())) {					sql.setNullString("remarks");				} else {					sql.setString("remarks", notifyType.getRemarks());				}				if (StringUtil.isBlank(notifyType.getSts())) {					sql.setNullString("sts");				} else {					sql.setString("sts", notifyType.getSts());				}				if (notifyType.getStsDate() == null) {					sql.setNullDate("stsDate");				} else {					sql.setTimestamp("stsDate", notifyType.getStsDate());				}				sql.fillParams(ps);				sql.log(this.getClass());				sql.clearParameters();				ps.addBatch();			}			ps.executeBatch();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 根据传入参数删除一条或者一批记录。	 * 	 * @return String ： 删除的SQL。	 */	public void delete(GenericVO vo) throws AppException, SysException {		if (vo == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;		if (StringUtil.isBlank(notifyType.getNotifyTypeId())) {			throw new AppException("100002", "缺少对象的主键！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql("DELETE FROM NOTIFY_TYPE WHERE 1=1  ");		sql.append(" and NOTIFY_TYPE_ID=:notifyTypeId");		sql.setLong("notifyTypeId", notifyType.getNotifyTypeId());		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			sql.fillParams(ps);			sql.log(this.getClass());			ps.executeUpdate();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}	/**	 * 注销一条或者一批	 * 	 * @return String ： 注销一条或者一批的SQL。	 */	public void unable(GenericVO vo) throws AppException, SysException {		NotifyTypeSVO notifyType = (NotifyTypeSVO) vo;	}	public void disableBat(List voList) throws AppException, SysException {		if (voList == null) {			throw new AppException("100001", "缺少DAO操作对象！");		}		Connection conn = null;		PreparedStatement ps = null;		Sql sql = new Sql("UPDATE NOTIFY_TYPE SET ");		sql.append(" STS='");		sql.append(SysConstants.USE_NO_STS);		sql.append("' WHERE 1=1  ");		sql.append(" and NOTIFY_TYPE_ID=:notifyTypeId");		try {			conn = ConnectionFactory.getConnection();			ps = conn.prepareStatement(sql.getSql());			for (int i = 0; i < voList.size(); i++) {				NotifyTypeSVO notifyTypeSVO = (NotifyTypeSVO) (voList.get(i));				if (StringUtil.isBlank(notifyTypeSVO.getNotifyTypeId())) {					throw new AppException("100002", "缺少对象的主键！");				}				sql.setString("notifyTypeId", notifyTypeSVO.getNotifyTypeId());				ps = sql.fillParams(ps);				sql.log(this.getClass());				sql.clearParameters();				ps.addBatch();			}			ps.executeBatch();		} catch (SQLException se) {			throw new SysException("100003", "JDBC操作异常！", se);		} finally {			JdbcUtil.close(ps);		}	}}