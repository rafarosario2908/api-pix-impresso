
package br.senac.pr.api_pix_impresso.controllers;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateSaldoCaixaDto;
import br.senac.pr.api_pix_impresso.dtos.UpdateSaldoContaDto;
import br.senac.pr.api_pix_impresso.dtos.updateContaDto;
import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.services.ContaService;
import net.sf.jsqlparser.statement.update.Update;

@RestController
@RequestMapping("/contas")
public class ContaController {

  private ContaService contaService;

  public ContaController(ContaService contaService) {
    this.contaService = contaService;
  }

  // POST - Cria uma nova conta
  @PostMapping("")
  public ResponseEntity<Conta> createConta(@RequestBody CreateContaDto dto) {
    // Criar um objeto da classe Conta
    Conta conta = new Conta(null,
        dto.getAgencia(),
        dto.getNumeroConta(),
        dto.getDigitoVerificador(),
        dto.getNome(),
        dto.getCPF(), 
        dto.getTipoConta(),
        dto.getNumeroCartao(), 
        dto.getSenha(),
        dto.getSaldo());
    // Salvar no banco
    int id = contaService.save(conta);
    conta.setId(Long.valueOf(id));
    // retornar o objeto conta o id
    return ResponseEntity.ok().body(conta);
  }

  // GET - Lista todas as contas
  @GetMapping("")
  public List<Conta> getContas() {
    return contaService.findAll();
  }
  // GET - Lista uma conta por ID
  @GetMapping("/{id}")
    public ResponseEntity<Conta> getContaById(@PathVariable long id){
      var conta =contaService.findById(id);
      if (conta == null) {
        return ResponseEntity.notFound().build();        
      }
      return ResponseEntity.ok().body(conta);
    }

  // PUT - Atualiza uma conta
  @PutMapping("/{id}")
  public ResponseEntity <Conta> updateConta(@RequestBody updateContaDto dto,
  @PathVariable long id)
  {
    Conta conta = contaService.findById(id);
    if (conta == null) {
      return ResponseEntity.notFound().build();
      
    }
    conta.setAgencia(dto.getAgencia());
    conta.setNumeroConta(dto.getNumeroConta());
    conta.setDigitoVerificador(dto.getDigitoVerificador());
    conta.setNome(dto.getNome());
    conta.setCpf(dto.getCpf());
    conta.setTipoConta(dto.getTipoConta());
    conta.setNumeroCartao(dto.getNumeroCartao());
    conta.setSenha(dto.getSenha());
    conta.setSaldo(dto.getSaldo());

    contaService.update(conta);
    return ResponseEntity.ok(conta);

  }
  
  // PATCH - Atualiza parcialmente uma conta
  @PatchMapping("/{id}")public ResponseEntity<String> updateSaldoConta(@RequestBody UpdateSaldoContaDto dto,@PathVariable Long id){
    Conta conta =contaService.findById(id);
    if (conta == null) {
      return ResponseEntity.notFound().build();
      
    }
    conta.setSaldo(dto.getSaldo());
    contaService.updateSaldoConta(conta);

    return ResponseEntity.ok().build();
  }

  // DELETE - Deleta uma conta
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteConta(@PathVariable Long id) {
    contaService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}
