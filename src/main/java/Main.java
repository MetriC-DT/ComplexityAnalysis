import Complexity.Complexity;
import Reader.*;
import Sort.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.stage.Stage;
import Complexity.Performance;

public class Main extends Application {

    private static int maxComplexity = 3000;

    private static Performance performance = Performance.AVERAGE;

    private static Complexity[] complexities = {
            new BubbleSort(),
            new SinkSort(),
            new MergeSort(),
            new QuickSort(),
            /*
            new BufferedReader(),
            new ScannerReader(),
             */
    };

    /**
     * gets the data needed to plot the chart
     * @return array of data points for each complexity
     */
    private Long[][] getData() {
        Long[][] data = new Long[complexities.length][maxComplexity];
        for (int i = 0; i < complexities.length; i++) {
            for (int j = 1; j <= maxComplexity; j++) {
                data[i][j-1] = complexities[i].runTest(j, performance);
            }
        }
        return data;
    }

    public static void main(String[] args) {
        if (args.length == 1) {
            try {
                maxComplexity = Integer.parseInt(args[0]);
                System.out.println("Testing up to " + maxComplexity);
            } catch (Exception e) {
                System.err.println("Argument must be integer. Leave empty to default to " + maxComplexity);
                System.exit(-1);
            }
        } else if (args.length == 2) {
            try {
                maxComplexity = Integer.parseInt(args[0]);
                String p = args[1].toUpperCase();
                switch (p) {
                    case "AVERAGE":
                        performance = Performance.AVERAGE;
                        break;
                    case "WORST":
                        performance = Performance.WORST;
                        break;
                    case "BEST":
                        performance = Performance.BEST;
                        break;
                    default:
                        System.out.println("Unknown performance, defaulting to " + performance.name());
                        break;
                }
                System.out.println("Testing up to " + maxComplexity
                        + " with performance " + performance.name());
            } catch (Exception e) {
                System.err.println(e.getMessage());
                System.exit(-1);
            }
        }
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Long[][] data = getData();
        stage.setTitle("Chart");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Complexity");
        yAxis.setLabel("Time");
        final ScatterChart<Number,Number> chart = new ScatterChart<>(xAxis,yAxis);
        chart.setTitle("Complexity Chart");

        for (int i = 0; i < data.length; i++) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName(complexities[i].name());

            for (int j = 0; j < data[i].length; j++) {
                series.getData().add(new XYChart.Data<>(j, data[i][j]));
            }

            chart.getData().add(series);
        }

        Scene scene  = new Scene(chart,800,600);

        stage.setScene(scene);
        stage.show();
    }
}
