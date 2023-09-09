package bwy.stan.app;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import tby.user.dao.UserDao;
import tby.user.domain.User;

import java.sql.SQLException;

@SpringBootApplication
public class BwyApplication {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		//SpringApplication.run(BwyApplication.class, args);

		UserDao dao = new UserDao();

		User user = new User();
		user.setId("bwy12");
		user.setName("배원영");
		user.setPassword("1234");

		dao.add(user);
		System.out.println(user.getId() + " 가 등록 되었습니다.");

		User user2 = dao.get(user.getId());
		System.out.println(user2.getName());

		System.out.println(user2.getId() + " 조회 성공");
	}

}
