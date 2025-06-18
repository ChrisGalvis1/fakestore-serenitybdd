package co.com.fakestore.api.utils;

import co.com.fakestore.api.models.carts.CartsModel;
import io.cucumber.datatable.DataTable;

import java.util.Collections;
import java.util.Map;

public class CartModelFactory {

    public static CartsModel crearDesde(DataTable table) {
        Map<String, String> data = table.asMaps().get(0);

        CartsModel.ProductCart product = new CartsModel.ProductCart(
                Integer.parseInt(data.get("productId")),
                data.get("title"),
                Double.parseDouble(data.get("price")),
                data.get("description"),
                data.get("category"),
                data.get("image")
        );

        return new CartsModel(
                Integer.parseInt(data.get("id")),
                Integer.parseInt(data.get("userId")),
                Collections.singletonList(product)
        );
    }
}
