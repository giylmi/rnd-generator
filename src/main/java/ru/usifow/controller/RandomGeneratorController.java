package ru.usifow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.usifow.model.BitsSequence;
import ru.usifow.repository.BitsRepository;
import ru.usifow.repository.InternetSourceBitsRepository;
import ru.usifow.util.BitsSequenceBase64Serializer;
import ru.usifow.util.BitsSequenceHexSerializer;

/**
 * Created by adel on 28.03.17.
 */
@Controller
@RequestMapping("/")
public class RandomGeneratorController {

    @Autowired
    @Qualifier("hotbitsRepository")
    private BitsRepository bitsRepository;


    @RequestMapping
    public String index() {
        return "index";
    }

    @RequestMapping(value="/api/rnd", method = RequestMethod.POST, produces = "text/plain")
    @ResponseBody
    public String generate(@ModelAttribute RndRequest req) {
        BitsSequence bitsSequence = bitsRepository.getBitsSequence(req.getNum().shortValue());
        if (req.getType().equals("hex")) {
            return new BitsSequenceHexSerializer().serialize(bitsSequence);
        }
        else if (req.getType().equals("base64")) {
            return new BitsSequenceBase64Serializer().serialize(bitsSequence);
        }
        else if (req.getType().equals("bin")) {
            return bitsSequence.print();
        }
        return "unknown type: " + req.getType();
    }
}
