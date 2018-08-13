package pl.devwannabe.naukaspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.devwannabe.naukaspring.components.TimeComponent;
import pl.devwannabe.naukaspring.domain.Knight;
import pl.devwannabe.naukaspring.domain.PlayerInformation;
import pl.devwannabe.naukaspring.services.KnightService;

import java.util.List;

@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService knightService;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnigts = knightService.getAllknights();
        model.addAttribute("knights", allKnigts);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerInformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value="/knights", method = RequestMethod.POST)
    public String saveKnight(Knight knight) {
        knightService.saveKnight(knight);
        return "redirect:/knights";
    }

    @RequestMapping(value="/knight/delete/{id}")
    public String deleteKnight(@PathVariable("id") Integer id) {
        knightService.deleteKnight(id);
        return "redirect:/knights";
    }
}