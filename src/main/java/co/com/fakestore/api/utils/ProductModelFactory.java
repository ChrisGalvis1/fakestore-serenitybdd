package co.com.fakestore.api.utils;

import co.com.fakestore.api.models.products.ProductsModel;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class ProductModelFactory {

    public static ProductsModel crearDesde(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);

        return new ProductsModel(
                Integer.parseInt(data.get("id")),
                data.get("title"),
                Double.parseDouble(data.get("price")),
                data.get("description"),
                data.get("category"),
                data.get("image")
        );
    }
}
