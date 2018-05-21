package com.wagner.cursomc.enums;

public enum TipoCliente {
    PESSOA_FISICA(1, "Pessoa Fisíca"),
    PESSOA_JURIDICA(2, "Pessoa Jurídica");
    private int codigo;
    private String descricao;

    private TipoCliente(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer codigo) {
        if (codigo != null) {
            for (TipoCliente tipoCliente : TipoCliente.values()) {
                if (codigo.equals(tipoCliente.getCodigo())) {
                    return tipoCliente;
                }
            }
            throw new IllegalArgumentException("Código inválido: " + codigo);
        }
        return null;
    }
}
