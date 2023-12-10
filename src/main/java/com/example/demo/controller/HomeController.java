package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {


@GetMapping("/home")
String getHome(){
    return "home";
}
    @GetMapping("/calc")
     String getCalc(){
           return "calc";
     }
    @PostMapping("/calc")
    public String postCalc(@RequestParam("num1") double num1, @RequestParam("num2") double num2, @RequestParam("operation") String operation, Model model) {
        double result;
        switch (operation) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;

            default:
                throw new IllegalArgumentException("Несуществующая операция");
        }
        model.addAttribute("result", result);
        return "result";
    }
    @GetMapping("/valute")
    String getValute(){
        return "valute";
    }

    @PostMapping("/convert")
    public String postConvert(@RequestParam("fromCurrency") String fromCurrency, @RequestParam("toCurrency") String toCurrency, @RequestParam("amount") double amount, Model model) {
        double result = 0;
        String _toCurrency = toCurrency;

        if (fromCurrency.equals("USD") && toCurrency.equals("EUR")) {
            result = amount * 0.75;
        } else if (fromCurrency.equals("USD") && toCurrency.equals("RUB")) {
            result = amount * 100;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("USD")) {
            result = amount * 1.25;
        } else if (fromCurrency.equals("EUR") && toCurrency.equals("RUB")) {
            result = amount * 110;
        } else if (fromCurrency.equals("RUB") && toCurrency.equals("USD")) {
            result = amount * 0.01;
        } else if (fromCurrency.equals("RUB") && toCurrency.equals("EUR")) {
            result = amount * 0.009;
        }

        model.addAttribute("result", result);
        model.addAttribute("toCurrency", _toCurrency);
        return "valute";
    }
}

