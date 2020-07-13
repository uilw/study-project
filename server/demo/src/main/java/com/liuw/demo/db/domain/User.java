package com.liuw.demo.db.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 6809540790892658918L;

    private Long id;

    private String username;

    private String password;
}