package com.netmusic.main.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.netmusic.main.dao.NetMainDAO;

@Service
@Transactional
public class NetMainServiceImpl implements NetMainService {
	Logger logger = Logger.getLogger(NetMainServiceImpl.class);
	
	private NetMainDAO netMainDAO;
	
	@Autowired(required=false)
	public NetMainServiceImpl(NetMainDAO netMainDAO) {
		this.netMainDAO = netMainDAO;
	}
}
