package com.example.models;

public class Topicos {

    private Integer id;
    private String nivel;
    private String pdf;
    
    public Topicos(Integer id, String nivel, String pdf) {
        this.id = id;
        this.nivel = nivel;
        this.pdf = pdf;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getPdf() {
        return pdf;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    @Override
    public String toString() {
        return "Topicos [id=" + id + ", nivel=" + nivel + ", pdf=" + pdf + "]";
    }
    
    
}
