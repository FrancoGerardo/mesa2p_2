package com.ssvs.SSVS.backend.dto;

import java.time.LocalDateTime;

public class EvaluacionDTO {
    private int evaluacionId;
    private int consultaId;
    private int pacienteId;
    private int medicoId;
    private int especialidadId;
    private int puntuacion;
    private String comentario;
    private LocalDateTime fechaEvaluacion;
    private String nombrePaciente;
    private String apellidoPaciente;
    private String nombreMedico;
    private String apellidoMedico;
    private String nombreEspecialidad;
    
    
// Getters y Setters
public String getNombrePaciente() {
    return nombrePaciente;
}

public void setNombrePaciente(String nombrePaciente) {
    this.nombrePaciente = nombrePaciente;
}

public String getApellidoPaciente() {
    return apellidoPaciente;
}

public void setApellidoPaciente(String apellidoPaciente) {
    this.apellidoPaciente = apellidoPaciente;
}

public String getNombreMedico() {
    return nombreMedico;
}

public void setNombreMedico(String nombreMedico) {
    this.nombreMedico = nombreMedico;
}

public String getApellidoMedico() {
    return apellidoMedico;
}

public void setApellidoMedico(String apellidoMedico) {
    this.apellidoMedico = apellidoMedico;
}

public String getNombreEspecialidad() {
    return nombreEspecialidad;
}

public void setNombreEspecialidad(String nombreEspecialidad) {
    this.nombreEspecialidad = nombreEspecialidad;
}
    
    
    // Getters y Setters
    public int getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(int evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public int getConsultaId() {
        return consultaId;
    }

    public void setConsultaId(int consultaId) {
        this.consultaId = consultaId;
    }

    public int getPacienteId() {
        return pacienteId;
    }

    public void setPacienteId(int pacienteId) {
        this.pacienteId = pacienteId;
    }

    public int getMedicoId() {
        return medicoId;
    }

    public void setMedicoId(int medicoId) {
        this.medicoId = medicoId;
    }

    public int getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(int especialidadId) {
        this.especialidadId = especialidadId;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getFechaEvaluacion() {
        return fechaEvaluacion;
    }

    public void setFechaEvaluacion(LocalDateTime fechaEvaluacion) {
        this.fechaEvaluacion = fechaEvaluacion;
    }
}
