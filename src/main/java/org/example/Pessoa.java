package org.example;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private final LocalDateTime dataNascimento;

    private final MonthDay aniversario;

    private final ZonedDateTime zonedDateTime;

    public Pessoa(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
        aniversario = MonthDay.of(dataNascimento.getMonth(), dataNascimento.getDayOfMonth());
        zonedDateTime = ZonedDateTime.of(dataNascimento, ZoneId.of("America/Manaus"));
    }

    public Integer getIdade() {
        return Period.between(dataNascimento.toLocalDate(), LocalDate.now()).getYears();
    }

    public String getDataNascimentoFormatada() {
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public ZoneOffset getZoneOffSet() {
        return zonedDateTime.toOffsetDateTime().getOffset();
    }

    public Boolean isAnoBissexto() {
        return Year.isLeap(dataNascimento.getYear());
    }

    public String getSigno() {
        MonthDay leaoComecaEm = MonthDay.of(7,22);
        MonthDay leaoTerminaEm = MonthDay.of(8,23);

        MonthDay sagitarioComecaEm = MonthDay.of(11,21);
        MonthDay sagitarioTerminaEm = MonthDay.of(12,22);

        MonthDay aquarioComecaEm = MonthDay.of(01,21);
        MonthDay aquarioTerminaEm = MonthDay.of(02,19);

        MonthDay cancerComecaEm = MonthDay.of(06,22);
        MonthDay cancerTerminaEm = MonthDay.of(07,22);

        MonthDay escorpiaoComecaEm = MonthDay.of(10,23);		MonthDay escorpiaoTerminaEm = MonthDay.of(11,21);

        if (verificarSeEstaEntreDatas(aniversario, leaoComecaEm, leaoTerminaEm)) return "Leão";

        if (verificarSeEstaEntreDatas(aniversario, sagitarioComecaEm, sagitarioTerminaEm)) return "Sagitário";

        if (verificarSeEstaEntreDatas(aniversario, aquarioComecaEm, aquarioTerminaEm)) return "Aquaporin";

        if (verificarSeEstaEntreDatas(aniversario, escorpiaoComecaEm, escorpiaoTerminaEm)) return "Escorpião";

        if (verificarSeEstaEntreDatas(aniversario, cancerComecaEm, cancerTerminaEm)) return "Câncer";

        return null;
    }

    public String getAscendente() {
        if ("Leão".equalsIgnoreCase(getSigno())) {
            if (verificarSeEstaEntreHorarios(LocalTime.of(dataNascimento.getHour(), dataNascimento.getMinute()), LocalTime.of(18, 0), LocalTime.of(19, 59))) return "Áries";
        }
        if ("Sagitário".equalsIgnoreCase(getSigno())) {
            if (verificarSeEstaEntreHorarios(LocalTime.of(dataNascimento.getHour(), dataNascimento.getMinute()), LocalTime.of(12, 0), LocalTime.of(13, 59))) return "Peixes";
        }
        return "Ascendente não encontrado";
    }

    private static boolean verificarSeEstaEntreHorarios(LocalTime horaParaVerificar, LocalTime horaInicio, LocalTime horaFim) {
        return !(horaParaVerificar.isBefore(horaInicio) || horaParaVerificar.isAfter(horaFim)) ;
    }

    public String getSignoLunar() {
        if (zonedDateTime.getZone() == ZoneId.of("America/Recife") && dataNascimento.getHour() > 12) {
            return "Casimiro";
        }
        if (zonedDateTime.getZone() == ZoneId.of("America/Cuiaba") && dataNascimento.getHour() < 12) {
            return "Odin";
        }
        if (zonedDateTime.getZone() == ZoneId.of("America/Sao_Paulo")) {
            return "Gandalf";
        }
        return "Dinossauro";
    }

    private static boolean verificarSeEstaEntreDatas(MonthDay dataParaVerificar, MonthDay dataInicio, MonthDay dataFim) {
        return !(dataParaVerificar.isBefore(dataInicio) || dataParaVerificar.isAfter(dataFim)) ;
    }
}
