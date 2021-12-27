package com.netmusic.follow.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.follow.dao.NetFollowDAO;
import com.netmusic.follow.vo.NetFollowVO;

@Service
@Transactional
public class NetFollowServiceImpl implements NetFollowService {
	Logger logger = Logger.getLogger(NetFollowServiceImpl.class);
	
	private NetFollowDAO netFollowDAO;
	
	@Autowired(required=false)
	public NetFollowServiceImpl(NetFollowDAO netFollowDAO) {
		this.netFollowDAO = netFollowDAO;
	}
	
	@Override
	public List<NetFollowVO> followList(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followList() 진입 >>> : ");
		
		return netFollowDAO.followList(fvo);
	}
	
	@Override
	public List<NetFollowVO> followerList(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followerList() 진입 >>> : ");
		
		return netFollowDAO.followerList(fvo);
	}

	@Override
	public List<NetFollowVO> followcheck(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followcheck() 진입 >>> : ");
		
		return netFollowDAO.followcheck(fvo);
	}
	
	@Override
	public int followInsert(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followInsert() 진입 >>> : ");
		
		return netFollowDAO.followInsert(fvo);
	}
	
	@Override
	public int followerInsert(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followerInsert() 진입 >>> : ");
		
		return netFollowDAO.followerInsert(fvo);
	}

	@Override
	public int followDelete(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followDelete() 진입 >>> : ");
		
		return netFollowDAO.followDelete(fvo);
	}

	@Override
	public int followerDelete(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetFollowServiceImpl followerDelete() 진입 >>> : ");
		
		return netFollowDAO.followerDelete(fvo);
	}
}
