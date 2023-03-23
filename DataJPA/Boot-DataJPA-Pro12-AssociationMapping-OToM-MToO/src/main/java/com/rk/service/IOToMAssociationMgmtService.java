package com.rk.service;

public interface IOToMAssociationMgmtService {
	public void saveDataUsingParent();
	public void saveDataUsingChid();
	public void loadDataUsingParent();
	public void deleteDataUsingParentById(int id);
	public void deleteAllChildsofAParentById(int id);
	public void AddNewChildtoAParentById(int id);
}
