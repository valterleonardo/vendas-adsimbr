package leonardo.valter.vendas.controllers.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import leonardo.valter.vendas.entity.Produto;
import leonardo.valter.vendas.entity.repository.produto.ProdutoRepository;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value="/api/infra")
@CrossOrigin
@Slf4j
public class InfraResource {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {	
		log.info("RequestService: /ping");
		
		Produto produto = new Produto();
		produto.setDescricao("As Crônicas de Gelo e Fogo");
		Produto valter = produtoRepository.save(produto);
		
		Produto valter2 = produtoRepository.findaProduto();
		
		
		
		
	    return new ResponseEntity<>("Pong!", HttpStatus.OK);
	}
}