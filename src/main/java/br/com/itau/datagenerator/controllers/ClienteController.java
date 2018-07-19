package br.com.itau.datagenerator.controllers;

import br.com.itau.datagenerator.domain.model.Cliente;
import br.com.itau.datagenerator.domain.repository.ClienteComplexRepository;
import br.com.itau.datagenerator.domain.repository.ClienteRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController extends BaseCrudController<Cliente, Integer> {
    private ClienteRepository repository;
    private ClienteComplexRepository complexRepository;

    public ClienteController(ClienteRepository repository, ClienteComplexRepository complexRepository) {
        this.repository = repository;
        this.complexRepository = complexRepository;
    }

    @Override
    protected CrudRepository<Cliente, Integer> getRepository() {
        return this.repository;
    }


    @RequestMapping(value = "documento/{doc}", method = RequestMethod.GET)
    public Cliente getByDoc(@PathVariable String doc) {
        return this.complexRepository.obterClientePorDocumento(doc);
    }

    @RequestMapping(value = "nome/{nome}", method = RequestMethod.GET)
    public Cliente getByName(@PathVariable String nome) {
        return this.repository.find(nome);
    }

}
