package optionalPackage.catalogPackage;

import optionalPackage.itemsPackage.Items;

import java.io.*;
import java.util.Map;

public class ReportCommand {

    public ReportCommand(Catalog catalog){
      this.ReportHTML(catalog);
    }

    public void ReportHTML(Catalog catalog)
    {
        try {
            StringBuilder htmlStringBuilder = new StringBuilder();
            htmlStringBuilder.append("<html>\n<head>\n<title>Catalog</title>\n</head>\n<body>\n");
            htmlStringBuilder.append("<h1>The contents of the catalog are:</h1>\n");
            for(Map.Entry<String, Items> entry : catalog.itemsMap.entrySet())
            {
                Items item = entry.getValue();
                htmlStringBuilder.append("<p style='color: red; font-size: 2em;'>\n");
                htmlStringBuilder.append("<a href='");
                htmlStringBuilder.append(catalog.localPath).append(item.getFullPath());
                htmlStringBuilder.append("'>\n");
                htmlStringBuilder.append(item.getCatalogNameFile());
                htmlStringBuilder.append("</a>\n").append(" - ").append(item.getFileDescription()).append("</p>\n");
            }
            htmlStringBuilder.append("</body></html>");
            WriteToFile(htmlStringBuilder.toString(),"TheReport.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void WriteToFile(String fileContent, String fileName) throws IOException {
        String projectPath = System.getProperty("user.dir");
        String tempFile = projectPath + File.separator + fileName;
        File file = new File(tempFile);
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();
    }
}
