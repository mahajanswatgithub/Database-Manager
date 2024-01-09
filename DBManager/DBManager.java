import java.io.*;
import java.util.*;

public class DBManager {
    private static final String METADATA_FILE = "metadata.txt";
    private static final String TABLE_DIR = "tables";

    public static void createTable(String query) {
        try {
            File metadataFile = new File(METADATA_FILE);
            FileWriter metadataWriter = new FileWriter(metadataFile, true);
            BufferedWriter metadataBufferedWriter = new BufferedWriter(metadataWriter);

            metadataBufferedWriter.write(query);
            metadataBufferedWriter.newLine();
            metadataBufferedWriter.close();

            String[] parts = query.split("\\(");
            String tableName = parts[0].split("CREATE TABLE ")[1].trim();
            File tableFile = new File(TABLE_DIR + File.separator + tableName + ".txt");
            tableFile.createNewFile();
            System.out.println("Table '" + tableName + "' created successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insertIntoTable(String query) {
        try {
            String[] splitQuery = query.split("VALUES");
            String tableName = splitQuery[0].split("INSERT INTO ")[1].trim();
            File tableFile = new File(TABLE_DIR + File.separator + tableName + ".txt");

            FileWriter tableWriter = new FileWriter(tableFile, true);
            BufferedWriter tableBufferedWriter = new BufferedWriter(tableWriter);

            String values = splitQuery[1].replaceAll("[(),']", "").trim();
            tableBufferedWriter.write(values);
            tableBufferedWriter.newLine();
            tableBufferedWriter.close();

            System.out.println("Values inserted into table '" + tableName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showTableContents(String tableName) {
        try {
            File tableFile = new File(TABLE_DIR + File.separator + tableName + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(tableFile));
            String line;

            System.out.println("Table Contents for '" + tableName + "':");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Into Table");
            System.out.println("3. Show Table Contents");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    System.out.println("Enter CREATE TABLE query:");
                    String createQuery = scanner.nextLine();
                    createTable(createQuery);
                    break;
                case 2:
                    System.out.println("Enter INSERT INTO query:");
                    String insertQuery = scanner.nextLine();
                    insertIntoTable(insertQuery);
                    break;
                case 3:
                    System.out.println("Enter table name:");
                    String tableName = scanner.nextLine();
                    showTableContents(tableName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }
}
