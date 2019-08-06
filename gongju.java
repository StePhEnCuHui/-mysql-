package KS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class gongju {

	public static void zengjia(String JSBH,String JXLBH,String KJ,String SFSY,String RNRS) {
		try {
			Connection conn = Data.getConn();
			String sql1="insert into js values('"+JSBH+"','"+JXLBH+"','"+KJ+"','"+SFSY+"','"+RNRS+"')";
			PreparedStatement pstm=conn.prepareStatement(sql1);
			pstm.executeUpdate();
			pstm.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
