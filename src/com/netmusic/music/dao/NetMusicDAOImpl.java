package com.netmusic.music.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.netmusic.music.vo.NetMusicVO;

@Repository
public class NetMusicDAOImpl implements NetMusicDAO {
	Logger logger = Logger.getLogger(NetMusicDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int musicInsert(NetMusicVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMusicDAOImpl musicInsert() 진입 >>> : ");
		
		return (Integer)sqlSession.insert("musicInsert", mvo);
	}

	@Override
	public List<NetMusicVO> musicSelectAll(NetMusicVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMusicDAOImpl musicSelectAll() 진입 >>> : ");
		
		return sqlSession.selectList("musicSelectAll", mvo);
	}

}
