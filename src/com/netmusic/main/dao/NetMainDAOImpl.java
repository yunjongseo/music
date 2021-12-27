package com.netmusic.main.dao;

import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NetMainDAOImpl implements NetMainDAO {
	Logger logger = Logger.getLogger(NetMainDAOImpl.class);
	
	@Autowired(required=false)
	private SqlSessionTemplate sqlSession;
}
