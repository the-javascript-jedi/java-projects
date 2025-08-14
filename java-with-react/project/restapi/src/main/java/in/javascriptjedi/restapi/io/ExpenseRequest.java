package in.javascriptjedi.restapi.io;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenseRequest {

    @NotEmpty
    private String name;

    private String note;

    @NotBlank
    private String category;

    @NotNull
    private Date date;
    @NotNull
    private BigDecimal amount;
}



