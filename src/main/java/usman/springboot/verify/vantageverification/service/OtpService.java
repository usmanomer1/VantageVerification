package usman.springboot.verify.vantageverification.service;


import com.twilio.Twilio;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCheck;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;



@Service
public class OtpService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.service.sid}")
    private String serviceSid;

    @PostConstruct
    public void twilioInit() {
        Twilio.init(accountSid, authToken);
    }

    public String sendOtp(String mobileNumber) {
        Verification verification =
                Verification.creator(serviceSid, mobileNumber, "sms")
                        .create();

        return verification.getStatus();
    }

    public String verifyOtp(String mobileNumber, String code) {
        VerificationCheck verificationCheck =
                VerificationCheck.creator(serviceSid, code)
                        .setTo(mobileNumber)
                        .create();

        return verificationCheck.getStatus();
    }
}
