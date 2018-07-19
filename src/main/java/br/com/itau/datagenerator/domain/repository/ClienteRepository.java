package br.com.itau.datagenerator.domain.repository;

import br.com.itau.datagenerator.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer> {

    /** Metodo exemplificando como executar consultas com filtros
     *
     * @param nome Nome do cliente que se deseja buscar
     * @return Lista de clientes
     */
    @Query("SELECT c FROM Cliente c WHERE LOWER(c.nome) = LOWER(:nome)")
    Cliente find(@Param("nome") String nome);
}
