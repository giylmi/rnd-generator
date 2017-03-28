package ru.usifow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.usifow.repository.BitsRepository;
import ru.usifow.repository.InternetSourceBitsRepository;

/**
 * Created by adel on 28.03.17.
 */
@Controller
public class RandomGeneratorController {

    @Autowired
    @Qualifier("hotbitsRepository")
    private BitsRepository bitsRepository;


    @RequestMapping
    public String index() {
        return "index";
    }
}
