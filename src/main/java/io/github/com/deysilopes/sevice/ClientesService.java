package io.github.com.deysilopes.sevice;

import io.github.com.deysilopes.model.Cliente;
import io.github.com.deysilopes.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    ClientesRepository clientesRepository;

    @Autowired
    public ClientesService(ClientesRepository repository){
         this.clientesRepository = repository;
     }

    public void salvarClientes(Cliente clients){
       this.clientesRepository.persistir(clients);
    }

    public void validarCliente(Cliente valCliente){

    }

}
