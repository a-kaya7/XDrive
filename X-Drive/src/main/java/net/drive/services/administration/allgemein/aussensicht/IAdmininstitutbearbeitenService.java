package net.drive.services.administration.allgemein.aussensicht;


import net.drive.entities.administration.allgemein.Institut;

public interface IAdmininstitutbearbeitenService {
 
	Institut updateInstitut(String idname, Institut updatedData);
	Institut getInstitutByIdname(String idname);

}
