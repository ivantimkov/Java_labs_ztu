
import com.education.ztu.game.Team;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        logger.info("Початок виконання програми");

        // 1. Серіалізація
        Team team = new Team("Champions");
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("team.ser"))) {
            oos.writeObject(team);
            logger.info("Серіалізація пройшла успішно.");
        } catch (IOException e) {
            logger.error("Помилка при серіалізації", e);
        }

        // 2. Десеріалізація
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("team.ser"))) {
            Team deserializedTeam = (Team) ois.readObject();
            logger.info("Десеріалізований об'єкт: " + deserializedTeam.getName());
        } catch (IOException | ClassNotFoundException e) {
            logger.error("Помилка при десеріалізації", e);
        }

        // 3. JSON
        Gson gson = new Gson();
        String json = gson.toJson(team);
        logger.info("Об'єкт у форматі JSON: " + json);
        Team teamFromJson = gson.fromJson(json, Team.class);
        logger.info("Об'єкт після десеріалізації з JSON: " + teamFromJson.getName());

        // 4. XML (DOM парсер)
        try {
            File xmlFile = new File("src/main/resources/sample.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Читання XML
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            logger.info("Читання XML: root = " + doc.getDocumentElement().getNodeName());

            // Зміна XML
            Node nameNode = doc.getElementsByTagName("name").item(0);
            nameNode.setTextContent("Updated Team");

            // Збереження XML
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            Result output = new StreamResult(new File("src/main/resources/sample_updated.xml"));
            Source input = new DOMSource(doc);
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(input, output);

            logger.info("XML файл оновлено та збережено.");
        } catch (Exception e) {
            logger.error("Помилка при обробці XML", e);
        }

        logger.info("Кінець виконання програми");
    }
}
