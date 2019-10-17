/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import modelo.Cidadee;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Administrador
 */
public class DaoCidadee {
     public static boolean inserir(Cidadee objeto) {
        String sql = "INSERT INTO cidadee (nome, sigla, habitantes, dia, area, distancia) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getSigla());
            ps.setInt(3, objeto.getHabitantes());
            ps.setDate(4, Date.valueOf(objeto.getDia()));
            ps.setDouble(5, objeto.getArea());
            ps.setDouble(6, objeto.getDistancia());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static void main(String[] args) {
        Cidadee objeto = new Cidadee();
        objeto.setNome("Quinze");
        objeto.setSigla("R");
        objeto.setHabitantes(4500);
        objeto.setDia(LocalDate.parse("11/01/1988", DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        objeto.setArea(1.10);
        objeto.setDistancia(4.00);
        boolean resultado = inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
    public static boolean alterar(Cidadee objeto) {
        String sql = "UPDATE cidadee SET nome = ?, sigla = ?, habitantes = ?, dia = ?, area = ?, distancia = ? WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, objeto.getNome());
            ps.setString(2, objeto.getSigla());
            ps.setInt(3, objeto.getHabitantes());
            ps.setDate(4, Date.valueOf(objeto.getDia()));
            ps.setDouble(5, objeto.getArea());
            ps.setDouble(6, objeto.getDistancia());
            ps.setInt(7, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static boolean excluir(Cidadee objeto) {
        String sql = "DELETE FROM cidadee WHERE codigo=?";
        try {
            PreparedStatement ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, objeto.getCodigo());
            ps.executeUpdate();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return false;
        }
    }
    public static List<Cidadee> consultar() {
        List<Cidadee> resultados = new ArrayList<>();
        //editar o SQL conforme a entidade
        String sql = "SELECT codigo, nome, sigla, habitantes, dia, area, distancia FROM cidadee";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidadee objeto = new Cidadee();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setHabitantes(rs.getInt("habitantes"));
                objeto.setDia(rs.getDate("dia").toLocalDate());
                objeto.setArea(rs.getDouble("area"));
                objeto.setDistancia(rs.getDouble("distancia"));
                
                resultados.add(objeto);//não mexa nesse, ele adiciona o objeto na lista
            }
            return resultados;
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
    public static Cidadee consultar(int primaryKey) {
        //editar o SQL conforme a entidade
        String sql = "SELECT nome, sigla, habitantes, dia, area, distancia FROM cidadee WHERE codigo=?";
        PreparedStatement ps;
        try {
            ps = conexao.Conexao.getConexao().prepareStatement(sql);
            ps.setInt(1, primaryKey);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidadee objeto = new Cidadee();
                //definir um set para cada atributo da entidade, cuidado com o tipo
                objeto.setCodigo(rs.getInt("codigo"));
                objeto.setNome(rs.getString("nome"));
                objeto.setSigla(rs.getString("sigla"));
                objeto.setHabitantes(rs.getInt("habitantes"));
                objeto.setDia(rs.getDate("dia").toLocalDate());
                objeto.setArea(rs.getDouble("area"));
                objeto.setDistancia(rs.getDouble("distancia"));
                return objeto;//não mexa nesse, ele adiciona o objeto na lista
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}