package br.com.afs.registro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.afs.registro.entities.Contato;

@Repository
public interface ContatoRepository extends JpaRepository<Contato, Long> {

}
