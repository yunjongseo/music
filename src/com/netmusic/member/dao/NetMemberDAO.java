package com.netmusic.member.dao;

import java.util.List;

import com.netmusic.main.vo.NetMainVO;
import com.netmusic.member.vo.NetFollowVO;
import com.netmusic.member.vo.NetMemberVO;

public interface NetMemberDAO {
	
	public int memberInsert(NetMemberVO mvo);
	public List<NetMemberVO> memberSelectAll(NetMemberVO mvo);
	public List<NetMemberVO> memberSelect(NetMemberVO mvo);
	public List<NetFollowVO> memFollowSelect(NetFollowVO fvo);
	
	// 아이디 중복 체크
	public List<NetMemberVO> memberIdCheck(NetMemberVO mvo);
}
