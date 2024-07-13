package usman.springboot.verify.vantageverification.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import usman.springboot.verify.vantageverification.dao.IVerifyRepo;
import usman.springboot.verify.vantageverification.model.Clientelle;

import java.util.Optional;

@Service
public class VerifyServiceImpl implements IVerifyService{
    @Autowired
    private IVerifyRepo repo;

    @Autowired
    private OtpService otpService;




    public String sendOtp(String phoneNumber, int formNumber) {
       Optional clientelle = repo.findById(formNumber);
        Object cl1 = clientelle.get();
        Clientelle cl2 = (Clientelle) cl1;;

        if (cl2.getPhoneNumber().equals(phoneNumber)) {
            return otpService.sendOtp(phoneNumber);
        } else {
            return "Client not found";
        }
    }

    public String verifyOtp(String mobileNumber,String code) {
        return otpService.verifyOtp(mobileNumber, code);
    }

    public String savenew(Clientelle cl1){
        Clientelle cl2 = repo.save(cl1);
        return "saved";

    }













}
