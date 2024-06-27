package br.senac.pr.api_pix_impresso.conta.mappers;

import java.util.function.Function;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.conta.dtos.CreateContaDto;
import br.senac.pr.api_pix_impresso.shared.models.Conta;

@Service
public class CreateContaToContaMapper implements Function<CreateContaDto, Conta> {

  @Override
  public Conta apply(CreateContaDto dto) {
    return new Conta(null, dto.getAgencia(), dto.getNumeroConta(),
        dto.getDigitoVerificador(), dto.getNome(),
        dto.getCPF(), dto.getTipoConta(), dto.getNumeroCartao(),
        dto.getSenha(), dto.getSaldo());
  }

}