package br.com.itau.datagenerator.domain.repository;

import br.com.itau.datagenerator.domain.model.Cliente;
import br.com.itau.datagenerator.domain.model.Cliente_;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ClienteComplexRepository {
    
    private EntityManager entityManager;

    public ClienteComplexRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Cliente obterClientePorDocumento(String docNumero) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery cq = cb.createQuery(Cliente.class);

        Root<Cliente> clienteRoot = cq.from(Cliente.class);

        cq = cq.select(clienteRoot).where(cb.equal(clienteRoot.get(Cliente_.documento), docNumero));

        TypedQuery<Cliente> typedQuery = entityManager.createQuery(cq);

        return typedQuery.getSingleResult();
    }
}
