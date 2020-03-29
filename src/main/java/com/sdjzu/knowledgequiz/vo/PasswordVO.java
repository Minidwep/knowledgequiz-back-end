package com.sdjzu.knowledgequiz.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PasswordVO {
    String exPwd;
    String account;
    String pwd;
}
