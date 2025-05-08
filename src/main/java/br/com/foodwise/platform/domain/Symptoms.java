package br.com.foodwise.platform.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Getter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Symptoms {
    private Long id;
    private String name;
    private ZonedDateTime createdAt;
}
