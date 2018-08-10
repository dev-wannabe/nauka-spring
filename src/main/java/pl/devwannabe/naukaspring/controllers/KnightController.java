package pl.devwannabe.naukaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.services.KnightService;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnigts = knightService.getAllknights();
        model.addAttribute("knights", allKnigts);
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value="/knights", method = RequestMethod.POST)
    public String saveKnight(Knight knight) {
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }
}