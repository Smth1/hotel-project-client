package entities.dto;

import entities.CleaningReport;
import lombok.Data;

import java.util.List;

@Data
public class CleaningReportDTO {
    private final List<CleaningReport> reports;
}
