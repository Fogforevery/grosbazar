package fr.epita.assistants.item_producer.domain.service;

import fr.epita.assistants.item_producer.data.model.GameModel;
import fr.epita.assistants.item_producer.data.model.ItemModel;
import fr.epita.assistants.item_producer.data.repository.GameRepository;
import fr.epita.assistants.item_producer.data.repository.ItemRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@ApplicationScoped
public class GameService {
    @Transactional
    public void deletespecific(List<ItemModel> modelList) {
        for (ItemModel itemModel : modelList) {
            if (itemModel.getId() != null) {
                new ItemRepository().delete(itemModel);
            }
        }
    }

    public static String readmapfile(String fileName) {
        String separator = ";";
        StringBuilder sb = new StringBuilder();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            return null;
        }
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            sb.append(line).append(separator);
        }
        String result = sb.toString();
        scanner.close();
        return result.substring(0, result.length() - separator.length());
    }

    public static String[][] convertStringTo2DArray(String input) {
        String[] lines = input.split(";");
        List<String[]> result = new ArrayList<>();
        for (String line : lines) {
            if (line.trim().isEmpty()) {
                continue;
            }

            List<String> row = new ArrayList<>();
            int i = 0;
            while (i < line.length()) {
                int count = 0;
                while (i < line.length() && Character.isDigit(line.charAt(i))) {
                    count = count * 10 + (line.charAt(i) - '0');
                    i++;
                }

                if (i < line.length() && Character.isLetter(line.charAt(i))) {
                    char type = line.charAt(i);
                    String element = goodblock(type);
                    if (element != null) {
                        for (int j = 0; j < count; j++) {
                            row.add(element);
                        }
                    }
                    i++;
                } else {
                    return null;
                }
            }
            result.add(row.toArray(new String[0]));
        }
        return result.toArray(new String[0][]);
    }

    public static String goodblock(char c) {
        switch (c) {
            case 'R':
                return "ROCK";
            case 'W':
                return "WOOD";
            case 'G':
                return "GROUND";
            case 'O':
                return "WATER";
            case 'M':
                return "MONEY";
            default:
                return null;
        }
    }

    @Transactional
    public static String[][] newGame(String mapPath) {
        new GameRepository().deleteAll();
        GameModel game = new GameModel();
        String basicmap = null;
        basicmap = readmapfile(mapPath);
        if (basicmap == null) {
            return null;
        }
        game.setMap(basicmap);
        new GameRepository().persist(game);
        String[][] map = convertStringTo2DArray(basicmap);
        return map;
    }
}
