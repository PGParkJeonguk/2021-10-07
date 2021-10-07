package co.micol.dbPrj.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.micol.dbPrj.DataSource;

public class DevServicelmpl extends DataSource {
	private PreparedStatement psmt;
	private ResultSet rs;
	
//	public List<DevVo> selectList(){
//		DevVo vo;
//		List<DevVo> list = new ArrayList<DevVo>();
//		
//	}
	
	public void selectList() {
		String sql = "select * from dev";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("address"));
				System.out.println(rs.getInt("age"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
