package com.netmusic.member.dao;

import java.util.List;

import com.netmusic.member.vo.NetMemberVO;

public interface NetMemberDAO {
	
	public int memberInsert(NetMemberVO mvo);
	
	// 아이디 중복 체크
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo);
}
