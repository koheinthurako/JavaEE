package entityServiceTest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import entityTest.Score;

public interface scoreServiceTest {

	public List<Score> getAll(Connection con) throws SQLException;

}
