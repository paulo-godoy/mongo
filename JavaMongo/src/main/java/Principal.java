import java.sql.Date;
import java.util.Arrays;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class Principal {

	public static void main(String[] args) {
		 MongoClient cliente = new MongoClient();
	        MongoDatabase bancoDeDados = cliente.getDatabase("test");
	        MongoCollection<Document> alunos = bancoDeDados.getCollection("alunos");
	        Document aluno = alunos.find().first();
	        Document novoAluno = new Document("nome", "Paulo")
	                .append("data_nascimento", new Date(2018, 01, 18))
	                .append("curso", new Document("nome", "Analise e desenvolvimento de sistemas"))
	                .append("notas", Arrays.asList(10, 9, 8))
	                .append("habilidades", Arrays.asList(
	                        new Document().append("nome", "Ingles").append("nível", "Básico"),
	                        new Document().append("nome", "Espanhol").append("nível", "Básico")));

//	        alunos.insertOne(novoAluno); //insere aluno
	        
//	        alunos.updateOne(Filters.eq("nome", "Murilo Dalbosco"),
//	        	    new Document("$set", new Document("nome", "Murilo Dalbosco Godoy"))); //faz update no aluno
	        
//	        alunos.deleteOne(Filters.eq("nome", "Joao Silva")); //deleta aluno
	       
	        
	        
	        cliente.close();

	}

}
