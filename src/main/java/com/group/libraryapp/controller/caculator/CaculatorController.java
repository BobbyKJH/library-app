package com.group.libraryapp.controller.caculator;

import com.group.libraryapp.dto.calculator.request.CalculatorAddRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//진입 지접으로 만들어 준다. @RestController
@RestController
public class CaculatorController {
    @GetMapping("/add") // Get /add
    public int addTwoNumbers(CalculatorAddRequest request){
        return request.getNumber1() + request.getNumber2();
    }
}

//@RequestParam : Params로 지정