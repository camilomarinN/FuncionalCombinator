package com.ces2.combinatorFunction.Utils;

import com.ces2.combinatorFunction.Enums.GENERO;
import com.ces2.combinatorFunction.Enums.ValidatorEnum;
import com.ces2.combinatorFunction.Models.Estudiante;

import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.function.Function;

public interface EstudianteValidator extends Function<Estudiante, ValidatorEnum> {

    static EstudianteValidator allValidations() {
        return estudiante -> {
            if (estudiante.getEmail() == null || !estudiante.getEmail().contains("@")) {
                return ValidatorEnum.EMAIL_NOT_VALID;
            }
            if (estudiante.getGenero() == null || !Arrays.stream(GENERO.values())
                    .anyMatch(genero -> genero.name().equals(estudiante.getGenero()))) {
                return ValidatorEnum.GENDER_NOT_VALID;
            }
            int edad = Period.between(estudiante.getFechaNacimiento(), LocalDate.now()).getYears();
            if (edad < 18) {
                return ValidatorEnum.IS_NOT_ADULT;
            }
            return ValidatorEnum.SUCCESS;
        };
    }
}