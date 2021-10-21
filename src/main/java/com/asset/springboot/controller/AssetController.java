package com.asset.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.asset.springboot.model.Asset;
import com.asset.springboot.model.Employee;
import com.asset.springboot.service.AssetService;
import com.asset.springboot.service.EmployeeService;

@RestController
public class AssetController {

	@Autowired
	private AssetService assetService;
	
	@PostMapping("/asset/create")
	public ResponseEntity<Asset> createAsset(@RequestBody Asset asset){
		return ResponseEntity.ok().body(this.assetService.createAsset(asset));
	}
	
	@GetMapping("/asset")
	public ResponseEntity<List<Asset>> getAsset(){
		return ResponseEntity.ok().body(this.assetService.getAllAsset());
	}
	
	@GetMapping("/asset/getbyname/{name}")
	public ResponseEntity<List<Asset>> getByName(@PathVariable String name){
		return ResponseEntity.ok().body(this.assetService.findByName(name));
	}
	
	@PutMapping("/asset/update/{id}")
	public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @RequestBody Asset asset){
		asset.setId(id);
		return ResponseEntity.ok().body(this.assetService.updateAsset(asset));
	}
	
	@PutMapping("/asset/recover/{id}")
	public ResponseEntity<Asset> recoverAsset(@PathVariable Long id /* , @RequestBody Asset asset */){
		//asset.setId(id);
		return ResponseEntity.ok().body(this.assetService.recoverAsset(id));
	}
	
	@DeleteMapping("/asset/delete/{id}")
	public HttpStatus deleteAsset(@PathVariable Long id){
		this.assetService.deleteAsset(id);
		return HttpStatus.OK;
	}
	
	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee(){
		return ResponseEntity.ok().body(this.empService.getEmployee());
	}
	
	@PutMapping("/asset/assign/{id}")
	public ResponseEntity<Asset> recoverAsset(@PathVariable Long id , @RequestBody Asset asset){
		return ResponseEntity.ok().body(this.assetService.assignAsset(id,asset));
	}
}
