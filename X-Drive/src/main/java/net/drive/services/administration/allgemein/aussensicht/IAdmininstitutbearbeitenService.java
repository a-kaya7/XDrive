package net.drive.services.administration.allgemein.aussensicht;

import java.util.List;


import net.drive.entities.administration.allgemein.Admininstitutneuanlage;

public interface IAdmininstitutbearbeitenService {
 
	Admininstitutneuanlage updateInstitut(String idname, Admininstitutneuanlage updatedData);
	Admininstitutneuanlage getInstitutByIdname(String idname);

}
