package br.com.foodwise.platform.infrastructure.rest.dtos.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SchemaMapping(typeName = "SymptomsRequest")
public class SymptomsRequest {
    private String name;
}
