package com.hms.hospital_management.dto.response;

import com.hms.hospital_management.entity.Trained_In;
import lombok.*;

/**
 * Data Transfer Object representing a simplified view of
 * Training /  Procedure's Training done by a doctor/ physician
 *  This DTO aggregates information from Trained_In , Procedure
 *  into a flat structure .
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoctorProcedureDTO {
    /** Training id of the doctor */
    private Integer id;
    /** Name of the Training */
    private String procedureName;
    /** Name of the Procedure*/
    private String name;
    /** Cost of the Training */
    private Double cost;
    /** Current status of the Training */
    private String status;

    /**
     * Maps an {@link Trained_In} to {@link DoctorProcedureDTO}
     *
     * <p>
     *     Performs safety check for the null fields
     * </p>
     *
     * @param entity  the source Trained_In thing
     */
    public DoctorProcedureDTO(Trained_In entity) {
        if (entity != null && entity.getProcedure() != null) {
            this.id = entity.getProcedure().getCode();
            this.procedureName = entity.getProcedure().getName();
            this.cost = entity.getProcedure().getCost();
            this.name = entity.getPhysician() != null ? entity.getPhysician().getName() : "N/A";

            // Adding a 5th field: Certification Date or Status
            this.status = "Certified since " + (entity.getCertificationDate() != null ? entity.getCertificationDate() : "N/A");
        }
    }
}
