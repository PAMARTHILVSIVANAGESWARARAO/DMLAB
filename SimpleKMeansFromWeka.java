import weka.clusterers.SimpleKMeans;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class SimpleKMeansFromWeka {
    public static void main(String[] args) throws Exception {
        String datasetPath = "C:\\Weka-3-8-6\\data\\iris.arff";
        DataSource source = new DataSource(datasetPath);
        Instances data = source.getDataSet();

        SimpleKMeans kmeans = new SimpleKMeans();
        kmeans.setNumClusters(3);
        kmeans.setSeed(10);
        kmeans.setPreserveInstancesOrder(true);

        kmeans.buildClusterer(data);

        System.out.println("\n=== Simple K-Means Results ===\n");
        System.out.println(kmeans);

        int[] assignments = kmeans.getAssignments();
        int i = 0;
        for (int clusterNum : assignments) {
            System.out.printf("Instance %d → Cluster %d\n", i, clusterNum);
            i++;
        }
    }
}
