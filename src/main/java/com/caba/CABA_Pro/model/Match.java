package com.caba.CABA_Pro.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "match")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @Column(name = "time", nullable = false)
    private int time; // en kg

    @Column(name = "place", nullable = false)
    private String place; // en cm

    @Column(name = "state")
    private String state; // en cm

    @Column(name = "result")
    private String result; // en cm

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "paciente_id", nullable = false)
    //private Paciente paciente;

    //@ManyToOne(fetch = FetchType.EAGER)
    //@JoinColumn(name = "nutricionista_id", nullable = false)
    //private Nutricionista nutricionista;

    // ==========================
    // Métodos de serialización
    // ==========================

    /*
    @JsonProperty("pacienteInfo")
    public Map<String, Object> getPacienteInfo() {
        if (paciente == null) {
            return null;
        }
        Map<String, Object> info = new HashMap<>();
        info.put("id", paciente.getId());
        info.put("nombre", paciente.getNombre());
        info.put("apellido", paciente.getApellido());
        info.put("email", paciente.getEmail());
        return info; // 🔹 faltaba este return
    }

    @JsonProperty("nutricionistaInfo")
    public Map<String, Object> getNutricionistaInfo() {
        if (nutricionista == null) {
            return null;
        }
        Map<String, Object> info = new HashMap<>();
        info.put("id", nutricionista.getId());
        info.put("nombre", nutricionista.getNombre());
        info.put("apellido", nutricionista.getApellido());
        info.put("numeroLicencia", nutricionista.getNumeroLicencia());
        info.put("especialidad", nutricionista.getEspecialidad());
        return info;
    }

    // ==========================
    // Lógica de dominio
    // ==========================
    public Double calcularIMC() {
        if (altura == null || peso == null || altura <= 0) {
            return null;
        }
        double alturaEnMetros = altura / 100.0;
        return peso / (alturaEnMetros * alturaEnMetros);
    }*/

    // ==========================
    // Constructores
    // ==========================
    public Match() {}

    public Match(Long id, LocalDate date, int time, String place, String state, String result) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.place = place;
        this.state = state;
        this.result = result;
    }
        

    // ==========================
    // Getters y setters (generales)
    // ==========================
    
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public int getTime() { return time; }
    public void setTime(int time) { this.time = time; }

    public String getPlace() { return place; }
    public void setPlace(String place) { this.place = place; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    
}
