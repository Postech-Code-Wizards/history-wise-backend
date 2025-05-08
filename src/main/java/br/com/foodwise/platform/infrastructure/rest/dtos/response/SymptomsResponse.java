package br.com.foodwise.platform.infrastructure.rest.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.graphql.data.method.annotation.SchemaMapping;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@SchemaMapping(typeName = "SymptomsResponse")
public class SymptomsResponse {
    private Long id;
    private String name;
    private ZonedDateTime createdAt;
}
