package com.example.ussd.ussdController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Scanner;

@RestController
public class UssdController {

    @PostMapping("/ussd")
    public String handleUssdRequest(@RequestBody String requestBody) {
        Map<String, String> body = Arrays
                .stream(requestBody.split("&"))
                .map(entry -> entry.split("="))
                .collect(Collectors.toMap(entry -> entry[0], entry -> entry.length == 2 ? entry[1] : ""));

        String sessionId = body.get("sessionId");
        String serviceCode = body.get("serviceCode");
        String phoneNumber = body.get("phoneNumber");
        String text = body.get("text");

        StringBuilder response = new StringBuilder("");

        if (text.isEmpty()) {
            response.append("CON Dear customer,kindly select your service:\n" +
                    "1. Insurance\n" +
                    "2. Buy policy\n" +
                    "3.Claims\n"+
                    "4.Contact Us\n" +
                    "5.Exit");
        } else if (text.equals("1")) {
            response.append("CON Type of insurance:\n" +
                    "1.Third Party\n" +
                    "2.Domestic"
            );
        } else if (text.equals("1*1")) {
            response.append("CON 1.policy status \n 2.Back ");

        } else if (text.equals("1*1*1")) {
            response.append("CON 1.Active \n 2.Expired ");

        }else if(text.equals("1*1*1*2")) {
                response.append("CON 1.Enter ID number\n 2.Exit");
            }else if(text.equals("1*1*1*2*1")) {
                response.append("CON 1.Enter car plate number\n 2.exit");
            }else if(text.equals("1*1*1*2*1*1")) {
                response.append("CON 1.Enter start date\n 2.Exit");
            }else if(text.equals("1*1*1*2*1*1*1")) {
                response.append("CON select mode of payment:\n 1.Mobile money\n 2.Pay from Account");
            }else if (text.equals("1*1*1*2*1*1*1")) {
                response.append("CON 1.Enter mobile number: \n 2.exit");
            }else if(text.equals("1*1*1*2*1*1*1*1")) {
                response.append("END Do you wish to sh.1000 ?\n 1.Accept\n 2.Decline");
            }else if(text.equals("1*1*1*2*1*1*1*1")) {
                response.append("CON Select accoun to pay from: \n 1.ACC1 \n 2.ACC 2");
            }else if(text.equals("1*1*1*2*1*1*1*1*2")) {
                response.append("END Confirm sh.1000 policy purchase:\n 1.Accept \n 2.Decline");

        }else if(text.equals("2")) {
            response.append("CON 1.Third party \n 2.Domestic");
        }else if(text.equals("2*1")) {
            response.append("CON 1.Enter ID number\n 2.Exit");
        }else if(text.equals("2*1*1")) {
            response.append("CON 1.Enter car plate number\n 2.exit");
        }else if(text.equals("2*1*1*1")) {
            response.append("CON 1.Enter start date\n 2.Exit");
        }else if(text.equals("2*1*1*1*1")) {
            response.append("CON select mode of payment:\n 1.Mobile money\n 2.Pay from Account");
        }else if (text.equals("2*1*1*1*1*1")) {
            response.append("CON 1.Enter mobile number: \n 2.exit");
        }else if(text.equals("2*1*1*1*1*1*1")) {
            response.append("END Do you wish to sh.1000 ?\n 1.Accept\n 2.Decline");
        }else if(text.equals("2*1*1*1*1*2")) {
            response.append("CON Select accoun to pay from: \n 1.ACC1 \n 2.ACC 2");
        }else if(text.equals("2*1*1*1*1*2*1")) {
            response.append("END Confirm sh.1000 policy purchase:\n 1.Accept \n 2.Decline");
        }else if(text.equals("2*2")) {
                response.append("CON 1.Enter ID number\n 2.Exit");
            }else if(text.equals("2*1*1")) {
                response.append("CON 1.Enter car plate number\n 2.exit");
            }else if(text.equals("2*2*1*1")) {
                response.append("CON 1.Enter start date\n 2.Exit");
            }else if(text.equals("2*2*1*1*1")) {
                response.append("CON select mode of payment:\n 1.Mobile money\n 2.Pay from Account");
            }else if (text.equals("2*2*1*1*1*1")) {
                response.append("CON 1.Enter mobile number: \n 2.exit");
            }else if(text.equals("2*2*1*1*1*1*1")) {
                response.append("END Do you wish to sh.1000 ?\n 1.Accept\n 2.Decline");
            }else if(text.equals("2*2*1*1*1*2")) {
                response.append("CON Select accoun to pay from: \n 1.ACC1 \n 2.ACC 2");
            }else if(text.equals("2*2*1*1*1*2*1")) {
            response.append("END Confirm sh.1000 policy purchase:\n 1.Accept \n 2.Decline");
        }else if(text.equals("3")) {
            response.append("CON 1.Enter Incident date\n 2.Exit");
        }else if(text.equals("3*1")) {
            response.append("CON 1.Enter Incident details \n 2.Exit");
        }else if(text.equals("3*1*1")){
            response.append("CON 1.Enter your Email Address\n 2.Exit");
        }else if(text.equals("3*1*1*1")){
            response.append("CON kindly confirm claim submission\n 1.Accept\n 2.Decline");
        }else if(text.equals("4"))
            response.append("END Reach us at:\n Tel:+(254)763000000\n Email:info@equitybank.co.ke");

        return response.toString();
    }
}
