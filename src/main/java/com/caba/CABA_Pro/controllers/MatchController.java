package com.caba.CABA_Pro.controllers;

import com.caba.CABA_Pro.model.Match;
import com.caba.CABA_Pro.repository.MatchRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/matches")
public class MatchController {

    private final MatchRepository matchRepository;

    public MatchController(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    // Mostrar lista de partidos
    @GetMapping
    public String listMatches(Model model) {
        model.addAttribute("title", "Lista de Partidos");
        model.addAttribute("matches", matchRepository.findAll());
        return "matches/matchList";
    }

    // Formulario
    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("title", "Formulario de Partido");
        model.addAttribute("matchForm", new MatchForm());
        return "matches/form";
    }

    // Guardar partido
    @PostMapping
    public String saveMatch(
            @Valid @ModelAttribute("matchForm") MatchForm form,
            BindingResult result,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("title", "Formulario de Partido");
            return "matches/form";
        }

        // Convertir DTO a entidad
        Match match = new Match();
        match.setDate(form.getDate());
        match.setTime(form.getTime());
        match.setPlace(form.getPlace());
        match.setState(form.getState());
        match.setResult(form.getResult());

        matchRepository.save(match);

        redirectAttributes.addFlashAttribute("successMessage", "El partido se creó correctamente 🎉");
        // PRG Pattern → evita reenvío del formulario al refrescar
        return "redirect:/matches";
    }

    // Mostrar detalles de un partido
    @GetMapping("/{idMatch}")
    public String showMatch(@PathVariable Long idMatch, Model model) {
        Match match = matchRepository.findById(idMatch)
                .orElseThrow(() -> new IllegalArgumentException("Invalid match ID: " + idMatch));

        model.addAttribute("title", "Detalles del Partido");
        model.addAttribute("match", match);
        return "matches/detail";
    }

    // Eliminar partido
    @PostMapping("/{idMatch}/delete")
    public String deleteMatch(@PathVariable Long idMatch, RedirectAttributes redirectAttributes) {
        if (matchRepository.existsById(idMatch)) {
            matchRepository.deleteById(idMatch);
            redirectAttributes.addFlashAttribute("successMessage", "El partido fue eliminado correctamente 🗑️");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "El partido no existe ❌");
        }
        return "redirect:/matches";
    }

}
