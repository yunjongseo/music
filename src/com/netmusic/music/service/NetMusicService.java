package com.netmusic.music.service;

import java.util.List;

import com.netmusic.music.vo.NetMusicVO;

public interface NetMusicService {

	public int musicInsert(NetMusicVO mvo);
	public List<NetMusicVO> musicSelectAll(NetMusicVO mvo);
}
