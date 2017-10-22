package Model;

import java.sql.*;

public class BancoDeDados {
    private final String url = "jdbc:postgresql://localhost:5432/postgres";
    private final String user = "postgres";
    private final String password = "rpypk";
    
    public Connection conectar(){
        Connection conexao = null;
        
        try{
            conexao = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Banco de Dados Conectado");
        }catch (SQLException erro){
            System.out.println("Falha ao conectar: "+erro.getMessage());
        }
        return conexao;
    }
    
    public void cadastrarProduto(Produto produto){
        String SQL = "INSERT INTO public.produto "
                + "(nome, preco, categoria)"
                + "VALUES (?, ?, ?)";
        long idGerado = 0;
        
        try (Connection conexao = conectar(); PreparedStatement pstmt = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
            pstmt.setString(1, produto.getNome());
            pstmt.setFloat(2, produto.getPreco());
            pstmt.setInt(3, 1);
            
            int temp = pstmt.executeUpdate();
            
            if(temp > 0){
                try (ResultSet rs = pstmt.getGeneratedKeys()){
                    idGerado = rs.getLong(1);
                } catch(SQLException erro){
                    System.out.println("Erro ao gerar chave: "+erro.getMessage());
                }
            }
        }catch(SQLException erro){
            System.out.println("Erro ao inserir novo produto: "+erro.getMessage());
        }
    }
    
    public void cadastrarUsuario(Usuario usuario){
        String SQL = "INSERT INTO public.usuario"
                    +"(nome, sobrenome, email, senha, tipo)"
                    +"VALUES (?, ?, ?, ?, ?)";
        long chave = 0;
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS)){
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getSobrenome());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getSenha());
            ps.setInt(5, usuario.getTipo());

            int temp = ps.executeUpdate();
            if(temp > 0){
                try (ResultSet rs = ps.getGeneratedKeys()){
                    chave = rs.getLong(1);
                }catch(SQLException erro){
                    System.out.println("Erro ao gerar chave primária do usuário: "+erro.getMessage());
                }
            }
        }catch(SQLException erro){
            System.out.println("Erro ao inserir Usuário: "+erro.getMessage());
        }
    }
    
    public boolean verificarEmailLogin(Usuario usuario){
        String SQL = "SELECT count(*) FROM public.usuario WHERE email = ?";
        int total = 0;
        try (Connection conexao = conectar(); PreparedStatement ps = conexao.prepareStatement(SQL)){
            ps.setString(1, usuario.getEmail());
            ResultSet rs = ps.executeQuery();
            rs.next();
            total = rs.getInt(1);
            System.out.println("Consulta realizada com sucesso!");
        } catch(SQLException erro){
            System.out.println("Falha ao executar consulta: "+erro.getMessage());
        }
        
        return total == 0;
    }
}
