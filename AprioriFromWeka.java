import weka.associations.Apriori;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;

public class AprioriFromWeka {
    public static void main(String[] args) throws Exception {
        String datasetPath = "C:\\Weka-3-8-6\\data\\weather.nominal.arff";
        DataSource source = new DataSource(datasetPath);
        Instances data = source.getDataSet();

        Apriori apriori = new Apriori();
        apriori.setLowerBoundMinSupport(0.1);
        apriori.setMinMetric(0.5);
        apriori.setNumRules(10);

        apriori.buildAssociations(data);

        System.out.println("\n=== Apriori Results ===\n");
        System.out.println(apriori);
    }
}
