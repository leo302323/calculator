package com.airwallex.calculator;

import com.airwallex.calculator.core.Calculator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author lezha13
 */
@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while (!"".equals(input)) {
            calculator.calculate(input);
            input = br.readLine();
        }
        System.out.println(input);
    }

}
