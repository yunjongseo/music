package com.netmusic.login.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netmusic.login.vo.TempAuthNumVO;
import com.netmusic.login.vo.TempPwVO;
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
	public List<NetMemberVO> emailCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl emailCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("emailCheck", mvo);
	}

	@Override
	public int tempAuthNumInsert(TempAuthNumVO tvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl tempAuthNumInsert() 함수 진입 >>> :");
		
		return (Integer)sqlSession.insert("tempAuthNumInsert", tvo);
	}

	@Override
	public List<NetMemberVO> emailIdFind(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl emailIdFind() 함수 진입 >>> :");
		
		return sqlSession.selectList("emailIdFind", mvo);
	}

	@Override
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl pwIdCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("pwIdCheck", mvo);
	}

	@Override
	public List<NetMemberVO> pwEmailCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl pwEmailCheck() 함수 진입 >>> :");
		
		return sqlSession.selectList("pwEmailCheck", mvo);
	}

	@Override
	public int tempPwInsert(TempPwVO tvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl tempPwInsert() 함수 진입 >>> :");
		
		return (Integer)sqlSession.insert("tempPwInsert", tvo);
	}

	@Override
	public int pwUpdate(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginDAOImpl pwUpdate() 함수 진입 >>> :");
		
		return (Integer)sqlSession.update("pwUpdate", mvo);
	}

}
