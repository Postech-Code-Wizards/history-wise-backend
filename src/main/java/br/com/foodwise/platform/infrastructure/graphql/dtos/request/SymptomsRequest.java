package br.com.foodwise.platform.infrastructure.graphql.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SymptomsRequest {
    private String name;
}
