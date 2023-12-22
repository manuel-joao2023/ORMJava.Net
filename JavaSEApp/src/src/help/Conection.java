/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package help;

import DTO.ConectionTesteDTO;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author BRAVANTIC
 */
public class Conection {

    static String url = "https://localhost:7255/";
    static Gson json = new Gson();
    static String jsonResult;

    public static String RequestConectionApiPost(byte[] bytes, ConectionTesteDTO dto, Emuns opcao) {
        
        try {
            String newUrl = url + UrlByParam(opcao);
            if (bytes != null) {
                 jsonResult = json.toJson(bytes);
            }else if(dto != null){
                 jsonResult = json.toJson(dto);
            }  
            URL urlApi = new URL(newUrl);
            HttpsURLConnection con = (HttpsURLConnection) urlApi.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            // Configurar cabeçalhos
            con.setRequestProperty("Content-Type", "application/json");

            // Abre uma stream de saída para enviar os dados JSON para o servidor
            try (OutputStream os = con.getOutputStream()) {
                byte[] jsonBytes = jsonResult.getBytes("utf-8");
                os.write(jsonBytes, 0, jsonBytes.length);
            }

            // Lê a resposta da API
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String resposta = reader.lines().collect(Collectors.joining("\n"));
                // Criando um objeto GsonBuilder e registrando o deserializador personalizado
                return resposta;
            } catch (Exception e) {
                System.err.println("e: " + e.getMessage());
            }
            con.disconnect();

        } catch (IOException e) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, e);
        } catch (Exception ex) {
            Logger.getLogger(Conection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String UrlByParam(Emuns option) throws Exception {
        switch (option) {
            case DLLCONTENT:
                return "Files/DllContent";
            case TESTCONECTION:
                return "TestConection";
            case GenerateDatabase:
                return "Files/GenerateDatabase";
            case GenerateDatabaseByJar:
                return "Files/GenerateDatabaseByJar";
        }
        throw new Exception("Url invalido");
    }
}
