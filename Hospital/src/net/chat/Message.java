package net.chat;

import java.text.SimpleDateFormat;
import java.sql.*;

public class Message {
	private String msgFrom; // ��Ϣ������
	private String msgTo; // ��Ϣ������
	private String msgContent;// ��������

	/**
	 * ��Ϣ������setMsgFrom���Ե�set����
	 */
	public void setMsgFrom(String msgFrom) {
		this.msgFrom = msgFrom;
	}

	/**
	 * ��Ϣ������setMsgTo���Ե�set����
	 */
	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	/**
	 * ��Ϣ����msgContent���Ե�set����
	 */
	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	/**
	 * ��message���󱣴浽���ݿ�msgInfo���еķ���
	 */
	public boolean saveToDataBase() throws SQLException, ClassNotFoundException {
		BaseConn conn = null;
		try {
			conn = new BaseConn();
			SimpleDateFormat cal = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String time = cal.format(new java.util.Date());
			String sql = "insert into message(msgFrom,msgTo,msgTime,msgContent) values(?,?,?,?)";
			PreparedStatement ps = conn.preparedStatement(sql);
			ps.setString(1, msgFrom);
			ps.setString(2, msgTo);
			ps.setString(3, time);
			ps.setString(4, msgContent);
			conn.executeUpdate();
			return true;
		} catch (SQLException ex) {
			ex.printStackTrace();
			throw ex;
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			throw ex;
		}
	}
}
