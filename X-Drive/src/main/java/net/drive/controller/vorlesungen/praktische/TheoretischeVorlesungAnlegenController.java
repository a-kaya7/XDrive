package net.drive.controller.vorlesungen.praktische;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.drive.entities.vorlesung.theoretische.TheoretischeVorlesung;
import net.drive.services.vorlesung.theoretische.aussensicht.ITheoretischeVorlesungAnlegen;

@RestController
@RequestMapping("/vorlesung/anlegen")
public class TheoretischeVorlesungAnlegenController {
	
	private final ITheoretischeVorlesungAnlegen theoretischeVorlesungAnlegen;
	
	public TheoretischeVorlesungAnlegenController(ITheoretischeVorlesungAnlegen theoretischeVorlesungAnlegen ) {
		this.theoretischeVorlesungAnlegen = theoretischeVorlesungAnlegen;
	}

	@PostMapping
	public TheoretischeVorlesung vorlesungAnlegen(@RequestBody TheoretischeVorlesung theoretischeVorlesung) {
		return theoretischeVorlesungAnlegen.vorlesungAnlegen(theoretischeVorlesung, null);
	}
}
