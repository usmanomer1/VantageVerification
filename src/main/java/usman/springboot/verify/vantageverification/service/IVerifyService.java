package usman.springboot.verify.vantageverification.service;

public interface IVerifyService {

    public String sendOtp(String phoneNumber,int formNumber);
    public String verifyOtp(String phoneNumber,String code);
}
