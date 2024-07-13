package usman.springboot.verify.vantageverification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import usman.springboot.verify.vantageverification.dao.IVerifyRepo;
import usman.springboot.verify.vantageverification.model.Clientelle;
import usman.springboot.verify.vantageverification.service.VerifyServiceImpl;

@SpringBootApplication
public class VantageVerificationApplication {

    public static void main(String[] args) {
        SpringApplication.run(VantageVerificationApplication.class, args);
    }






}
