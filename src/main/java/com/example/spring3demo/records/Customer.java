package com.example.spring3demo.records;

import org.springframework.data.annotation.Id;

public record Customer(@Id Integer id, String name) {
}
