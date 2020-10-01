package entities.dto;

import entities.CleaningReport;
import lombok.Data;

import java.util.List;

@Data
public final class CleaningReportDTO {
    private final List<CleaningReport> reports;
}
