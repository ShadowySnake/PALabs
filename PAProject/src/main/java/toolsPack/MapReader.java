package toolsPack;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {
    public static int[] initialPacMap(int gridBlocks) throws IOException {
        FileReader file = new FileReader(Variables.absoluteDirectoryPath +
                "\\src\\main\\resources\\PacMap.txt");
        BufferedReader br = new BufferedReader(file);
        String line;

        int[] map = new int[gridBlocks * gridBlocks];
        int mapPlace = 0;

        while ((line = br.readLine())!=null){
            String[] splitLine = line.split(",");
            for(String value : splitLine){
                map[mapPlace] = Integer.parseInt(value);
                mapPlace = mapPlace + 1;
            }
        }

        return map;
    }
}

