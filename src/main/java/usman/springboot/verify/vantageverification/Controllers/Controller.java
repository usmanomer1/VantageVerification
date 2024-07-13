package usman.springboot.verify.vantageverification.Controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import usman.springboot.verify.vantageverification.dao.IVerifyRepo;
import usman.springboot.verify.vantageverification.model.Clientelle;
import usman.springboot.verify.vantageverification.service.IVerifyService;
import usman.springboot.verify.vantageverification.service.VerifyServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://13.50.204.230")
public class Controller {
    @Autowired
    VerifyServiceImpl service;

    @Operation(summary = "Send OTP to a mobile number", description = "This endpoint sends an OTP to the provided mobile number.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP sent successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request parameters")
    })
    @PostMapping("/send-otp")
    public String sendOtp(@Parameter(description = "Mobile number to send the OTP", required = true) @RequestParam String mobileNumber,
                          @Parameter(description = "Form number associated with the OTP request", required = true) @RequestParam int formNumber, HttpSession session) {
        session.setAttribute("data", mobileNumber);

        return service.sendOtp("+"+mobileNumber, formNumber);
    }

    @Operation(summary = "Verify OTP for a mobile number", description = "This endpoint verifies the OTP sent to a mobile number.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OTP verified successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid OTP or mobile number")
    })
    @PostMapping("/verify-otp")
    public String verifyOtp(@Parameter(description = "OTP to be verified", required = true) @RequestParam String code, HttpSession session) {
        String data = (String) session.getAttribute("data");
        return service.verifyOtp("+"+data, code);
    }

    @PostMapping("save-new")
    public String saveNew(@RequestBody Clientelle cl1){
       return service.savenew(cl1);
    }



}
