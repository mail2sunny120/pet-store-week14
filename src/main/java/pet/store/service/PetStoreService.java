package pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pet.store.controller.model.PetStoreData;
import pet.store.dao.PetStoreDao;
import pet.store.entity.PetStore;

@Service
public class PetStoreService {

	@Autowired
	private PetStoreDao petStoreDao;
	
	public PetStore savePetStore(PetStoreData  p)
	{
	
		Long petStoreId = p.getPetStoreId();
		//petStoreId = null;
		PetStore newPetstore=findOrCreatePetStore(petStoreId);
		copyPetStoreFields(newPetstore, p);
		
		newPetstore = petStoreDao.save(newPetstore);
		
		return newPetstore;
	}

	

	private PetStore findOrCreatePetStore(Long petStoreId) {
		// TODO Auto-generated method stub
		if(Objects.isNull(petStoreId)) {
			return new PetStore();
		}
		else {
			return findPetStorebyId(petStoreId);
		}
	}
	
	private PetStore findPetStorebyId(Long petStoreId) {
		// TODO Auto-generated method stub
		return petStoreDao.findById(petStoreId).orElseThrow(()->new NoSuchElementException("Pet Store "+petStoreId +  "was not found"));
	}



	private void copyPetStoreFields(PetStore petStore,PetStoreData petStoreData)
	{
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreAddress(petStoreData.getPetStoreAddress());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		
	}
	
	
	
}
