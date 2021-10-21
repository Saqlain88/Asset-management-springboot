package com.asset.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asset.springboot.model.Asset;

public interface AssetRepository extends JpaRepository<Asset, Long> {
	
	public List<Asset> findByName(String assetName);

}
