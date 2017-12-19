package han.kunpeng.recyclerviewdemo.utility;

import android.content.res.AssetManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import timber.log.Timber;

/**
 * CSVParser
 *
 * @author William Han
 * @date 2017/12/15
 */
public class CSVParser {
    private List<String[]> dataset = null;
    private InputStream inputStream = null;

    public CSVParser(final String fileName){
        try {
            AssetManager assetManager = GlobalContext.getContext().getAssets();
            inputStream = assetManager.open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            dataset = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                // Row and column indices starting from 0
                String[] row = line.split(",");
                dataset.add(row);
            }
        } catch (IOException ex) {
            Timber.d("[CSVParser] IOException: " + ex.toString());
        } finally {
            try {
                if (null == inputStream) {
                    Timber.d("[CSVParser] null == inputStream");
                } else {
                    inputStream.close();
                }
            } catch (IOException e) {
                Timber.d("[CSVParser] Close Input Stream Exception: " + e.toString());
            }
        }
    }

    public List<String[]> parse() {
        return dataset;
    }

}
