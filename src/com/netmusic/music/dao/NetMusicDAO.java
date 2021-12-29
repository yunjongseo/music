package com.netmusic.music.dao;

import java.util.List;

import com.netmusic.music.vo.NetMusicVO;

public interface NetMusicDAO {

	public int musicInsert(NetMusicVO mvo);
	public List<NetMusicVO> musicSelectAll(NetMusicVO mvo);
}
