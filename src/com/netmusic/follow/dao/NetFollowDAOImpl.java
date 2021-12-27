package com.netmusic.follow.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netmusic.follow.vo.NetFollowVO;

@Repository
public class NetFollowDAOImpl implements NetFollowDAO {
	Logger logger = Logger.getLogger(NetFollowDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<NetFollowVO> followList(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followList() 진입 >>> : ");
		
		return sqlSession.selectList("followList", fvo);
	}
	
	@Override
	public List<NetFollowVO> followerList(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followerList() 진입 >>> : ");
		
		return sqlSession.selectList("followerList", fvo);
	}
	
	@Override
	public List<NetFollowVO> followcheck(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followcheck() 진입 >>> : ");
		
		return sqlSession.selectList("followcheck", fvo);
	}

	@Override
	public int followInsert(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followInsert() 진입 >>> : ");
		
		return (Integer)sqlSession.insert("followInsert", fvo);
	}

	@Override
	public int followerInsert(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followerInsert() 진입 >>> : ");
		
		return (Integer)sqlSession.insert("followerInsert", fvo);
	}

	@Override
	public int followDelete(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followDelete() 진입 >>> : ");
		
		return (Integer)sqlSession.delete("followDelete", fvo);
	}

	@Override
	public int followerDelete(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowDAOImpl followerDelete() 진입 >>> : ");
		
		return (Integer)sqlSession.delete("followerDelete", fvo);
	}
}
