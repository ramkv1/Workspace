package com.rk.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.rk.document.PlayerInfo;

public interface PlayerInfoRepository extends MongoRepository<PlayerInfo,Integer> {

}
