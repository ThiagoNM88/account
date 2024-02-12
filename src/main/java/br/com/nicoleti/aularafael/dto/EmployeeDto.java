package br.com.nicoleti.aularafael.dto;


import lombok.Data;

@Data
public class EmployeeDto {
    private int id;
    private String nome;
    private String cargo;
    private float salario;
    private float beneficios;

}
