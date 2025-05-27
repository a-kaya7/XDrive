package net.drive.controller.vorlesungen.praktische;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;
import net.drive.services.vorlesung.theoretische.aussensicht.ITheoretischeVorlesungAnzeigen;

@RestController
@RequestMapping("/vorlesung/anzeigen")
public class TheoretischeVorlesungAnzeigenController {

	private final ITheoretischeVorlesungAnzeigen theoretischeVorlesungAnzeigen;
	
	
	public TheoretischeVorlesungAnzeigenController(ITheoretischeVorlesungAnzeigen theoretischeVorlesungAnzeigen ) {
		this.theoretischeVorlesungAnzeigen = theoretischeVorlesungAnzeigen;
	}
	
	@GetMapping
	public List<TheoretischeVorlesung> getAllVorlesung(){
		return theoretischeVorlesungAnzeigen.getAllVorlesung();
	}
	
	@GetMapping("/{vorlesungId}")
	public TheoretischeVorlesung getOneVorlesung(@PathVariable("vorlesungId") long vorlesungId) {
		return theoretischeVorlesungAnzeigen.getOneVorlesung(null);
	}
}
