package com.netmusic.member.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.main.vo.NetMainVO;
import com.netmusic.member.dao.NetMemberDAO;
import com.netmusic.member.vo.NetFollowVO;
import com.netmusic.member.vo.NetMemberVO;

@Service
@Transactional
public class NetMemberServiceImpl implements NetMemberService {
	Logger logger = Logger.getLogger(NetMemberServiceImpl.class);
	
	private NetMemberDAO netMemberDAO;
	
	@Autowired(required=false)
	public NetMemberServiceImpl(NetMemberDAO netMemberDAO) {
		this.netMemberDAO = netMemberDAO;
	}
	
	@Override
	public int memberInsert(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberServiceImpl memberInsert() 진입 >>> : ");
		
		return netMemberDAO.memberInsert(mvo);
	}

	@Override
	public List<NetMemberVO> memberSelectAll(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberServiceImpl memberSelectAll() 진입 >>> : ");
		
		return netMemberDAO.memberSelectAll(mvo);
	}
	
	@Override
	public List<NetMemberVO> memberSelect(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberServiceImpl memberSelect() 진입 >>> : ");
		
		return netMemberDAO.memberSelect(mvo);
	}
	
	@Override
	public List<NetFollowVO> memFollowSelect(NetFollowVO fvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberServiceImpl memFollowSelect() 진입 >>> : ");
		
		return netMemberDAO.memFollowSelect(fvo);
	}
	
	@Override
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo) {
		// TODO Auto-generated method stub
		logger.info("NetMemberServiceImpl memberIdCheck() 진입 >>> : ");
		
		return netMemberDAO.memberIdCheck(mvo);
	}
}
