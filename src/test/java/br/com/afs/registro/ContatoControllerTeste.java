package br.com.afs.registro;

import br.com.afs.registro.entities.Contato;
import br.com.afs.registro.webservice.Http;

public class ContatoControllerTeste {

	public static void main(String[] args) throws Exception {
		Http http = new Http();
		Contato c = new Contato();
		String url = "http://localhost:8080/contatos/";
		System.out.println("busca todos os contatos salvos:");
		http.sendGet(url);
		System.out.println("Busca contato por Id:");
		http.sendGet(url + "/1");
		c.setNome("bob");
		c.setEmail("bob@teste.com");
		c.setCelular("11 999999999");
		System.out.println("cadastra novo contato:");
		http.sendMethod(url, "{\"nome\":\"" + c.getNome() + "\",\"email\":\"" + c.getEmail() + "\",\"celular\":\""
				+ c.getCelular() + "\"}", "POST");
		System.out.println("Atualiza contato específico:");
		http.sendMethod(url + "1/", "{\"nome\":\"" + c.getNome() + "\",\"email\":\"" + c.getEmail()
				+ "\",\"celular\":\"" + c.getCelular() + "\"}", "PUT");
		System.out.println("exclui contato:");
		http.sendMethod(url + "1", "", "DELETE");
	}
}