package com.netmusic.follow.service;

import java.util.List;

import com.netmusic.follow.vo.NetFollowVO;

public interface NetFollowService {

	public List<NetFollowVO> followList(NetFollowVO fvo);
	public List<NetFollowVO> followerList(NetFollowVO fvo);
	public List<NetFollowVO> followcheck(NetFollowVO fvo);
	public int followInsert(NetFollowVO fvo);
	public int followerInsert(NetFollowVO fvo);
	public int followDelete(NetFollowVO fvo);
	public int followerDelete(NetFollowVO fvo);
}
