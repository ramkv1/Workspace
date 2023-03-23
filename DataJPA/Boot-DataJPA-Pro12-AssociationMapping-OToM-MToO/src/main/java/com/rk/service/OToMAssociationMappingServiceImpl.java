package com.rk.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rk.entity.Person;
import com.rk.entity.PhoneNumber;
import com.rk.repository.IPersonRepository;
import com.rk.repository.IPhoneNumberRepository;

@Service("OToMService")
public class OToMAssociationMappingServiceImpl implements IOToMAssociationMgmtService {
	@Autowired
	private IPersonRepository personRepo;
	@Autowired
	private IPhoneNumberRepository phoneRepo;
	
	
	@Override
	public void saveDataUsingParent() {
		//create Parent object
		Person per=new Person("Raja","Hyd");
		//Create child object
		PhoneNumber ph1=new PhoneNumber(9999999L,"aritel","personal");
		PhoneNumber ph2=new PhoneNumber(88888888L,"vi","Office");
		
		//add perent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		
		//add child to parent
		Set<PhoneNumber> phonesSet=new HashSet();
		phonesSet.add(ph1);phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save parent Object
		personRepo.save(per);
		System.out.println("Person and his associated Phonenumbers are Saved(parent to child)");
	}


	@Override
	public void saveDataUsingChid() {
		//create parent Object
		Person per=new Person("ramesh","vizag");
		//create child object
		PhoneNumber ph1=new PhoneNumber(8888888888L,"airtel","personal");
		PhoneNumber ph2=new PhoneNumber(7777777777L,"vi","office");
		
		//add parent to child
		ph1.setPersonInfo(per);
		ph2.setPersonInfo(per);
		//add child to parent
		Set<PhoneNumber> phonesSet=new HashSet<PhoneNumber>();
		phonesSet.add(ph1);
		phonesSet.add(ph2);
		per.setContactDetails(phonesSet);
		
		//save the parent object
		phoneRepo.save(ph1);
		phoneRepo.save(ph2);
		System.out.println("Person and his associated Phonenumbers are Saved(child to parent  )");

	}


	@Override
	public void loadDataUsingParent() {
		Iterable<Person> it=personRepo.findAll();
		it.forEach(per->{
			System.out.println("parent::"+per);
		});
	}


	@Override
	public void deleteDataUsingParentById(int id) {
		//load parent object by id
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			personRepo.delete(per);
			System.out.println("Parent and the association child object are deleted");
		}
		else {
			System.out.println(id+"Person not found for deletion");
		}
	}


	@Override
	public void deleteAllChildsofAParentById(int id) {
		//Load parent object by id
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			//get all child of a parent
			Set<PhoneNumber> child=per.getContactDetails();
			//remove parent link from child
			child.forEach(ph->{
				ph.setPersonInfo(null);
			});
			//delete all child objs
			phoneRepo.deleteAll(child);
			
			System.out.println("Only the child  of a Parent are deleted");
		}
		else {
			System.out.println(id+"Person not found for  deletion");
		}
	}


	@Override
	public void AddNewChildtoAParentById(int id) {
		//Load parent Object
		Optional<Person> opt=personRepo.findById(id);
		if(opt.isPresent()) {
			Person per=opt.get();
			//get childs of a parent
			Set<PhoneNumber> childs=per.getContactDetails();
			//create the new child object
			PhoneNumber ph=new PhoneNumber(77777777777L,"vodafone","Personal");
			//link child to parent
			ph.setPersonInfo(per);
			childs.add(ph);
			phoneRepo.save(ph);
			System.out.println("New child is add to the Parent");
		}
		else {
			System.out.println(id+"Parent not found for Insertion");
		}
	}
}
