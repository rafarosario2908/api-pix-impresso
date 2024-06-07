package br.senac.pr.api_pix_impresso.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.senac.pr.api_pix_impresso.dtos.CreateCaixaDto;
import br.senac.pr.api_pix_impresso.models.Caixa;
import br.senac.pr.api_pix_impresso.services.CaixaService;

@RestController
@RequestMapping("/caixas")
public class CaixaController {
  private CaixaService caixaService;

  public CaixaController(CaixaService caixaService) {
    this.caixaService = caixaService;
  }

  @GetMapping("")
  public List<Caixa> getCaixas() {
    return caixaService.findAll();
  }

  @PostMapping("")
  public Caixa createCaixa(@RequestBody CreateCaixaDto dto) {
    Caixa caixa = new Caixa(null,
        dto.getLocalizacao(),
        dto.getSaldo());
    // Salvar no banco
    int id = caixaService.save(caixa);
    caixa.setId(Long.valueOf(id));
    // retornar o objeto caixa o id
    return caixa;
  }

  // PATCH
  // PUT
  // DELETE

}