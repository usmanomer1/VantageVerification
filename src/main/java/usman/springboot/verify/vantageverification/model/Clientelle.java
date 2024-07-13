package usman.springboot.verify.vantageverification.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clientelle {


    String phoneNumber;

    @Id
    int formNumber;


}
