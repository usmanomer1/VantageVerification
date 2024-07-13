package usman.springboot.verify.vantageverification.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import usman.springboot.verify.vantageverification.model.Clientelle;

@Repository
public interface IVerifyRepo extends JpaRepository<Clientelle, Integer> {

}
