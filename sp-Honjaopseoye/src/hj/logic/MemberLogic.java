package hj.logic;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hj.dao.MemberDao;

@Service
public class MemberLogic {
	Logger logger = Logger.getLogger(MemberLogic.class);
	
	@Autowired
	private MemberDao memberDao = null;
	
}
