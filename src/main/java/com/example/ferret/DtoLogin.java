package com.example.ferret;

public class DtoLogin {

    public class LoginDt {
        private String nome = "Rubens Leme";
        private String usuario = "admin";
        private String senha = "admin";

        public LoginDt(String nome, String usuario, String senha) {
            this.nome = nome;
            this.usuario = usuario;
            this.senha = senha;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getUsuario() {
            return usuario;
        }

        public void setUsuario(String usuario) {
            this.usuario = usuario;
        }

        public String getSenha() {
            return senha;
        }

        public void setSenha(String senha) {
            this.senha = senha;
        }

    }
}