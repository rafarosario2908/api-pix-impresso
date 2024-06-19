package br.senac.pr.api_pix_impresso.services;

import java.util.List;

import org.springframework.stereotype.Service;

import br.senac.pr.api_pix_impresso.models.Conta;
import br.senac.pr.api_pix_impresso.repositories.JdbcCaixaRepository;
import br.senac.pr.api_pix_impresso.repositories.JdbcContaRepository;

// TODO - implementar um CRUD completo baseado nas chamadas do controller
@Service
public class ContaService implements BaseService<Conta, Long> {

   private JdbcContaRepository  contaRepository;

   public void updateSaldoConta(Conta conta)
   {
    contaRepository.update(conta);
   }

  @Override
  public int save(Conta object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'save'");
  }

  @Override
  public List<Conta> findAll() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findAll'");
  }

  @Override
  public Conta findById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'findById'");
  }

  @Override
  public int update(Conta object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'update'");
  }

  @Override
  public void deleteById(Long id) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
  }
  

}