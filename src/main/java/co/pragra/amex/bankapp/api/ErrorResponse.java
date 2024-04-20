package co.pragra.amex.bankapp.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String errCode;
    private Date  errorDate;
    private String message;
}
