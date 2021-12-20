package com.netmusic.member.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netmusic.main.vo.NetMainVO;
import com.netmusic.member.vo.NetFollowVO;
import com.netmusic.member.vo.NetMemberVO;

@Repository
public class NetMemberDAOImpl implements NetMemberDAO {
	Logger logger = Logger.getLogger(NetMemberDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;

	@Override
	public int memberInsert(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberDAOImpl memberInsert() 진입 >>> : ");
		
		return (Integer)sqlSession.insert("memberInsert", mvo);
	}

	@Override
	public List<NetMemberVO> memberSelectAll(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberDAOImpl memberSelectAll() 진입 >>> : ");
		
		return sqlSession.selectList("memberSelectAll", mvo);
	}
	
	@Override
	public List<NetMemberVO> memberSelect(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberDAOImpl memberSelect() 진입 >>> : ");
		
		return sqlSession.selectList("memberSelect", mvo);
	}
	
	@Override
	public List<NetFollowVO> memFollowSelect(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberDAOImpl memFollowSelect() 진입 >>> : ");
		
		return sqlSession.selectList("memFollowSelect", fvo);
	}
	
	@Override
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberDAOImpl memberIdCheck() 진입 >>> : ");
		
		return sqlSession.selectList("memberIdCheck", mvo);
	}
}
