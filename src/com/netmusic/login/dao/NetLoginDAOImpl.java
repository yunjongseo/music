package com.netmusic.login.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.member.vo.NetMemberVO;

@Repository
public class NetLoginDAOImpl implements NetLoginDAO {
	Logger logger = Logger.getLogger(NetLoginDAOImpl.class);

	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NetMemberVO> loginCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl loginCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("loginCheck", mvo);
	}

	@Override
	public List<NetMemberVO> idCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl idCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("idCheck", mvo);
	}

	@Override
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl pwIdCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("pwIdCheck", mvo);
	}

	@Override
	public int tempPwInsert(NetLoginVO lvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl tempPwInsert() 함수 진입 >>> :");
		
		return (Integer)sqlSession.insert("tempPwInsert", lvo);
	}

	@Override
	public int pwUpdate(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl pwUpdate() 함수 진입 >>> :");
		
		return (Integer)sqlSession.update("pwUpdate", mvo);
	}

}
