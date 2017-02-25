package br.com.devcave.ws.client.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonForm {
    private Long id;
    private String email;
    private String name;
}
