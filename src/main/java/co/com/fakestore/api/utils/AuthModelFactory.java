package co.com.fakestore.api.utils;

import co.com.fakestore.api.models.auth.AuthModel;
import io.cucumber.datatable.DataTable;

import java.util.Map;

public class AuthModelFactory {

    public static AuthModel crearDesde(DataTable dataTable) {
        Map<String, String> data = dataTable.asMaps().get(0);
        return new AuthModel(
                data.get("username"),
                data.get("password")
        );
    }
}
