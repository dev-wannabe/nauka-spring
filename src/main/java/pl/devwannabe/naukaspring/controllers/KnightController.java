package pl.devwannabe.naukaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.services.KnightService;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getknights(Model model) {
        List<Knight> allKnigts = knightService.getAllknights();
        model.addAttribute("knights", allKnigts);
        return "knights";
    }
}
