package ch4;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImp implements UserDao{
	
	private JdbcOperations jdbcOperations;
	
	@Autowired
	public UserDaoImp(JdbcOperations jdbcOperations){
		this.jdbcOperations=jdbcOperations;
	}

	@Override
	public void insert(User user) {
		String sql="insert into user values(?,?,?,?,?)";
		//the first way
		jdbcOperations.update(sql, new Object[]{user.getUno(),
				user.getUname(),user.getPwd(),
				user.getTel(),user.getAddress()});
		
		//the another way
		jdbcOperations.update(sql, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setObject(1, user.getUno());
				pstmt.setObject(2, user.getUname());
				pstmt.setObject(3, user.getPwd());
				pstmt.setObject(4, user.getTel());
				pstmt.setObject(5, user.getAddress());
			}
		});
		
	}

	@Override
	public void removeByUno(int uno) {
		String sql="delete from user where uno ="+uno;
		jdbcOperations.update(sql);
	}

	@Override
	public void update(User user) {
		String sql="update user set uname=? where uno=?";
		jdbcOperations.update(sql, new PreparedStatementSetter(){
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setObject(1, user.getUname());
				pstmt.setObject(2, user.getUno());
			}
		});
	}

	@Override
	public User selectUserByUno(int uno) {
		String sql="select * from user where uno="+uno;
		
		Map<String, Object> users=jdbcOperations.queryForMap(sql);
		User user=new User((int)users.get("uno"), (String)users.get("uname"), 
				(String)users.get("pwd"), (int)users.get("tel"), (String)users.get("address"));
		return user;
	}

	@Override
	public List<User> selectAllUsers() {
		String sql="select * from user";
		List<User> users=jdbcOperations.query(sql, new RowMapper<User>(){
			@Override
			public User mapRow(ResultSet rs, int row) throws SQLException {
				User user=new User(rs.getInt(1), 
						rs.getString(2), rs.getString(3),
						rs.getInt(4), rs.getString(5));
				return user;
			}
		});
		return users;
	}
	
	
}
