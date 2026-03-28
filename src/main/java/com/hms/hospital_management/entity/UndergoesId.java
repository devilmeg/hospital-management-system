package com.hms.hospital_management.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UndergoesId implements Serializable {

    @Column(name = "Patient", nullable = false)
    private Integer patientId;

    @Column(name = "Procedures", nullable = false)
    private Integer procedureId;

    @Column(name = "Stay", nullable = false)
    private Integer stayId;

    @Column(name = "DateUndergoes", nullable = false)
    private LocalDateTime dateUndergoes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UndergoesId that)) return false;
        return Objects.equals(patientId, that.patientId) &&
                Objects.equals(procedureId, that.procedureId) &&
                Objects.equals(stayId, that.stayId) &&
                Objects.equals(dateUndergoes, that.dateUndergoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, procedureId, stayId, dateUndergoes);
    }
}