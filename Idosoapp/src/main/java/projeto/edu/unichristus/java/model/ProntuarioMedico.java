package projeto.edu.unichristus.java.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ProntuarioMedico {
    private int id;
    private LocalDateTime dataHoraIdosa;
    private Idosa idosa;
    private List<Consulta> consultas;
    private List<Prescricao> prescricoes;
    private List<Vacina> vacinas;
    private List<EventoSentinela> eventosSentinela;

    public ProntuarioMedico() {
        this.consultas = new ArrayList<>();
        this.prescricoes = new ArrayList<>();
        this.vacinas = new ArrayList<>();
        this.eventosSentinela = new ArrayList<>();
    }

    public ProntuarioMedico(int id, LocalDateTime dataHoraIdosa, Idosa idosa, List<Consulta> consultas, List<Prescricao> prescricoes, List<Vacina> vacinas, List<EventoSentinela> eventosSentinela) {
        this.id = id;
        this.dataHoraIdosa = dataHoraIdosa;
        this.idosa = idosa;
        this.consultas = consultas != null ? consultas : new ArrayList<>();
        this.prescricoes = prescricoes != null ? prescricoes : new ArrayList<>();
        this.vacinas = vacinas != null ? vacinas : new ArrayList<>();
        this.eventosSentinela = eventosSentinela != null ? eventosSentinela : new ArrayList<>();
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public LocalDateTime getDataHoraIdosa() { return dataHoraIdosa; }
    public void setDataHoraIdosa(LocalDateTime dataHoraIdosa) { this.dataHoraIdosa = dataHoraIdosa; }
    public Idosa getIdosa() { return idosa; }
    public void setIdosa(Idosa idosa) { this.idosa = idosa; }
    public List<Consulta> getConsultas() { return consultas; }
    public void setConsultas(List<Consulta> consultas) { this.consultas = consultas; }
    public List<Prescricao> getPrescricoes() { return prescricoes; }
    public void setPrescricoes(List<Prescricao> prescricoes) { this.prescricoes = prescricoes; }
    public List<Vacina> getVacinas() { return vacinas; }
    public void setVacinas(List<Vacina> vacinas) { this.vacinas = vacinas; }
    public List<EventoSentinela> getEventosSentinela() { return eventosSentinela; }
    public void setEventosSentinela(List<EventoSentinela> eventosSentinela) { this.eventosSentinela = eventosSentinela; }

    public void adicionarConsulta(Consulta consulta) { this.consultas.add(consulta); }
    public void adicionarPrescricao(Prescricao prescricao) { this.prescricoes.add(prescricao); }
    public void adicionarVacina(Vacina vacina) { this.vacinas.add(vacina); }
    public void adicionarEventoSentinela(EventoSentinela evento) { this.eventosSentinela.add(evento); }

    public String gerarResumoHistorico() {
        StringBuilder sb = new StringBuilder();
        sb.append("Idosa: ").append(idosa != null ? idosa.getNome() : "").append("\n");
        sb.append("Consultas: ").append(consultas.size()).append("\n");
        sb.append("Prescrições: ").append(prescricoes.size()).append("\n");
        sb.append("Vacinas: ").append(vacinas.size()).append("\n");
        sb.append("Eventos Sentinela: ").append(eventosSentinela.size()).append("\n");
        return sb.toString();
    }
}