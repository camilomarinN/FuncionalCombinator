package com.ces2.combinatorFunction.Controllers;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ces2.combinatorFunction.Enums.GENERO;
import com.ces2.combinatorFunction.Enums.ValidatorEnum;
import com.ces2.combinatorFunction.Models.Estudiante;
import com.ces2.combinatorFunction.Utils.EstudianteValidator;

@Controller
public class Controllers {

    @GetMapping("/")
    public String index(Model model) {

        // correcto
        Estudiante estudiante1 = new Estudiante(
                "camilo",
                "camilo_marin@gmail.com",
                GENERO.MALE.name(),
                LocalDate.of(2000, 1, 1));

        // Correo equivocado
        Estudiante estudiante2 = new Estudiante(
                "daniela",
                "danigmail.com",
                GENERO.FEMALE.name(),
                LocalDate.of(2000, 1, 1));

        // Genero incorrecto
        Estudiante estudiante3 = new Estudiante(
                "Alice",
                "test@gmail.com",
                "extraterrestre",
                LocalDate.of(2000, 1, 1));

        // menor de edad
        Estudiante estudiante4 = new Estudiante(
                "Miguel",
                "MNC@gmail.com",
                GENERO.OTHER.name(),
                LocalDate.of(2010, 1, 1));

        ValidatorEnum resultado1 = EstudianteValidator.allValidations().apply(estudiante1);
        ValidatorEnum resultado2 = EstudianteValidator.allValidations().apply(estudiante2);
        ValidatorEnum resultado3 = EstudianteValidator.allValidations().apply(estudiante3);
        ValidatorEnum resultado4 = EstudianteValidator.allValidations().apply(estudiante4);

        model.addAttribute("correcto", resultado1);
        model.addAttribute("correo", resultado2);
        model.addAttribute("genero", resultado3);
        model.addAttribute("edad", resultado4);
        return "index";
    }
}
