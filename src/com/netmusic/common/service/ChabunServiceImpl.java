package com.netmusic.common.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.common.dao.ChabunDAO;
import com.netmusic.member.vo.NetMemberVO;
import com.netmusic.music.vo.NetMusicVO;

@Service
@Transactional
public class ChabunServiceImpl implements ChabunService {
	private Logger logger = Logger.getLogger(ChabunServiceImpl.class);
	
	private ChabunDAO chabunDAO;
	
	@Autowired(required=false)
	public ChabunServiceImpl(ChabunDAO chabunDAO) {
		this.chabunDAO = chabunDAO;
	}

	@Override
	public NetMemberVO getMemChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getMemChabun() 진입 >>> : ");
		return chabunDAO.getMemChabun();
	}

	@Override
	public NetMusicVO getMusicChabun() {
		// TODO Auto-generated method stub
		logger.info("ChabunServiceImpl getMusicChabun() 진입 >>> : ");
		
		return chabunDAO.getMusicChabun();
	}

}
