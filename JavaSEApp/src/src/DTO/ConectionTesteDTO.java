/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author BRAVANTIC
 */
@Getter
@Setter
@AllArgsConstructor
public class ConectionTesteDTO {
    private String Host;
    private String Port;
    private String Database;
    private String Username;
    private String Password;
    private String SGBD;
    private byte[] DllBytes;
}
