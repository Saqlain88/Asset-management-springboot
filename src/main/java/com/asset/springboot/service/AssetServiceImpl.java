package com.asset.springboot.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.asset.springboot.exception.AlreadyAssignedException;
import com.asset.springboot.exception.CannotRemoveAssignedAsset;
import com.asset.springboot.exception.EmployeeNotFoundException;
import com.asset.springboot.exception.ResourceNotFoundException;
import com.asset.springboot.model.Asset;
import com.asset.springboot.model.Category;
import com.asset.springboot.model.Employee;
import com.asset.springboot.repository.AssetRepository;
import com.asset.springboot.repository.CategoryRepository;
import com.asset.springboot.repository.EmployeeRepository;

@Service
@Transactional
public class AssetServiceImpl implements AssetService {

	//assignment status: if available then 0, assigned then 1 and recovered then 2.
	public final int AssetAvailable = 0;
	public final int AssetAssigned = 1;
	public final int AssetRecovered = 2;
	
	@Autowired
	private AssetRepository assetRepository;
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Asset createAsset(Asset asset) {
		Optional<Category> categoryDb = this.categoryRepository.findById(asset.getCategoryId());
		if (categoryDb.isPresent()) {
			return assetRepository.save(asset);
		} else {
			throw new ResourceNotFoundException("No such category exist, enter correct category id ");
		}
	}

	@Override
	public Asset updateAsset(Asset asset) {
		Optional<Asset> assetDb = this.assetRepository.findById(asset.getId());
		if (assetDb.isPresent()) {
			Asset assetUpdate = assetDb.get();
			Optional<Category> categoryDb = this.categoryRepository.findById(asset.getCategoryId());
			if (categoryDb.isPresent()) {
				assetUpdate.setId(asset.getId());
				assetUpdate.setCategoryId(asset.getCategoryId());
				assetUpdate.setName(asset.getName());
				assetUpdate.setPurchaseDate(asset.getPurchaseDate());
				assetUpdate.setConditionNote(asset.getConditionNote());
				assetUpdate.setAssignmentStatus(asset.getAssignmentStatus());
				assetRepository.save(assetUpdate);
				return assetUpdate;
			} else {
				throw new ResourceNotFoundException("No such category exist, enter correct category id");
			}

		} else {
			throw new ResourceNotFoundException("No such asset exist");
		}
	}

	@Override
	public List<Asset> getAllAsset() {
		// TODO Auto-generated method stub
		return assetRepository.findAll();
	}

	@Override
	public List<Asset> findByName(@PathVariable("assetName") String assetName) {
		return assetRepository.findByName(assetName);
	}

	@Override
	public void deleteAsset(long id) {
		Optional<Asset> assetDb = this.assetRepository.findById(id);
		if (assetDb.isPresent()) {
			Asset copy = assetDb.get();
			if(copy.getAssignmentStatus() == this.AssetAssigned) {
				throw new CannotRemoveAssignedAsset("This asset is assigned and cannot be deleted.");
			}else {
				this.assetRepository.delete(assetDb.get());
			}
		} else {
			throw new ResourceNotFoundException("Record not found with id: " + id);
		}
	}

	// Recover
	@Override	
	public Asset recoverAsset(Long id) {
		Optional<Asset> assetDb = this.assetRepository.findById(id);
		if (assetDb.isPresent()) {
			Asset assetUpdate = assetDb.get();
			assetUpdate.setId(id);
			assetUpdate.setAssignmentStatus(this.AssetRecovered);
			assetUpdate.setAssignedTo(0);
			assetRepository.save(assetUpdate);
			return assetUpdate;
		} else {
			throw new ResourceNotFoundException("No such asset exist");
		}
	}
	
	@Autowired
	private EmployeeRepository empRepo;
	@Override
	public Asset assignAsset(Long id,Asset asset) {
		Optional<Asset> assetDb = this.assetRepository.findById(id);
		Optional<Employee> empDb= this.empRepo.findById(asset.getAssignedTo());
		if (assetDb.isPresent()) {
			if(!empDb.isPresent()) {
				throw new EmployeeNotFoundException("No such employee exist!");
			}
			Asset assetUpdate = assetDb.get();
			if(assetUpdate.getAssignmentStatus() == this.AssetAssigned) {
				throw new AlreadyAssignedException("This asset is already assigned to employee");
			}
			assetUpdate.setId(id);
			assetUpdate.setAssignmentStatus(this.AssetAssigned);
			assetUpdate.setAssignedTo(asset.getAssignedTo());
			assetRepository.save(assetUpdate);
			return assetUpdate;
		} else {
			throw new ResourceNotFoundException("No such asset exist");
		}
	}

}
