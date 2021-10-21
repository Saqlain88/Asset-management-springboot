package com.asset.springboot.service;

import java.util.List;

import com.asset.springboot.model.Asset;

public interface AssetService {
	
	Asset createAsset(Asset asset);
	Asset updateAsset(Asset asset);
	Asset recoverAsset(Long id);
	Asset assignAsset(Long id, Asset asset);
	List<Asset> getAllAsset();
	List<Asset> findByName(String assetName);
	void deleteAsset(long id);
}
