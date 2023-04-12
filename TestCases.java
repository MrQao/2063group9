package usecase;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestCases {

  private static List<Architect> architects = new ArrayList<>();
  private static List<Engineer> engineers = new ArrayList<>();
  private static List<Project> projects = new ArrayList<>();

  public static void main(String[] args) {
    // Load data from XML files
    loadDataFromXMLFiles();

    // Batch registration of end-users
    batchRegistrationOfEndUsers();

    // Assigning a project to an architect
    assignProjectToArchitect("P_1", 2);
    assignProjectToArchitect("P_1", 5);
    assignProjectToArchitect("P_1", 5);
    assignProjectToArchitect("P_1", 6);
    assignProjectToArchitect("P_3", 5);
    assignProjectToArchitect("P_4", 5);
    assignProjectToArchitect("P_5", 5);

    // Assigning a project to an engineer
    assignProjectToEngineer("P_1", 1, 0);
    assignProjectToEngineer("P_1", 7, 5);
    assignProjectToEngineer("P_1", 1, 5);
    assignProjectToEngineer("P_1", 1, 5);
    assignProjectToEngineer("P_2", 1, 5);
    assignProjectToEngineer("P_3", 1, 5);
    assignProjectToEngineer("P_4", 1, 5);
    assignProjectToEngineer("P_5", 1, 5);
    assignProjectToEngineer("P_3", 0, 5);

    // Updating a completion percentage
    updateCompletionPercentage("P_1", 5, 110.0);
    updateCompletionPercentage("P_1", 6, 90.0);
    updateCompletionPercentage("P_1", 5, 90.0);

    // Printing a completion percentage
    printCompletionPercentage("P_1", 5);
    printCompletionPercentage("P_1", 6);
  }

  private static void loadDataFromXMLFiles() {
    try {
      File architectsFile = new File("architects.xml");
      File engineersFile = new File("engineers.xml");
      File projectsFile = new File("projects.xml");

      DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

      // Load architects data
      Document architectsDoc = dBuilder.parse(architectsFile);
      architectsDoc.getDocumentElement().normalize();
      NodeList architectList = architectsDoc.getElementsByTagName("architect");
      for (int i = 0; i < architectList.getLength(); i++) {
        Node node = architectList.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
          Element element = (Element) node;
          int id = Integer.parseInt(element.getAttribute("id"));
          String name = element.getElementsByTagName("name").item(0).getTextContent();
          Architect architect = new Architect(id, name);
          architects.add
         }
      }
    }
  }
    