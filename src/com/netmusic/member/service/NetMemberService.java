package com.netmusic.member.service;

import java.util.List;

import com.netmusic.main.vo.NetMainVO;
import com.netmusic.member.vo.NetMemberVO;

public interface NetMemberService {

	public int memberInsert(NetMemberVO mvo);
	public List<NetMemberVO> memberSelectAll(NetMemberVO mvo);
	public List<NetMemberVO> memberSelect(NetMemberVO mvo);
	
	// 아이디 중복 체크
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo);
}
