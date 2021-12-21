package com.netmusic.login.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.login.dao.NetLoginDAO;
import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.member.vo.NetMemberVO;

@Service
@Transactional
public class NetLoginServiceImpl implements NetLoginService {
	Logger logger = Logger.getLogger(NetLoginServiceImpl.class);
	
	private NetLoginDAO netLoginDAO;
	
	@Autowired(required=false)
	public NetLoginServiceImpl(NetLoginDAO netLoginDAO) {
		this.netLoginDAO = netLoginDAO;
	}
	
	@Override
	public List<NetMemberVO> loginCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl loginCheck() 함수 진입 >>> :");
		
		return netLoginDAO.loginCheck(mvo);
	}
	
	@Override
	public List<NetMemberVO> idCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl idCheck() 함수 진입 >>> :");
		
		return netLoginDAO.idCheck(mvo);
	}

	@Override
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl pwIdCheck() 함수 진입 >>> :");
		
		return netLoginDAO.pwIdCheck(mvo);
	}

	@Override
	public int tempPwInsert(NetLoginVO lvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl tempPwInsert() 함수 진입 >>> :");
		
		return netLoginDAO.tempPwInsert(lvo);
	}

	@Override
	public int pwUpdate(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl pwUpdate() 함수 진입 >>> :");
		
		return netLoginDAO.pwUpdate(mvo);
	}
}
