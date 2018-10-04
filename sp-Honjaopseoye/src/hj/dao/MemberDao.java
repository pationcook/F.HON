package hj.dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

public class MemberDao {
	Logger logger = Logger.getLogger(MemberDao.class);

	private SqlSessionTemplate sqlSessionTemplate;
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}

/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[아이디 중복 체크]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
	public int id_sel(String pMap) {
		logger.info("id_sel 호출 성공");
		logger.info(pMap);
		int result = 0;
		result = sqlSessionTemplate.selectOne("id_sel", pMap);
		logger.info("result: " + result);
		return result;
	}

/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[비밀번호 중복 체크]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
	public int tel_sel(String pMap) {
		logger.info("tel_sel 호출 성공");
		int result = 0;
		result = sqlSessionTemplate.selectOne("tel_sel", pMap);
		return result;
	}

	public int insert(Map<String, Object> pMap) {
		/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[트리거 사용]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
		int result = 0;
		result = sqlSessionTemplate.insert("join", pMap);
		//result = sqlSessionTemplate.insert("grade", pMap);
		logger.info(result);
		return result;
	}

/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[주소록 호출]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
	public List<Map<String, Object>> doselect(Map<String, Object> pMap) {
		logger.info("doselect 호출 성공");
		List<Map<String, Object>> list = null;
		list = sqlSessionTemplate.selectList("doselect", pMap);
		return list;
	}
	public List<Map<String, Object>> siSelect(Map<String, Object> pMap) {
		logger.info("siselect 호출 성공");
		List<Map<String, Object>> list = null;
		list = sqlSessionTemplate.selectList("siselect", pMap);
		logger.info(list);
		return list;
	}
	public List<Map<String, Object>> dongSelect(Map<String, Object> pMap) {
		logger.info("dongselect 호출 성공");
		List<Map<String, Object>> list = null;
		list = sqlSessionTemplate.selectList("dongselect", pMap);
		logger.info(list);
		return list;
	}
	public List<Map<String, Object>> detailSelect(Map<String, Object> pMap) {
		logger.info("상세주소 호출 성공");
		List<Map<String, Object>> list = null;
		list = sqlSessionTemplate.selectList("detailselect", pMap);
		logger.info(list);
		return list;
	}

/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[회원 정보 수정]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
	public int update(Map<String, Object> pMap) {
		int result = 0;
		result = sqlSessionTemplate.delete("update", pMap);
		logger.info("result : " + result);
		return result;
	}

/*[[[[[[[[[[[[[[[[[[[[[[[[[[[[[[ ]]]]]]]]]]]]]]]]]]]]]]]]]]]]]]*/
	public int delete(Map<String, Object> pMap) throws IOException {
		logger.info("delete 호출성공");
		int result = 0;
		result = sqlSessionTemplate.delete("delete", pMap);
		logger.info("result : " + result);
		return result;
	}

	public List<Map<String, Object>> select(Map<String, Object> pMap) throws IOException {
		logger.info(pMap);
		logger.info("mdao : select 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		List<Map<String, Object>> memberList = null;
		memberList = sqlSessionTemplate.selectList("membermap.select", pMap);
		return memberList;
	}

	public String login(Map<String, Object> pMap) throws IOException {
		String result = "";
		logger.info(pMap);
		logger.info("mdao : login 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		result = sqlSessionTemplate.selectOne("membermap.login", pMap);
		logger.info(result);

		return result;
	}

	public String check(Map<String, Object> pMap) throws IOException {
		String result = "";
		logger.info("check" + pMap);
		logger.info("mdao : check 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		result = sqlSessionTemplate.selectOne("membermap.check", pMap);
		logger.info("result占쎈뮉" + result);

		return result;
	}

	public String check2(Map<String, Object> pMap) throws IOException {
		String result = "";
		logger.info("check2" + pMap);
		logger.info("mdao : check 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		result = sqlSessionTemplate.selectOne("membermap.check2", pMap);
		logger.info("result占쎈뮉" + result);

		return result;
	}

	public List<Map<String, Object>> idSearch(Map<String, Object> pMap) throws IOException {
		logger.info("idSearch:" + pMap);
		logger.info(pMap.get("ins_name"));
		logger.info(pMap.get("mem_tel"));
		List<Map<String, Object>> idSearch = null;
		idSearch = sqlSessionTemplate.selectList("idSearch", pMap);
		// String user_pw = idSearch.get(0).get("mem_pw").toString();
		logger.info("idSearch : " + idSearch);
		return idSearch;
	}

	public List<Map<String, Object>> e_idSearch(Map<String, Object> pMap) throws IOException {
		logger.info("e_idSearch:" + pMap);
		List<Map<String, Object>> e_idSearch = null;
		logger.info(pMap.get("e_name"));
		logger.info(pMap.get("e_mail"));
		e_idSearch = sqlSessionTemplate.selectList("e_idSearch", pMap);
		logger.info("e_idSearch : " + e_idSearch);
		return e_idSearch;
	}

	public String pwCheck(Map<String, Object> pMap) throws IOException {
		String result = "";
		logger.info("pwCheck" + pMap);
		logger.info("mdao : pwCheck 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		result = sqlSessionTemplate.selectOne("membermap.pwCheck", pMap);
		logger.info("result占쎈뮉" + result);

		return result;
	}

	public String pwCheck2(Map<String, Object> pMap) throws IOException {
		String result = "";
		logger.info("pwCheck2" + pMap);
		logger.info("mdao : pwCheck2 筌롫뗄�꺖占쎈굡 占쎌깈�빊占� 占쎄쉐�⑨옙");
		result = sqlSessionTemplate.selectOne("membermap.pwCheck2", pMap);
		logger.info("result占쎈뮉" + result);

		return result;
	}

	public List<Map<String, Object>> pwSearch(Map<String, Object> pMap) throws IOException {
		logger.info("pwSearch:" + pMap);
		logger.info(pMap.get("mem_id"));
		logger.info(pMap.get("mem_tel"));
		List<Map<String, Object>> pwSearch = null;
		pwSearch = sqlSessionTemplate.selectList("pwSearch", pMap);
		// String user_pw = idSearch.get(0).get("mem_pw").toString();
		logger.info("pwSearch : " + pwSearch);
		return pwSearch;
	}

	public List<Map<String, Object>> e_pwSearch(Map<String, Object> pMap) throws IOException {
		logger.info("e_pwSearch:" + pMap);
		List<Map<String, Object>> e_pwSearch = null;
		logger.info(pMap.get("e_id"));
		logger.info(pMap.get("e_mail"));
		e_pwSearch = sqlSessionTemplate.selectList("e_pwSearch", pMap);
		logger.info("e_idSearch : " + e_pwSearch);
		return e_pwSearch;
	}
	
	public List<Map<String, Object>> getMemberList(Map<String, Object> pMap) throws IOException {
		logger.info("getMemberList:" + pMap);
		List<Map<String, Object>> getMemberList = null;
		logger.info(pMap.get("mem_id"));
		getMemberList = sqlSessionTemplate.selectList("getMemberList", pMap);
		logger.info("e_idSearch : " + getMemberList);
		return getMemberList;
	}

	public static void main(String[] args) throws IOException {
			   MemberDao md = new MemberDao();
			   Map<String, Object> pMap = new HashMap<String,Object>();
			   pMap.put("mem_id", "test1");
			   pMap.put("mem_pw", "123");
			   String id = "test1";
			   System.out.println(md.id_sel(id));
			   //System.out.println(md.getMemberList(pMap));
		}
}
