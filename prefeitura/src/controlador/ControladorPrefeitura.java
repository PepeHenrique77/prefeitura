/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoPrefeitura;
import javax.swing.JOptionPane;
import modelo.Prefeitura;
import tela.manutencao.ManutencaoPrefeitura;
import tela.manutencao.ManutencaoPrefeitura;
import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorPrefeitura {

    public static void inserir(ManutencaoPrefeitura man){
        Prefeitura objeto = new Prefeitura();
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setNr_funcionarios(Integer.parseInt(man.jtfNrFuncionarios.getText()));
        boolean resultado = DaoPrefeitura.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}

    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Nome");
        modelo.addColumn("Descrição");
        List<Prefeitura> resultados = DaoPrefeitura.consultar();
        for (Prefeitura objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getNr_funcionarios());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
