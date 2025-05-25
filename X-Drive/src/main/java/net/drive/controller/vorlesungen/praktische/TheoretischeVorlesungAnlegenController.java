package net.drive.controller.vorlesungen.praktische;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.services.vorlesung.theoretische.aussensicht.ITheoretischeVorlesungAnlegen;

@RestController
@RequestMapping
public class TheoretischeVorlesungAnlegenController {
	
	private final ITheoretischeVorlesungAnlegen theoretischeVorlesungAnlegen;
	
	public TheoretischeVorlesungAnlegenController(ITheoretischeVorlesungAnlegen theoretischeVorlesungAnlegen ) {
		this.theoretischeVorlesungAnlegen = theoretischeVorlesungAnlegen;
	}

	
}
