package leonardo.valter.vendas.controllers.infra;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import leonardo.valter.vendas.entity.Pedido;
import leonardo.valter.vendas.entity.repository.pedido.PedidoRepository;

@Service
public class EmailService {
	
	@Autowired private JavaMailSender mailSender;
	@Autowired private PedidoRepository pedidoRepository;

	public String enviarPedidosParaFornecedores() {
		List<Pedido> pedidos = pedidoRepository.findAll();
		return enviarEmail(pedidos);
		
	}
	
	public String enviarEmail(List<Pedido> pedidos) {		
		for (Pedido pedido : pedidos) {
			SimpleMailMessage mensagem = new SimpleMailMessage();
			mensagem.setText(
					"Bom dia "+ pedido.getProduto().getFornecedor().getNome() +
					",\n gostaria de solicitar o pedido dos itens abaixo:\n"+
					pedido.getProduto().getDescricao() + " / " + pedido.getQuantidade() + " unidades.");
			mensagem.setTo(pedido.getProduto().getFornecedor().getEmail());
			mensagem.setFrom("no-reply@valterleonardo.com.br");
			
			try {
				mailSender.send(mensagem);				
			} catch (Exception e) {
				e.printStackTrace();
				return "Erro ao enviar email";
			}	
		}
		return "Emails enviados com sucesso!";
	}
}
