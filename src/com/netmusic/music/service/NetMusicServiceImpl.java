package com.netmusic.music.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.music.dao.NetMusicDAO;
import com.netmusic.music.vo.NetMusicVO;

@Service
@Transactional
public class NetMusicServiceImpl implements NetMusicService {
	Logger logger = Logger.getLogger(NetMusicServiceImpl.class);
	
	private NetMusicDAO netMusicDAO;
	
	@Autowired(required=false)
	public NetMusicServiceImpl(NetMusicDAO netMusicDAO) {
		this.netMusicDAO = netMusicDAO;
	}
	
	@Override
	public int musicInsert(NetMusicVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMusicServiceImpl musicInsert() 진입 >>> : ");
		
		return netMusicDAO.musicInsert(mvo);
	}

	@Override
	public List<NetMusicVO> musicSelectAll(NetMusicVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMusicServiceImpl musicSelectAll() 진입 >>> : ");
		
		return netMusicDAO.musicSelectAll(mvo);
	}

}
