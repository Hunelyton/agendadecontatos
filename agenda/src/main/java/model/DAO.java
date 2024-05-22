package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	/** Módulo de conexão **/
	// parametros de conexção
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://127.0.0.1:3306/agenda?useTimezone=true&serverTimezone=UTC";
	private final String user = "root";
	private String password = "Hume1006@*";

	// métodos de conexão
	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	/* CRUD CREAT */
	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,telefone,email) values (?,?,?)";
		try {

			// abrir conexão com o BD
			Connection con = conectar();

			// prepara a query para gravar no BD
			PreparedStatement pst = con.prepareStatement(create);

			// substituir os parametros pelo conteudo das variaveis JavaBeans
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getTelefone());
			pst.setString(3, contato.getEmail());

			// Executa a query
			pst.executeUpdate();

			// Encerra a conexão com o BD por melhorar o desempenho e segurança
			con.close();

		} catch (Exception e) {
			System.out.println(e);

		}

	}

	/** CRUD READ **/
	public ArrayList<JavaBeans> listarContatos() {
		// Objeto para acessar o JavaBeans
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			// abrir conexão com BD
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			// enquanto houver contatos o laço abaixo vai sempre estar rodando para trazer a
			// ordem
			while (rs.next()) {
				// variavel que recebe dados do BD
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String telefone = rs.getString(3);
				String email = rs.getString(4);
				// armazenando no vetor dinamico ( ArrayList)
				contatos.add(new JavaBeans(id, nome, telefone, email));
			}
			// Encerrando conexão com BD
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
