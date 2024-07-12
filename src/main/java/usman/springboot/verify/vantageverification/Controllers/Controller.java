package usman.springboot.verify.vantageverification.Controllers;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import usman.springboot.verify.vantageverification.service.VerifyServiceImpl;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
public class RestController {
    @Autowired
    VerifyServiceImpl service;

    @ApiOperation(value = "Send OTP to a mobile number", notes = "This endpoint sends an OTP to the provided mobile number.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OTP sent successfully"),
            @ApiResponse(code = 400, message = "Invalid request parameters")
    })
    @PostMapping("/send-otp")
    public String sendOtp(@ApiParam(value = "Mobile number to send the OTP", required = true) @RequestParam String mobileNumber,
                          @ApiParam(value = "Form number associated with the OTP request", required = true) @RequestParam String formNumber) {
        return service.sendOtp(mobileNumber, formNumber);
    }

    @ApiOperation(value = "Verify OTP for a mobile number", notes = "This endpoint verifies the OTP sent to a mobile number.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OTP verified successfully"),
            @ApiResponse(code = 400, message = "Invalid OTP or mobile number")
    })
    @PostMapping("/verify-otp")
    public String verifyOtp(@ApiParam(value = "Mobile number to verify the OTP", required = true) @RequestParam String mobileNumber,
                            @ApiParam(value = "OTP to be verified", required = true) @RequestParam String code) {
        return service.verifyOtp(mobileNumber, code);
    }
}