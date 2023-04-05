package Dell_IT_Academy.Data;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    public static Map<String, Map<String,Integer>> fillData() {

        Map<String, Map<String, Integer>> map = new HashMap<>();

        /* Ler o arquivo CSV e preencher o mapa com as distâncias entre as cidades */
        try (BufferedReader br = new BufferedReader(new FileReader("Data/DNIT-Distancias.csv"))) {
            String[] cities = br.readLine().split(";");
            for (String city : cities) {
                map.put(city, new HashMap<>());
            }

            String row;
            int i = 0;
            while ((row = br.readLine()) != null) {
                String[] distances = row.split(";");  /* Separa as distâncias*/
                for (int j = 0; j < distances.length; j++) {
                    map.get(cities[i]).put(cities[j], Integer.parseInt(distances[j]));
                }  //  Map<CidadeOrigem, Map<CidadeDestino, distância>>
                i++;
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return map;
    }
}
