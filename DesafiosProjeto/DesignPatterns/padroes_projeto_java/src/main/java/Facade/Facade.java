package Facade;

import Facade.subsistemaCRM.CrmService;
import Facade.subsistemaCep.CepApi;

//prover uma interface que reduza a complexidade nas integrações
//com  subsistemas

public class Facade {
     public void migrarCliente(String nome, String cep){
          String cidade = CepApi.getInstancia().recuperarCidade(cep);
          String estado = CepApi.getInstancia().recuperarEstado(cep);

          CrmService.gravarCliente(nome, cep, cidade, estado);
     }
}
