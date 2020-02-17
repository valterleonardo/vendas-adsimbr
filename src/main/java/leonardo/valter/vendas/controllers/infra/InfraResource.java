package leonardo.valter.vendas.controllers.infra;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/api/infra")
@CrossOrigin
public class InfraResource {
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {	
	    return new ResponseEntity<>("Pong!", HttpStatus.OK);
	}
}