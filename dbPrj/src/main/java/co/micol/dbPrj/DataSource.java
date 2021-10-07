package co.micol.dbPrj;

import java.io.File;
import java.io.FileReader;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.sql.Connection;

public class DataSource {
	private String driver;		//사용할 jdbc 드라이버
	private String url;			//DBMS가 위치한 주소
	private String user;		//DB의 계정
	private String password;	//DB 접속계정의 패스워드
	
	public Connection conn;		//java에서 DBMS 연결하는 객체
	
	public DataSource() {
		getDbproperties();		//외부 properties를 읽어서와 내부 변수에 담는다. = 개발자들이 만들었다.
		try {
			Class.forName(driver);	// 내앱에 드라이버 설치.
			conn = DriverManager.getConnection(url,user,password);
			System.out.println("DB 연결 성공");
			
		}catch(ClassNotFoundException|SQLException e) {
			e.printStackTrace();
			System.out.println("DB 연결 실패");
		}
	}
	
	private void getDbproperties() {
		File path = new File("src/main/resources/db.properties");	//파일을 다루는 객체.
		Properties properties = new Properties();
		try {
			FileReader file = new FileReader(path);
			properties.load(file);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		}catch(Exception e) {
			e.printStackTrace();
		}
	
	}
}
