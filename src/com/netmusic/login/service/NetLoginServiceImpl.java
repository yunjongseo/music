package com.netmusic.login.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.login.dao.NetLoginDAO;
import com.netmusic.login.vo.NetLoginVO;
import com.netmusic.login.vo.TempAuthNumVO;
import com.netmusic.login.vo.TempPwVO;
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
	public List<NetLoginVO> loginCheck(NetLoginVO lvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl loginCheck() 함수 진입 >>> :");
		
		return netLoginDAO.loginCheck(lvo);
	}
	
	@Override
	public List<NetMemberVO> emailCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl emailCheck() 함수 진입 >>> :");
		
		return netLoginDAO.emailCheck(mvo);
	}

	@Override
	public int tempAuthNumInsert(TempAuthNumVO tvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl tempAuthNumInsert() 함수 진입 >>> :");
		
		return netLoginDAO.tempAuthNumInsert(tvo);
	}

	@Override
	public List<NetMemberVO> emailIdFind(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl emailIdFind() 함수 진입 >>> :");
		
		return netLoginDAO.emailIdFind(mvo);
	}

	@Override
	public List<NetMemberVO> pwIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl pwIdCheck() 함수 진입 >>> :");
		
		return netLoginDAO.pwIdCheck(mvo);
	}

	@Override
	public List<NetMemberVO> pwEmailCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl pwEmailCheck() 함수 진입 >>> :");
		
		return netLoginDAO.pwEmailCheck(mvo);
	}

	@Override
	public int tempPwInsert(TempPwVO tvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl tempPwInsert() 함수 진입 >>> :");
		
		return netLoginDAO.tempPwInsert(tvo);
	}

	@Override
	public int pwUpdate(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetLoginServiceImpl pwUpdate() 함수 진입 >>> :");
		
		return netLoginDAO.pwUpdate(mvo);
	}
}
