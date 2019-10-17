/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class Cidadee {
    private Integer codigo;
    private String nome;
    private String sigla;
    private Integer habitantes;
    private LocalDate dia;
    private Double area;
    private Double distancia;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(Integer habitantes) {
        this.habitantes = habitantes;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Cidadee{" + "nome=" + nome + '}';
    }

}
