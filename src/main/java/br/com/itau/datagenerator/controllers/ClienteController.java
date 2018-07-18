package br.com.itau.datagenerator.controllers;

import br.com.itau.datagenerator.domain.model.Cliente;
import br.com.itau.datagenerator.domain.repository.ClienteRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseCrudController<Cliente, Integer> {
    private ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @Override
    protected CrudRepository<Cliente, Integer> getRepository() {
        return this.repository;
    }
}
