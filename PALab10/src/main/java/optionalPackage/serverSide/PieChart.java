package optionalPackage.serverSide;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class PieChart extends ApplicationFrame {
    private static SocialNetworkServer serverData;

    public PieChart( String title, SocialNetworkServer server ) {
        super( title );
        serverData = server;
        setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset( ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
        serverData.getListOfUsers().forEach(x -> dataset.setValue(x ,
                serverData.numberOfFriends.get(serverData.getListOfUsers().indexOf(x))));
        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {

        return ChartFactory.createPieChart(
                "Total Friendships",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);
    }

    public static JPanel createDemoPanel( ) {
        JFreeChart chart = createChart(createDataset( ) );
        return new ChartPanel( chart );
    }
}
