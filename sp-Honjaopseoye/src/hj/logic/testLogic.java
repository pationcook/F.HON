package hj.logic;

import java.io.IOException;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hj.dao.MemberDao;

@Service
public class testLogic {
	Logger logger = Logger.getLogger(testLogic.class);
	@Autowired
	private MemberDao memberDao = null;//xml문서에 따로 name속성을 추가하지 않으므로 클래스 이름에 낙타표기법을 준수해야 됨.
	public void test(Map<String, Object> pMap) {
		logger.info("test호출 성공");
		try {
			memberDao.check(pMap);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
