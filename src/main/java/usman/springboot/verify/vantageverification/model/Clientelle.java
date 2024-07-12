package usman.springboot.verify.vantageverification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
@Entity
public class client {
    @Id
    int id;

    String phoneNumber;

    String formNumber;


}
