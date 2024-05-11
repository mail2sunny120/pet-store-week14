package pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.entity.PetStore;
import pet.store.service.PetStoreService;

@RestController
@RequestMapping("/pet_store")
//@RequestMapping(value = "/pet_store",method = RequestMethod.POST)
@Slf4j
public class PetStoreController {

	@Autowired
	PetStoreService petStoreService;
	
	@PostMapping
	public PetStore  myPost(@RequestBody PetStoreData petStoreData)
	{
		//log.info(petStoreData.toString());
		
		PetStore petStore = petStoreService.savePetStore(petStoreData);
		return petStore;
		
	}

	@PutMapping("{petStoreId}")
	public PetStore  storeUpdate(@PathVariable Long petStoreId,@RequestBody PetStoreData petStoreData)
	{
		PetStore petStore = null;
		
		petStoreService.savePetStore(petStoreData);
		return petStore;
		
	}
	
}
