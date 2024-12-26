package com.start.templatejava.dto.auth;

import java.util.List;

/**
 * DTO de la réponse du JXT.
 */
public class JwtResponseDTO {
    private long id;
    private boolean asset;
    private List<String> roles;
    private String token;

    public JwtResponseDTO() {
        super();
    }

    public JwtResponseDTO(long id, boolean asset, List<String> roles, String token) {
        this.id = id;
        this.asset = asset;
        this.roles = roles;
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public boolean isAsset() {
        return asset;
    }

    public List<String> getRoles() {
        return roles;
    }

    public String getToken() {
        return token;
    }
}
