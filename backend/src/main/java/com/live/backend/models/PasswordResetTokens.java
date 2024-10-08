package com.live.backend.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "password_reset_tokens")
public class PasswordResetTokens {

    @Id
    @Column(length = 255,nullable = false)
    private String email;

    @Column(length = 255,nullable = false)
    private String token;

    @Column(nullable = true)
    private LocalDateTime created_at;


}
