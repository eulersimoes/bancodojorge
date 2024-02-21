package br.com.bancodojorge.apirest.domain.util;

import br.com.bancodojorge.apirest.domain.model.Cliente;

import java.sql.Date;


public class ClienteUtil {

    public static Cliente gerarClienteAleatorio()
    {
            Cliente cliente = new Cliente();
            String clienteNome = GeradorNomesUtil.generateName();
            String clienteCpf = GeradorCPFUtil.gerarCpf();
            String clienteEndereco = GeradorEnderecoUtil.gerarEndereco();
            Date clienteDataNascimento = GeradorDataNascimento.gerarData();
            cliente.setNome(clienteNome);
            cliente.setCpf(clienteCpf);
            cliente.setEndereco(clienteEndereco);
            cliente.setDataNascimento(clienteDataNascimento);
            return cliente;
    }
}
