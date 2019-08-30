package MMA;

import java.util.Date;
import java.util.List;

import Test.Detail;

public interface DetailDao {
	public Detail selectDetailByDno(int dno);
	public List<Detail> selecAllDetails();
	public Date selectTime();
	public java.sql.Date selectSQLTime();
}
