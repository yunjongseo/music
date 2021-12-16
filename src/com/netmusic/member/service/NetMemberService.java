package com.netmusic.member.service;

import java.util.List;

import com.netmusic.member.vo.NetMemberVO;

public interface NetMemberService {

	public int memberInsert(NetMemberVO mvo);
	
	// 아이디 중복 체크
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo);
}
