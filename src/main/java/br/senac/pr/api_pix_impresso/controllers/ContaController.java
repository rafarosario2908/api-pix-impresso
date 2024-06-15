package br.senac.pr.api_pix_impresso.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.services.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {
  private ContaService contaService;
  

  public ContaController(ContaService contaService) {
    this.contaService = contaService;
  }
  @GetMapping
  public List<Conta>getContas(){

    return contaService.findAll();
  }
  @GetMapping("/{id}")
  public ResponseEntity<Conta>getContasById(@PathVariable Long id){
    var conta = contaService.findById(id);
    if (conta == null) {
      return ResponseEntity.notFound().build();
      
    }
    return ResponseEntity.ok().body(conta);
  }

  // POST - Cria uma nova conta
  @PostMapping("")
public Conta createConta(@RequestBody CreateContaDto  dto){
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
        int id = contaService.save(conta);
    conta.setId(Long.valueOf(id));

    return conta;



}


    
  // GET - Lista todas as contas
  // GET - Lista uma conta por ID
  // PUT - Atualiza uma conta
  // PATCH - Atualiza parcialmente uma conta
  // DELETE - Deleta uma conta
}