package edu.ssafy.hong.rest.dao;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.ssafy.hong.rest.dto.UserInfo;
@Repository
public class UserDao {
    @Autowired
    private SqlSession session;
    
    public int insert(UserInfo user) {
        return session.insert("user.insert", user);
    }
    public List<UserInfo> selectAll() {
        return session.selectList("user.selectAll");
    }
}